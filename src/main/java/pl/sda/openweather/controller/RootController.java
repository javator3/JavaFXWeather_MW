package pl.sda.openweather.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.sda.openweather.WeatherService;
import pl.sda.openweather.model.Weather;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class RootController implements Initializable {

    @FXML
    private Button search;

    @FXML
    private TextField city;

    @FXML
    private Label temp;

    @FXML
    private Label tempFeel;

    @FXML
    private Label tempValue;

    @FXML
    private Label tempFeelValue;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setCity(ActionEvent actionEvent) {
        WeatherService weatherService = new WeatherService(
                "http://api.apixu.com/v1/current.json",
                "13b4146ab016460c9e992445191002");

        Weather weather = weatherService.getCityWeather(city.getText());
        tempValue.setText(String.valueOf(weather.getCurrent().getTemp_c()));
        tempFeelValue.setText(String.valueOf(weather.getCurrent().getFeelslike_c()));


    }
}
