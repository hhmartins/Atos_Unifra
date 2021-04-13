package br.hhm.ExerciciosAPIRest.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.hhm.ExerciciosAPIRest.Models.Populacao;

@Repository
public interface PopulacaoRepository extends JpaRepository<Populacao, Long>{
	
	List<Populacao> findAllByAno(int ano);
	
	List<Populacao> removeByAno(int ano);

}
