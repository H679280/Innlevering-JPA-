DROP SCHEMA IF EXISTS forelesning2_todo CASCADE;
CREATE SCHEMA Oblig3;
SET search_path TO Oblig3;
    
-- Ikke nødvendig å slette tabellen(e) siden vi har tomt skjema, men ...
-- DROP TABLE IF EXISTS todo CASCADE;
CREATE TABLE Ansatt ( 

    ansatt_id SERIAL PRIMARY KEY, 
    brukernavn VARCHAR(10) UNIQUE NOT NULL, 
    fornavn VARCHAR(50) NOT NULL, 
    etternavn VARCHAR(50) NOT NULL, 
    ansettelsesdato DATE NOT NULL, 
    stilling VARCHAR(50) NOT NULL, 
    manedslonn NUMERIC(10,2) NOT NULL 
    -- evt koble til avdeling 
    (avd_id INT NOT NULL,  
    FOREIGN KEY (avd_id) REFERENCES Avdeling(avd_id), ) ??  
    
    ); 
    INSERT INTO Ansatt (brukernavn, fornavn, etternavn, ansettelsesdato, stilling, manedslonn) 
    VALUES 
    ('VH', 'Veronika, 'Nordmo', '2022-01-15', 'Utvikler', 55000), 
    ('IB, 'Idunn', 'Blindheim', '2021-06-01', 'Prosjektleder', 65000), 
    ('AFK', 'Anna', 'Kaland, '2023-03-10', 'Tester', 50000); 
    SELECT * FROM ansatt; 
    ); 
    
    CREATE TABLE Avdeling ( 

    avd_id  SERIAL PRIMARY KEY, 

    navn VARCHAR(100) NOT NULL, 

    sjef_id INT UNIQUE  
    ); 
    