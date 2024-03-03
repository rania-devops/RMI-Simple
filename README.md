# RMI-Simple
Rapport sur le Travail : Création d'une Calculatrice RMI en Java

**1. objectif :**
L'objectif principal est de permettre à un client distant d'invoquer des opérations mathématiques sur un serveur distant.

**2. Architecture :**
L'architecture du projet se compose de trois parties principales : l'interface RMI, le serveur RMI, et le client RMI.

- **Interface RMI (CalculatorInterface.java) :**
  - Définit les méthodes de calcul à distance avec l'extension de l'interface `Remote`.
  - Permet de définir un contrat clair entre le serveur et le client.

- **Serveur RMI (CalculatorServer.java) :**
  - Implémente l'interface RMI, fournissant les fonctionnalités de calcul.
  - Utilise la classe `UnicastRemoteObject` pour exposer les méthodes de manière distribuée.
  - Enregistre l'objet distant dans le registre RMI pour permettre son accès aux clients.

- **Client RMI (CalculatorClient.java) :**
  - Utilise l'interface RMI pour déclarer les méthodes distantes disponibles sur le serveur.
  - Interagit avec l'utilisateur pour choisir l'opération et saisir les opérandes.
  - Communique avec le serveur distant pour effectuer les calculs.

**3. Fonctionnalités :**
La calculatrice RMI offre les fonctionnalités de base suivantes :
- Addition
- Soustraction
- Multiplication
- Division

**4. Utilisation :**
- Le serveur est lancé en premier, créant une instance de la classe `CalculatorServer` et la liant au registre RMI.
- Le client est ensuite exécuté, recherchant l'objet distant dans le registre RMI et permettant à l'utilisateur d'effectuer des calculs à distance.
- Le client peut effectuer plusieurs opérations successives avant de choisir de quitter.

