CREATE DATABASE ArteBD;

USE ArteBD;

CREATE TABLE usuario (
  idusu INT AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL,
  fecha_registro DATE,
  constraint pk_usuario primary key (idusu)
);

CREATE TABLE obra (
  idobra INT AUTO_INCREMENT,
  titulo VARCHAR(100) NOT NULL,
  autor_id INT,
  descripcion VARCHAR(200),
  año_publicacion INT,
  categoria VARCHAR(50),
  constraint pk_obra primary key (idobra),
  constraint fk_obra_autor FOREIGN KEY (autor_id) REFERENCES usuario(idusu)
);

CREATE TABLE puntuacion (
  idpuntu INT AUTO_INCREMENT,
  obra_id INT,
  usuario_id INT,
  puntuacion INT,
  comentario VARCHAR(200),
  constraint pk_puntuacion primary key (idpuntu),
  constraint fk_puntuacion_obra FOREIGN KEY (obra_id) REFERENCES obra(idobra),
  constraint fk_puntuacion_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(idusu)
);

-- INSERCION DE DATOS

insert into usuario
	(nombre, email, fecha_registro)
values
	('Kat', 'kat@gmail.com', curdate()),
	('Patty', 'patty@gmail.com', curdate()),
    ('Eusebio', 'eusebio@gmail.com', curdate()),
    ('Coco', 'coco@gmail.com', curdate());
    
insert into obra
	(titulo, autor_id, descripcion, año_publicacion, categoria)
values
	('La Mona Risa Perdida', 1, 'Una pintura misteriosa de una mujer con una sonrisa que nadie puede encontrar', 2021, 'Pintura'),
    ('El Pollo Volador', 2, 'Una escultura de un pollo, desafiando las leyes de la física y volando libremente por el cielo', 2023, 'Escultura'),
    ('La Última Cena de Pizza', 3, 'Una pintura que captura el momento en que Jesús y sus apóstoles disfrutan de una deliciosa cena de pizza', 2020, 'Pintura'),
    ('El Grito del Hambre', 2, 'Una pintura que muestra a una persona gritando porque se le acabó el helado en el congelador', 2020, 'Pintura'),
    ('La Estatua que se Tomó un Descanso', 1, ' Una escultura de una figura humana en una postura relajada, sentada en un sofá y viendo televisión', 2020, 'Escultura');
    
insert into puntuacion
	(obra_id, usuario_id, puntuacion, comentario)
values
	(1, 3, 2, 'No se sabe donde está la sonrisa, fatal'),
    (4, 2, 10, 'Empatizo mucho con el autor, ha lagrado transmitir sus sentimientos de una manera magistral');
