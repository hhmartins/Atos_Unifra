import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponenteServicoAlbumComponent } from './componente-servico-album.component';

describe('ComponenteServicoAlbumComponent', () => {
  let component: ComponenteServicoAlbumComponent;
  let fixture: ComponentFixture<ComponenteServicoAlbumComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComponenteServicoAlbumComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponenteServicoAlbumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
