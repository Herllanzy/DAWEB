package br.edu.ifpb.daweb.herllan.projetoDAWEB.Service;

import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.entity.Discipline;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean validateStudent(Student student) {
        if (student == null) {
            System.out.println("Erro: Estudante não pode ser nulo.");
            return false;
        }
        if (student.getNome() == null || student.getNome().trim().isEmpty()) {
            System.out.println("Erro: Nome do estudante é obrigatório.");
            return false;
        }
        if (student.getMatricula() == null || student.getMatricula().trim().isEmpty()) {
            System.out.println("Erro: Matrícula do estudante é obrigatória.");
            return false;
        }
        if (student.getIdade() <= 0) {
            System.out.println("Erro: Idade do estudante deve ser maior que zero.");
            return false;
        }
        if (student.getTurma() <= 0) {
            System.out.println("Erro: Turma do estudante deve ser maior que zero.");
            return false;
        }
        return true;
    }

    public boolean validateDiscipline(Discipline discipline) {
        if (discipline == null) {
            System.out.println("Erro: Disciplina não pode ser nula.");
            return false;
        }
        if (discipline.getCodigo() <= 0) {
            System.out.println("Erro: Código da disciplina é obrigatório e deve ser maior que zero.");
            return false;
        }
        if (discipline.getNomeDisciplina() == null || discipline.getNomeDisciplina().trim().isEmpty()) {
            System.out.println("Erro: Nome da disciplina é obrigatório.");
            return false;
        }
        if (discipline.getProfessor() == null || discipline.getProfessor().trim().isEmpty()) {
            System.out.println("Erro: Nome do professor é obrigatório.");
            return false;
        }
        return true;
    }
}