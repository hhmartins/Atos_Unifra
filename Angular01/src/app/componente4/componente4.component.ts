import { Pessoa } from './../models/Pessoa.model';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-componente4',
  templateUrl: './componente4.component.html',
  styleUrls: ['./componente4.component.css']
})
export class Componente4Component implements OnInit {


  pessoas =
  [
    new Pessoa ("Henrique", "estudante"),
    new Pessoa ("Reiner",  "professor"),
    new Pessoa ("Fabricio", "professor"),
    new Pessoa ("Carara", "professor"),
    new Pessoa ("Londero", "professor"),
    new Pessoa ("Copetti", "professor"),
    new Pessoa ("Mario", "professor"),
    new Pessoa ("Beltrame", "professor"),
    new Pessoa ("Leonardo", "professor"),
    new Pessoa ("Alice", "professora"),
    new Pessoa ("Canha", "professora")
  ];

  selecionado = null;
  editando = null;
  nome = null;
  papel = null;

  selecionar(pessoa)
  {
    this.selecionado = pessoa;
  }

  cadastro = new FormGroup
  (
    {
      nome: new FormControl(''),
      papel: new FormControl('')
    }
  );
/* //salvar antigo
  salvar()
  {
    const p = new Pessoa(this.cadastro.value.nome, this.cadastro.value.papel);
    this.pessoas.push(p);
  }
*/

  salvar()
  {
    if (this.editando)
    {
      this.editando.nome = this.nome;
      this.editando.papel = this.papel;
    }
    else
    {
      const p = new Pessoa(this.cadastro.value.nome, this.cadastro.value.papel);
      this.pessoas.push(p);
    }

    this.cancelar();
  }


  excluir(pessoa)

  {
    if(this.editando == pessoa)
    {
      alert('Não pode exlcuir uma pessoa em edição.');
    }
    else
    {
      if(confirm('Deseja prosseguir com a exclusão de "' + pessoa.nome + '" ?'))
      {
        const i = this.pessoas.indexOf(pessoa);
        this.pessoas.splice(i, 1);
      }
    }

  }

  cancelar()
  {
    this.nome = null;
    this.papel = null;
    this.editando = null;
  }

  editar(pessoa)
  {
    this.editando = pessoa;
    this.nome = pessoa.nome;
    this.papel = pessoa.papel;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
