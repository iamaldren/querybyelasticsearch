CREATE TABLE pokemon_type_mapper (
    pokemon_id  INTEGER         NOT NULL,
    type_id     INTEGER         NOT NULL,
    PRIMARY KEY(pokemon_id, type_id)
);