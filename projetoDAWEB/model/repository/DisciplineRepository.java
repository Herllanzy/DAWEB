package br.edu.ifpb.daweb.herllan.projetoDAWEB.model.repository;

import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

    List<Discipline> findByNomeDisciplina(String nomeDisciplina);
    Discipline findByCodigo(int codigo);
}