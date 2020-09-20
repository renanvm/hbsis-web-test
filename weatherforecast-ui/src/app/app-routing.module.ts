import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CreateCidadeComponent} from './create-cidade/create-cidade.component';
import {ListCidadesComponent} from './list-cidades/list-cidades.component';
import {ForecastCidadeComponent} from './forecast-cidade/forecast-cidade.component';

const routes: Routes = [
  {path: '', component: CreateCidadeComponent},
  {path: 'create-cidade', component: CreateCidadeComponent},
  {path: 'list-cidades', component: ListCidadesComponent},
  {path: 'forecast-cidade/:nome', component: ForecastCidadeComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
