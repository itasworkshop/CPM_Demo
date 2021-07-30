INSERT INTO TEAM (
  ID,
  NAME,
  PID
  )
  SELECT
    ID,
    NAME,
    PID
  FROM
    CSVREAD('./db/TEAMS.csv', NULL, 'UTF-8');