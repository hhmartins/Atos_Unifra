package br.hhm.ExerciciosAPIRest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.hhm.ExerciciosAPIRest.Models.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long>{
	
	long countByNumero(int numero);

}
