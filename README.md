# Gestion des Véhicules et des Conducteurs

Ce projet est une application web permettant de gérer la flotte de véhicules d'une entreprise et d'assigner des conducteurs à ces véhicules. 

## Fonctionnalités :

- **Gestion des véhicules :**
    - Ajouter de nouveaux véhicules avec leur modèle, immatriculation et état (assigné ou non assigné).
    - Afficher la liste de tous les véhicules disponibles.
    - Modifier les informations d'un véhicule existant.
    - Supprimer un véhicule.
- **Gestion des conducteurs :**
    - Ajouter de nouveaux conducteurs avec leur nom et leur permis de conduire.
    - Afficher la liste de tous les conducteurs disponibles.
    - Modifier les informations d'un conducteur existant.
    - Supprimer un conducteur.
- **Assignation des conducteurs aux véhicules :**
    - Assigner un conducteur à un véhicule pour une période donnée.
    - Afficher l'historique des assignations.
    - Supprimer une assignation.
    - Afficher les assignations en cours (non terminées).
    - Assigner un conducteur à un véhicule pour une période donnée avec la possibilité de choisir les dates de début et de fin.


## Structure du projet :

- **ControleIsicApplication.java :** point d'entrée de l'application
- **AssignationController.java :** gère les requêtes HTTP pour les assignations
- **ConducteurController.java :** gère les requêtes HTTP pour les conducteurs
- **VehiculeController.java :** gère les requêtes HTTP pour les véhicules
- **Assignation.java :** représente une assignation de conducteur à un véhicule
- **Conducteur.java :** représente un conducteur
- **ConducteurVehiculePK.java :** représente la clé primaire composite d'une assignation
- **Vehicule.java :** représente un véhicule
- **AssignationRepository.java :** interface de repository pour les assignations
- **ConducteurRepository.java :** interface de repository pour les conducteurs
- **VehiculeRepository.java :** interface de repository pour les véhicules
- **AssignationService.java :** service pour la gestion des assignations
- **ConducteurService.java :** service pour la gestion des conducteurs
- **VehiculeService.java :** service pour la gestion des véhicules

## Fichiers HTML :

- **index.html :** page d'accueil
- **add-conducteur.html :** formulaire d'ajout de conducteur
- **add-vehicule.html :** formulaire d'ajout de véhicule
- **all-assignations.html :** page affichant toutes les assignations
- **all-conducteurs.html :** page affichant tous les conducteurs
- **all-vehicules.html :** page affichant tous les véhicules
- **create-custom-assignation.html :** formulaire d'assignation avec date de début et de fin
- **create-assignation.html :** formulaire d'assignation instantanée
- **end-assignation.html :** page permettant de supprimer une assignation en cours 
- **update-conducteur.html :** formulaire de modification de conducteur
- **update-vehicule.html :** formulaire de modification de véhicule

## Lancement de l'application :

1. **Installer Maven :** https://maven.apache.org/install.html
2. **Cloner le projet :** `git clone <url du repo>`
3. **Configurer la base de données :**
   - Créer une base de données MySQL.
   - Configurer les paramètres de connexion dans le fichier `application.properties`.
4. **Lancer l'application :** `mvn spring-boot:run`

L'application web sera accessible à l'adresse http://localhost:8080.

## Remarques :

- Le projet utilise Spring Boot, Spring Data JPA et Thymeleaf.
- Vous pouvez modifier le code et le design des pages HTML selon vos besoins.
- N'hésitez pas à ajouter des fonctionnalités supplémentaires (comme la recherche, la pagination, etc.) à l'application.
- Ce projet est un exemple de base et peut être étendu pour répondre à d'autres besoins.


##  A propos du projet

Ce projet utilise les technologies suivantes :

- **Spring Boot** pour créer une application web simple et rapide.
- **Spring Data JPA** pour la persistance des données dans une base de données relationnelle.
- **Thymeleaf** pour le rendu des pages web.
- **MySQL** pour stocker les données de l'application.

Le projet est divisé en plusieurs modules, dont :

- **Le module des entités** qui définit les classes représentant les données de l'application (Véhicule, Conducteur, Assignation).
- **Le module des repositories** qui définit les interfaces de repository pour la manipulation des données.
- **Le module des services** qui définit les services pour la logique métier de l'application.
- **Le module des controllers** qui gère les requêtes HTTP et les réponses.
- **Le module des pages web** qui contient les fichiers HTML pour l'interface utilisateur.

## Instructions d'installation et d'utilisation

1. **Cloner le projet :** `git clone <url du repo>`
2. **Installer les dépendances :** `mvn install`
3. **Configurer la base de données :**
    - Créer une base de données MySQL.
    - Configurer les paramètres de connexion dans le fichier `application.properties`.
4. **Lancer l'application :** `mvn spring-boot:run`

L'application web sera accessible à l'adresse http://localhost:8080.

##  Ressources
- [Spring Boot](https://spring.io/projects/spring-boot/)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Thymeleaf](https://www.thymeleaf.org/)
- [MySQL](https://www.mysql.com/)
- [Maven](https://maven.apache.org/)

##  Contribuer
Les contributions au projet sont les bienvenues! N'hésitez pas à créer un pull request.
