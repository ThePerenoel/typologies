package com.typologies.api.documents.entity;

import java.util.List;
import java.util.UUID;

public class TypologieEntity {

    private UUID id;
    private String title;
    private String type;
    private boolean requiresSignature;
    private boolean requiresInitials;
    private List<String> emailAdresses;

    public TypologieEntity(String title, String type, boolean requiresSignature, boolean requiresInitials, List<String> emailAdresses) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.type = type;
        this.requiresSignature = requiresSignature;
        this.requiresInitials = requiresInitials;
        this.emailAdresses = emailAdresses;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
