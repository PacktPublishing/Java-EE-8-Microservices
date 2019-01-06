
package com.packtpub.Microservices.openliberty;

public class Temperature {
    public String temperatureScale;
    public String getTemperatureScale() {
		return temperatureScale;
	}

	public void setTemperatureScale(String tempratureScale) {
		this.temperatureScale = tempratureScale;
	}

	public double temperature;

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
   
  
}
