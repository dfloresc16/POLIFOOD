CREATE DATABASE POLIFOOD;
DROP DATABASE POLIFOOD;
USE POLIFOOD;

CREATE TABLE Usuarios(
	id INT NOT NULL AUTO_INCREMENT,
    correo varchar(50) NOT NULL,
    celular varchar(12) NOT NULL,
    contrasenia varchar(20) NOT NULL,
    boleta varchar(10) NOT NULL,
    primary key(id)
);


CREATE TABLE Personales(
	id_usuario_fk int NOT NULL,
    nombre varchar(50) NOT NULL,
    paterno varchar(50) NOT NULL,
    materno varchar(50) NOT NULL,
    primary key(id_usuario_fk),
    foreign key(id_usuario_fk) references Usuarios(id) ON DELETE CASCADE ON UPDATE CASCADE 
);


-- CREATE TABLE Productos(
-- 	id_producto int NOT NULL AUTO_INCREMENT,
--     id_usuario_fk int NOT NULL,
--     primary key(id_producto), 
--     foreign key (id_usuario_fk) references Usuarios(id) ON DELETE CASCADE ON UPDATE CASCADE 
-- );


CREATE TABLE Datos_producto(
	id_datos int NOT NULL AUTO_INCREMENT,
    id_usuario_fk int NOT NULL,
    nombre_producto varchar(20) NOT NULL,
    precio float NOT NULL,
    descripcion varchar(50) NULL,
    primary key(id_datos),
    foreign key (id_usuario_fk) references Usuarios(id) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE Ordenes(
	id_compra int auto_increment,
   -- id_usuariov_fk int NOT NULL,
    id_datos_fk int NOT NULL,
    cantidad int NOT NULL,
    primary key (id_compra),
    -- foreign key (id_usuario_fk) references Usuarios(id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key (id_datos_fk) references Datos_producto(id_datos) ON DELETE CASCADE ON UPDATE CASCADE 
);


CREATE TABLE Ventas(
	id_usuario_fk int, 
    id_compra_fk int,
    mensaje varchar(250) NOT NULL,
    primary key(id_compra_fk),
    foreign key(id_compra_fk) references Ordenes(id_compra)ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key(id_Usuario_fk) references Usuarios(id) ON DELETE CASCADE ON UPDATE CASCADE 
);


CREATE TABLE Solicitud(
	id_solicitud int NOT NULL auto_increment,
    id_compra_fk int NOT NULL,
    id_producto_fk int NOT NULL,
    primary key(id_solicitud),
    foreign key(id_compra_fk) references Ordenes(id_compra)ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key(id_producto_fk) references Productos(id_producto) ON DELETE CASCADE ON UPDATE CASCADE 
);


