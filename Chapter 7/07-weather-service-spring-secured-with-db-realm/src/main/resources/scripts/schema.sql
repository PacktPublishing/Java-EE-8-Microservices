CREATE TABLE app_user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  username varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE app_role (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  role_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE user_role (
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  CONSTRAINT FKZm9yZWlnbmtleQ1246ad1135f FOREIGN KEY (user_id) REFERENCES app_user (id),
  CONSTRAINT FKaGViZWxlaHViZWxl121dv3456 FOREIGN KEY (role_id) REFERENCES app_role (id)
);