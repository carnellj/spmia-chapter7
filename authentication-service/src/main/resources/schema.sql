DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS user_orgs;


CREATE TABLE user_orgs (
  organization_id   VARCHAR(100)  NOT NULL,
  user_name         VARCHAR(100)   NOT NULL,
  PRIMARY KEY (user_name));


INSERT INTO user_orgs (organization_id, user_name) VALUES ('d1859f1f-4bd7-4593-8654-ea6d9a6a626e', 'john.carnell');
INSERT INTO user_orgs (organization_id, user_name) VALUES ('42d3d4f5-9f33-42f4-8aca-b7519d6af1bb', 'william.woodward');
