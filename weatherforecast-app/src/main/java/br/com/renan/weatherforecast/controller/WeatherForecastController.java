package br.com.renan.weatherforecast.controller;

import br.com.renan.weatherforecast.model.Previsao;
import br.com.renan.weatherforecast.service.WeatherForecastService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/forecast")
@CrossOrigin()
public class WeatherForecastController {

    @Value("${openweather.api.key}")
    private String apiKey;
    @Value("${openweather.api.url}")
    private String apiUrl;
    @Value("${openweather.api.url.onecall}")
    private String apiUrlOneCall;
    @Value("${openweather.api.lang}")
    private String apiLang;
    @Value("${openweather.api.units}")
    private String units;
    @Value("${openweather.api.exclude}")
    private String exclude;
    private RestTemplate restTemplate = new RestTemplate();
    private WeatherForecastService weatherForecastService;

    public WeatherForecastController(WeatherForecastService weatherForecastService) {
        this.weatherForecastService = weatherForecastService;
    }

    @GetMapping("/check/{cidade}")
    public ResponseEntity<?> checkCidadeIsValid(@PathVariable String cidade) {
        String requestUrl = apiUrl + cidade + apiKey;
        try {
            int statusCode = restTemplate.getForEntity(requestUrl, String.class).getStatusCode().value();
            return ResponseEntity.status(statusCode).build();
        } catch (HttpStatusCodeException exception) {
            int statusCode = exception.getStatusCode().value();
            return ResponseEntity.status(statusCode).build();
        }
    }

    @GetMapping("/{cidade}")
    public ResponseEntity<List<Previsao>> getForecastWeather(@PathVariable String cidade) throws JsonProcessingException {
        String requestCoordinates = apiUrl + cidade + apiKey + apiLang + units;
        Map coordinates = this.weatherForecastService.getCoordenadasCidade(restTemplate.getForObject(requestCoordinates, String.class).toString());
        String urlOneCall = apiUrlOneCall+"lat="+coordinates.get("latitude")+"&lon="+coordinates.get("longitude")+apiLang+exclude+units+apiKey;
        List<Previsao> newForecastJson = this.weatherForecastService.handleForecastJson(restTemplate.getForEntity(urlOneCall, String.class).getBody());
        return ResponseEntity.ok().body(newForecastJson);
    }
}
