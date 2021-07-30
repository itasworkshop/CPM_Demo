DROP TABLE IF EXISTS TASK;
CREATE TABLE TASK (
    ID          INTEGER NOT NULL AUTO_INCREMENT
  , NAME VARCHAR2(5)
  , cost  NUMBER
  , DEPENDENCIES VARCHAR2(50)
  , PRIMARY KEY (ID)
);