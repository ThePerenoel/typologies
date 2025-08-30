package com.typologies.api.users.dto;

import com.typologies.api.documents.dto.TypologieDto;

import java.util.List;

public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private List<TypologieDto> typologies;

    public UserDto() {}

    public UserDto(String firstName, String lastName, List<TypologieDto> typologies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.typologies = typologies;
    }

    public UserDto(Long id, String firstName, String lastName, List<TypologieDto> typologies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.typologies = typologies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TypologieDto> getTypologies() {
        return typologies;
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


    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", typologies=" + typologies +
                '}';
    }
}
