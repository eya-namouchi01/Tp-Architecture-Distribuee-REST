
INSERT INTO adresse (pays,ville,rue, gps_position) VALUES
('France', 'Paris', 'Rue de Rivoli', '48.8566,2.3522'),
('France', 'Marseille', 'Vieux Port', '43.2965,5.3698');


INSERT INTO agence (nom, login, mot_de_passe) VALUES
('Leclerc', 'login3', 'pass3');


INSERT INTO credit_card (num_carte, date_expiration, cvv) VALUES
('1111222233334444', '2026-12', '123'),
('5555666677778888', '2027-06', '456'),
('9999000011112222', '2025-11', '789');


INSERT INTO client (id, email, nom, prenom, telephone, credit_card_id) VALUES
(1, 'client1@email.com', 'Nom1', 'Prenom1', '12345678', 1),
(2, 'client2@email.com', 'Nom2', 'Prenom2', '87654321', 2),
(3, 'client3@email.com', 'Nom3', 'Prenom3', '11223344', 3);


INSERT INTO chambre (nb_lits, prix, img) VALUES
(2, 155.0, NULL),
(3, 200.0, NULL),
(4, 300.0, NULL),
(2, 200.0, NULL),
(3, 300.0, NULL),
(4, 400.0, NULL);



INSERT INTO hotel (nom, categorie, nb_lits, adresse_id) VALUES
('Oceania', 'etoiles3', 10, 1),
('Radisson', 'etoiles5', 20, 3);


INSERT INTO offre (
  prix,
  date_debut_disponibilte,
  datefin_disponibilite,
  nbre_lits,
  hotel_id,
  chambre_id,
  agence_id
) VALUES
(300.0, '2025-12-10', '2025-12-20', 4, 1, 3, 1);
(300.0, '2025-12-05', '2025-12-15', 3, 2, 5, 1),
(400.0, '2025-12-10', '2025-12-20', 4, 2, 6, 1);



INSERT INTO reservation (
  offre_id,
  date_entree,
  date_sortie,
  client_email
) VALUES
(1, '2025-12-14', '2025-12-18', 'client3@email.com');
(1, '2025-12-06', '2025-12-10', 'client2@email.com'),
(4, '2025-12-14', '2025-12-20', 'client3@email.com');