connect 'jdbc:derby:RssfResultsDB;';

SELECT c.name, c.season, phase, t1.name team1, t2.name team2, leg1_1,leg1_2,leg2_1,leg2_2,total1,total2
FROM ((MATCH_PAIR m JOIN  TEAM t1 ON m.team1 = t1.id) 
JOIN TEAM t2 ON m.team2 = t2.id)
JOIN COMPETITION c ON c.id = m.competition
ORDER BY c.season, c.name;