import { Pessoa } from './../models/Pessoa.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente3',
  templateUrl: './componente3.component.html',
  styleUrls: ['./componente3.component.css']
})
export class Componente3Component implements OnInit {

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

  constructor() { }

  ngOnInit(): void {
  }

}
