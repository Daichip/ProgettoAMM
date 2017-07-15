-- DB: ammdb ; User: DF ; password: 123 --

CREATE TABLE Utenti
(
    idUtente INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(256), --Indica che il nome è univoco, e non può essercene un altro uguale (Anche se per un utente con ID diverso) [è un vincolo di integrità]--
    cognome VARCHAR(256),
    password VARCHAR(256), --Devo assicurarmi che NON sia nulla--
    frasePresentazione VARCHAR(256),
    dataNascita VARCHAR(256),
    urlFotoProfilo VARCHAR(256),
    username VARCHAR(256)    
);

CREATE TABLE Gruppi
(
    idGruppo INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nomeGruppo VARCHAR(256), --Indica che il nome è univoco, e non può essercene un altro uguale (Anche se per un utente con ID diverso) [è un vincolo di integrità]--
    descrizione VARCHAR(1024)
);

CREATE TABLE TipoPost
(
    idTipoPost INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nameTipoPost VARCHAR(32)
);

CREATE TABLE Post
(
    idPost INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    autore INTEGER, --Indica che il nome è univoco, e non può essercene un altro uguale (Anche se per un utente con ID diverso) [è un vincolo di integrità]--
    contenuto VARCHAR(256),
    urlPost VARCHAR(256), --Devo assicurarmi che NON sia nulla--
    tipo INTEGER,
    FOREIGN KEY (autore) REFERENCES Utenti (idUtente),
    FOREIGN KEY (tipo) REFERENCES TipoPost(idTipoPost)
);

CREATE TABLE Amicizie
(
    follower INTEGER,
    followed INTEGER,
    PRIMARY KEY (follower, followed),
    FOREIGN KEY (follower) REFERENCES Utenti(idUtente),
    FOREIGN KEY (followed) REFERENCES Utenti(idUtente)
);

CREATE TABLE PartecipaGruppi (
   followed INTEGER,
   follower INTEGER,
   PRIMARY KEY (followed, follower),
   FOREIGN KEY (followed) REFERENCES gruppi(idGruppo),
   FOREIGN KEY (follower) REFERENCES Utenti(idUtente)
);

INSERT INTO TipoPost(idTipoPost, nameTipoPost)
VALUES (default, 'TEXT');

INSERT INTO TipoPost(idTipoPost, nameTipoPost)
VALUES (default, 'IMAGE');

INSERT INTO Utenti (idUtente, nome, cognome, password, frasePresentazione, dataNascita, urlFotoProfilo, username)
VALUES (default, 
        'Mario',
        'Rossi',
        '123',
        'I was once known as Jumpman',
        '1981-07-09',
        '/ProgettoAMM/Assets/marioRossi.jpg',
        'MMMR');
		
INSERT INTO Utenti (idUtente, nome, cognome, password, frasePresentazione, dataNascita, urlFotoProfilo, username)
VALUES (default, 
        'Luca',
        'Verdi',
        '123',
        'I am a hero!',
        '1986-02-21',
        '/ProgettoAMM/Assets/lucaVerdi.jpg',
        'LLV');
		
INSERT INTO Utenti (idUtente, nome, cognome, password, frasePresentazione, dataNascita, urlFotoProfilo, username)
VALUES (default, 
        'Carlo',
        'Neri',
        '123',
        'Nobody remembers me..',
        '1988-10-09',
        '/ProgettoAMM/Assets/carloRossi.gif',
        'CSGR');
		

INSERT INTO Utenti (idUtente, nome, cognome, password, frasePresentazione, dataNascita, urlFotoProfilo, username)
VALUES (default, 
        'Davide',
        'Fara',
        '123',
        'What can I say.. Hello?',
        '1996-05-12',
        '/ProgettoAMM/Assets/adminPic.png',
        'DF');


INSERT INTO Utenti (idUtente, nome, cognome, password, frasePresentazione, dataNascita, urlFotoProfilo, username)
VALUES (default, 
        'Dante',
        'Sparda',
        '123',
        'I am a demon hunter',
        '2001-08-23',
        '/ProgettoAMM/Assets/dante.jpg',
        'DMC');


INSERT INTO Utenti (idUtente, nome, cognome, password, frasePresentazione, dataNascita, urlFotoProfilo, username)
VALUES (default, 
        'Crash',
        'Bandicoot',
        '123',
        'I am a bandicoot that runs away from trouble',
        '1996-12-06',
        '/ProgettoAMM/Assets/crash.jpg',
        'CB');
		

INSERT INTO Utenti (idUtente, nome, cognome, password, frasePresentazione, dataNascita, urlFotoProfilo, username)
VALUES (default, 
        'Ness',
        ' ',
        '123',
        '...',
        '1994-07-27',
        '/ProgettoAMM/Assets/ness.jpg',
        'NEB');


INSERT INTO Utenti (idUtente, nome, cognome, password, frasePresentazione, dataNascita, urlFotoProfilo, username)
VALUES (default, 
        'Toad',
        'Kinopio',
        '123',
        'I enjoy far too much telling Mario that the princess is another castle',
        '1985-09-13',
        '/ProgettoAMM/Assets/toad.jpg',
        'TK');
		

