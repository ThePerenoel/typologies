package com.typologies.api.users;

import com.typologies.api.users.dto.UserDto;
import com.typologies.api.users.usecase.GetAllUsers;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/users")
public class UsersEndpoint {

    @Inject
    GetAllUsers getAllUsers;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        List<UserDto> users = getAllUsers.act();
        return Response.ok(users).build();
    }

}
