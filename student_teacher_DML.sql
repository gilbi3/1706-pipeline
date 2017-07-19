INSERT INTO user_role VALUES('Teacher', 1);
INSERT INTO user_role VALUES('Student', 2);

INSERT INTO st_user(username, first_name, last_name, pw, user_role_id) 
  VALUES('pomona', 'Tabitha', 'Mourmont', '123', 1);
INSERT INTO st_user(username, first_name, last_name, pw, user_role_id) 
  VALUES('heraclitus', 'Bertrand', 'Russel', '123', 1);
INSERT INTO st_user(username, first_name, last_name, pw, user_role_id) 
  VALUES('scully', 'Bernie', 'Scully', '123', 2);
INSERT INTO st_user(username, first_name, last_name, pw, user_role_id) 
  VALUES('harlowestelle', 'Estelle', 'Harlowe', '123', 2);
INSERT INTO st_user(username, first_name, last_name, pw, user_role_id) 
  VALUES('Luy', 'Luanne', 'Wallace', '123', 2);
INSERT INTO st_user(username, first_name, last_name, pw, user_role_id) 
  VALUES('gottfried', 'Gottfried', 'Anhelm', '123', 2);
INSERT INTO st_user(username, first_name, last_name, pw, user_role_id) 
  VALUES('skippy', 'Skip', 'Williamson', '123', 2);
  
SELECT * FROM st_user;

SELECT st.user_id, st.username, st.first_name, st.last_name, st.pw, ur.user_role
FROM st_user st JOIN user_role ur ON st.user_role_id = ur.user_role_id;