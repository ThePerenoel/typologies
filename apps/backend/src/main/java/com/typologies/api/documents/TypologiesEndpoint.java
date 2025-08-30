package com.typologies.api.documents;

import com.typologies.api.documents.dto.TypologieDto;
import com.typologies.api.documents.usecase.CreateTypologie;
import com.typologies.api.documents.usecase.DeleteTypologie;
import com.typologies.api.documents.usecase.GetAllTypologie;
import jakarta.annotation.Nonnull;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/typologie")
public class TypologiesEndpoint {

    @Inject
    GetAllTypologie getAllTypologie;

    @Inject
    CreateTypologie createTypologie;

    @Inject
    DeleteTypologie deleteTypologie;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTypologies() {
        List<TypologieDto> typologies = getAllTypologie.act();
        return Response.ok(typologies).build();
    }

    @POST
    public Response addTypologie(TypologieDto typologie) {
        createTypologie.act(typologie);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeTypologie(@PathParam("id") String id) {
        deleteTypologie.act(Long.valueOf(id));
        return Response.ok().build();
    }

}
