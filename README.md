# Évaluation-Stage

## Aperçu du Projet

Évaluation-Stage est une application web complète conçue pour la gestion des évaluations des stagiaires en entreprise. Ce système permet aux maîtres de stage, aux formateurs et aux administrateurs de suivre, évaluer et gérer les performances des stagiaires de manière efficace et centralisée.

## Architecture

Ce projet est développé avec une architecture moderne séparant le frontend et le backend :

- **Backend** : API RESTful développée avec Spring Boot
- **Frontend** : Interface utilisateur interactive construite avec React

## Fonctionnalités

- 👥 **Autentification 
- 📝 **Formulaires d'évaluation** : Création et personnalisation de grilles d'évaluation
- 📊 **Suivi des évaluations** : Tableaux de bord et statistiques sur les progrès des stagiaires
- ⏱️ **Planification** : Gestion des périodes d'évaluation et des échéances
- 📈 **Dashbort** : Génération de statistiques détaillés sur les evalutions 
- 🔄 **Workflow d'approbation** : Processus de validation des évaluations

## Prérequis

### Pour le développement

- JDK 17+
- Maven 3.8+
- Node.js 18+
- npm 9+ ou yarn 1.22+
- MySQL 8+ ou PostgreSQL 14+

### Pour le déploiement

- Serveur avec Java 17+
- Serveur web (Nginx ou Apache) pour le frontend
- Base de données MySQL ou PostgreSQL

## Installation et Configuration

### Backend (Spring Boot)

1. Cloner le dépôt :
```bash
git clone https://github.com/MohAitMesskine/Evaluation-stage.git
cd evaluation-stage/backend
