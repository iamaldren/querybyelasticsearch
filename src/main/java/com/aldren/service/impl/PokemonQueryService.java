package com.aldren.service.impl;

import com.aldren.exception.RecordNotFoundException;
import com.aldren.model.PokemonES;
import com.aldren.service.QueryService;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
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
public class PokemonQueryService implements QueryService<PokemonES> {

    private static final String INDEX = "pokemon";

    @Autowired
    private RestHighLevelClient client;

    @Override
    public String createData(PokemonES data) throws IOException {
        IndexRequest request = new IndexRequest(INDEX)
                .id(String.valueOf(data.getId()));

        String pokemonJson = mapper.writeValueAsString(data);

        request.source(pokemonJson, XContentType.JSON);
        request.timeout(TimeValue.timeValueSeconds(3L));

        IndexResponse response = client.index(request, RequestOptions.DEFAULT);

        return response.getResult().name();
    }

    @Override
    public PokemonES getData(int id) throws IOException {
        GetRequest request = new GetRequest(INDEX).id(String.valueOf(id));

        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        Map<String, Object> result = response.getSource();

        return mapper.convertValue(result, PokemonES.class);
    }

    @Override
    public String deleteData(int id) throws IOException, RecordNotFoundException {
        DeleteRequest request = new DeleteRequest(INDEX).id(String.valueOf(id));

        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);

        if(response.getResult() == DocWriteResponse.Result.NOT_FOUND) {
            throw new RecordNotFoundException(String.format("Record with id of %d in pokemon index is not found", id));
        }

        if(response.getResult() == DocWriteResponse.Result.DELETED) {
            return String.format("Delete for record with id %d from pokemon index is successfully deleted.", id);
        }

        return null;
    }

}
