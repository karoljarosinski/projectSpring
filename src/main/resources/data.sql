INSERT INTO news
(title,description)
VALUES
('Wygrana ZAKSY', 'Drużyna ZAKSY wygrała lige mistrzów'),
('Transfer Wlazłego', 'Wlazly przechodzi'),
('Spadek Będzina', 'Drużyna ze śląska spada z pluslig');

INSERT INTO teams
(Nazwa,Miasto)
VALUES
('Asseco', 'Rzeszów'),
('Trefl', 'Gdańsk'),
('Jastrzębski', 'Węgiel');

INSERT INTO players
(Imie,Nazwisko, team_id)
VALUES
('Mariusz', 'Wlazły', 1),
('Piotr', 'Gruszka', 2),
('Mateusz', 'Mika', 3);