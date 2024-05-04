# Gestion des Ressources Matérielles de la Faculté

Ce projet vise à développer un logiciel pour la gestion centralisée des ressources matérielles au sein des différents départements de la Faculté des Sciences et Techniques.

## Description

Le logiciel permettra la gestion des appels d'offre pour l'acquisition de matériel informatique et d'autres ressources, la sécurisation des accès pour différents utilisateurs, et la gestion efficace des ressources après acquisition, incluant leur maintenance et leur répartition.

## Fonctionnalités

- **Gestion des Appels d'Offres** : Création et suivi des appels d'offres pour l'achat de ressources.
- **Sécurisation des Accès** : Accès sécurisé pour les utilisateurs selon leur rôle (administrateur, fournisseur, responsable de département).
- **Suivi des Livraisons** : Suivi des livraisons, attribution de numéros d'inventaire, et affectation des ressources aux départements et enseignants.
- **Gestion de la Maintenance** : Signalement et suivi des pannes matérielles, gestion des interventions de maintenance.

## Gestion des Utilisateurs

Cette section du logiciel permet de gérer les profils des utilisateurs impliqués dans la gestion des ressources matérielles, y compris les responsables de département, les fournisseurs et les techniciens de maintenance. Les fonctionnalités clés incluent :

- **Création et gestion de comptes** : Les utilisateurs peuvent créer des comptes et les administrateurs peuvent gérer ces comptes, en attribuant ou modifiant les rôles et les permissions selon les besoins.
- **Authentification et sécurité** : Le système propose des mesures de sécurité robustes pour l'authentification des utilisateurs, incluant le chiffrement des mots de passe et la gestion des sessions sécurisées.
- **Gestion des rôles** : Chaque utilisateur a des accès spécifiques selon son rôle dans le système, garantissant que les données sensibles sont protégées et que les opérations sont effectuées dans les limites de leurs responsabilités.

## Gestion des Matériels

Le logiciel offre une interface complète pour la gestion des matériels informatiques et autres ressources matérielles de la faculté. Les principales fonctionnalités sont :

- **Inventaire des matériels** : Enregistrement et suivi de tous les équipements acquis, avec des détails comme la marque, les spécifications techniques, et le numéro d'inventaire.
- **Affectation des ressources** : Attribution des matériels aux départements et aux individus, avec la capacité de suivre qui utilise quoi et où les ressources sont localisées.
- **Maintenance et réparations** : Gestion des incidents techniques, suivi des réparations et historique des maintenances pour chaque pièce d'équipement.
- **Mises à jour de l'état des équipements** : Les utilisateurs peuvent mettre à jour l'état des ressources en temps réel, permettant une gestion dynamique de l'inventaire.

Ces fonctionnalités permettent une gestion efficace et transparente des ressources matérielles, assurant une utilisation optimale et une maintenance appropriée.

## Technologies Utilisées

- **Java EE/Spring Boot** : Pour le backend.
- **MySQL** : Pour la gestion de bases de données.

## Installation

```bash
git clone https://github.com/darkseidH/RessourceManagment.git
cd RessourceManagment
