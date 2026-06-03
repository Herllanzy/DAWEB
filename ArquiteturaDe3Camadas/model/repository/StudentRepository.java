package ArquiteturaDe3Camadas.model.repository;

import ArquiteturaDe3Camadas.model.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public void save(Student student){
        students.add(student);
    }

    public List<Student> findAll(){
        return new ArrayList<>(students);
    }

    public Student findByRegister(int register){
        for (Student student : students){
            if (student.getMatricula() == register){
                return student;
            }
        }
        return null;
    }

    public boolean delete(Student student) {
        return students.remove(student);
    }

    public boolean existsByRegister(int register) {
        return findByRegister(register) != null;
    }
}