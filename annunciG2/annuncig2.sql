Script sql x Antonio


/*Creazione schema:*/

CREATE SCHEMA `annunci` ;

Creazione tabella utenti:
CREATE  TABLE `annunci`.`utenti` (
  `codice_utente` INT NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(45) NULL ,
  `password` VARCHAR(45) NULL ,
  `nome` VARCHAR(45) NULL ,
 `cognome` VARCHAR(45) NULL , `codice_ruolo` INT NULL ,
  `stato` INT NULL DEFAULT 1 ,
  `credito_residuo` INT NULL ,
  PRIMARY KEY (`codice_utente`) );


/*Creazione tabella ruoli:*/


CREATE  TABLE `annunci`.`ruoli` (
  `codice_ruolo` INT NOT NULL ,
  `descrizione` VARCHAR(45) NULL , PRIMARY KEY (`codice_ruolo`) );


/*Creazione tabella annunci:*/

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

/*Creazione tabella categoria:*/

CREATE  TABLE `annunci`.`categoria` (
  `codice_categoria` INT NOT NULL AUTO_INCREMENT,
  `descrizione` VARCHAR(45) NULL ,
  PRIMARY KEY (`codice_categoria`) );


/*Creazione tabella prodotti:*/

CREATE  TABLE `annunci`.`prodotti` (
  `codice_prodotto` INT NOT NULL AUTO_INCREMENT,
  `descrizione` VARCHAR(45) NULL ,
  `prezzo` INT NULL ,
  `data_acquisto` DATE NULL ,
  `acquirente` INT NULL , 
  PRIMARY KEY (`codice_prodotto`) );



/*Foreign key annunci:*/

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


/*Foreign key utenti:*/

ALTER TABLE `annunci`.`utenti` 
  ADD CONSTRAINT `fk_annunci_ruoli`
  FOREIGN KEY (`codice_ruolo` )
  REFERENCES `annunci`.`ruoli` (`codice_ruolo` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `fk_annunci_ruoli_idx` (`codice_ruolo` ASC) ;

ALTER TABLE `annunci`.`prodotti` 
  ADD CONSTRAINT `fk_prodotti_utenti`
  FOREIGN KEY (`acquirente` )
  REFERENCES `annunci`.`ruoli` (`codice_utente` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `fk_prodotti_utenti_idx` (`acquirente` ASC) ;


