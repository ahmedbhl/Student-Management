INSERT INTO `admin`(`Actived`, `email`, `motDePasse`, `nom`, `numTel`, `prenom`) VALUES (1,'admin@admin.com','0cc175b9c0f1b6a831c399e269772661','admin',99999999,'admin');

INSERT INTO `role`(`roleName`, `idAdmin`) VALUES ('ROLE_ADMIN',LAST_INSERT_ID());