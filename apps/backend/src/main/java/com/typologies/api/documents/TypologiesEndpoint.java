package com.typologies.api.documents;

import com.typologies.api.documents.dto.TypologieDto;
import com.typologies.api.documents.usecase.CreateTypologie;
import com.typologies.api.documents.usecase.GetAllTypologie;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/typologie")
public class TypologiesEndpoint {

    @Inject
    GetAllTypologie getAllTypologie;

    @Inject
    CreateTypologie createTypologie;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTypologies() {
        List<TypologieDto> typologies = getAllTypologie.act();
        return Response.ok(typologies).build();
    }

    @POST
    public Response addTypologie(TypologieDto typologie) {
        System.out.println(typologie);
        createTypologie.act(typologie);
        return Response.ok().build();
    }

}
