package com.example.domain.model;

public class Nested {
    public enum Status {
        GOOD,
        BAD
    }

    private Status status;

    private String string;


    public Status getStatus() { return status; }

    public void setStatus(final Status status) { this.status = status; }

    public String getString() { return string; }

    public void setString(final String string) { this.string = string; }
}
