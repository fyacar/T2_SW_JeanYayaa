
CREATE DATABASE BDjeanYaya;
USE BDjeanYaya;

CREATE TABLE Personaje
(
 IdPersonaje 		INT NOT NULL AUTO_INCREMENT,
 NomPersonaje		VARCHAR(50) NOT NULL,
 ApePersonaje 		VARCHAR(50) NOT NULL,
 FechNacPersonaje	DATE NOT NULL,
 PRIMARY KEY (IdPersonaje)
);

CREATE TABLE ProgramaTv
(
 IdProgramaTv 		INT NOT NULL AUTO_INCREMENT,
 Titulo 			VARCHAR(250) NOT NULL,
 Resumen 			VARCHAR(250) NOT NULL,
 FechaInicio	DATE NOT NULL,
 IdPersonaje 			INT NOT NULL,
 PRIMARY KEY (IdProgramaTv),
 FOREIGN KEY (IdPersonaje) REFERENCES Personaje(IdPersonaje)
 );
 
 
 INSERT INTO Personaje (NomPersonaje, ApePersonaje, FechNacPersonaje) VALUES
('Jean', 'Yaya', '1980-01-15'),
('Mili', 'Ann', '1990-03-22'),
('Robert', 'Barateon', '1985-07-09'),
('Emily', 'Suarez', '1992-10-14'),
('Roberto', 'Jimenez', '1983-05-25');

INSERT INTO ProgramaTv (Titulo, Resumen, FechaInicio, IdPersonaje) VALUES
('Atv Noticias', 'Noticiero matutino', '2023-01-01', 1),
('Cocinando', 'Programa de cocina', '2023-02-15', 2),
('CiberConversaciones', 'Programa sobre tecnología', '2023-03-10', 3),
('Vida Sana', 'Tips para vida saludable', '2023-04-20', 4),
('Diario de un herrate', 'Programa sobre viajes', '2023-05-05', 5);

select * from Personaje;
select * from ProgramaTv;