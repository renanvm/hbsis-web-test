import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CreateCidadeComponent} from './create-cidade/create-cidade.component';

const routes: Routes = [
  { path: 'create-cidade', component: CreateCidadeComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
