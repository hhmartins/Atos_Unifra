import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-componente2',
  templateUrl: './componente2.component.html',
  styleUrls: ['./componente2.component.css']
})
export class Componente2Component implements OnInit {

  pessoas =
  [
    {nome: "Henrique", papel: "estudante"},
    {nome: "Reiner", papel: "professor"},
    {nome: "Fabricio", papel: "professor"},
    {nome: "Carara", papel: "professor"},
    {nome: "Londero", papel: "professor"},
    {nome: "Copetti", papel: "professor"},
    {nome: "Mario", papel: "professor"},
    {nome: "Beltrame", papel: "professor"},
    {nome: "Leonardo", papel: "professor"},
    {nome: "Alice", papel: "professora"},
    {nome: "Canha", papel: "professora"}
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
