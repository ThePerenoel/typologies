package com.typologies.api.users.entity;

import java.util.ArrayList;
import java.util.UUID;

public class UserEntity {
    private String id;
    private String firstName;
    private String lastName;
    private ArrayList<Long> typologies;

    public UserEntity() {}
    public UserEntity(String id, String firstName, String lastName, ArrayList<Long> typologies) {
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

    public ArrayList<Long> getTypologies() {
        return typologies;
    }

    public void setTypologies(ArrayList<Long> typologies) {
        this.typologies = typologies;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", typologies=" + typologies +
                '}';
    }
}
