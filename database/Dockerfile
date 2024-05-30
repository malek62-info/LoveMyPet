FROM mysql:latest

# Définir le mot de passe root MySQL
ENV MYSQL_ROOT_PASSWORD=

# Définir le nom de la base de données et l'utilisateur MySQL
ENV MYSQL_DATABASE=lv


# Copier le script SQL dans le répertoire d'initialisation de la base de données
COPY ./lv.sql /docker-entrypoint-initdb.d/

EXPOSE 3306


