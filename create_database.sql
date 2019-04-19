CREATE TABLE IF NOT EXISTS `anniv` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prenom` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `anneeNaissance` date DEFAULT NULL,
  `sexe` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)) 
