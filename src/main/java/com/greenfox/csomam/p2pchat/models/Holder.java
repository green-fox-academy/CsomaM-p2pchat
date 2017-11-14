package com.greenfox.csomam.p2pchat.models;

public class Holder {

    private Message message;
    private Client client;
    private String createdAt;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAT(String createdAT) {
        this.createdAt = createdAT;
    }

    public Holder(Message message, Client client) {
        this.message = message;
        this.client = client;
    }

    public Holder() {
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
