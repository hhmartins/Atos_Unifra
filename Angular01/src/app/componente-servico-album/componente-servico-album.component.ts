import { Servico2Service } from './../services/servico2.service';
import { Component, OnInit } from '@angular/core';
import { Album } from './../models/Album.model';

@Component({
  selector: 'app-componente-servico-album',
  templateUrl: './componente-servico-album.component.html',
  styleUrls: ['./componente-servico-album.component.css']
})
export class ComponenteServicoAlbumComponent implements OnInit {

  albums:Album;
  erro:any;

  userId = null;
  selecionado = null;


  constructor(private albumServico:Servico2Service)
  {
    this.getter();
  }

  ngOnInit(): void {
  }

  getter()
  {
    this.albumServico.getAlbums().subscribe
    (
      (data:Album) =>
      {
        this.albums = data;
        console.log('o que retornou em data:', data);
        console.log('Variavel albums:', this.albums);
      },
      (error: any) =>
      {
        this.erro = error;
        console.error('ERRO: ', this.erro);
      }
    );

  }



}
