package br.hhm.ExerciciosAPIRest.Controller;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.hhm.ExerciciosAPIRest.Models.AlunoProfessor;
import br.hhm.ExerciciosAPIRest.Models.Candidato;
import br.hhm.ExerciciosAPIRest.Models.Populacao;
import br.hhm.ExerciciosAPIRest.Repositories.AlunoProfessorRepository;
import br.hhm.ExerciciosAPIRest.Repositories.CandidatoRepository;
import br.hhm.ExerciciosAPIRest.Repositories.PopulacaoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController",
description = "REST APIs relacionada a entrega 1")
@RestController
@RequestMapping("/entrega1")
public class Exercicio1Controller {
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	@Autowired
	private PopulacaoRepository populacaoRepository;
	@Autowired
	private AlunoProfessorRepository alunoProfessorRepository;
	
	//EXERCICIO 1 ################################################################################################
	@ApiOperation(value = "Retorna a Hora Atual", response = Iterable.class, tags = "Hora Atual")
	@GetMapping("/hora")
	public Date getData()
	{
		Date date = new Date();  
		return date;
	}
	
	//EXERCICIO 2 ################################################################################################
	@ApiOperation(value = "Retorn a temperatura em fahrenheit", response = Iterable.class, tags = " temperatura convertida em fahrenheit")
	@GetMapping("/temperatura/{temp}")
	public String convetTemp(@PathVariable float temp)
	{ 
		double result = (temp*1.8)+32;
		return temp + " ºC convertido para ºF resulta em " +result+ " ºF";
	}
	
	//EXERCICIO 3 ################################################################################################
	@ApiOperation(value = "Verifica se o numero é par ou impar", response = Iterable.class, tags = "Paridade")
	@GetMapping("/paridade/{numb}")
	public String verificaPar(@PathVariable int numb)
	{ 
		if(numb % 2 == 0) return "O número " +numb+ " é par";
		else return "O número " +numb+ " é impar";
	}
	
	//EXERCICIO 4 ################################################################################################
	@ApiOperation(value = "Cadastra um voto para o candidato", response = Iterable.class, tags = "candidato")
	@PostMapping("/candidatos")
	@ResponseStatus(HttpStatus.CREATED)
	public Candidato adicionar(@RequestBody Candidato candidato)
	{
		return candidatoRepository.save(candidato);
	}
	
	
	@ApiOperation(value = "Cadastra um voto para o candidato", response = Iterable.class, tags = "candidato")
	@GetMapping("/candidatos")
	public String resultadoParcial()
	{
		long votos15 = candidatoRepository.countByNumero(15);
		long votos7 = candidatoRepository.countByNumero(7);
		
		if(votos15 > votos7) return "O resultado parcial da eleição é de vitória do partido 15 com um total de "+votos15+" votos, contra "+votos7+ " votos do partido 7";
		else if(votos15 == votos7) return "O resultado parcial da eleição é de empate tecnico com um total de " +votos15+ " para cada partido";
		else return "O resultado parcial da eleição é de vitória do partido 7 com um total de "+votos7+" votos, contra "+votos15+ " votos do partido 15";
	}
	
	@ApiOperation(value = "Contagem de votos para o candidato", response = Iterable.class, tags = "candidato")
	@GetMapping("/candidatos/{numero}")
	public String contagemDeVotos(@PathVariable int numero)
	{
		long votos = candidatoRepository.countByNumero(numero);

		return "O numero de votos do partido " +numero+" foi igual a "+votos+" votos.";

	}
	
	//EXERCICIO 5 ################################################################################################
	@ApiOperation(value = "Cadastra o ano e a população da cidade", response = Iterable.class, tags = "cidade")
	@PostMapping("/cidade")
	@ResponseStatus(HttpStatus.CREATED)
	public Populacao adicionar(@RequestBody Populacao populacao)
	{
		return populacaoRepository.save(populacao);
	}
	
	@ApiOperation(value = "Retorna todos os anos e as populações da cidade", response = Iterable.class, tags = "cidade")
	@GetMapping("/cidade")
	public List<Populacao> getPòpulacao()
	{
		return populacaoRepository.findAll();

	}
	
	@ApiOperation(value = "Retorna a população do ano especificado", response = Iterable.class, tags = "cidade")
	@GetMapping("/cidade/{ano}")
	public List<Populacao> populacaoDoAno(@PathVariable int ano)
	{

		return populacaoRepository.findAllByAno(ano);

	}
	
	@ApiOperation(value = "Deleta o id selecionado", response = Iterable.class, tags = "cidade")
	@DeleteMapping("/cidade/{id}")
	public void deletePopulacao(@PathVariable long id) {
		populacaoRepository.deleteById(id);
	}
	
	@ApiOperation(value = "Alterar um ano e população cadastrada", response = Iterable.class, tags = "cidade")
	@PutMapping("/cidade/{id}")
	public Populacao updatePessoa(@RequestBody Populacao populacao, @PathVariable Long id) {
		Populacao p = populacaoRepository.getOne(id);
		if(p == null) {
			return null;
		}
		p.setAno(populacao.getAno());
		p.setPopulacao(populacao.getPopulacao());
		return populacaoRepository.save(p);
	}
	
	//EXERCICIO 6 ################################################################################################
	
	@ApiOperation(value = "Cadastra um aluno ou professor", response = Iterable.class, tags = "Aluno ou Professor")
	@PostMapping("/aluno")
	@ResponseStatus(HttpStatus.CREATED)
	public AlunoProfessor adicionar(@RequestBody AlunoProfessor alunoprofessor)
	{
		return alunoProfessorRepository.save(alunoprofessor);
	}
	
	@ApiOperation(value = "Retorna todos os dados da lista.", response = Iterable.class, tags = "Aluno ou Professor")
	@GetMapping("/aluno")
	public List<AlunoProfessor> getAlunoProfessor()
	{
		return alunoProfessorRepository.findAll();

	}
	
	@ApiOperation(value = "Retorna a lista da ocupação solicitada", response = Iterable.class, tags = "Aluno ou Professor")
	@GetMapping("/aluno/{ocupacao}")
	public List<AlunoProfessor> listOcupacao(@PathVariable String ocupacao)
	{

		return alunoProfessorRepository.findAllByOcupacao(ocupacao);

	}
	
	
	@ApiOperation(value = "Deleta o id selecionado", response = Iterable.class, tags = "Aluno ou Professor")
	@DeleteMapping("/aluno/{id}")
	public void deleteAlunoProfessor(@PathVariable long id) {
		alunoProfessorRepository.deleteById(id);
	}
	
	@ApiOperation(value = "Alterar uma pessoa cadastrada", response = Iterable.class, tags = "Aluno ou Professor")
	@PutMapping("/aluno/{id}")
	public AlunoProfessor updatePessoa(@RequestBody AlunoProfessor alunoProfessor, @PathVariable Long id) {
		AlunoProfessor user = alunoProfessorRepository.getOne(id);
		if(user == null) {
			return null;
		}
		user.setNome(alunoProfessor.getNome());
		user.setOcupacao(alunoProfessor.getOcupacao());
		return alunoProfessorRepository.save(user);
	}
	
	
}
