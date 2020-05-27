# Bordeaux Medic - Serveur

## 1.Description 

Ce projet représente le côté back-end de l'application Bordeaux Medic. Il y a, à l'intérieur une API REST qui permet de faire la liaison avec les deux autres applications (front-office et le back-office).

## 2. Usage

C'est une application qui fonctionne avec un serveur (Tomcat par exemple).

- Il faut en premier lieu configurer le serveur
- En deuxième lieu, configurer la compilation avec Java

Il suffit de lancer le serveur en arrière plan pour faire fonctionner les deux autres application.

## 3. Description des méthodes de l'API REST

### A. Appointments

- *http://localhost:8080/BordeauxMedicServer_war_exploded/Appointments* | GET | Permet de récupérer l'ensemble des informations de l'intégralité des rendez-vous stockés sous format JSON.
- *http://localhost:8080/BordeauxMedicServer_war_exploded/Appointments/{id}* | GET | Permet de récupérer l'ensemble des informations d'un rendez-vous en passant en paramètre du lien l'id du rendez-vous que l'on veut récupérer sous format JSON. 
- *http://localhost:8080/BordeauxMedicServer_war_exploded/Appointments/{id}* | POST | Permet d'envoyer les nouveaux rendez-vous créés vers le serveur et ainsi les stocker sous format XML.
- *http://localhost:8080/BordeauxMedicServer_war_exploded/Appointments/{doctorId}/{month}/{year}* | GET | Permet de récupérer l'ensemble des rendez-vous du mois pour un docteur sous format JSON. 
- *http://localhost:8080/BordeauxMedicServer_war_exploded/Appointments/{appointmentId}* | DELETE | Supprime un rendez-vous en passant en paramètre l'id du rendez-vous que l'on veut supprimer.

### B.Doctor

- *http://localhost:8080/BordeauxMedicServer_war_exploded/Doctors* | GET | Permet de récupérer l'ensemble des informations de l'intégralité des docteurs stockés sous format JSON.

### C. Schedule

- http://localhost:8080/BordeauxMedicServer_war_exploded/Schedules/{doctorId}/{month}/ | GET | Permet de récupérer l'ensemble des horaires disponibles pour un docteur pour le mois données sous format JSON.

> Attention : dans l'ensemble des liens ci-dessus, *BordeauxMedicServer_war_exploded* est l'artifact créer de base par IntelliJ, il se peut qu'il soit différent lors de votre compilation sur un autre IDE.

