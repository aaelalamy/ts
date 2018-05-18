INSERT INTO USERS (USER_NAME,PASSWORD) VALUES ('aelalamy','hashpassword');


CREATE TABLE Termination_Call_Detail (
    Variable1 varchar(255),
    Variable4 varchar(255),
    Variable5 varchar(255),
    Variable8 varchar(255)
);

						
INSERT INTO Termination_Call_Detail (Variable1, Variable4, Variable5, Variable8) VALUES ('0508997119', '905001', 'ar', 'EIWRUU283478742ASKJ');
INSERT INTO Termination_Call_Detail (Variable1, Variable4, Variable5, Variable8) VALUES ('0241155112', '23424', 'en', 'fafsaffaf');
INSERT INTO Termination_Call_Detail (Variable1, Variable4, Variable5, Variable8) VALUES ('0457363434', '2363', 'al', '45232fdsaasfa');
INSERT INTO Termination_Call_Detail (Variable1, Variable4, Variable5, Variable8) VALUES ('0353434523', '768567', 'en', 'asdwqewqewewqe');
INSERT INTO Termination_Call_Detail (Variable1, Variable4, Variable5, Variable8) VALUES ('0241155112', '214212', 'ar', 'asdasdasdqweqweqweqwe');
INSERT INTO Termination_Call_Detail (Variable1, Variable4, Variable5, Variable8) VALUES ('0873763746', '12323', 'al', 'EIWRUU283478742ASKJ');
INSERT INTO Termination_Call_Detail (Variable1, Variable4, Variable5, Variable8) VALUES ('0241155112', '65464', 'ar', 'adlkjsajdlksajdhj');

CREATE TABLE DropCall (
    ANI varchar(255),
    SessionID varchar(255),
    SourceIp varchar(255)
);

INSERT INTO DropCall (ANI, SessionID, SourceIp) VALUES ('0508997119','JSAHDKJHSADJHJASDKJ','10.21.70.11');
INSERT INTO DropCall (ANI, SessionID, SourceIp) VALUES ('0241155112','FJAKHASFKJHAKJFHKJH','10.21.70.11');
INSERT INTO DropCall (ANI, SessionID, SourceIp) VALUES ('0241155112','SAFHHSAFJHJKHKJHJHK','10.21.70.11');
INSERT INTO DropCall (ANI, SessionID, SourceIp) VALUES ('1273687637','EIWRUU283478742ASKJ','10.21.70.11');
INSERT INTO DropCall (ANI, SessionID, SourceIp) VALUES ('1237613876','SDHFJHSAFKJHKHJHKJH','10.21.70.11');
INSERT INTO DropCall (ANI, SessionID, SourceIp) VALUES ('0508997119','EIWRUU283478742ASKJ','10.21.70.11');
INSERT INTO DropCall (ANI, SessionID, SourceIp) VALUES ('8247987487','UYUYIUYIUAYSDMAMSDA','10.21.70.11');

--INSERT INTO APP_ROLE (id,name) VALUES (1,'ADMIN');
--INSERT INTO APP_ROLE (id,name) VALUES (2,'ACTUATOR');

--INSERT INTO  APP_USER (ID,FIRST_NAME,LAST_NAME,USERNAME,PASSWORD) VALUES (1,'Amr','El-Alamy','aaelalamy','$2a$10$ny4C5OH82JRBB4MJiejBv.0YGWAYwmmzHRreIxUZLVAHoxfzML28q');

--INSERT INTO APP_USERS_ROLES (USER_ID,ROLE_ID) VALUES (1,1);
--INSERT INTO APP_USERS_ROLES (USER_ID,ROLE_ID) VALUES (1,2);