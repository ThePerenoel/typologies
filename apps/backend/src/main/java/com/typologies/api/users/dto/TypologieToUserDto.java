package com.typologies.api.users.dto;

public class TypologieToUserDto {
    private Long typologieId;
    private String userId;

    public TypologieToUserDto() {}

    public TypologieToUserDto(Long typologieId, String userId) {
        this.typologieId = typologieId;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
