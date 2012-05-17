CREATE TABLE COMPETITION (
   id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
   name VARCHAR(50), 
   season VARCHAR(10),
   uri VARCHAR(80),
   CONSTRAINT competition_pk PRIMARY KEY (id)
);

CREATE TABLE PHASE (
   competition INTEGER NOT NULL, 
   name VARCHAR(50) NOT NULL, 
   uri VARCHAR(80),
   CONSTRAINT phase_pk PRIMARY KEY (competition,name),
   CONSTRAINT phase_fk FOREIGN KEY (competition) REFERENCES COMPETITION(id)
);

CREATE TABLE TEAM (
   id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
   name VARCHAR(50) NOT NULL, 
   country VARCHAR(3) NOT NULL,
   CONSTRAINT team_pk PRIMARY KEY (id)
);

CREATE TABLE MATCH_PAIR (
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	team1 INTEGER NOT NULL, 
	team2 INTEGER NOT NULL,
	leg1_1 INTEGER NOT NULL,
	leg1_2 INTEGER NOT NULL,
	leg2_1 INTEGER NOT NULL,
	leg2_2 INTEGER NOT NULL,
	total1 INTEGER NOT NULL,
	total2 INTEGER NOT NULL,	
	competition INTEGER NOT NULL,
	phase VARCHAR(50) NOT NULL,
	uri VARCHAR(80),
	CONSTRAINT match_pair_pk PRIMARY KEY (id),
	CONSTRAINT match_pair_phase_fk FOREIGN KEY (competition,phase) REFERENCES PHASE(competition,name),
	CONSTRAINT match_pair_team1_fk FOREIGN KEY (team1) REFERENCES TEAM(id),
	CONSTRAINT match_pair_team2_fk FOREIGN KEY (team2) REFERENCES TEAM(id)
);





-- SELECTS AND INSERTS DE PRUEBA 

SELECT id FROM COMPETITION WHERE name='Champions Cup' AND season='1966-67';
INSERT INTO COMPETITION (name,season,uri) VALUES ('Champions Cup','1966-67','');

SELECT * FROM PHASE WHERE competition=1 AND name='Semi-Finals';
INSERT INTO PHASE (competition,name,uri) VALUES (1,'Semi-Finals','');

SELECT id FROM TEAM WHERE name='Barcelona FC' AND country='Esp';
INSERT INTO TEAM (name,country) VALUES ('Barcelona FC','Esp');

SELECT * FROM MATCH_PAIR;
INSERT INTO MATCH_PAIR (team1,team2,leg1_1,leg1_2,leg2_1,leg2_2,total1,total2,competition,phase) 
VALUES (1,1,1,2,1,2,1,2,1,'Semi-Finals');


SELECT c.name, c.season, phase, t1.name team1, t2.name team2, leg1_1,leg1_2,leg2_1,leg2_2,total1,total2
FROM ((MATCH_PAIR m JOIN  TEAM t1 ON m.team1 = t1.id) 
JOIN TEAM t2 ON m.team2 = t2.id)
JOIN COMPETITION c ON c.id = m.competition
ORDER BY c.season, c.name; 