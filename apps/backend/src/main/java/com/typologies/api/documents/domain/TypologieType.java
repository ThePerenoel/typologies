package com.typologies.api.documents.domain;

public enum TypologieType {
    CLASSIC("Classique"),
    CUSTOM("Personnalisée");

    private final String label;

    TypologieType(String label) {
        this.label = label;
    }
}
