# Product manager

Application Spring Boot et front Vuejs (./front/product-manager)

## Comment demarrer

Dépendance

- Base de donne Posgres Sql
- Java 11
- node 13
- Spring Boot 2.6.3
- VueJs 3

La configuration d'hôte de base de donnée doit être changer si on veut démarrer l'application en local. 

Demarer avec docker:

```bash
  docker-compose build
  docker-compose up
```


## Initialisation

1) Il faut céér un untilisateur par defaut avec les idendifiant et mdp admin/admi.
Il faut aller sur l'url http://localhost:8081/api/auth/createadmin pour générer l'utilisateur.
2) Se connecter avec admin/admins
