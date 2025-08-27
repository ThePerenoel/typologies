package com.typologies.api.documents.dto;

import java.util.List;

public class TypologieDto {

    private String title;
    private String type;
    private boolean requiresSignature;
    private boolean requiresInitials;
    private List<String> emailAdresses;

    public TypologieDto() {}

    public TypologieDto(String title, String type, boolean requiresSignature, boolean requiresInitials, List<String> emailAdresses) {
        this.title = title;
        this.type = type;
        this.requiresSignature = requiresSignature;
        this.requiresInitials = requiresInitials;
        this.emailAdresses = emailAdresses;
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

    public boolean isRequiresSignature() {
        return requiresSignature;
    }

    public void setRequiresSignature(boolean requiresSignature) {
        this.requiresSignature = requiresSignature;
    }

    public boolean isRequiresInitials() {
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
        return "TypologieDto{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", requiresSignature=" + requiresSignature +
                ", requiresInitials=" + requiresInitials +
                ", emailAdresses=" + emailAdresses +
                '}';
    }
}
