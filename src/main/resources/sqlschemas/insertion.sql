
-- ******************************************************************************* --
-- Fichier SQL à exécuter pour remplir la base de données avec des valeurs de test --
-- ******************************************************************************* --

INSERT INTO enseignants (id, nom_famille, prenom,created_at)
VALUES (nextval('personne_seq'),'Zaghdoudi','Sofien',now());
INSERT INTO enseignants (id, nom_famille, prenom,created_at)
VALUES (nextval('personne_seq'),'Ben Foulen','Mohamed',now());
INSERT INTO classes (id, nom, enseignant_id,created_at)
VALUES (nextval('classe_seq'), 'Classe1', (select id from enseignants where nom_famille ='Zaghdoudi'),now());
INSERT INTO classes (id, nom, enseignant_id,created_at)
VALUES (nextval('classe_seq'), 'Classe2', (select id from enseignants where nom_famille ='Ben Foulen'),now());
INSERT INTO etudiants (id, nom_famille, prenom, classe_id, created_at)
VALUES (nextval('personne_seq'), 'Adam', 'Zaghdoudi', (select id from classes where nom ='Classe1'),now());
INSERT INTO etudiants (id, nom_famille, prenom, classe_id, created_at)
VALUES (nextval('personne_seq'), 'Eya', 'Zaghdoudi', (select id from classes where nom ='Classe1'),now());
INSERT INTO etudiants (id, nom_famille, prenom, classe_id, created_at)
VALUES (nextval('personne_seq'), 'Elma', 'Zaghdoudi', (select id from classes where nom ='Classe2'),now());
INSERT INTO etudiants (id, nom_famille, prenom, classe_id, created_at)
VALUES (nextval('personne_seq'), 'Amen Allah', 'Zaghdoudi', (select id from classes where nom ='Classe2'),now());