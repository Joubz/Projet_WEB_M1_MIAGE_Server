# Bordeaux Medic - Serveur

## 1.Description 

Ce projet représente le côté back-end de l'application Bordeaux Medic. Il y a, à l'intérieur une API REST qui permet de faire la liaison avec les deux autres applications (front-office et le back-office).

## 2. Usage

C'est une application qui fonctionne avec un serveur (Tomcat par exemple).

Exemple d'installation avec IntelliJ :

- Recopier l'ensemble du projet vers un dossier destination
- Cliquer sur le bouton *edit configuration* pour créer une nouvelle configuration. (Tomcat Server --> Local)
- Rentrer les champs suivants :
  - *Application server* : Renseigner les fichiers pour votre serveur Tomcat
  - Dans la section *Before launch* ajouté à l'aide du bouton *+*, *Build Artifact*. Sélectionner l'artifact et cliquer sur le bouton *OK*
  - Quitter la configuration
- Réaliser la combinaison suivante : MAJ + CTRL + ALT + S
  - Dans *Project Settings*, sélectionner *Project*. 
  - Dans le champ *Project SDK*, renseigner le SDK Java. 
  - Cliquer sur le bouton Apply
- Vous pouvez maintenant lancer l'application

## 3. Description des méthodes de l'API REST

### A. Appointment

- *http://localhost:8080/BordeauxMedicServer_war_exploded/Appointments* | GET | Permet de récupérer l'ensemble des informations de l'intégralité des rendez-vous stockés sous format XML, envoyé en format JSON.
- *http://localhost:8080/BordeauxMedicServer_war_exploded/Appointments/{id}* | GET | Permet de récupérer l'ensemble des informations d'un rendez-vous en passant en paramètre du lien l'id du rendez-vous que l'on veut récupérer sous format JSON. 
- *http://localhost:8080/BordeauxMedicServer_war_exploded/Appointments/{id}* | POST | Permet de créer un rendez-vous vers le serveur et ainsi le stocker sous format XML.
- *http://localhost:8080/BordeauxMedicServer_war_exploded/Appointments/{doctorId}/{month}/{year}* | GET | Permet de récupérer l'ensemble des rendez-vous du mois et d'une année précise, pour un docteur, sous format JSON. 
- *http://localhost:8080/BordeauxMedicServer_war_exploded/Appointments/{appointmentId}* | DELETE | Supprime un rendez-vous en passant en paramètre l'id du rendez-vous que l'on veut supprimer.

### B.Doctor

- *http://localhost:8080/BordeauxMedicServer_war_exploded/Doctors* | GET | Permet de récupérer l'ensemble des informations de l'intégralité des docteurs stockés sous format XML, envoyé en format JSON.

### C. Schedule

- http://localhost:8080/BordeauxMedicServer_war_exploded/Schedules/{doctorId}/{month}/ | GET | Permet de récupérer l'ensemble des horaires disponibles pour un docteur pour le mois données sous format JSON.

> Attention : dans l'ensemble des liens ci-dessus, *BordeauxMedicServer_war_exploded* est l'artifact créer de base par IntelliJ, il se peut qu'il soit différent lors de votre compilation sur un autre IDE.

## 4. Autre informations

- Les fichiers de stockage sont stockés directement dans le serveur Tomcat, dossier Tomcat/bin. Ils sont sous format XML avec les noms suivants :
  - appointments.xml
  - doctors.xml
  - patients.xml