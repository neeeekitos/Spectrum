-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 11 mai 2020 à 23:53
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
(1, '5466466', '2020-19-12 01:19:23');

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
) ENGINE=MyISAM AUTO_INCREMENT=141 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `messages`
--

INSERT INTO `messages` (`msgID`, `projectID`, `username`, `message`, `dateMsg`) VALUES
(14, 0, 'Roman', 'coucou', '2020-34-01 07:34:02'),
(15, 0, 'Roman', 'This is Roman', '2020-39-01 07:39:50'),
(16, 0, 'Roman', 'Yo', '2020-42-01 07:42:19'),
(17, 0, 'Nikita', 'wasssuuuuuuuuuuup', '2020-45-01 07:45:46'),
(18, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:50'),
(19, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:51'),
(20, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:51'),
(21, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:51'),
(22, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:52'),
(23, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:52'),
(24, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:52'),
(25, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:52'),
(26, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:52'),
(27, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:52'),
(28, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:53'),
(29, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:53'),
(30, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:53'),
(31, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:53'),
(32, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:53'),
(33, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:53'),
(34, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:53'),
(35, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:54'),
(36, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:54'),
(37, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:54'),
(38, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:54'),
(39, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:54'),
(40, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:54'),
(41, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:55'),
(42, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:55'),
(43, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:55'),
(44, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:55'),
(45, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:55'),
(46, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:55'),
(47, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:56'),
(48, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:56'),
(49, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:56'),
(50, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:56'),
(51, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:56'),
(52, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:56'),
(53, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:56'),
(54, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:57'),
(55, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:57'),
(56, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:58'),
(57, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:58'),
(58, 0, 'Nikita', 'rrrr', '2020-45-01 07:45:58'),
(59, 0, 'Nikita', 'Yo', '2020-24-01 08:24:04'),
(60, 0, 'Nikita', 'lalalalaaaaaaaaaaaaaaaaaaaaaaaa', '2020-01-02 01:01:25'),
(61, 0, 'Nikita', 'lalalalaaaaaaaaaaaaaaaaaaaaaaaa', '2020-01-02 01:01:25'),
(62, 0, 'Nikita', 'lalalalaaaaaaaaaaaaaaaaaaaaaaaa', '2020-01-02 01:01:26'),
(63, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:02'),
(64, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:02'),
(65, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:02'),
(66, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:03'),
(67, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:03'),
(68, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:03'),
(69, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:03'),
(70, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:03'),
(71, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:03'),
(72, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:04'),
(73, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:04'),
(74, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:04'),
(75, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:04'),
(76, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:04'),
(77, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:04'),
(78, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:04'),
(79, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:05'),
(80, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:05'),
(81, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:05'),
(82, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:05'),
(83, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:05'),
(84, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:05'),
(85, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:06'),
(86, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:06'),
(87, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:06'),
(88, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:06'),
(89, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:06'),
(90, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:06'),
(91, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:06'),
(92, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:07'),
(93, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:07'),
(94, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:07'),
(95, 0, 'Nikita', 'laaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-03-02 01:03:07'),
(96, 0, 'Nikita', 'ddsfsdfsd', '2020-03-02 01:03:39'),
(97, 0, 'Nikita', 'ddsfsdfsd', '2020-03-02 01:03:40'),
(98, 0, 'Nikita', 'ddsfsdfsd', '2020-03-02 01:03:40'),
(99, 0, 'Nikita', 'yaaaaaaaaaaaaaaa', '2020-55-09 12:55:47'),
(100, 0, 'Nikita', 'yaaaaaaaaaaaaaaa', '2020-55-09 12:55:48'),
(101, 0, 'Nikita', 'yaaaaaaaaaaaaaaa', '2020-55-09 12:55:49'),
(102, 0, 'Nikita', 'yaaaaaaaaaaaaaaa', '2020-55-09 12:55:51'),
(103, 0, 'Nikita', 'sdsds', '2020-23-09 01:23:39'),
(104, 0, 'Nikita', 'sdsds', '2020-23-09 01:23:40'),
(105, 0, 'Nikita', 'coucou', '2020-25-09 01:25:18'),
(106, 0, 'Nikita', 'ça va?', '2020-25-09 01:25:46'),
(107, 0, 'Nikita', 'Yo', '2020-29-09 01:29:32'),
(108, 0, 'Roman', 'coucou', '2020-29-09 01:29:59'),
(109, 0, 'Roman', 'yo', '2020-30-09 01:30:18'),
(110, 0, 'Nikita', 'yaaaaaa', '2020-30-09 01:30:48'),
(111, 0, 'Roman', 'yo', '2020-35-09 01:35:40'),
(112, 0, 'Nikita', 'coucou', '2020-36-09 01:36:19'),
(113, 0, 'Nikita', 'yo', '2020-01-09 02:01:51'),
(114, 0, 'Nikita', 'yo', '2020-01-09 02:01:59'),
(115, 0, 'Nikita', 'yo', '2020-01-09 02:01:59'),
(116, 0, 'Nikita', 'yo', '2020-01-09 02:01:59'),
(117, 0, 'Nikita', 'yo', '2020-02-09 02:02:00'),
(118, 0, 'Nikita', 'yo', '2020-02-09 02:02:00'),
(119, 0, 'Nikita', 'yo', '2020-02-09 02:02:00'),
(120, 0, 'Nikita', 'yo', '2020-02-09 02:02:00'),
(121, 0, 'Nikita', 'yo', '2020-02-09 02:02:00'),
(122, 0, 'Nikita', 'coucou', '2020-02-09 02:02:56'),
(123, 0, 'Nikita', 'Coucou', '2020-10-09 02:10:14'),
(124, 0, 'Roman', 'yo', '2020-18-09 02:18:09'),
(125, 0, 'Roman', 'lalalalal', '2020-09-09 06:09:55'),
(126, 0, 'Roman', 'yo', '2020-10-09 06:10:03'),
(127, 0, 'Nikita ', 'Tapez votre message ici', '2020-17-10 12:17:24'),
(128, 2, 'mathieu', 'Bonjour à tous !', '2020-35-10 12:35:21'),
(129, 2, 'mathieu', 'Je suis Mathieu', '2020-35-10 12:35:32'),
(130, 2, 'Valentina', 'Bonjour Mathieu!', '2020-35-10 12:35:41'),
(131, 2, 'Valentina', 'Et moi, je suis Valentina!', '2020-35-10 12:35:51'),
(132, 2, 'Valentina', 'ça va notre projet, cela avance bien?', '2020-36-10 12:36:19'),
(133, 2, 'mathieu', 'Ouiiii, on a fait pas mal de choses aujourdhui', '2020-36-10 12:36:58'),
(134, 2, 'mathieu', 'On a fait une video du fonctionnement de notre machine', '2020-37-10 12:37:16'),
(135, 2, 'Valentina', 'Vous êtes à l\'INSA encore?', '2020-37-10 12:37:37'),
(136, 2, 'mathieu', 'yes, encore une semaine je crois', '2020-37-10 12:37:55'),
(137, 2, 'mathieu', 'Cela depend de la situation', '2020-44-10 04:44:39'),
(138, 2, 'mathieu', '?', '2020-46-10 04:46:58'),
(139, 0, 'Nikita', 'Bonjour à tous!', '2020-50-10 04:50:46'),
(140, 2, 'mathieu', 'Coucou', '2020-43-10 07:43:28');

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
) ENGINE=MyISAM AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `projetassociation`
--

INSERT INTO `projetassociation` (`id`, `username`, `projectID`) VALUES
(47, 'Valentina', 2),
(10, 'Roman', 0),
(9, 'Nikita', 0),
(46, 'Lena', 2),
(44, 'Valentina', 1),
(32, 'Valentina', 0),
(40, 'Lena', 1),
(30, 'mathieu', 1),
(41, 'Roman', 1),
(26, 'Lena', 0),
(42, 'Nikita', 1),
(45, 'Roman', 2),
(48, 'mathieu', 2),
(53, 'vale', 0);

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
(0, 'lalala'),
(4, 'P2I 6'),
(3, 'New Project'),
(2, 'P2I 2'),
(1, 'Algo');

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
  `mdp` varchar(255) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`userID`, `username`, `prenom`, `nom`, `mdp`) VALUES
(2, 'neeeekitos', 'Nikita', 'TEREKHOV', 'neeeekitos'),
(3, 'lena', 'Lena', 'LEHMANN', 'lena'),
(4, 'roman', 'Roman', 'HOCHHAUSEN', 'roman'),
(5, 'vale', 'Valentina', 'Etegan', 'lalala'),
(6, 'lehmann', 'Lena', 'Lehmann', 'QWerty123#');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
