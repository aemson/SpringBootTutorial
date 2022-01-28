package com.tutorials.springTutorial.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestData {
    @JsonProperty("name")
    String name;
    @JsonProperty("address")
    String address;

    public RequestData(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
