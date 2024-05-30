# Utiliser une image de base avec Java 21
FROM openjdk:21

# Exposer le port sur lequel l'application écoute et le port de la base de données
EXPOSE 8086
EXPOSE 3307

# Ajouter le fichier JAR dans le conteneur
ADD target/lovemypet-app.jar lovemypet-app.jar

# Commande à exécuter lors du démarrage du conteneur
CMD ["java", "-jar", "lovemypet-app.jar"]
