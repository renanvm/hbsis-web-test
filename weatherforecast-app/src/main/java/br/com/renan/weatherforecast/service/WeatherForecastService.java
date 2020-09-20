package br.com.renan.weatherforecast.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherForecastService {

    public Map getCoordenadasCidade(String result) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map coordenadas = new HashMap<String, String>();
        try {
            JsonNode jsonNode = objectMapper.readValue(result, JsonNode.class);
            JsonNode coordNode = jsonNode.get("coord");
            coordenadas.put("longitude", coordNode.get("lon").asText());
            coordenadas.put("latitude", coordNode.get("lat").asText());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return coordenadas;
    }
}
