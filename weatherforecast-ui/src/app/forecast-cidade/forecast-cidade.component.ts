import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Previsao} from '../model/previsao.model';
import {WeatherForecastService} from '../service/weather-forecast.service';

@Component({
  selector: 'app-forecast-cidade',
  templateUrl: './forecast-cidade.component.html',
  styleUrls: ['./forecast-cidade.component.css']
})
export class ForecastCidadeComponent implements OnInit {


  previsoes: Previsao[];

  constructor(private route: ActivatedRoute, private weatherForecastService: WeatherForecastService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      let nomeCidade = params['nome'];
      this.weatherForecastService.getPrevisoes(nomeCidade).subscribe(res => {
        this.previsoes = res;
      })
    });
  }

}
