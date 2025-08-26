package com.typologies.api.documents;

import com.typologies.api.documents.dto.TypologieDto;
import com.typologies.api.documents.usecase.GetAllTypologie;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Arrays;
import java.util.List;

@Path("/typologie")
public class TypologiesEndpoint {

    @Inject
    GetAllTypologie getAllTypologie;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTypologies() {
        List<TypologieDto> typologies = getAllTypologie.act();
        return Response.ok(typologies)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
                .build();
    }

}
