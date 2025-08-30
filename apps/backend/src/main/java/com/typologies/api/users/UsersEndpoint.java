package com.typologies.api.users;

import com.typologies.api.users.dto.TypologieToUserDto;
import com.typologies.api.users.dto.UserDto;
import com.typologies.api.users.usecase.AddUser;
import com.typologies.api.users.usecase.AssociateTypologie;
import com.typologies.api.users.usecase.GetAllUsers;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/users")
public class UsersEndpoint {

    @Inject
    GetAllUsers getAllUsers;

    @Inject
    AssociateTypologie associateTypologie;

    @Inject
    AddUser addUser;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        List<UserDto> users = getAllUsers.act();
        return Response.ok(users).build();
    }

    @POST

    public Response addUser(UserDto userDto) {
        addUser.act(userDto);
        return Response.ok().build();
    }

    @POST
    @Path("/associate")
    public Response associateTypologie(TypologieToUserDto typologieToUserDto) {
        associateTypologie.act(typologieToUserDto.getUserId(), typologieToUserDto.getTypologieId());
        return Response.ok().build();
    }

}
