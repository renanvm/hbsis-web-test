import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {AppRoutingModule} from './app-routing.module';
import { CreateCidadeComponent } from './create-cidade/create-cidade.component';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { ListCidadesComponent } from './list-cidades/list-cidades.component';
import { ForecastCidadeComponent } from './forecast-cidade/forecast-cidade.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateCidadeComponent,
    ListCidadesComponent,
    ForecastCidadeComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
