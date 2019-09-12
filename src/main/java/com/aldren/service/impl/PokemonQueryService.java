package com.aldren.service.impl;

import com.aldren.model.Pokemon;
import com.aldren.service.QueryService;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class PokemonQueryService implements QueryService<Pokemon> {

    private static final String INDEX = "pokemon";
    private static final String TYPE = "pokedex";

    @Autowired
    private RestHighLevelClient client;

    @Override
    public String createData(Pokemon data) throws IOException {
        IndexRequest request = new IndexRequest(INDEX)
                .type(TYPE)
                .id(String.valueOf(data.getIndex()));

        String pokemonJson = mapper.writeValueAsString(data);

        request.source(pokemonJson, XContentType.JSON);
        request.timeout(TimeValue.timeValueSeconds(3L));

        IndexResponse response = client.index(request, RequestOptions.DEFAULT);

        return response.getResult().name();
    }

    @Override
    public Pokemon getData(int id) throws IOException {
        GetRequest request = new GetRequest(INDEX).type(TYPE).id(String.valueOf(id));

        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        Map<String, Object> result = response.getSource();

        return mapper.convertValue(result, Pokemon.class);
    }
}
