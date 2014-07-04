-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 04 Juillet 2014 à 09:25
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `restotunisie`
--

-- --------------------------------------------------------

--
-- Structure de la table `carte`
--

CREATE TABLE IF NOT EXISTS `carte` (
  `id_carte` int(11) NOT NULL AUTO_INCREMENT,
  `nom_carte` varchar(30) DEFAULT NULL,
  `id_resto` int(11) DEFAULT NULL,
  `id_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_carte`),
  KEY `id_resto` (`id_resto`),
  KEY `fk_type` (`id_type`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=38 ;

--
-- Contenu de la table `carte`
--

INSERT INTO `carte` (`id_carte`, `nom_carte`, `id_resto`, `id_type`) VALUES
(1, 'Carte Boisson', 1, 1),
(2, 'Carte Pizza', 1, NULL),
(6, 'Carte Sandiwch', 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id_client` int(11) NOT NULL AUTO_INCREMENT,
  `nom_client` varchar(30) NOT NULL,
  `adresse_mail` varchar(30) NOT NULL,
  `tel` varchar(20) NOT NULL,
  PRIMARY KEY (`id_client`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id_client`, `nom_client`, `adresse_mail`, `tel`) VALUES
(16, 'Abdsalem', 'Abdsalem@gmail.com', '29582364'),
(17, 'souhaib', 'souhaib@gmail.com', '52630213');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `id_commande` int(11) NOT NULL AUTO_INCREMENT,
  `id_resto` int(11) DEFAULT NULL,
  `id_client` int(11) DEFAULT NULL,
  `commande` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_commande`),
  KEY `id_resto` (`id_resto`),
  KEY `id_client` (`id_client`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `commande`
--

INSERT INTO `commande` (`id_commande`, `id_resto`, `id_client`, `commande`) VALUES
(1, 1, 16, 'pizza'),
(2, 8, 17, 'couca');

-- --------------------------------------------------------

--
-- Structure de la table `contient`
--

CREATE TABLE IF NOT EXISTS `contient` (
  `id_carte` int(11) DEFAULT NULL,
  `id_type` int(11) DEFAULT NULL,
  KEY `id_carte` (`id_carte`),
  KEY `id_type` (`id_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `menu`
--

CREATE TABLE IF NOT EXISTS `menu` (
  `id_menu` int(11) NOT NULL AUTO_INCREMENT,
  `nom_menu` varchar(20) DEFAULT NULL,
  `prix` varchar(20) DEFAULT NULL,
  `id_type` int(11) DEFAULT NULL,
  `id_carte` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_menu`),
  KEY `id_menu` (`id_menu`),
  KEY `menu_ibfk_1` (`id_type`),
  KEY `fk_menu` (`id_carte`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `menu`
--

INSERT INTO `menu` (`id_menu`, `nom_menu`, `prix`, `id_type`, `id_carte`) VALUES
(1, 'CocaCola', '5000 dt', 1, 1),
(2, 'MARGHERITA', '8000 dt', 2, 2),
(3, 'NEAPOLITAN', '12000', 2, 2),
(4, 'Makloub', '3500 dt', 3, 6),
(5, 'Ton', '2000 dt', 3, 6);

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

CREATE TABLE IF NOT EXISTS `note` (
  `id_note` int(11) NOT NULL AUTO_INCREMENT,
  `id_resto` int(11) DEFAULT NULL,
  `id_client` int(11) DEFAULT NULL,
  `note` int(11) DEFAULT NULL,
  `commentaire` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id_note`),
  KEY `id_note` (`id_note`),
  KEY `note_ibfk_1` (`id_resto`),
  KEY `note_ibfk_2` (`id_client`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `note`
--

INSERT INTO `note` (`id_note`, `id_resto`, `id_client`, `note`, `commentaire`) VALUES
(1, 6, 16, 10, 'Joli'),
(2, 6, 16, 10, 'Cool'),
(3, 3, 17, 10, 'Bien'),
(4, 3, 17, 20, 'Trés bien'),
(5, 3, 16, 2, 'mal');

-- --------------------------------------------------------

--
-- Structure de la table `resto`
--

CREATE TABLE IF NOT EXISTS `resto` (
  `id_resto` int(11) NOT NULL AUTO_INCREMENT,
  `name_resto` varchar(30) NOT NULL,
  `place_resto` varchar(30) NOT NULL,
  `fourchette_resto` int(11) NOT NULL,
  PRIMARY KEY (`id_resto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=61 ;

--
-- Contenu de la table `resto`
--

INSERT INTO `resto` (`id_resto`, `name_resto`, `place_resto`, `fourchette_resto`) VALUES
(1, 'Gammarth Lounge', 'Gammarth', 3),
(3, 'Cap', 'Gammarth', 4),
(6, 'VillaDidon', 'Carthage', 4),
(8, 'My Way', 'LAC', 2),
(9, 'Dokena', 'Marsa plage', 2),
(39, 'Sindbad', 'Gammarth', 4),
(45, 'Boeuf', 'Soukra', 4);

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

CREATE TABLE IF NOT EXISTS `type` (
  `id_type` int(11) NOT NULL AUTO_INCREMENT,
  `nom_type` varchar(20) NOT NULL,
  PRIMARY KEY (`id_type`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `type`
--

INSERT INTO `type` (`id_type`, `nom_type`) VALUES
(1, 'Boisson'),
(2, 'pizza'),
(3, 'sandwich');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `carte`
--
ALTER TABLE `carte`
  ADD CONSTRAINT `fk_type` FOREIGN KEY (`id_type`) REFERENCES `type` (`id_type`),
  ADD CONSTRAINT `carte_ibfk_1` FOREIGN KEY (`id_resto`) REFERENCES `resto` (`id_resto`);

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`id_resto`) REFERENCES `resto` (`id_resto`),
  ADD CONSTRAINT `commande_ibfk_2` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`);

--
-- Contraintes pour la table `contient`
--
ALTER TABLE `contient`
  ADD CONSTRAINT `contient_ibfk_1` FOREIGN KEY (`id_carte`) REFERENCES `carte` (`id_carte`),
  ADD CONSTRAINT `contient_ibfk_2` FOREIGN KEY (`id_type`) REFERENCES `type` (`id_type`);

--
-- Contraintes pour la table `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `fk_menu` FOREIGN KEY (`id_carte`) REFERENCES `carte` (`id_carte`),
  ADD CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`id_type`) REFERENCES `type` (`id_type`);

--
-- Contraintes pour la table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `note_ibfk_1` FOREIGN KEY (`id_resto`) REFERENCES `resto` (`id_resto`),
  ADD CONSTRAINT `note_ibfk_2` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
