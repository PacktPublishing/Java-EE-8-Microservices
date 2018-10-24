package com.packtpub.microservices.weather;

import java.io.Serializable;

/**
 * @author mertcaliskan
 */
public class Location implements Serializable {

    String name;

    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
