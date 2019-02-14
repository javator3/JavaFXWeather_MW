package pl.sda.openweather;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.openweather.model.Weather;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class WeatherService {
    private String finalURL;
    private String url;
    private String apiKey;

    public WeatherService(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
    }


    public Weather getCityWeather(String city) {
        String urlwithApiKey = null;

        apiKey = "?key=" + apiKey + "&q=";

        try {
            urlwithApiKey = String.valueOf(new URL(url + apiKey));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        finalURL = urlwithApiKey + city;

        URL jsonURL = null;
        Weather weather = null;
        try {
            jsonURL = new URL(finalURL);
            ObjectMapper objectMapper = new ObjectMapper();
             weather = objectMapper.readValue(jsonURL, Weather.class);
        } catch (IOException e) {
            System.out.println("Nie można pobrać danych dla miasta " + city);
        }

        return weather;
    }

}
