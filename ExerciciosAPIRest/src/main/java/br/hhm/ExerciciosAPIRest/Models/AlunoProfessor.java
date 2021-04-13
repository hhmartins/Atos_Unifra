package br.hhm.ExerciciosAPIRest.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class AlunoProfessor {
	
	@ApiModelProperty(notes = "ID da população", name="id", required=true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @ApiModelProperty(notes = "Nome", name="nome", 
            required=true, value="Nome")
    @Column(nullable = false)
	private String nome;
	
    @ApiModelProperty(notes = "Ocupação: Professor ou Aluno", name="ocupação", 
            required=true, value="Ocupação: Professor ou Aluno")
    @Column(nullable = false)
    
	private String ocupacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

}
