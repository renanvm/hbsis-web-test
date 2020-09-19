import { Component, OnInit } from '@angular/core';
import {Cidade} from '../model/cidade.model';
import {CidadeService} from '../service/cidade.service';

@Component({
  selector: 'app-list-cidades',
  templateUrl: './list-cidades.component.html',
  styleUrls: ['./list-cidades.component.css']
})
export class ListCidadesComponent implements OnInit {

  cidades: Cidade[];
  alert: boolean;

  constructor(private cidadeService: CidadeService) {
  }

  ngOnInit(): void {
    this.cidadeService.getAll().subscribe(res => {
      this.cidades = res;
    });
  }

  removeCidade(cidadeId: any) {
    this.cidadeService.remove(cidadeId).subscribe(() => {
      this.showAlert();
      this.cidadeService.getAll().subscribe(res => {
        this.cidades = res;
      });
    });
  }

  showAlert() {
    this.alert = true;
    setTimeout(() => {
      this.alert = false;
    }, 3000);
  }

}
