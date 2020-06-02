-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 02 juin 2020 à 06:10
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projet_java`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

DROP TABLE IF EXISTS `administrateur`;
CREATE TABLE IF NOT EXISTS `administrateur` (
  `id_administrateur` int(11) NOT NULL AUTO_INCREMENT,
  `prenom` varchar(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id_administrateur`),
  UNIQUE KEY `pseudo` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `administrateur`
--

INSERT INTO `administrateur` (`id_administrateur`, `prenom`, `nom`, `username`, `password`) VALUES
(1, 'jeremy', 'deblaecker', 'jd', 'jd');

-- --------------------------------------------------------

--
-- Structure de la table `agences`
--

DROP TABLE IF EXISTS `agences`;
CREATE TABLE IF NOT EXISTS `agences` (
  `id_agences` int(30) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `adresse_siege` varchar(30) NOT NULL,
  PRIMARY KEY (`id_agences`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `agences`
--

INSERT INTO `agences` (`id_agences`, `nom`, `adresse_siege`) VALUES
(2, '13100 Aix en provence', 'Citya'),
(3, '83330 Castellet', 'Foncia');

-- --------------------------------------------------------

--
-- Structure de la table `agents`
--

DROP TABLE IF EXISTS `agents`;
CREATE TABLE IF NOT EXISTS `agents` (
  `id_agents` int(11) NOT NULL AUTO_INCREMENT,
  `prenom` varchar(15) NOT NULL,
  `nom` varchar(15) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  PRIMARY KEY (`id_agents`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `agents`
--

INSERT INTO `agents` (`id_agents`, `prenom`, `nom`, `username`, `password`) VALUES
(1, 'isatys', 'riviere', 'ir', 'ir');

-- --------------------------------------------------------

--
-- Structure de la table `biens`
--

DROP TABLE IF EXISTS `biens`;
CREATE TABLE IF NOT EXISTS `biens` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `surface` varchar(15) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `code_postal` varchar(15) NOT NULL,
  `nbr_pieces` varchar(15) NOT NULL,
  `description` varchar(30) NOT NULL,
  `prix` varchar(20) NOT NULL,
  `type_bien` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `biens`
--

INSERT INTO `biens` (`id`, `surface`, `adresse`, `code_postal`, `nbr_pieces`, `description`, `prix`, `type_bien`) VALUES
(2, '100m²', '2 rue le corbusier', '13100', '6', 'Jolie Maison', '6000€', '1');

-- --------------------------------------------------------

--
-- Structure de la table `documents`
--

DROP TABLE IF EXISTS `documents`;
CREATE TABLE IF NOT EXISTS `documents` (
  `id_document` int(11) NOT NULL,
  `document` longblob NOT NULL,
  PRIMARY KEY (`id_document`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `favoris`
--

DROP TABLE IF EXISTS `favoris`;
CREATE TABLE IF NOT EXISTS `favoris` (
  `id_favoris` int(11) NOT NULL,
  `id_prop` int(11) NOT NULL,
  PRIMARY KEY (`id_favoris`),
  KEY `favoris_propriete_FK` (`id_prop`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `migrations`
--

DROP TABLE IF EXISTS `migrations`;
CREATE TABLE IF NOT EXISTS `migrations` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `proprietes_photos`
--

DROP TABLE IF EXISTS `proprietes_photos`;
CREATE TABLE IF NOT EXISTS `proprietes_photos` (
  `id_photo` int(11) NOT NULL,
  `photo` longblob NOT NULL,
  `id_prop` int(11) NOT NULL,
  PRIMARY KEY (`id_photo`),
  KEY `proprietes_photos_propriete_FK` (`id_prop`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

DROP TABLE IF EXISTS `type`;
CREATE TABLE IF NOT EXISTS `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom_type` varchar(15) NOT NULL,
  `description` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type`
--

INSERT INTO `type` (`id`, `nom_type`, `description`) VALUES
(1, 'Maison', 'Maison...');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `id_users` int(11) NOT NULL AUTO_INCREMENT,
  `prenom` varchar(10) NOT NULL,
  `nom` varchar(10) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(10) NOT NULL,
  `telephone` varchar(30) NOT NULL,
  `role` varchar(15) NOT NULL,
  `code_postal` int(10) NOT NULL,
  `adresse` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id_users`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id_users`, `prenom`, `nom`, `username`, `password`, `telephone`, `role`, `code_postal`, `adresse`, `email`) VALUES
(1, 'Victor', 'Granier', 'vg', 'vg', '0541645', 'Acheteur', 13100, 'Aix', 'vg@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `vendeur`
--

DROP TABLE IF EXISTS `vendeur`;
CREATE TABLE IF NOT EXISTS `vendeur` (
  `id_users` int(11) NOT NULL,
  `prenom` varchar(10) NOT NULL,
  `nom` varchar(10) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(10) NOT NULL,
  `telephone` varchar(30) NOT NULL,
  `email` varchar(5) NOT NULL,
  `adresse` varchar(10) NOT NULL,
  `role` int(11) NOT NULL,
  `code_postal` varchar(10) NOT NULL,
  `id_agents` int(11) NOT NULL,
  `id_agences` int(11) NOT NULL,
  PRIMARY KEY (`id_users`),
  KEY `vendeur_agents0_FK` (`id_agents`),
  KEY `vendeur_agences1_FK` (`id_agences`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
