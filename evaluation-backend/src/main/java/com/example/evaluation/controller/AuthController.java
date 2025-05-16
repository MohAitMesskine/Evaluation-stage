package com.example.evaluation.controller;

import com.example.evaluation.dto.AuthRequest;
import com.example.evaluation.dto.AuthResponse;
import com.example.evaluation.model.User;
import com.example.evaluation.repository.UserRepository;
import com.example.evaluation.service.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(req.usernameOrEmail(), req.password())
            );

            // Récupérer l'utilisateur en base
            User user = userRepo.findByUsername(req.usernameOrEmail())
                    .or(() -> userRepo.findByEmail(req.usernameOrEmail()))
                    .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

            // Affichage console pour debug
            System.out.println("Mot de passe encodé en base : " + user.getPassword());

            // Générer token
            String token = jwtUtil.generateToken(req.usernameOrEmail());

            // Retourner token + mot de passe encodé (pour debug uniquement)
            return ResponseEntity.ok(new AuthResponse(token, user.getPassword()));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nom d'utilisateur ou mot de passe invalide");
        }
    }

    // 🔴 Endpoint de register supprimé
}
