package com.aldren.service.impl;

import com.aldren.model.PokemonES;
import com.aldren.model.Tables;
import com.aldren.service.DatabaseService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonDatabaseService implements DatabaseService<PokemonES> {

    @Autowired
    private DSLContext dsl;

    @Override
    @Async
    public void insertData(PokemonES data) {
       List<Integer> ids =  dsl.selectFrom(Tables.POKEMON_TYPE)
                .where(Tables.POKEMON_TYPE.TYPE.in(data.getType()))
                .fetch()
                .getValues(Tables.POKEMON_TYPE.ID);

       dsl.insertInto(Tables.POKEMON)
               .columns(Tables.POKEMON.ID, Tables.POKEMON.NAME, Tables.POKEMON.SPECIES)
               .values(data.getId(), data.getName(), data.getSpecies()).execute();

       ids.forEach(id -> {
           dsl.insertInto(Tables.POKEMON_TYPE_MAPPER)
                   .columns(Tables.POKEMON_TYPE_MAPPER.POKEMON_ID, Tables.POKEMON_TYPE_MAPPER.TYPE_ID)
                   .values(data.getId(), id)
                   .execute();
       });
    }
}
