DROP DATABASE IF EXISTS Lanchonete;
CREATE DATABASE Lanchonete;
CREATE TABLE Lanchonete.Enderecos(Codigo INT PRIMARY KEY AUTO_INCREMENT,
Cep VARCHAR(45) NOT NULL,
Logradouro VARCHAR(45) NOT NULL,
Numero INT);
CREATE TABLE Lanchonete.Clientes(Codigo INT PRIMARY KEY AUTO_INCREMENT,
Nome VARCHAR(45) NOT NULL,
EnderecosCodigo INT NOT NULL REFERENCES Enderecos(Codigo));
CREATE TABLE Lanchonete.Telefones(Codigo INT PRIMARY KEY AUTO_INCREMENT, 
Telefone VARCHAR(45) NOT NULL, 
ClientesCodigo INT NOT NULL REFERENCES Clientes(Codigo));
CREATE TABLE Lanchonete.Entregadores(Codigo INT PRIMARY KEY AUTO_INCREMENT,
Nome VARCHAR(45) NOT NULL,
TelefoneCelular VARCHAR(45) NOT NULL);
CREATE TABLE Lanchonete.Pedidos(Codigo INT PRIMARY KEY AUTO_INCREMENT,
Data DATETIME NOT NULL,
Status VARCHAR(45) NOT NULL,
ClienteCodigo INT NOT NULL REFERENCES Clientes(Codigo),
EntregadorCodigo INT NOT NULL REFERENCES Entregadores(Codigo));
CREATE TABLE Lanchonete.Sanduiches(Codigo INT PRIMARY KEY AUTO_INCREMENT,
Preco DECIMAL(10,2) NOT NULL,
Nome VARCHAR(45) NOT NULL,
CodigoPedido INT NOT NULL REFERENCES Pedidos(Codigo));
INSERT INTO Lanchonete.Entregadores VALUES 	(1, "Roberto", "4199999-1111");
INSERT INTO Lanchonete.Enderecos VALUES (1, "11111-111", "Rua Robertinho Junior", 111);
INSERT INTO Lanchonete.Clientes VALUES (1, "Augusto", 1);
INSERT INTO Lanchonete.Pedidos VALUES (1,'2010-10-10 10:10:10',"0 – em preparação",1,1);
INSERT INTO Lanchonete.Sanduiches VALUES(1, 8.99, "Sanduiche de Presunto", 1),(2, 11.99, "X-Bacon", 1);

SELECT * FROM Lanchonete.Pedidos WHERE Status = "0 – em preparação";


