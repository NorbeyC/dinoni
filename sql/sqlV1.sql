use donani;

#CREACION TABLAS
CREATE TABLE Usuarios (
	id int NOT NULL auto_increment,
    nombre VARCHAR(50) unique NOT NULL,
    tipoIdentificacion VARCHAR(3) NOT NULL,
    identificacion VARCHAR(20) unique NOT NULL,
    correo VARCHAR(50) NOT NULL,
    passwd VARCHAR(20) NOT NULL,
    telefono NUMERIC(10) NOT NULL,
    primary key(id)
);


CREATE TABLE Productos (
	id int NOT NULL auto_increment,
    nombre VARCHAR(50) unique NOT NULL,
    descripcion VARCHAR(70),
    precio NUMERIC(15) NOT NULL,
    cantidad NUMERIC(9) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    estado VARCHAR(1) NOT NULL,
    imagen VARCHAR(255) NOT NULL,
    primary key(id)
);

CREATE TABLE Compras (
	id int NOT NULL auto_increment,
    identificacionUsuario VARCHAR(20) NOT NULL,
    nombreUsuario VARCHAR(50) NOT NULL,
    producto VARCHAR(50) NOT NULL,
    cantidad NUMERIC(9) NOT NULL,
    total NUMERIC(10) NOT NULL,
    primary key(id),
    FOREIGN KEY(identificacionUsuario) REFERENCES usuarios(identificacion)
	ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(nombreUsuario) REFERENCES usuarios(nombre)
	ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(producto) REFERENCES productos(nombre)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Resenas (
	id int NOT NULL auto_increment,
    producto VARCHAR(50) NOT NULL,
    identificacionUsuario VARCHAR(20) NOT NULL,
    nombreUsuario VARCHAR(50) NOT NULL,
    comentario VARCHAR(200) NOT NULL,
    primary key(id),
    FOREIGN KEY(identificacionUsuario) REFERENCES usuarios(identificacion)
	ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(nombreUsuario) REFERENCES usuarios(nombre)
	ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(producto) REFERENCES productos(nombre)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Ventas (
	id int NOT NULL auto_increment,
    ventasDia NUMERIC(10) NOT NULL,
    fecha VARCHAR(20) NOT NULL,
    ventasSemana NUMERIC(10) NOT NULL,
    ventasMes NUMERIC(10) NOT NULL,
    primary key(id)
);

CREATE TABLE Estadisticas (
	id int NOT NULL auto_increment,
    producto VARCHAR(50) NOT NULL,
    ventas NUMERIC(10) NOT NULL,
    primary key(id),
    FOREIGN KEY(producto) REFERENCES productos(nombre)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE nps (
	id int NOT NULL auto_increment,
    producto VARCHAR(50) NOT NULL,
    identificacionUsuario VARCHAR(20) NOT NULL,
    nombreUsuario VARCHAR(50) NOT NULL,
    satisfaccion decimal(10,2) NOT NULL,
    primary key(id),
    FOREIGN KEY(identificacionUsuario) REFERENCES usuarios(identificacion)
	ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(nombreUsuario) REFERENCES usuarios(nombre)
	ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(producto) REFERENCES productos(nombre)
	ON DELETE CASCADE ON UPDATE CASCADE
);


#INSERTS
#Categorias
#'TECNOLOGIA'
#'HOGAR'
#'MODA'
#'DEPORTE'
#'JUGUETES'
#'LIBROS'

#Productos
INSERT INTO Productos( nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Iphone14','Nuevo Iphone 14 Pro Max',13000000,1,'TECNOLOGIA','D','https://www.apple.com/v/iphone-14-pro/a/images/meta/iphone-14-pro_overview__e2a7u9jy63ma_og.png?202210041411');
INSERT INTO Productos(nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Iphone13','Nuevo Iphone 13 Pro Max',6000000,5,'TECNOLOGIA','D','https://http2.mlstatic.com/D_NQ_NP_640390-MLA48035617078_102021-O.jpg');
INSERT INTO Productos( nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Samsung Galaxy S22','Nuevo Samsung S22',5000000,10,'TECNOLOGIA','D','https://http2.mlstatic.com/D_NQ_NP_997614-MLA49303777721_032022-O.jpg');
INSERT INTO Productos( nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Galaxy Z Flip4','Nuevo Galaxy Z Flip4',4410800,1,'TECNOLOGIA','D','https://static.s-sfr.fr/media/catalogue/article/mobile/rhq5fiju/ZFlip4_lavande_Front-Table-Top-Side_400x540px.png');
INSERT INTO Productos(nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Huawei P50 pro 256GB','Nuevo Huawei P50 pro 256GB',6500000,5,'TECNOLOGIA','D','https://consumer.huawei.com/content/dam/huawei-cbg-site/latam/co/mkt/pdp/phones/p50-pro/Black.png');
INSERT INTO Productos( nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Samsung Galaxy Z Fold 3','Nuevo Samsung Galaxy Z Fold 3',8000000,10,'TECNOLOGIA','D','https://images.samsung.com/is/image/samsung/p6pim/ae/2108/gallery/ae-galaxy-z-fold3-f926-5g-sm-f926bzgdmea-thumb-477354387');
INSERT INTO Productos( nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Xiaomi 12 Pro 5G','Nuevo Xiaomi 12 Pro 5G',4300000,4,'TECNOLOGIA','D','https://co.celulares.com/fotos/xiaomi-12-pro-93483-g-alt.jpg');
INSERT INTO Productos( nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Motorola edge 30 Fusion','Nuevo Motorola edge 30 Fusion',4000000,4,'TECNOLOGIA','D','https://comoto.vtexassets.com/arquivos/motorola-edge-30-fusion-pdp-design-gallery-2-m-.jpg');
INSERT INTO Productos( nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Insta 360 one x2','Nueva Insta 360 one x2',2100000,5,'TECNOLOGIA','D','https://www.bhphotovideo.com/cdn-cgi/image/format=auto,fit=scale-down,width=500,quality=95/https://www.bhphotovideo.com/images/images500x500/insta360_cinosxx_a_one_x2_1603755936_1601137.jpg');
INSERT INTO Productos( nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Mini drone DJI Mini 3','Nuevo Mini drone DJI Mini 3',5220000,4,'TECNOLOGIA','D','https://http2.mlstatic.com/D_NQ_NP_2X_607049-MLA50334387993_062022-F.webp');
INSERT INTO Productos( nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Portátil Hp Gamer 15 Corei5','Nuevo Portátil Hp Gamer 15 Corei5',4180000,8,'TECNOLOGIA','D','https://http2.mlstatic.com/D_NQ_NP_2X_737136-MCO43291277065_082020-F.webp');
INSERT INTO Productos( nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Amazon Echo Dot 4th','Nuevo Amazon Echo Dot 4th',171200,7,'TECNOLOGIA','D','https://http2.mlstatic.com/D_NQ_NP_2X_750680-MLA45737899828_042021-F.webp');
INSERT INTO Productos( nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Audífonos inalámbricos Sony 1000X','Nuevos Audífonos inalámbricos Sony 1000X',1080000,4,'TECNOLOGIA','D','https://http2.mlstatic.com/D_NQ_NP_880985-MLA44483791963_012021-O.webp');
INSERT INTO Productos( nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Sony PlayStation 5','Nuevo Sony PlayStation 5',3600000,4,'TECNOLOGIA','D','https://res.cloudinary.com/walmart-labs/image/upload/w_960,dpr_auto,f_auto,q_auto:best/gr/images/product-images/img_large/00071171954176L.jpg');
INSERT INTO Productos( nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Aspiradora trapeadora robot Xiaomi','Nueva Aspiradora trapeadora robot Xiaomi',1500000,8,'TECNOLOGIA','D','https://http2.mlstatic.com/D_NQ_NP_735287-MLA46033006216_052021-O.webp');
INSERT INTO Productos( nombre, descripcion, precio, cantidad, categoria, estado, imagen) VALUES ('Bocina Bose S1 Pro System','Nueva Bocina Bose S1 Pro System',3400000,4,'TECNOLOGIA','D','https://http2.mlstatic.com/D_NQ_NP_624623-MLA32788000452_112019-O.webp');


#Usuarios
INSERT INTO Usuarios(nombre,tipoIdentificacion, identificacion, correo, passwd, telefono) VALUES('admin','CC','0000','admin@admin.com','admin123',0000);
INSERT INTO Usuarios(nombre,tipoIdentificacion, identificacion, correo, passwd, telefono) VALUES('DIEGO LEON','CC','1135','diego@gmail.com','diego12345',3008556023);
INSERT INTO Usuarios(nombre,tipoIdentificacion, identificacion, correo, passwd, telefono) VALUES('NORBEY CARDONA','CC','2541','norbey@gmail.com','norbeychiquis',3214569878);
INSERT INTO Usuarios(nombre,tipoIdentificacion, identificacion, correo, passwd, telefono) VALUES('NICOLAS CASTRO','CC','6548','nicolas@hotmail.com','nico12',3657895123);

#Compras
INSERT INTO Compras(identificacionUsuario, nombreUsuario, producto, cantidad, total) VALUES('1135','DIEGO LEON','Iphone14',2,26000000);
INSERT INTO Compras(identificacionUsuario, nombreUsuario, producto, cantidad, total) VALUES('2541','NORBEY CARDONA','Iphone13',1,6000000);
INSERT INTO Compras(identificacionUsuario, nombreUsuario, producto, cantidad, total) VALUES('6548','NICOLAS CASTRO','Samsung Galaxy S22',3,15000000);

#Resenas
INSERT INTO Resenas(producto,identificacionUsuario, nombreUsuario,comentario) VALUES('Iphone14','1135','DIEGO LEON','El mejor producto de mi vida');
INSERT INTO Resenas(producto,identificacionUsuario, nombreUsuario, comentario) VALUES('Iphone13','2541','NORBEY CARDONA','Bastante completo');
INSERT INTO Resenas(producto,identificacionUsuario, nombreUsuario, comentario) VALUES('Samsung Galaxy S22','6548','NICOLAS CASTRO','No cumple con las expectativas');

#Estadisticas


#Ventas


#Nps
INSERT INTO nps(producto,identificacionUsuario,nombreUsuario,satisfaccion) VALUES('Iphone14','1135','DIEGO LEON',5.00);
INSERT INTO nps(producto,identificacionUsuario,nombreUsuario,satisfaccion) VALUES('Iphone13','2541','NORBEY CARDONA',4.50);
INSERT INTO nps(producto,identificacionUsuario,nombreUsuario,satisfaccion) VALUES('Samsung Galaxy S22','6548','NICOLAS CASTRO',2.9);

#CONSULTAS
SELECT * FROM productos;
SELECT * FROM usuarios;
SELECT * FROM compras;
SELECT * FROM resenas;
SELECT * FROM ventas;
SELECT * FROM estadisticas;
SELECT * FROM nps;

#ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'diego12345';

#DROPS
drop table compras;
drop table resenas;
drop table ventas;
drop table estadisticas;
drop table nps;
drop table usuarios;
drop table productos;

