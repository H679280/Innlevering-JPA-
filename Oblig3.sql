    -- Ikke nødvendig å slette tabellen(e) siden vi har tomt skjema, men ...
-- DROP TABLE IF EXISTS todo CASCADE;
--lager ansatt-- 

DROP SCHEMA IF EXISTS Firma CASCADE; 

CREATE SCHEMA Firma; 

SET search_path TO Firma; 

 

CREATE TABLE Ansatt ( 
    ansatt_id SERIAL PRIMARY KEY, 
    brukernavn VARCHAR(10) UNIQUE NOT NULL, 
    fornavn VARCHAR(50) NOT NULL, 
    etternavn VARCHAR(50) NOT NULL, 
    ansettelsesdato DATE NOT NULL, 
    stilling VARCHAR(50) NOT NULL, 
    manedslonn NUMERIC(10,2) NOT NULL,
    avd_id INTEGER NOT NULL,
    prosjekt 
    
    CONSTRAINT AnsattFK FOREIGN KEY (avd_id) REFERENCES Avdeling(avd_id)
    -- legger til kobling etter hvert--  

); 

 

--lager avdeling-- 

CREATE TABLE Avdeling ( 
    avd_id  SERIAL PRIMARY KEY, 
    navn VARCHAR(100) NOT NULL, 
    sjef_id INTEGER,
    
    CONSTRAINT AvdelingFK FOREIGN KEY (sjef_id) REFERENCES Ansatt(ansatt_id)
    -- legger til ansatt_id senere-- 

); 

 

-- kobler ansatt til avdeling-- 

ALTER TABLE Ansatt ADD COLUMN avd_id INT NOT NULL; ALTER TABLE Ansatt ADD CONSTRAINT fk_avd FOREIGN KEY (avd_id) REFERENCES Avdeling(avd_id) ON DELETE RESTRICT; 

 

-- legger til eksempelverdier-- 

INSERT INTO Avdeling (navn) 
VALUES  
('IT'),  
('HR'),  
('Økonomi'); 

 

INSERT INTO Ansatt (brukernavn, fornavn, etternavn, ansettelsesdato, stilling, manedslonn, avd_id) VALUES  
('VH', 'Veronika', 'Nordmo', '2022-01-15', 'Utvikler', 55000, 1),  
('IB', 'Idunn', 'Blindheim', '2021-06-01', 'Prosjektleder', 65000, 2),  
('AFK', 'Anna', 'Kaland', '2023-03-10', 'Tester', 50000, 1),  
('OJ', 'Ole', 'Jensen', '2019-05-23', 'Systemadministrator', 60000, 1),  
('LM', 'Lars', 'Mikkelsen', '2020-08-17', 'HR-konsulent', 52000, 2),  
('TS', 'Therese', 'Solberg', '2022-09-12', 'Rekrutteringsansvarlig', 53000, 2),  
('KA', 'Kari', 'Andersen', '2018-11-30', 'Regnskapsfører', 58000, 3),  
('PB', 'Petter', 'Berg', '2020-04-14', 'Økonomisjef', 75000, 3),  
('ML', 'Marius', 'Lunde', '2023-01-10', 'Supportmedarbeider', 47000, 1),  
('HH', 'Hanne', 'Haugen', '2021-07-21', 'Personalansvarlig', 62000, 2 
); 

 

SELECT *FROM ansatt; 

SELECT *FROM avdeling; 
 

--kobler avdeling til ansatt-- 

ALTER TABLE Avdeling ADD COLUMN sjef_id INT UNIQUE; ALTER TABLE Avdeling ADD CONSTRAINT fk_sjef FOREIGN KEY (sjef_id) REFERENCES Ansatt(ansatt_id) ON DELETE RESTRICT; 

UPDATE Avdeling SET sjef_id = 1 WHERE avd_id = 1; -- Gjør Veronika sjef for IT -- 

UPDATE Avdeling SET sjef_id = 2 WHERE avd_id = 2; -- Gjør Idunn sjef for HR-- 
