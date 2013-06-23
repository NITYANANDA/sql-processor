DROP TABLE IF EXISTS AUTH_USER CASCADE;
DROP TABLE IF EXISTS AUTH_ROLE CASCADE;
DROP TABLE IF EXISTS USER_ROLE CASCADE;
DROP TABLE IF EXISTS USER_SESSION CASCADE;

CREATE TABLE AUTH_USER (
  ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  USERNAME VARCHAR(30) NOT NULL,
  PASSWORD VARCHAR(50),
  NAME VARCHAR(100) NOT NULL, 
  EMAIL VARCHAR(100),
  LAST_LOGIN TIMESTAMP,
  VERSION INT NOT NULL DEFAULT 0
);

CREATE INDEX IX_AUTH_USER_USERNAME ON AUTH_USER (USERNAME);

CREATE TABLE AUTH_ROLE (
  ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(100) NOT NULL, 
  DESCRIPTION VARCHAR(100) NULL,
  VERSION INT NOT NULL DEFAULT 0
);

CREATE TABLE USER_ROLE (
  ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  AUTH_USER_ID BIGINT NOT NULL,
  AUTH_ROLE_ID BIGINT NOT NULL,
  VERSION INT NOT NULL DEFAULT 0
);

ALTER TABLE USER_ROLE ADD CONSTRAINT FK_USER_ROLE_AUTH_USER
	FOREIGN KEY (AUTH_USER_ID) REFERENCES AUTH_USER (ID) ON DELETE CASCADE
;

ALTER TABLE USER_ROLE ADD CONSTRAINT FK_USER_ROLE_AUTH_ROLE
	FOREIGN KEY (AUTH_ROLE_ID) REFERENCES AUTH_ROLE (ID) ON DELETE CASCADE
;

CREATE INDEX IX_USER_ROLE_USER_ID ON USER_ROLE (AUTH_USER_ID);

CREATE INDEX IX_USER_ROLE_ROLE_ID ON USER_ROLE (AUTH_ROLE_ID);

CREATE TABLE USER_SESSION (
  ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  AUTH_USER_ID BIGINT NOT NULL,
  LAST_ACCESS TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)
;

ALTER TABLE USER_SESSION ADD CONSTRAINT FK_USER_SESSION_AUTH_USER
	FOREIGN KEY (AUTH_USER_ID) REFERENCES AUTH_USER (ID) ON DELETE CASCADE
;

CREATE INDEX IX_USER_SESSION_ROLE_ID ON USER_SESSION (AUTH_USER_ID);
