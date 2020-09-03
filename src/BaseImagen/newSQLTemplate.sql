

CREATE DATABASE imagenes;
USE imagenes;

CREATE TABLE usuario 
(
id_usuario INT AUTO_INCREMENT,
nombre VARCHAR (90),
foto BLOB ,
PRIMARY KEY(id_usuario)
); 
