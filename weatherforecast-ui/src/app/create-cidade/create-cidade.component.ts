import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {CidadeService} from '../service/cidade.service';
import {Cidade} from '../model/cidade.model';

@Component({
  selector: 'app-create-cidade',
  templateUrl: './create-cidade.component.html',
  styleUrls: ['./create-cidade.component.css']
})
export class CreateCidadeComponent implements OnInit {

  cidadeForm = this.fb.group({
    id: [],
    nome: ["",Validators.required],
    estado: [],
    pais: [],
  });
  alert: boolean;
  msgAlert: string;

  constructor(private fb: FormBuilder, private cidadeService: CidadeService) {
  }

  ngOnInit(): void {
  }

  private createCidadeFromForm(): Cidade {
    return {
      ...new Cidade(),
      id: this.cidadeForm.get(['id']).value,
      nome: this.cidadeForm.get(['nome']).value,
      estado: this.cidadeForm.get(['estado']).value,
      pais: this.cidadeForm.get(['pais']).value,
    };
  }

  save(): any {
    const cidade = this.createCidadeFromForm();
      this.cidadeService.create(cidade).subscribe(res => {
        this.showAlert('Cidade cadastrada com sucesso!');
      });
  }

  showAlert(message: string) {
    this.msgAlert = message;
    this.alert = true;
    setTimeout(() => {
      this.alert = false;
    }, 3000);
  }


}
