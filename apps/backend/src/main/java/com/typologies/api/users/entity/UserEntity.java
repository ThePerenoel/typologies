package com.typologies.api.users.entity;

import com.typologies.api.documents.entity.TypologieEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String firstName;

    @NotBlank
    @Column(nullable = false)
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_typologie",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "typologie_id")
    )
    private List<TypologieEntity> typologies;

    public UserEntity() {}

    public UserEntity(String firstName, String lastName, List<TypologieEntity> typologies) {
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

    public @NotBlank String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank String lastName) {
        this.lastName = lastName;
    }

    public List<TypologieEntity> getTypologies() {
        return typologies;
    }

    public void setTypologies(ArrayList<TypologieEntity> typologies) {
        this.typologies = typologies;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", typologies=" + typologies +
                '}';
    }
}
