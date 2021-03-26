export class Pessoa
{
  nome: string;
  papel: string;

  constructor(nome:string, papel?: string) //quando coloca o "?" é que pode ser nulo
  {
    this.nome = nome;
    this.papel = papel;
  }
}