INSERT INTO Utenti (idUtente, nome, cognome, password, frasePresentazione, dataNascita, urlFotoProfilo, username)
VALUES (default, 
        'Vivi',
        'Orunitia',
        '123',
        'What am I?',
        '2000-07-07',
        '/ProgettoAMM/Assets/vivi.jpg',
        'VO');
		



INSERT INTO Post (idPost, autore, contenuto, urlPost, tipo)
VALUES (default,
        1,
        'Mamma mia!',
        '',
        1);

INSERT INTO Post (idPost, autore, contenuto, urlPost, tipo)
VALUES (default,
        2,
        'Selfie with a friend(?)',
        'Assets/linkedImg.jpg',
        2);


INSERT INTO Post (idPost, autore, contenuto, urlPost, tipo)
VALUES (default,
        3,
        'Guarda <a href=\"https://en.wikipedia.org/wiki/List_of_recurring_Mario_franchise_enemies#Shy_Guy\" target=\"_blank\"> https://en.wikipedia.org/wiki/List_of_recurring_Mario_franchise_enemies#Shy_Guy </a> per scoprire qualcosa su di me!',
        '',
        1);

INSERT INTO Post (idPost, autore, contenuto, urlPost, tipo)
VALUES (default,
        4,
        'Trying this DB stuff.. It is indeed cool',
        '',
        1);


INSERT INTO Post (idPost, autore, contenuto, urlPost, tipo)
VALUES (default,
        5,
        'I slay demon when I have free time, and also as a job. Call me!',
        '',
        1);


INSERT INTO Post (idPost, autore, contenuto, urlPost, tipo)
VALUES (default,
        6,
        'I will get ya, Cortex!',
        '',
        1);


INSERT INTO Post (idPost, autore, contenuto, urlPost, tipo)
VALUES (default,
        7,
        'PK Thundeeeeeer!',
        '',
        1);


INSERT INTO Post (idPost, autore, contenuto, urlPost, tipo)
VALUES (default,
        8,
        'The Princess is in another castle',
        '',
        1);

INSERT INTO Post (idPost, autore, contenuto, urlPost, tipo)
VALUES (default,
        9,
        '...',
        '',
        1);

INSERT INTO Post (idPost, autore, contenuto, urlPost, tipo)
VALUES (default,
        9,
        'Me and the boys vs something I still cannot understand',
        'Assets/vsOzma.jpg',
        2);

INSERT INTO Post (idPost, autore, contenuto, urlPost, tipo)
VALUES (default,
        6,
        'You do what you gotta do to find some apples...',
        'Assets/riskingLife.jpg',
        2);

INSERT INTO Post (idPost, autore, contenuto, urlPost, tipo)
VALUES (default,
        8,
        'The squad is ready to go to collect some stars',
        'Assets/theSquad.jpg',
        2);

INSERT INTO Post (idPost, autore, contenuto, urlPost, tipo)
VALUES (default,
        7,
        'I found my new career, look at me!',
        'Assets/baseballNess.jpg',
        2);

INSERT INTO Post (idPost, autore, contenuto, urlPost, tipo)
VALUES (default,
        1,
        'Saturday night with the boys',
        'Assets/saturdayNight.png',
        2);


INSERT INTO Gruppi(idGruppo, nomeGruppo, descrizione)
VALUES(default, 'Plumbers', 'Il meglio del peggio direttamente dal Mushroom Kingdom!');

INSERT INTO Gruppi(idGruppo, nomeGruppo, descrizione)
VALUES(default, 'Heroes of the Triforce', 'Un gruppo per tutti quelli che hanno ucciso Ganon');

INSERT INTO Gruppi(idGruppo, nomeGruppo, descrizione)
VALUES(default, 'Nobodies','Un gruppo per me e basta... Son solo anche qui');

INSERT INTO Amicizie (follower, followed)
VALUES (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (1, 6),
       (1, 7),
       (1, 8),
       (1, 9),
       (2, 1),
       (2, 3),
       (2, 4),
       (2, 5),
       (2, 6),
       (2, 7),
       (2, 8),
       (2, 9),
       (3, 1),
       (3, 2),
       (3, 4),
       (3, 5),
       (3, 6),
       (3, 7),
       (3, 8),
       (3, 9),       
       (4, 1),
       (4, 2),
       (4, 3),
       (4, 5),
       (4, 6),
       (4, 7),
       (4, 8),
       (4, 9),
       (5, 1),
       (5, 2),
       (5, 3),
       (5, 4),
       (5, 6),
       (5, 7),
       (5, 8),
       (5, 9),
       (6, 1),
       (6, 2),
       (6, 3),
       (6, 4),
       (6, 5),
       (6, 7),
       (6, 8),
       (6, 9),
       (7, 1),
       (7, 2),
       (7, 3),
       (7, 4),
       (7, 5),
       (7, 6),
       (7, 8),
       (7, 9),
       (8, 1),
       (8, 2),
       (8, 3),
       (8, 4),
       (8, 5),
       (8, 6),
       (8, 7),
       (8, 9),
       (9, 1),
       (9, 2),
       (9, 3),
       (9, 4),
       (9, 5),
       (9, 6),
       (9, 7),
       (9, 8);
       
INSERT INTO PartecipaGruppi(followed,follower)
VALUES (1,4),
       (2,4),
       (3,4),
       (1,1),
       (2,2),
       (3,3);