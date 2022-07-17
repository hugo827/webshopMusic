USE webshopmusicdb;

CREATE USER 'dbconnect'@'localhost' IDENTIFIED WITH mysql_native_password BY 'connect';

GRANT SELECT, INSERT, UPDATE, DELETE ON webshopmusicdb.* TO 'dbconnect'@'localhost';