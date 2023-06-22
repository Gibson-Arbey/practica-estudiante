CREATE TABLE IF NOT EXISTS jornada (
id INT NOT NULL AUTO_INCREMENT,
nombre varchar(20),
PRIMARY KEY (id),
UNIQUE KEY (nombre)
);

INSERT IGNORE INTO jornada (id,nombre) VALUES
(1,"diurna"),
(2,"nocturna");