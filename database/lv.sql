-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 04 mai 2024 à 15:25
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `lv`
--

-- --------------------------------------------------------

--
-- Structure de la table `adoption`
--

CREATE DATABASE IF NOT EXISTS lv;
USE lv;


DROP TABLE IF EXISTS `adoption`;
CREATE TABLE IF NOT EXISTS `adoption` (
  `end_date` date DEFAULT NULL,
  `idadoption` int NOT NULL AUTO_INCREMENT,
  `idanimal` int DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  PRIMARY KEY (`idadoption`),
  KEY `FK242vl657ovwxx6sc68twg72wt` (`idanimal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `animal`
--

DROP TABLE IF EXISTS `animal`;
CREATE TABLE IF NOT EXISTS `animal` (
  `date_of_birth` date DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `idanimal` int NOT NULL AUTO_INCREMENT,
  `idperson` int DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `imageurl` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `race` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idanimal`),
  KEY `FK3t5e4xcb4rwsh1burgs8k3ipn` (`idperson`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `animal`
--

INSERT INTO `animal` (`date_of_birth`, `gender`, `idanimal`, `idperson`, `weight`, `category`, `imageurl`, `name`, `race`) VALUES
('2024-04-10', 1, 1, 1, 20, NULL, NULL, 'chocho', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `animal_vu_email`
--

DROP TABLE IF EXISTS `animal_vu_email`;
CREATE TABLE IF NOT EXISTS `animal_vu_email` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_animal_vue` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `animaux_perdus`
--

DROP TABLE IF EXISTS `animaux_perdus`;
CREATE TABLE IF NOT EXISTS `animaux_perdus` (
  `id_animal_perdu` bigint NOT NULL AUTO_INCREMENT,
  `id_animal` int NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  PRIMARY KEY (`id_animal_perdu`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `animaux_perdus`
--

INSERT INTO `animaux_perdus` (`id_animal_perdu`, `id_animal`, `latitude`, `longitude`) VALUES
(1, 1, 48.986502, 1.705317);

-- --------------------------------------------------------

--
-- Structure de la table `animaux_vus`
--

DROP TABLE IF EXISTS `animaux_vus`;
CREATE TABLE IF NOT EXISTS `animaux_vus` (
  `id_animal_vu` bigint NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `heure` time(6) NOT NULL,
  `id_animal` int NOT NULL,
  `id_personne` int NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `rayon` double NOT NULL,
  PRIMARY KEY (`id_animal_vu`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `animaux_vus`
--

INSERT INTO `animaux_vus` (`id_animal_vu`, `date`, `heure`, `id_animal`, `id_personne`, `latitude`, `longitude`, `rayon`) VALUES
(1, '2024-03-02', '61:56:29.000000', 1, 2, 48.862725, 2.287592, 30);

-- --------------------------------------------------------

--
-- Structure de la table `candidature`
--

DROP TABLE IF EXISTS `candidature`;
CREATE TABLE IF NOT EXISTS `candidature` (
  `id_person` int DEFAULT NULL,
  `idadoption` int DEFAULT NULL,
  `idcandidature` int NOT NULL AUTO_INCREMENT,
  `date_candidature` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idcandidature`),
  KEY `FKiockkj5a2yiyu6nqma17sivfx` (`idadoption`),
  KEY `FK1mks6lohhxvy1i041ikqihsx9` (`id_person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `date` date DEFAULT NULL,
  `id_evenement` int NOT NULL AUTO_INCREMENT,
  `id_person` int DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_evenement`),
  KEY `FKo39ol5p5gmabo69e27ngklokc` (`id_person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `feeding_confirmation`
--

DROP TABLE IF EXISTS `feeding_confirmation`;
CREATE TABLE IF NOT EXISTS `feeding_confirmation` (
  `animal_id` int DEFAULT NULL,
  `feeding_time_id` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `person_id` int DEFAULT NULL,
  `confirmation_date` datetime(6) NOT NULL,
  `confirmation_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `feeding_times`
--

DROP TABLE IF EXISTS `feeding_times`;
CREATE TABLE IF NOT EXISTS `feeding_times` (
  `animal_id` int NOT NULL,
  `feeding_time` time DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `FKderw3spcki4yfxyrd9doo2u9j` (`animal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `heure`
--

DROP TABLE IF EXISTS `heure`;
CREATE TABLE IF NOT EXISTS `heure` (
  `heure` time(6) DEFAULT NULL,
  `idheure` int NOT NULL AUTO_INCREMENT,
  `idtraitement` int DEFAULT NULL,
  PRIMARY KEY (`idheure`),
  KEY `FKh76sa4pqrw58lkjpednroepy4` (`idtraitement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `historique_adoption`
--

DROP TABLE IF EXISTS `historique_adoption`;
CREATE TABLE IF NOT EXISTS `historique_adoption` (
  `end_date` date DEFAULT NULL,
  `idanimal` int DEFAULT NULL,
  `idhistoriqueadoption` int NOT NULL AUTO_INCREMENT,
  `idperson` int DEFAULT NULL,
  PRIMARY KEY (`idhistoriqueadoption`),
  KEY `FKs0nsil5ehtbliwkty0sk3ao4t` (`idanimal`),
  KEY `FKjbqt2gloueaei7dibwf5xcb9q` (`idperson`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `historique_weight`
--

DROP TABLE IF EXISTS `historique_weight`;
CREATE TABLE IF NOT EXISTS `historique_weight` (
  `idanimal` int DEFAULT NULL,
  `idhistorique` int NOT NULL AUTO_INCREMENT,
  `weight` double DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`idhistorique`),
  KEY `FKosldr4qxo0wp92omteaxpca70` (`idanimal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `id_evenement` int DEFAULT NULL,
  `id_inscription` int NOT NULL AUTO_INCREMENT,
  `id_person` int DEFAULT NULL,
  PRIMARY KEY (`id_inscription`),
  KEY `FK4n2m00pje0i0svw1qjulert9v` (`id_evenement`),
  KEY `FK9el96yht9su3i89o4901kiddi` (`id_person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `items_to_donate`
--

DROP TABLE IF EXISTS `items_to_donate`;
CREATE TABLE IF NOT EXISTS `items_to_donate` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idperson` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKco860mfcmi40n5t9yotvw8qhv` (`idperson`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `medicament`
--

DROP TABLE IF EXISTS `medicament`;
CREATE TABLE IF NOT EXISTS `medicament` (
  `idmedicament` int NOT NULL AUTO_INCREMENT,
  `medicamentname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmedicament`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `id_person` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_person`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `person`
--

INSERT INTO `person` (`id_person`, `address`, `email`, `first_name`, `image_url`, `last_name`, `password`, `phone_number`) VALUES
(1, NULL, '42000139@parisnanterre.fr', NULL, NULL, NULL, 'faiz', NULL),
(2, NULL, 'im@gmail.com', NULL, NULL, 'im', 'im', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `traitement`
--

DROP TABLE IF EXISTS `traitement`;
CREATE TABLE IF NOT EXISTS `traitement` (
  `datedebut` date DEFAULT NULL,
  `datefin` date DEFAULT NULL,
  `idanimal` int DEFAULT NULL,
  `idmedicament` int DEFAULT NULL,
  `idtraitement` int NOT NULL AUTO_INCREMENT,
  `nombre_prises` int DEFAULT NULL,
  `commentaire` varchar(1000) DEFAULT NULL,
  `fichierurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idtraitement`),
  KEY `FKd8yyt8khnqj5nlmgvb83xtmd5` (`idanimal`),
  KEY `FKacss3cjpkfurou4ntuk8h3vhf` (`idmedicament`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `vaccin`
--

DROP TABLE IF EXISTS `vaccin`;
CREATE TABLE IF NOT EXISTS `vaccin` (
  `idvaccin` int NOT NULL AUTO_INCREMENT,
  `vaccinename` varchar(45) DEFAULT NULL,
  `info_vaccin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idvaccin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `vaccination`
--

DROP TABLE IF EXISTS `vaccination`;
CREATE TABLE IF NOT EXISTS `vaccination` (
  `date` date DEFAULT NULL,
  `id_animal` int DEFAULT NULL,
  `id_vaccin` int DEFAULT NULL,
  `idvaccination` int NOT NULL AUTO_INCREMENT,
  `vaccination_time` time(6) DEFAULT NULL,
  `vet_name` varchar(50) DEFAULT NULL,
  `vet_address` varchar(100) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idvaccination`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `adoption`
--
ALTER TABLE `adoption`
  ADD CONSTRAINT `FK242vl657ovwxx6sc68twg72wt` FOREIGN KEY (`idanimal`) REFERENCES `animal` (`idanimal`);

--
-- Contraintes pour la table `animal`
--
ALTER TABLE `animal`
  ADD CONSTRAINT `FK3t5e4xcb4rwsh1burgs8k3ipn` FOREIGN KEY (`idperson`) REFERENCES `person` (`id_person`);

--
-- Contraintes pour la table `candidature`
--
ALTER TABLE `candidature`
  ADD CONSTRAINT `FK1mks6lohhxvy1i041ikqihsx9` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`),
  ADD CONSTRAINT `FKiockkj5a2yiyu6nqma17sivfx` FOREIGN KEY (`idadoption`) REFERENCES `adoption` (`idadoption`);

--
-- Contraintes pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `FKo39ol5p5gmabo69e27ngklokc` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`);

--
-- Contraintes pour la table `feeding_times`
--
ALTER TABLE `feeding_times`
  ADD CONSTRAINT `FKderw3spcki4yfxyrd9doo2u9j` FOREIGN KEY (`animal_id`) REFERENCES `animal` (`idanimal`);

--
-- Contraintes pour la table `heure`
--
ALTER TABLE `heure`
  ADD CONSTRAINT `FKh76sa4pqrw58lkjpednroepy4` FOREIGN KEY (`idtraitement`) REFERENCES `traitement` (`idtraitement`);

--
-- Contraintes pour la table `historique_adoption`
--
ALTER TABLE `historique_adoption`
  ADD CONSTRAINT `FKjbqt2gloueaei7dibwf5xcb9q` FOREIGN KEY (`idperson`) REFERENCES `person` (`id_person`),
  ADD CONSTRAINT `FKs0nsil5ehtbliwkty0sk3ao4t` FOREIGN KEY (`idanimal`) REFERENCES `animal` (`idanimal`);

--
-- Contraintes pour la table `historique_weight`
--
ALTER TABLE `historique_weight`
  ADD CONSTRAINT `FKosldr4qxo0wp92omteaxpca70` FOREIGN KEY (`idanimal`) REFERENCES `animal` (`idanimal`);

--
-- Contraintes pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `FK4n2m00pje0i0svw1qjulert9v` FOREIGN KEY (`id_evenement`) REFERENCES `evenement` (`id_evenement`),
  ADD CONSTRAINT `FK9el96yht9su3i89o4901kiddi` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`);

--
-- Contraintes pour la table `items_to_donate`
--
ALTER TABLE `items_to_donate`
  ADD CONSTRAINT `FKco860mfcmi40n5t9yotvw8qhv` FOREIGN KEY (`idperson`) REFERENCES `person` (`id_person`);

--
-- Contraintes pour la table `traitement`
--
ALTER TABLE `traitement`
  ADD CONSTRAINT `FKacss3cjpkfurou4ntuk8h3vhf` FOREIGN KEY (`idmedicament`) REFERENCES `medicament` (`idmedicament`),
  ADD CONSTRAINT `FKd8yyt8khnqj5nlmgvb83xtmd5` FOREIGN KEY (`idanimal`) REFERENCES `animal` (`idanimal`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

SELECT * FROM `animal` LIMIT 5;