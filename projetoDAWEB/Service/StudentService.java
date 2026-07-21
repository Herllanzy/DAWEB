package br.edu.ifpb.daweb.herllan.projetoDAWEB.Service;

import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.DTO.StudentDTO;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.entity.Student;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ValidationService validationService;

    public StudentDTO save(StudentDTO studentDTO) {
        Student student = studentDTO.toEntity();
        if (validationService.validateStudent(student)) {
            Student saved = studentRepository.save(student);
            return StudentDTO.fromEntity(saved);
        }
        return null;
    }

    public List<StudentDTO> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(StudentDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<StudentDTO> findById(Long id) {
        return studentRepository.findById(id)
                .map(StudentDTO::fromEntity);
    }

    public void deleteById(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            System.out.println("Erro: Estudante com ID " + id + " não encontrado.");
        }
    }

    public boolean update(String matricula, String newNome, String newMatricula) {
        Student student = studentRepository.findByMatricula(matricula); 

        if (student == null) {
            System.out.println("Erro: Estudante não encontrado com matrícula: " + matricula);
            return false;
        }

        student.setNome(newNome);
        student.setMatricula(newMatricula);

        if (validationService.validateStudent(student)) {
            studentRepository.save(student);
            return true;
        }
        return false;
    }
}