Script sql x Antonio


Creazione schema:

CREATE SCHEMA `annunci` ;

Creazione tabella utenti:
CREATE  TABLE `annunci`.`utenti` (
  `codice_utente` INT NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(45) NULL ,
  `password` VARCHAR(45) NULL ,
  `nome` VARCHAR(45) NULL ,
 `cognome` VARCHAR(45) NULL ,0 `codice_ruolo` INT NULL ,
  `stato` INT NULL DEFAULT 1 ,
  `credito_residuo` INT NULL ,
  PRIMARY KEY (`codice_utente`) );


Creazione tabella ruoli:


CREATE  TABLE `annunci`.`ruoli` (
  `codice_ruolo` INT NOT NULL ,
  `descrizione` VARCHAR(45) NULL , PRIMARY KEY (`codice_ruolo`) );


Creazione tabella annunci:

CREATE  TABLE `annunci`.`annunci` (
  `codice_annuncio` INT NOT NULL AUTO_INCREMENT ,
  `descrizione` VARCHAR(45) NULL ,
  `data_inserimento` TIMESTAMP NULL DEFAULT now() ,
  `visite` INT NULL ,
  `stato` INT NULL DEFAULT 1 ,
  `codice_categoria` INT NULL ,
  `codice_prodotto` INT NULL ,
  `codice_utente` INT NULL ,
  PRIMARY KEY (`codice_annuncio`) );

Creazione tabella categoria:

CREATE  TABLE `annunci`.`categoria` (
  `codice_categoria` INT NOT NULL AUTO_INCREMENT,
  `descrizione` VARCHAR(45) NULL ,
  PRIMARY KEY (`codice_categoria`) );


Creazione tabella prodotti:

CREATE  TABLE `annunci`.`prodotti` (
  `codice_prodotto` INT NOT NULL AUTO_INCREMENT,
  `descrizione` VARCHAR(45) NULL ,
  `prezzo` INT NULL ,
  `data_acquisto` DATE NULL ,
  PRIMARY KEY (`codice_prodotto`) );



Foreign key annunci:

ALTER TABLE `annunci`.`annunci` 
  ADD CONSTRAINT `fk_annunci_categoria`
  FOREIGN KEY (`codice_categoria` )
  REFERENCES `annunci`.`categoria` (`codice_categoria` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `fk_annunci_categoria_idx` (`codice_categoria` ASC) ;



ALTER TABLE `annunci`.`annunci` 
  ADD CONSTRAINT `fk_annunci_prodotti`
  FOREIGN KEY (`codice_prodotto` )
  REFERENCES `annunci`.`prodotti` (`codice_prodotto` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `fk_annunci_prodotti_idx` (`codice_prodotto` ASC) ;



ALTER TABLE `annunci`.`annunci` 
  ADD CONSTRAINT `fk_annunci_utente`
  FOREIGN KEY (`codice_utente` )
  REFERENCES `annunci`.`utenti` (`codice_utente` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `fk_annunci_utente_idx` (`codice_utente` ASC) ;


Foreign key utenti:

ALTER TABLE `annunci`.`utenti` 
  ADD CONSTRAINT `fk_annunci_ruoli`
  FOREIGN KEY (`ruolo` )
  REFERENCES `annunci`.`ruoli` (`codice_ruolo` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `fk_annunci_ruoli_idx` (`ruolo` ASC) ;


Inserimento ruoli:

INSERT INTO `annunci`.`ruoli` (`codice_ruolo`, `descrizione`) VALUES ('1', 'Amministratore');
INSERT INTO `annunci`.`ruoli` (`codice_ruolo`, `descrizione`) VALUES ('2', 'Standard');
INSERT INTO `annunci`.`ruoli` (`codice_ruolo`, `descrizione`) VALUES ('3', 'Ospite');

Inserimento utenti:


INSERT INTO `annunci`.`Utenti` (`codice_utente`, `username`, `password`, `nome`, `cognome`, `ruolo`, `stato`, `credito_residuo`) VALUES (11, 'Antonio', 'Scarpati', 'Antonio', 'Scarpati', '1', '', '800');


inserimento categorie:

INSERT INTO `annunci`.`categoria` (`codice_categoria`, `descrizione`) VALUES ('1', 'Elettrodomestici');
INSERT INTO `annunci`.`categoria` (`codice_categoria`, `descrizione`) VALUES ('2', 'Libri');
INSERT INTO `annunci`.`categoria` (`codice_categoria`, `descrizione`) VALUES ('3', 'Elettronica');
INSERT INTO `annunci`.`categoria` (`codice_categoria`, `descrizione`) VALUES ('4', 'Telefonia');

inserimento prodotti:

INSERT INTO `annunci`.`prodotti` (`codice_prodotto`, `descrizione`, `prezzo`) VALUES ('1', 'Samsung Galaxy', '200');
INSERT INTO `annunci`.`prodotti` (`codice_prodotto`, `descrizione`, `prezzo`) VALUES ('2', 'Il nome della rosa', '10');
INSERT INTO `annunci`.`prodotti` (`codice_prodotto`, `descrizione`, `prezzo`) VALUES ('3', 'Portatile Asus', '100');
INSERT INTO `annunci`.`prodotti` (`codice_prodotto`, `descrizione`, `prezzo`) VALUES ('4', 'Forno elettrico', '50');


inserimento annunci:

INSERT INTO `annunci`.`annunci` (`codice_annuncio`, `descrizione`, `codice_categoria`, `codice_prodotto`, `codice_utente`) VALUES ('1', 'Vendo telefono', '4', '1', '1');
INSERT INTO `annunci`.`annunci` (`codice_annuncio`, `descrizione`, `codice_categoria`, `codice_prodotto`, `codice_utente`) VALUES ('2', 'Vendo forno', '1', '4', '3');
INSERT INTO `annunci`.`annunci` (`codice_annuncio`, `descrizione`, `codice_categoria`, `codice_prodotto`, `codice_utente`) VALUES ('3', 'Vendo computer', '3', '3', '2');
INSERT INTO `annunci`.`annunci` (`codice_annuncio`, `descrizione`, `codice_categoria`, `codice_prodotto`, `codice_utente`) VALUES ('4', 'Vendo libro', '2', '2', '5');
