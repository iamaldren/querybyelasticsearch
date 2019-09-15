package com.aldren.service.impl;

import com.aldren.model.PokemonES;
import com.aldren.model.Tables;
import com.aldren.service.DatabaseService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PokemonDatabaseService implements DatabaseService<PokemonES> {

    @Autowired
    private DSLContext dsl;

    @Override
    public void insertData(PokemonES data) {
       List<Integer> ids =  dsl.selectFrom(Tables.POKEMON_TYPE)
                .where(Tables.POKEMON_TYPE.TYPE.in(data.getType()))
                .fetch()
                .getValues(Tables.POKEMON_TYPE.ID);
    }
}
