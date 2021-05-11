INSERT INTO news
(title,description)
VALUES
('Wygrana ZAKSY', 'Drużyna ZAKSY wygrała lige mistrzów'),
('Transfer Wlazłego', 'Wlazly przechodzi'),
('Spadek Będzina', 'Drużyna ze śląska spada z pluslig');

INSERT INTO stats
(GAINED_POINTS,GAINED_SETS, LOST_POINTS, LOST_SETS,TOTAL_POINTS)
VALUES
(1,2,3,4,5),
(1241,1231,321,2,1),
(1234,123,213,123,2132);

INSERT INTO teams
(team_name,city, STATS_ID)
VALUES
('Asseco', 'Rzeszów',1),
('Trefl', 'Gdańsk',2),
('Jastrzębski', 'Węgiel',3);

INSERT INTO players
(first_name,last_name,team_id)
VALUES
('Mariusz', 'Wlazły', 1),
('Piotr', 'Gruszka', 2),
('Mateusz', 'Mika', 3);
