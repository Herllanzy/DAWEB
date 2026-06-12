package br.edu.ifpb.daweb.herllan.projetoDAWEB.repository;

import br.edu.ifpb.daweb.herllan.projetoDAWEB.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
