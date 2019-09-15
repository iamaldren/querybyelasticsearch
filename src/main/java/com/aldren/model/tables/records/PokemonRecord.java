/*
 * This file is generated by jOOQ.
 */
package com.aldren.model.tables.records;


import com.aldren.model.tables.Pokemon;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PokemonRecord extends UpdatableRecordImpl<PokemonRecord> implements Record3<Integer, String, String> {

    private static final long serialVersionUID = 1584731110;

    /**
     * Setter for <code>aldren.pokemon.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>aldren.pokemon.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>aldren.pokemon.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>aldren.pokemon.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>aldren.pokemon.species</code>.
     */
    public void setSpecies(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>aldren.pokemon.species</code>.
     */
    public String getSpecies() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Pokemon.POKEMON.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Pokemon.POKEMON.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Pokemon.POKEMON.SPECIES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getSpecies();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getSpecies();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonRecord value3(String value) {
        setSpecies(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PokemonRecord values(Integer value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PokemonRecord
     */
    public PokemonRecord() {
        super(Pokemon.POKEMON);
    }

    /**
     * Create a detached, initialised PokemonRecord
     */
    public PokemonRecord(Integer id, String name, String species) {
        super(Pokemon.POKEMON);

        set(0, id);
        set(1, name);
        set(2, species);
    }
}
