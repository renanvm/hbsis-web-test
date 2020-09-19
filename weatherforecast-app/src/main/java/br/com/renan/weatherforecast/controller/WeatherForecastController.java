package br.com.renan.weatherforecast.controller;

import br.com.renan.weatherforecast.service.WeatherForecastService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin()
public class WeatherForecastController {

    @Value("${openweather.api.key}")
    private String apiKey;
    @Value("${openweather.api.url}")
    private String apiUrl;
    @Value("${openweather.api.lang}")
    private String apiLang;
    private RestTemplate restTemplate = new RestTemplate();
    private WeatherForecastService weatherForecastService;

    public WeatherForecastController(WeatherForecastService weatherForecastService) {
        this.weatherForecastService = weatherForecastService;
    }

    @GetMapping("/{cidade}")
    public ResponseEntity<?> checkCidadeIsValid(@PathVariable String cidade) {
        String requestUrl = apiUrl + cidade + apiKey + apiLang;
        try {
            int statusCode = restTemplate.getForEntity(requestUrl, String.class).getStatusCode().value();
            return ResponseEntity.status(statusCode).build();
        } catch (HttpStatusCodeException exception) {
            int statusCode = exception.getStatusCode().value();
            return ResponseEntity.status(statusCode).build();
        }
    }
}
