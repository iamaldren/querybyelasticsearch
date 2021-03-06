package com.aldren.service;

import com.aldren.exception.RecordNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public interface QueryService<T> {

    ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    String createData(T data) throws IOException;

    T getData(int id) throws IOException;

    String deleteData(int id) throws IOException, RecordNotFoundException;

}
