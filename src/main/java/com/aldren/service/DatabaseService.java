package com.aldren.service;

import org.jooq.DSLContext;

public interface DatabaseService<T> {

    void insertData(T data);

}
