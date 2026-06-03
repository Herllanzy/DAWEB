package ArquiteturaDe3Camadas.presentation.controller;

import java.util.List;

import ArquiteturaDe3Camadas.Business.DTO.StudentDTO;
import ArquiteturaDe3Camadas.Business.service.PrinterService;
import ArquiteturaDe3Camadas.Business.service.StudentService;
import ArquiteturaDe3Camadas.Business.service.ValidationService;

public class StudentController {

    private ValidationService validationService = new ValidationService();
    private StudentService studentService = new StudentService();
    private PrinterService printerService = new PrinterService();

    public void create(String nome, int matricula, int idade, int turma){
        if (validationService.validateName(nome)){
            studentService.create(nome, matricula, idade, turma);
            printerService.println("Estudante cadastrado com sucesso!");
        } else {
            printerService.println("Erro: Nome inválido!");
        }
    }

    public void showAll(){
        List<StudentDTO> students = studentService.findAll();

        if (students.isEmpty()) {
            printerService.println("Nenhum estudante cadastrado.");
            return;
        }

        printerService.println("Lista de estudantes: ");
        for(StudentDTO student : students) {
            printerService.println(student.toString());
        }
    }

    public boolean update(int oldMatricula, String newNome, int newMatricula){
        if(validationService.validateName(newNome)){
            return studentService.update(oldMatricula, newNome, newMatricula);
        }
        return false;
    }

    public boolean delete(int matricula) {
        return studentService.delete(matricula);
    }

    public StudentDTO findByRegister(int matricula) {
        return studentService.findByRegister(matricula);
    }
}