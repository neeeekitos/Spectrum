-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 12 mai 2020 à 21:58
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
-- Base de données :  `spectrum`
--

-- --------------------------------------------------------

--
-- Structure de la table `codeprojets`
--

DROP TABLE IF EXISTS `codeprojets`;
CREATE TABLE IF NOT EXISTS `codeprojets` (
  `projectID` int(11) NOT NULL,
  `code` varchar(15) NOT NULL,
  `dateCreation` varchar(30) NOT NULL,
  PRIMARY KEY (`projectID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `codeprojets`
--

INSERT INTO `codeprojets` (`projectID`, `code`, `dateCreation`) VALUES
(0, '123245', '2020-41-12 11:41:05'),
(2, '6465465', '2020-45-12 11:45:51');

-- --------------------------------------------------------

--
-- Structure de la table `messages`
--

DROP TABLE IF EXISTS `messages`;
CREATE TABLE IF NOT EXISTS `messages` (
  `msgID` int(11) NOT NULL AUTO_INCREMENT,
  `projectID` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `message` text NOT NULL,
  `dateMsg` varchar(30) NOT NULL,
  PRIMARY KEY (`msgID`)
) ENGINE=MyISAM AUTO_INCREMENT=205 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `messages`
--

INSERT INTO `messages` (`msgID`, `projectID`, `username`, `message`, `dateMsg`) VALUES
(204, 2, 'nikita', 'Surement et vous ?', '2020-58-12 11:58:05'),
(203, 2, 'roman', 'Parfait ! Vous allez à la K-fete?', '2020-57-12 11:57:57'),
(202, 2, 'nikita', 'On l\'a déjà déposé également :)', '2020-57-12 11:57:36'),
(201, 2, 'roman', 'Oui et toi?', '2020-52-12 11:52:41'),
(200, 2, 'nikita', '?', '2020-52-12 11:52:30'),
(199, 2, 'nikita', 'Pareil, tu as fini ton projet d\'algo?', '2020-52-12 11:52:15'),
(198, 2, 'roman', 'Oui, et toi?', '2020-51-12 11:51:10'),
(197, 2, 'nikita', 'Yo, ça va ?', '2020-46-12 11:46:37'),
(196, 2, 'roman', 'Salut Nikita !', '2020-46-12 11:46:22');

-- --------------------------------------------------------

--
-- Structure de la table `projetassociation`
--

DROP TABLE IF EXISTS `projetassociation`;
CREATE TABLE IF NOT EXISTS `projetassociation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `projectID` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `projetassociation`
--

INSERT INTO `projetassociation` (`id`, `username`, `projectID`) VALUES
(100, 'roman', 2),
(99, 'nikita', 2),
(97, 'vale', 0),
(98, 'nikita', 0),
(96, 'lena', 0);

-- --------------------------------------------------------

--
-- Structure de la table `projets`
--

DROP TABLE IF EXISTS `projets`;
CREATE TABLE IF NOT EXISTS `projets` (
  `projectID` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  PRIMARY KEY (`projectID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `projets`
--

INSERT INTO `projets` (`projectID`, `nom`) VALUES
(0, 'P2I'),
(1, 'Algo'),
(2, 'Algo');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`userID`, `username`, `prenom`, `nom`, `email`, `mdp`) VALUES
(2, 'nikita', 'Nikita', 'TEREKHOV', '', 'nikita'),
(3, 'lena', 'Lena', 'LEHMANN', '', 'lena'),
(4, 'roman', 'Roman', 'HOCHHAUSEN', '', 'roman'),
(5, 'vale', 'Valentina', 'Etegan', '', 'vale'),
(8, 'test', 'test', 'test', 'test@gmail.com', 'QWerty123#');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
