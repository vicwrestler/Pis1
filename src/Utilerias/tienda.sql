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
	tipo_usuario INT NOT NULL
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

SET @img="red.jpg";
SELECT * FROM Almacen;

INSERT INTO Personas(Nombre_s, Apellido_s, Telefono, Correo, Contraseña, Imagen, tipo_usuario) 
VALUES ("Manuel", "Santiago", "12546789", "w-restler@hotmail.com",	"1234",	@img, 1);
INSERT INTO Personas(Nombre_s, Apellido_s, Telefono, Correo, Contraseña, Imagen, tipo_usuario) 
VALUES ("Victor", "Ramirez", "232344321", "w-restler@hotmail.com",	"1234",	@img, 0);
INSERT INTO Personas(Nombre_s, Apellido_s, Telefono, Correo, Contraseña, Imagen, tipo_usuario) 
VALUES ("Meliodas", "pecado",	"12125689",	"prueba@gmail.com",	"1234",	@img, 1);
INSERT INTO Personas(Nombre_s, Apellido_s, Telefono, Correo, Contraseña, Imagen, tipo_usuario) 
VALUES ("Escanor", "pecado", "23877543", "prueba@gmail.com", "1234", @img, 1);
INSERT INTO Personas(Nombre_s, Apellido_s, Telefono, Correo, Contraseña, Imagen, tipo_usuario) 
VALUES ("Denise", "Ramirez", "76456709", "prueba@gmail.com", "12345", @img, 2);
INSERT INTO Personas(Nombre_s, Apellido_s, Telefono, Correo, Contraseña, Imagen, tipo_usuario) 
VALUES ("Emily", "Blunt", "32456789", "prueba@gmail.com", "1234", @img, 2);
INSERT INTO Personas(Nombre_s, Apellido_s, Telefono, Correo, Contraseña, Imagen, tipo_usuario) 
VALUES ("Scarlett", "Johanson", "12342412", "prueba@gmail.com", "1234", @img, 2);

SET @mensaje="Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi qui, iste omnis quo vitae odio autem ipsa pariatur fuga consectetur perferendis repellat, sit tempore magnam, necessitatibus laboriosam dolorem quas molestias.";
INSERT INTO Almacen(Titulo, Descripcion, Costo, Categoria, Foto, Id_admin, Cantidad)
VALUES ("Arduino", @mensaje, 150.00, 0, @img, 2, 100);
INSERT INTO Almacen(Titulo, Descripcion, Costo, Categoria, Foto, Id_admin, Cantidad)
VALUES ("Led", @mensaje, 1.00, 1, @img, 2, 1000);
INSERT INTO Almacen(Titulo, Descripcion, Costo, Categoria, Foto, Id_admin, Cantidad)
VALUES ("Servomotor", @mensaje, 80.00, 2, @img, 4, 50);
INSERT INTO Almacen(Titulo, Descripcion, Costo, Categoria, Foto, Id_admin, Cantidad)
VALUES ("Rasperry", @mensaje, 1150.00, 0, @img, 3, 20);
INSERT INTO Almacen(Titulo, Descripcion, Costo, Categoria, Foto, Id_admin, Cantidad)
VALUES ("Amplificador", @mensaje, 150.00, 4, @img, 4, 100);

INSERT INTO Carrito(Id_usuario, Id_producto, Cantidad) VALUES(3, 2, 20);
INSERT INTO Carrito(Id_usuario, Id_producto, Cantidad) VALUES(5, 5, 19);
INSERT INTO Carrito(Id_usuario, Id_producto, Cantidad) VALUES(3, 1, 1);

#------------------------------------------------------------------------------------------

SELECT Titulo, Descripcion, Costo, Foto FROM Almacen;
SELECT * FROM Personas WHERE tipo_usuario=2;
SELECT * FROM Almacen WHERE Id_admin=2;
SELECT P.Nombre_s FROM Carrito AS C INNER JOIN Personas AS P ON P.Id_Persona=C.Id_usuario;
SELECT * FROM Personas WHERE tipo_usuario=1;
SELECT A.Titulo, A.Costo, A.Foto, C.Cantidad FROM Almacen AS A, Carrito AS C WHERE C.Id_usuario=3 AND A.Id_Producto=C.Id_producto;
SELECT * FROM Almacen WHERE Categoria=0;
SELECT Titulo, Descripcion,Costo, Categoria, Foto, Id_admin, Cantidad FROM almacen, Personas WHERE Titulo=Arduino AND Id_admin=Id_Persona
SELECT * FROM almacen, Personas WHERE Id_Persona=Id_admin