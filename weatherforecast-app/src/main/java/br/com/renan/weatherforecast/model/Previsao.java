package br.com.renan.weatherforecast.model;

import java.time.LocalDate;

public class Previsao {

    private Double tempMinima;
    private Double tempMaxima;
    private Long umidade;
    private Double velocidadeVento;
    private String descricao;
    private LocalDate data;


    public Double getTempMinima() {
        return tempMinima;
    }

    public void setTempMinima(Double tempMinima) {
        this.tempMinima = tempMinima;
    }

    public Double getTempMaxima() {
        return tempMaxima;
    }

    public void setTempMaxima(Double tempMaxima) {
        this.tempMaxima = tempMaxima;
    }

    public Long getUmidade() {
        return umidade;
    }

    public void setUmidade(Long umidade) {
        this.umidade = umidade;
    }

    public Double getVelocidadeVento() {
        return velocidadeVento;
    }

    public void setVelocidadeVento(Double velocidadeVento) {
        this.velocidadeVento = velocidadeVento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
