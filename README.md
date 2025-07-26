# 🎓 Évaluation-Stage

## 📌 Aperçu du Projet

**Évaluation-Stage** est une application web complète destinée à la gestion des évaluations des stagiaires en entreprise. Elle permet aux maîtres de stage, formateurs et administrateurs de suivre, évaluer et analyser les performances des stagiaires de manière centralisée et efficace.

## 🧱 Architecture

Le projet est basé sur une architecture moderne **frontend-backend séparée** :

- 🔙 **Backend** : API RESTful développée avec **Spring Boot**
- 🎨 **Frontend** : Interface utilisateur interactive réalisée avec **React.js** et **Tailwind CSS**

## 🚀 Fonctionnalités principales

- 👥 **Authentification et autorisation** (JWT & OAuth2)
- 📝 **Formulaires d’évaluation dynamiques** : création et personnalisation de grilles
- 📊 **Suivi des performances** : tableaux de bord, graphiques et statistiques
- 📆 **Gestion des périodes** : planification des phases d’évaluation
- 📈 **Dashboard d'administration** : vue globale sur les évaluations et utilisateurs
- ✅ **Workflow d’approbation** : validation multi-niveaux des évaluations

## 📦 Technologies utilisées

### Backend

- Java 17+
- Spring Boot 3+
- Spring Security (JWT/OAuth2)
- MySQL ou PostgreSQL
- MapStruct, Lombok
- Maven

### Frontend

- React 18+
- Vite
- Tailwind CSS
- Axios
- React Router DOM
- Formik, Yup

## ⚙️ Prérequis

### Pour le développement

- [JDK 17+](https://adoptium.net/)
- [Maven 3.8+](https://maven.apache.org/)
- [Node.js 18+](https://nodejs.org/)
- [npm 9+](https://www.npmjs.com/) ou [Yarn](https://yarnpkg.com/)
- [MySQL 8+](https://www.mysql.com/) ou [PostgreSQL 14+](https://www.postgresql.org/)

### Pour le déploiement

- Serveur avec Java 17+ installé
- Serveur Web (Nginx, Apache) pour servir le frontend
- Base de données relationnelle (MySQL ou PostgreSQL)

## ⚙️ Installation et Lancement

### 1. Clonage du projet

```bash
git clone https://github.com/votre-organisation/evaluation-stage.git
cd evaluation-stage
cd evaluation-backend
```
2. Installation et exécution du Backend (Spring Boot)
Étapes :
Créez la base de données dans MySQL :
```
CREATE DATABASE evaluation_stage;
```
Configurez le fichier src/main/resources/application.properties :
```
spring.datasource.url=jdbc:mysql://localhost:3306/evaluation_stage
spring.datasource.username=root
spring.datasource.password=mot_de_passe
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8080
```
Exécutez le backend :
```
./mvnw spring-boot:run
```
Ou avec Maven si mvnw ne fonctionne pas :
```
mvn spring-boot:run
```
L’API sera disponible sur : http://localhost:8080

3. Installation et exécution du Frontend (React)
```
cd ../evaluation-frontend
```
Installez les dépendances :
```
npm install
```
Démarrez l’application :

L’application sera accessible sur : http://localhost:5173

4. (Optionnel) Build pour production
Frontend :
```
npm run build
```
Le dossier dist/ peut être déployé avec Nginx ou un autre serveur web.

Backend :
```
./mvnw clean install
```
java -jar target/evaluation-backend-0.0.1-SNAPSHOT.jar
🧪 Tests
Backend : JUnit, Mockito

Frontend (optionnel) : Jest, React Testing Library

📁 Structure du projet

evaluation-stage/
├── evaluation-backend/     # API Spring Boot
└── evaluation-frontend/    # Application React.js
📄 Licence
Ce projet est sous licence MIT.

🙌 Contributions
Les contributions sont les bienvenues !
Veuillez créer une issue ou proposer une pull request.


