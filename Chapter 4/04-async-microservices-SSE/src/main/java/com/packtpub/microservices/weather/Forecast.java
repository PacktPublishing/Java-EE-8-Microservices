package com.packtpub.microservices.weather;

import com.packtpub.microservices.domain.weather.Temperature;

public class Forecast {

    private Location location;
    private Temperature temperature;

    public Forecast(Location location, Temperature temperature) {
        this.location = location;
        this.temperature = temperature;
    }

    public Location getLocation() {
        return location;
    }
    public Temperature getTemperature() {
        return temperature;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
    
}
