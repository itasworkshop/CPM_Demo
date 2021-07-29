INSERT INTO TASK (
  ID,
  NAME,
  COST,
  dependencies
  )
  SELECT
    ID,
    NAME,
    COST,
    dependencies
  FROM
    CSVREAD('./db/TASKS.csv', NULL, 'UTF-8');