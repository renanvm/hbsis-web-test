package br.com.renan.weatherforecast.service;


import br.com.renan.weatherforecast.model.Previsao;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class WeatherForecastService {

    private static final Integer DAYS = 5;

    public Map getCoordenadasCidade(String result) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map coordinates = new HashMap<String, String>();
        try {
            JsonNode jsonNode = objectMapper.readValue(result, JsonNode.class);
            JsonNode coordNode = jsonNode.get("coord");
            coordinates.put("longitude", coordNode.get("lon").asText());
            coordinates.put("latitude", coordNode.get("lat").asText());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return coordinates;
    }

    public List<Previsao> handleForecastJson(String result) {
        List<Previsao> list = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readValue(result, JsonNode.class);
            JsonNode daily = jsonNode.get("daily");
            if(daily.size() > 5){
                for (int i = 0; i < DAYS; i++) {
                    Previsao previsao = new Previsao();
                    Long dt = daily.get(i).get("dt").asLong();
                    Double min = daily.get(i).get("temp").get("min").asDouble();
                    Double max = daily.get(i).get("temp").get("max").asDouble();
                    Long humidity = daily.get(i).get("humidity").asLong();
                    Double windSpeed = daily.get(i).get("wind_speed").asDouble();
                    String description = daily.get(i).get("weather").get(0).get("description").asText();
                    previsao.setData(LocalDate.parse(convertDate(dt)));
                    previsao.setTempMinima(min);
                    previsao.setTempMaxima(max);
                    previsao.setUmidade(humidity);
                    previsao.setVelocidadeVento(windSpeed);
                    previsao.setDescricao(description);
                    list.add(previsao);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private String convertDate(Long dt) {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDtm = Instant.ofEpochSecond(dt)
                .atZone(ZoneId.of("GMT-4"))
                .format(formatter);

        return formattedDtm;
    }
}
