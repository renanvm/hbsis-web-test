import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CreateCidadeComponent} from './create-cidade/create-cidade.component';
import {ListCidadesComponent} from './list-cidades/list-cidades.component';

const routes: Routes = [
  {path: 'create-cidade', component: CreateCidadeComponent},
  {path: 'list-cidades', component: ListCidadesComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
