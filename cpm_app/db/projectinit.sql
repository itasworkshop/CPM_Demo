INSERT INTO PROJECT (
  ID,
  PID,
  NAME,
  TASK
  )
  SELECT
    ID,
    PID,
    NAME,
    TASK
  FROM
    CSVREAD('./db/PROJECT.csv', NULL, 'UTF-8');