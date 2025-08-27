package com.typologies.api.documents.domain;

public enum TypologieType {
    GENERAL("Général"),
    CUSTOM("Personnalisée");

    private final String label;

    TypologieType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
