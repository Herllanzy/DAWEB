package ArquiteturaDe3Camadas.Business.service;

import java.util.ArrayList;
import java.util.List;

import ArquiteturaDe3Camadas.Business.DTO.StudentDTO;
import ArquiteturaDe3Camadas.model.entity.Student;
import ArquiteturaDe3Camadas.model.repository.StudentRepository;

public class StudentService {

    private StudentRepository studentRepository = new StudentRepository();

    public void create(String nome, int matricula, int idade, int turma) {
        Student student = new Student(nome, matricula, idade, turma);
        studentRepository.save(student);
    }

    public List<StudentDTO> findAll(){
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();

        for (Student student : students) {
            StudentDTO studentDTO = new StudentDTO(student.getNome(), student.getMatricula(), student.getIdade(), student.getTurma());
            studentsDTO.add(studentDTO);
        }
        return studentsDTO;
    }

    public boolean update(int oldMatricula, String newNome, int newMatricula){
        Student student = studentRepository.findByRegister(oldMatricula);

        if (student != null){
            student.setMatricula(newMatricula);
            student.setNome(newNome);
            return true;
        }
        return false;
    }

    public boolean delete(int matricula) {
        Student student = studentRepository.findByRegister(matricula);
        if (student != null) {
            return studentRepository.delete(student);
        }
        return false;
    }


    public StudentDTO findByRegister(int matricula) {
        Student student = studentRepository.findByRegister(matricula);
        if (student != null) {
            return new StudentDTO(student.getNome(), student.getMatricula(), student.getIdade(), student.getTurma());
        }
        return null;
    }
}