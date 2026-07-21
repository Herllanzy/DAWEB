package br.edu.ifpb.daweb.herllan.projetoDAWEB.Service;

import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.DTO.DisciplineDTO;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.DTO.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrinterService {

    public void printStudent(StudentDTO student) {
        if (student != null) {
            System.out.println(student.toString());
        } else {
            System.out.println("Estudante não encontrado.");
        }
    }

    public void printAllStudents(List<StudentDTO> students) {
        if (students == null || students.isEmpty()) {
            System.out.println("Nenhum estudante cadastrado.");
            return;
        }
        System.out.println("\n--- Lista de Estudantes ---");
        for (StudentDTO s : students) {
            System.out.println(s.toString());
        }
        System.out.println("Total: " + students.size());
    }

    public void printDiscipline(DisciplineDTO discipline) {
        if (discipline != null) {
            System.out.println(discipline.toString());
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    public void printAllDisciplines(List<DisciplineDTO> disciplines) {
        if (disciplines == null || disciplines.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }
        System.out.println("\n--- Lista de Disciplinas ---");
        for (DisciplineDTO d : disciplines) {
            System.out.println(d.toString());
        }
        System.out.println("Total: " + disciplines.size());
    }

    public void printMenu() {
        System.out.println("\n===== SISTEMA ACADÊMICO =====");
        System.out.println("1 - Cadastrar Estudante");
        System.out.println("2 - Listar Estudantes");
        System.out.println("3 - Buscar Estudante por ID");
        System.out.println("4 - Atualizar Estudante");
        System.out.println("5 - Deletar Estudante");
        System.out.println("6 - Cadastrar Disciplina");
        System.out.println("7 - Listar Disciplinas");
        System.out.println("8 - Buscar Disciplina por ID");
        System.out.println("9 - Atualizar Disciplina");
        System.out.println("10 - Deletar Disciplina");
        System.out.println("11 - Adicionar Aluno a Disciplina");
        System.out.println("12 - Remover Aluno de Disciplina");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }
}