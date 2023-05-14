[Version anglaise](README_En.md)

# Spring Boot Rest Api - Gestion Scolaire
Dans ce tutoriel, nous allons créer une API Spring Boot Rest pour une application de gestion de scolarité dans les termes suivants :

##### Structure de base de données en fonction des exigences commerciales suivantes.
Gestion scolaire qui contient la structure suivante:
* Les étudiants sont liés à une seule classe
* Un seul enseignant par classe
* L'étudiant doit contenir les informations suivantes: ID, Prénom, Nom de famille
* L'enseignant doit contenir les informations suivantes: ID, Prénom, Nom de famille
* La classe doit contenir les informations suivantes: ID, nom

##### API RESTful en utilisant Java Spring Boot avec les éléments suivants :
* Sécuriser l'API après la connexion en utilisant un jeton JWT généré.
* Obtenir la liste des étudiants avec les éléments suivants :
* Filtres : Nom de la classe et/ou Nom complet de l'enseignant
    - Tous les étudiants de la liste seront retournés en cas d'absence de valeur de filtres
* Paginé

##### Spring Boot
Spring Boot est un projet Spring qui facilite le processus de configuration et de publication des applications.

En suivant des étapes simples, vous pourrez exécuter votre premier projet.

##### API REST (Representational State Transfer Application Program Interface)
Il se base sur le protocole **HTTP** pour transférer des informations. 
Un client lance une requête HTTP, et le serveur renvoie une réponse à travers plusieurs méthodes dont les plus utilisées sont : **POST**, **GET**, **PUT** et **DELETE**.

##### Outils utilisés : 
* Java 8
* IDE Intellij IDEA
* Spring Boot 2.5.7 (avec Spring Web MVC et Spring Data JPA)
* PostgreSQL
* Lombok 1.18.22
* Maven 4.0.0


## Initialisation du projet
Pour amorcer une application Spring Boot , nous pouvons démarrer le projet à partir de zéro avec notre IDE préféré, ou simplement utiliser un autre moyen qui facilite la vie : [SpringInitializr](https://start.spring.io/)

Initialement, nous avons choisi les dépendances suivantes : Spring web, Spring Data JPA, Validation,H2 Database, Lombok et PostgreSQL Driver.

![Screenshot](src/main/resources/images/springInitializer.PNG)

## Étapes pour exécuter le projet

* Créez la base de données en se référant sur les paramétres de création dans le fichier application.properties sous resources.
* Vous pouvez exécuter votre projet en cliquant sur (Run 'ScolariteApplication') ou en utilisant le raccourcis (Maj+F10)
* Exécutez le script dans le fichier insertion.sql sous resources/sqlschemas afin de remplir la base de données avec des données de test.
* Lancez postman et importez le fichier scolarite App.postman_collection.json sous resources/postman:
    - Créer un nouveau utilisateur grace à la requête register '{{url}}/api/register'
    - S'authentifier et prendre un token en utlisant la requête '{{url}}/api/authenticate'
    - Afficher la liste des étudiants selon les filtres saisis via la requête '{{url}}/api/etudiants/search?nomClasse=Classe1&nomEnseignant=Sofien Zaghdoudi&page=1&per_page=2'# sofien_zaghdoudi_ehe5sa124z
