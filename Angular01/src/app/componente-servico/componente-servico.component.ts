import { Servico1Service } from './../services/servico1.service';
import { Photo } from './../models/Photo.model';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';


@Component({
  selector: 'app-componente-servico',
  templateUrl: './componente-servico.component.html',
  styleUrls: ['./componente-servico.component.css']
})
export class ComponenteServicoComponent implements OnInit {

  photos:Photo;
  albumId:number;
  erro:any;


  constructor(private photoServico:Servico1Service, private route:ActivatedRoute)
  {

  }

  ngOnInit():void {
    this.route.params.subscribe(params => {
      this.albumId=params['albumID']
    })

    this.photoServico.getPhotosByAlbumId(this.albumId).subscribe
    (
      (data:Photo) =>
      {
        this.photos = data;
        console.log('o que retornou em data:', data);
        console.log('Variavel photos:', this.photos);
      },
      (error: any) =>
      {
        this.erro = error;
        console.error('ERRO: ', this.erro);
      }
    );
  }

}
