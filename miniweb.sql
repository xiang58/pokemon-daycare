ALTER SESSION SET PLSCOPE_SETTINGS = 'IDENTIFIERS:NONE';

CREATE TABLE Pokemons (
    pkm_id NUMBER(4) PRIMARY KEY,
    pokedex NUMBER(4) NOT NULL CHECK(pokedex > 0 AND pokedex < 893),
    pkm_lv NUMBER(3) NOT NULL CHECK(pkm_lv > 0 AND pkm_lv < 101),
    pkm_name VARCHAR2(30) NOT NULL,
    pkm_type1 VARCHAR2(15) NOT NULL,
    pkm_type2 VARCHAR2(15),
    gender CHAR(1) DEFAULT '?' NOT NULL 
        CHECK(gender = 'M' OR gender = 'F' OR gender = '?'),
    nickname VARCHAR2(50),
    comments VARCHAR2(1000)
);

CREATE SEQUENCE pkm_id_seq;

CREATE OR REPLACE TRIGGER pokemons_tr
BEFORE INSERT ON Pokemons
FOR EACH ROW 
    BEGIN
        SELECT pkm_id_seq.NEXTVAL
        INTO :NEW.pkm_id FROM dual;
    END;
/

INSERT INTO Pokemons (
    pokedex, pkm_lv, pkm_name, pkm_type1, pkm_type2, gender, nickname, comments
) VALUES (
    1, 5, 'Bulbasaur', 'Grass', 'Poison', 
    'F', 'Alice', 'Green little plant?'
);

INSERT INTO Pokemons (
    pokedex, pkm_lv, pkm_name, pkm_type1, pkm_type2, gender, nickname, comments
) VALUES (
    4, 5, 'Charmander', 'Fire', NULL, 
    'M', 'Charlie', 'Feels warm.'
);

INSERT INTO Pokemons (
    pokedex, pkm_lv, pkm_name, pkm_type1, pkm_type2, gender, nickname, comments
) VALUES (
    7, 5, 'Squirtle', 'Water', NULL, 
    'M', 'Bob', 'He lieks watering Bulbasaur.'
);

COMMIT;
