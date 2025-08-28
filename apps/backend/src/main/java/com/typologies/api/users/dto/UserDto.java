package com.typologies.api.users.dto;

import com.typologies.api.documents.dto.TypologieDto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private String id;
    private String firstName;
    private String lastName;
    private List<TypologieDto> typologies;

    public UserDto() {}

    public UserDto(String firstName, String lastName, List<TypologieDto> typologies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.typologies = typologies;
    }

    public UserDto(String id, String firstName, String lastName, List<TypologieDto> typologies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.typologies = typologies;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTypologies(List<TypologieDto> typologies) {
        this.typologies = typologies;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
