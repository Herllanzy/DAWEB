package br.edu.ifpb.daweb.herllan.projetoDAWEB.model.repository;

import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNome(String nome);
    Student findByMatricula(String matricula);
}