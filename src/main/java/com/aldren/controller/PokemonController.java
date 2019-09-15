package com.aldren.controller;

import com.aldren.exception.BadRequetException;
import com.aldren.exception.RecordNotFoundException;
import com.aldren.model.PokemonES;
import com.aldren.model.Response;
import com.aldren.service.QueryService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PokemonController {

    @Autowired
    @Qualifier("pokemonQueryService")
    private QueryService<PokemonES> svc;

    @GetMapping("/pokemon/{id}")
    public @ResponseBody
    PokemonES getPokemon(@PathVariable("id") int id) throws IOException {
        return svc.getData(id);
    }

    @PostMapping("/pokemon")
    public @ResponseBody Response addPokemon(PokemonES pokemonES) throws IOException {
        String result = svc.createData(pokemonES);

        return Response.builder()
                .timestamp(DateFormatUtils.format(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSSZ"))
                .status(HttpStatus.OK.value())
                .description(HttpStatus.OK.name())
                .message(result)
                .path("/api/pokemon")
                .build();
    }

    @DeleteMapping("/pokemon/{id}")
    public @ResponseBody Response deletePokemon(@PathVariable("id") int id) throws IOException,
            RecordNotFoundException, BadRequetException {
        Optional<String> option = Optional.of(svc.deleteData(id));

        if(!option.isPresent()) {
            throw new BadRequetException("Bad Request for pokemon with id of " + id);
        }

        return Response.builder()
                .timestamp(DateFormatUtils.format(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSSZ"))
                .status(HttpStatus.OK.value())
                .description(HttpStatus.OK.name())
                .message(option.get())
                .path("/api/pokemon/{id}")
                .build();
    }

}
