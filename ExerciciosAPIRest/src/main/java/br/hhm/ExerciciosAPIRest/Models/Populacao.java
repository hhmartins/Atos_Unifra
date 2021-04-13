package br.hhm.ExerciciosAPIRest.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Populacao {
	
	@ApiModelProperty(notes = "ID da população", name="id", required=true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ApiModelProperty(notes = "Ano da cidade", name="ano", 
            required=true, value="Ano da cidade")
    @Column(nullable = false)
	private int ano;
	
    @ApiModelProperty(notes = "População da Cidade", name="populacao", 
            required=true, value="População da Cidade")
    @Column(nullable = false)
	private int populacao;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}


	public int getPopulacao() {
		return populacao;
	}


	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}
	
	
	

}
