/*
 * This file is generated by jOOQ.
 */
package com.aldren.model;


import com.aldren.model.tables.Pokemon;
import com.aldren.model.tables.PokemonType;
import com.aldren.model.tables.PokemonTypeMapper;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in aldren
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>aldren.pokemon</code>.
     */
    public static final Pokemon POKEMON = Pokemon.POKEMON;

    /**
     * The table <code>aldren.pokemon_type</code>.
     */
    public static final PokemonType POKEMON_TYPE = PokemonType.POKEMON_TYPE;

    /**
     * The table <code>aldren.pokemon_type_mapper</code>.
     */
    public static final PokemonTypeMapper POKEMON_TYPE_MAPPER = PokemonTypeMapper.POKEMON_TYPE_MAPPER;
}