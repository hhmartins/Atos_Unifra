package br.hhm.ExerciciosAPIRest.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.hhm.ExerciciosAPIRest.Models.AlunoProfessor;


@Repository
public interface AlunoProfessorRepository extends JpaRepository<AlunoProfessor, Long>{
	
	List<AlunoProfessor> findAllByOcupacao(String ocupacao);

}
