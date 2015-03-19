--
-- Structure de la table `takeaphotoforme_demandes`
--
CREATE TABLE IF NOT EXISTS `takeaphotoforme_demandes` (
> `id_demande` int(11) NOT NULL AUTO\_INCREMENT,
> `id_user` int(11) NOT NULL,
> `longitude` varchar(255) NOT NULL,
> `latitude` varchar(255) NOT NULL,
> `description` varchar(255) NOT NULL,
> `etat` int(11) NOT NULL,
> `timestamp` timestamp NOT NULL DEFAULT CURRENT\_TIMESTAMP,
> PRIMARY KEY (`id_demande`),
> KEY `id_user` (`id_user`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO\_INCREMENT=141 ;

--
-- Structure de la table `takeaphotoforme_users`
--
CREATE TABLE IF NOT EXISTS `takeaphotoforme_users` (
> `id_user` int(11) NOT NULL AUTO\_INCREMENT,
> `login` varchar(40) NOT NULL,
> `password` text NOT NULL,
> `date_creation` timestamp NOT NULL DEFAULT CURRENT\_TIMESTAMP,
> PRIMARY KEY (`id_user`),
> UNIQUE KEY `login` (`login`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO\_INCREMENT=55 ;