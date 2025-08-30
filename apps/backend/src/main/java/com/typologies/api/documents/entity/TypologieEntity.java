package com.typologies.api.documents.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "Typologie")
public class TypologieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @NotBlank
    @Column(nullable = false)
    private String type;

    private boolean requiresSignature;
    private boolean requiresInitials;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "typologie_email_addresses",
            joinColumns = @JoinColumn(name = "typologie_id"))
    @Column(name = "email_address")
    private List<String> emailAdresses;

    public TypologieEntity() {}

    public TypologieEntity(String title, String type, boolean requiresSignature, boolean requiresInitials, List<String> emailAdresses) {
        this.title = title;
        this.type = type;
        this.requiresSignature = requiresSignature;
        this.requiresInitials = requiresInitials;
        this.emailAdresses = emailAdresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank String title) {
        this.title = title;
    }

    public @NotBlank String getType() {
        return type;
    }

    public void setType(@NotBlank String type) {
        this.type = type;
    }

    public boolean requiresSignature() {
        return requiresSignature;
    }

    public void setRequiresSignature(boolean requiresSignature) {
        this.requiresSignature = requiresSignature;
    }

    public boolean requiresInitials() {
        return requiresInitials;
    }

    public void setRequiresInitials(boolean requiresInitials) {
        this.requiresInitials = requiresInitials;
    }

    public List<String> getEmailAdresses() {
        return emailAdresses;
    }

    public void setEmailAdresses(List<String> emailAdresses) {
        this.emailAdresses = emailAdresses;
    }

    @Override
    public String toString() {
        return "TypologieEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", requiresSignature=" + requiresSignature +
                ", requiresInitials=" + requiresInitials +
                ", emailAdresses=" + emailAdresses +
                '}';
    }
}