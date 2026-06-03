package ArquiteturaDe3Camadas.presentation.controller;

import java.util.List;

import ArquiteturaDe3Camadas.Business.DTO.DisciplineDTO;
import ArquiteturaDe3Camadas.Business.DTO.StudentDTO;
import ArquiteturaDe3Camadas.Business.service.DisciplineService;
import ArquiteturaDe3Camadas.Business.service.PrinterService;
import ArquiteturaDe3Camadas.Business.service.ValidationService;

public class DisciplineController {
    private DisciplineService disciplineService = new DisciplineService();
    private PrinterService printerService = new PrinterService();
    private ValidationService validationService = new ValidationService();

    public void create(String nomeDisciplina, int codigo, String professor) {
        if (validationService.validateName(nomeDisciplina) && validationService.validateName(professor)) {
            disciplineService.create(codigo, nomeDisciplina, professor);
            printerService.println("Disciplina cadastrada com sucesso!");
        } else {
            printerService.println("Erro: Nome da disciplina ou professor inválido!");
        }
    }

    public void showAll() {
        List<DisciplineDTO> disciplines = disciplineService.findAll();

        if (disciplines.isEmpty()) {
            printerService.println("Nenhuma disciplina cadastrada.");
            return;
        }

        printerService.println("Lista de disciplinas: ");
        for (DisciplineDTO discipline : disciplines) {
            printerService.println(discipline.toString());
        }
    }

    public boolean update(int oldCodigo, int newCodigo, String newNome, String newProfessor) {
        if (validationService.validateName(newNome) && validationService.validateName(newProfessor)) {
            return disciplineService.update(oldCodigo, newCodigo, newNome, newProfessor);
        }
        return false;
    }

    public boolean delete(int codigo) {
        return disciplineService.delete(codigo);
    }

    public void addStudentToDiscipline(int codigoDisciplina, StudentDTO studentDTO) {
        if (studentDTO == null) {
            printerService.println("Erro: Estudante não encontrado!");
            return;
        }

        boolean result = disciplineService.addStudentToDiscipline(codigoDisciplina, studentDTO);
        if (result) {
            printerService.println("Estudante " + studentDTO.getNome() + " matriculado na disciplina com sucesso!");
        } else {
            printerService.println("Erro: Disciplina não encontrada!");
        }
    }

    public void showStudentsFromDiscipline(int codigo) {
        List<StudentDTO> students = disciplineService.getStudentsFromDiscipline(codigo);
        DisciplineDTO discipline = disciplineService.findDisciplineByCode(codigo);

        if (discipline == null) {
            printerService.println("Disciplina não encontrada!");
            return;
        }

        if (students == null || students.isEmpty()) {
            printerService.println("Nenhum estudante matriculado na disciplina " + discipline.getNomeDisciplina());
            return;
        }

        printerService.println("Estudantes matriculados em " + discipline.getNomeDisciplina() + ":");
        for (StudentDTO student : students) {
            printerService.println(student.toString());
        }
    }
}