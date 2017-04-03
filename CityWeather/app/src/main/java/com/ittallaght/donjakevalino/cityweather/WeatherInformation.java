package com.ittallaght.donjakevalino.cityweather;

/**
 * Created by Jake Valino on 30/03/2017.
 */

enum WeatherCondition
{
    Cloudy, Rainy, Sunny
}

public class WeatherInformation {
    private String city;
    private int temperature;
    //Enum to populate condition variable
    private  WeatherCondition cityCondidtion;

    // Getters
    public String GetCity()
    {
        return city;
    }

    public int GetTemperature()
    {
        return temperature;
    }

    public WeatherCondition GetCityCondition()
    {
        return cityCondidtion;
    }

    // Constructor
    public WeatherInformation(String cityIn, int temperatureIn, WeatherCondition cityConditionIn)
    {
        city = cityIn;
        temperature = temperatureIn;
        cityCondidtion = cityConditionIn;
    }





}
