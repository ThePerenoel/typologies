package com.typologies.api.users.dto;

public class TypologieToUserDto {
    private String typologieId;
    private String userId;

    public TypologieToUserDto() {}

    public TypologieToUserDto(String typologieId, String userId) {
        this.typologieId = typologieId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTypologieId() {
        return typologieId;
    }

    public void setTypologieId(String typologieId) {
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
