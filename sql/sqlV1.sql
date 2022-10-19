use donani;

#CREACION TABLAS
CREATE TABLE Usuarios (
	id int NOT NULL auto_increment,
    nombre VARCHAR(50) NOT NULL,
    tipoIdentificacion VARCHAR(3) NOT NULL,
    identificacion VARCHAR(20) NOT NULL,
    correo VARCHAR(50) NOT NULL,
    passwd VARCHAR(20) NOT NULL,
    telefono NUMERIC(10) NOT NULL,
    primary key(id)
);

CREATE TABLE Categorias (
	id NUMERIC(9) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    primary key(id)
);

CREATE TABLE Productos (
	id int NOT NULL auto_increment,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(70),
    precio NUMERIC(15) NOT NULL,
    cantidad NUMERIC(9) NOT NULL,
    categoria NUMERIC(9) NOT NULL,
    estado VARCHAR(1) NOT NULL,
    imagen VARCHAR(200) NOT NULL,
    primary key(id),
    FOREIGN KEY(categoria) REFERENCES categorias(id)
	ON DELETE CASCADE ON UPDATE CASCADE
);


#INSERTS
#Categorias
INSERT INTO Categorias (id, nombre) VALUES (1, 'TECNOLOGIA');
INSERT INTO Categorias (id, nombre) VALUES (2, 'HOGAR');
INSERT INTO Categorias (id, nombre) VALUES (3, 'MODA');
INSERT INTO Categorias (id, nombre) VALUES (4, 'DEPORTE');
INSERT INTO Categorias (id, nombre) VALUES (5, 'JUGUETES');
INSERT INTO Categorias (id, nombre) VALUES (6, 'LIBROS');



#Productos
INSERT INTO Productos( nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Iphone14','Nuevo Iphone 14 Pro Max',13000000,1,1,'D','https://www.apple.com/v/iphone-14-pro/a/images/meta/iphone-14-pro_overview__e2a7u9jy63ma_og.png?202210041411');
INSERT INTO Productos(nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Iphone13','Nuevo Iphone 13 Pro Max',6000000,5,1,'D','https://http2.mlstatic.com/D_NQ_NP_640390-MLA48035617078_102021-O.jpg');
INSERT INTO Productos( nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Samsung Galaxy S22','Nuevo Samsung S22',5000000,10,1,'D','https://http2.mlstatic.com/D_NQ_NP_997614-MLA49303777721_032022-O.jpg');



#CONSULTAS
SELECT * FROM productos;
SELECT * FROM categorias;
SELECT * FROM usuarios;

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'diego12345';

#DROPS
drop table usuarios;
drop table productos;
drop table categorias;