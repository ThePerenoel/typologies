package com.typologies.api.documents;

import java.util.List;

public class TypologieListDto {
    private List<TypologieDto> typologies;

    public TypologieListDto(List<TypologieDto> typologies) {
        this.typologies = typologies;
    }

    public List<TypologieDto> getTypologies() {
        return typologies;
    }

    public void setTypologies(List<TypologieDto> typologies) {
        this.typologies = typologies;
    }
}
