-- ROLES
INSERT INTO app_role (id, role_name) VALUES (1, 'ROLE_USER');
INSERT INTO app_role (id, role_name) VALUES (2, 'ROLE_ADMIN');

-- USERS
-- SHA-256 encrypted password is: secret
INSERT INTO app_user (id, username, name, password) VALUES (1, 'mulderbaba', 'Mert Caliskan', '2bb80d537b1da3e38bd30361aa855686bde0eacd7162fef6a25fe97bf527a25b');
INSERT INTO app_user (id, username, name, password) VALUES (2, 'ondrejm', 'Ondrej Mihalyi', '2bb80d537b1da3e38bd30361aa855686bde0eacd7162fef6a25fe97bf527a25b');
INSERT INTO app_user (id, username, name, password) VALUES (3, 'pscheidl', 'Pavel Pscheidl', '2bb80d537b1da3e38bd30361aa855686bde0eacd7162fef6a25fe97bf527a25b');

-- USER, ROLE mapping
INSERT INTO user_role(user_id, role_id) VALUES(1,2);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(3,1);