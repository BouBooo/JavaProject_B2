-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Dim 02 Juin 2019 à 20:21
-- Version du serveur :  10.1.37-MariaDB-0+deb9u1
-- Version de PHP :  7.0.33-0+deb9u3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `anniversaires`
--

-- --------------------------------------------------------

--
-- Structure de la table `anniv`
--

CREATE TABLE `anniv` (
  `id` int(11) NOT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `anneeNaissance` int(11) NOT NULL DEFAULT '1996',
  `sexe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `anniv`
--

INSERT INTO `anniv` (`id`, `prenom`, `nom`, `anneeNaissance`, `sexe`) VALUES
(1, 'Florent', 'NICOLAS', 1996, 0),
(2, 'Silouan', 'LE COSSEC', 1996, 0),
(3, 'Quentin', 'GANS', 1999, 1),
(4, 'Axel', 'PARIS', 1999, 0);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `anniv`
--
ALTER TABLE `anniv`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `anniv`
--
ALTER TABLE `anniv`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
