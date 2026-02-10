
INSERT INTO adresse (pays,ville,rue, gps_position) VALUES
('France', 'Paris', 'Rue de Rivoli', '48.8566,2.3522'),
('France', 'Paris', 'Place Bellecour', '45.7640,4.8357'),
('France', 'Marseille', 'Vieux Port', '43.2965,5.3698');


INSERT INTO agence (nom, login, mot_de_passe) VALUES
('Voyages E.Leclerc', 'login1', 'pass1'),
('Giromarfly', 'login2', 'pass2'),
('Carrefour Voyages', 'login3', 'pass3');


INSERT INTO credit_card (num_carte, date_expiration, cvv) VALUES
('1111222233334444', '2026-12', '123'),
('5555666677778888', '2027-06', '456'),
('9999000011112222', '2025-11', '789');


INSERT INTO client (id, email, nom, prenom, telephone, credit_card_id) VALUES
(1, 'client1@email.com', 'Nom1', 'Prenom1', '12345678', 1),
(2, 'client2@email.com', 'Nom2', 'Prenom2', '87654321', 2),
(3, 'client3@email.com', 'Nom3', 'Prenom3', '11223344', 3);


INSERT INTO chambre (nb_lits, prix, img) VALUES
(2, 100.0, NULL),
(3, 150.0, NULL),
(4, 200.0, NULL);


INSERT INTO hotel (nom, categorie, nb_lits, adresse_id) VALUES
('Oceania', 'etoiles3', 10, 1),
('Belaroïa', 'etoiles3', 15, 2),
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
(100.0, '2025-12-01', '2025-12-10', 2, 1, 1, 1),
(150.0, '2025-12-05', '2025-12-15', 3, 1, 2, 1),
(200.0, '2025-12-10', '2025-12-20', 4, 3, 3, 2),
(250.0, '2025-12-13', '2025-12-23', 4, 1, 2, 3);



INSERT INTO reservation (
  offre_id,
  date_entree,
  date_sortie,
  client_email
) VALUES
(3, '2025-12-06', '2025-12-10', 'client2@email.com'),
(4, '2025-12-14', '2025-12-20', 'client3@email.com');