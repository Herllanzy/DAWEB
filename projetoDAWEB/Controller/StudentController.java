package br.edu.ifpb.daweb.herllan.projetoDAWEB.Controller;

import br.edu.ifpb.daweb.herllan.projetoDAWEB.Service.ValidationService;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.Service.StudentService;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.DTO.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ValidationService validationService;

    public StudentDTO save(StudentDTO studentDTO) {
        return studentService.save(studentDTO);
    }

    public List<StudentDTO> findAll() {
        return studentService.findAll();
    }

    public Optional<StudentDTO> findById(Long id) {
        return studentService.findById(id);
    }

    public boolean deleteById(Long id) {
        if (id != null) {
            studentService.deleteById(id);
            return true;
        }
        return false;
    }
    
    public boolean update(String matricula, String newNome, String newMatricula) {
        return studentService.update(matricula, newNome, newMatricula);
    }
}