package com.cmssc.unite.unite.model.dto;

import java.time.LocalDate;

public class MessageDTO {

    private int id;

    private String value;

    private LocalDate date;

    private Integer senderId;

    public MessageDTO(int id, String value, LocalDate date, Integer senderId) {
        this.id = id;
        this.value = value;
        this.date = date;
        this.senderId = senderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }
}
