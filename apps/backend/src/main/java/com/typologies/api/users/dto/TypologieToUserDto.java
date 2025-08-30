package com.typologies.api.users.dto;

public class TypologieToUserDto {
    private Long typologieId;
    private Long userId;

    public TypologieToUserDto() {}

    public TypologieToUserDto(Long typologieId, Long userId) {
        this.typologieId = typologieId;
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTypologieId() {
        return typologieId;
    }

    public void setTypologieId(Long typologieId) {
        this.typologieId = typologieId;
    }

    @Override
    public String toString() {
        return "TypologieToUserDto{" +
                "typologieId='" + typologieId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
