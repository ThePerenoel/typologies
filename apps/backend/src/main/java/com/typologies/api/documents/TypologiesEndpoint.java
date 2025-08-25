package com.typologies.api.documents;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Arrays;
import java.util.List;

@Path("/typologie")
public class TypologiesEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTypologies() {
        List<String> emails = Arrays.asList("aaa@gmail.com", "bbb@gmail.com", "ccc@gmail.com");

        List<TypologieDto> typologies = Arrays.asList(
                new TypologieDto("Fiche de paie", "Géneral", true,  false, emails),
                new TypologieDto("Contrat de travail", "Géneral", true,  true,  emails),
                new TypologieDto("Bulletin de salaire", "Géneral", false, false, emails),
                new TypologieDto("Note de frais", "Géneral", true,  false, emails),
                new TypologieDto("Facture", "Géneral", false, false, emails)
        );

        return Response.ok(typologies)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
                .build();
    }

}
