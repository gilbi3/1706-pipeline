DROP TABLE st_user;
DROP TABLE user_role;


CREATE TABLE st_user(
  user_id NUMBER,
  username VARCHAR2(4000),
  first_name VARCHAR2(4000),
  last_name VARCHAR2(4000),
  pw VARCHAR2(4000),
  user_role_id NUMBER,
  PRIMARY KEY (user_id),
  FOREIGN KEY (user_role_id) REFERENCES user_role(user_role_id)
);

CREATE TABLE user_role(
  user_role VARCHAR2(4000),
  user_role_id NUMBER,
  PRIMARY KEY (user_role_id)
);

CREATE SEQUENCE  "STUDENT_TEACHER_DB"."INCR_SEQ"  
MINVALUE 1 
MAXVALUE 999999999999 
INCREMENT BY 1 
START WITH 1 
CACHE 20 
NOORDER  
NOCYCLE ;

CREATE OR REPLACE TRIGGER user_trig
BEFORE INSERT ON st_user
FOR EACH ROW
BEGIN
  IF :new.user_id IS NULL THEN
    SELECT incr_seq.nextval INTO :new.user_id FROM DUAL;                                                  
  END IF;
END;
/