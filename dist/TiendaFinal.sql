CREATE DATABASE Tienda CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE Tienda;
CREATE TABLE Personas(
	Id_Persona INT AUTO_INCREMENT PRIMARY KEY,
	Nombre_s VARCHAR(50) NOT NULL,
	Apellido_s VARCHAR(60) NOT NULL,
	Telefono VARCHAR(20) NOT NULL,
	Correo VARCHAR(50) NOT NULL,
	Contraseña VARCHAR(50) NOT NULL,
	Imagen LONGBLOB NOT NULL,
	tipo_usuario INT NOT NULL,
    credito DOUBLE
	);
SHOW TABLES;
CREATE TABLE Almacen(
	Id_Producto INT AUTO_INCREMENT PRIMARY KEY,
	Titulo VARCHAR(50) NOT NULL,
	Descripcion TEXT NOT NULL,
	Costo DECIMAL(10, 2) NOT NULL,
	Categoria INT NOT NULL,
	Foto LONGBLOB NOT NULL,
	Id_admin INT NOT NULL, 
	Cantidad INT NOT NULL
);
SHOW TABLES;
CREATE TABLE Carrito(
	Id_Carrito INT AUTO_INCREMENT PRIMARY KEY,
	Id_usuario INT NOT NULL,
	Id_producto INT NOT NULL,
	Cantidad INT NOT NULL
);
SHOW TABLES;
CREATE TABLE Quejas(
	Id_Queja INT AUTO_INCREMENT PRIMARY KEY,
	Titulo VARCHAR(50) NOT NULL,
	Descripcion TEXT NOT NULL,
	Id_usuario INT NOT NULL,
	Respuesta TEXT,
	Id_admin INT
);
ALTER TABLE Almacen ADD CONSTRAINT fk_ProAdmin FOREIGN KEY (Id_admin) REFERENCES Personas(Id_Persona)
ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Carrito ADD CONSTRAINT fk_CarrUsua FOREIGN KEY (Id_usuario) REFERENCES Personas(Id_Persona)
ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Carrito ADD CONSTRAINT fk_ProdU_ProdCarr FOREIGN KEY (Id_producto) REFERENCES Almacen(Id_Producto)
ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Quejas ADD CONSTRAINT fk_QuedUsu FOREIGN KEY (Id_usuario) REFERENCES Personas(Id_Persona)
ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Quejas ADD CONSTRAINT fk_QueRdAdm FOREIGN KEY (Id_admin) REFERENCES Personas(Id_Persona)
ON DELETE CASCADE ON UPDATE CASCADE;

INSERT INTO Personas(Nombre_s, Apellido_s, Telefono, Correo, Contraseña, Imagen, tipo_usuario) 
VALUES ("Victor", "Santiago", "12546789", "superadmin@hotmail.com",	"889a3a791b3875cfae413574b53da4bb8a90d53e",	"red.jpg", 0);
INSERT INTO Personas(Nombre_s, Apellido_s, Telefono, Correo, Contraseña, Imagen, tipo_usuario) 
VALUES ("Victor", "Ramirez", "232344321", "admin@hotmail.com",	"d033e22ae348aeb5660fc2140aec35850c4da997",	"red.jpg", 1);