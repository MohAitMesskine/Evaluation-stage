package com.example.evaluation.service;

import com.example.evaluation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        System.out.println("Recherche utilisateur : " + usernameOrEmail);
        var userOptional = userRepo.findByUsername(usernameOrEmail).or(() -> userRepo.findByEmail(usernameOrEmail));
        if (userOptional.isEmpty()) {
            System.out.println("Utilisateur non trouvé");
            throw new UsernameNotFoundException("Utilisateur non trouvé");
        }
        var user = userOptional.get();
        System.out.println("Utilisateur trouvé : " + user.getUsername() + ", password hash : " + user.getPassword());
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole()))
        );
    }

}
