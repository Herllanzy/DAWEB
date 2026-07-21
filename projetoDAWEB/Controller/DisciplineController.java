package br.edu.ifpb.daweb.herllan.projetoDAWEB.Controller;

import br.edu.ifpb.daweb.herllan.projetoDAWEB.Service.DisciplineService;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.DTO.DisciplineDTO;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.DTO.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    public DisciplineDTO save(DisciplineDTO disciplineDTO) {
        return disciplineService.save(disciplineDTO);
    }

    public List<DisciplineDTO> findAll() {
        return disciplineService.findAll();
    }

    public Optional<DisciplineDTO> findById(Long id) {
        return disciplineService.findById(id);
    }

    public void deleteById(Long id) {
        disciplineService.deleteById(id);
    }

    public DisciplineDTO update(DisciplineDTO disciplineDTO) {
        return disciplineService.update(disciplineDTO);
    }

    public void addStudentToDiscipline(Long disciplineId, StudentDTO studentDTO) {
        disciplineService.addStudentToDiscipline(disciplineId, studentDTO);
    }

    public void removeStudentFromDiscipline(Long disciplineId, StudentDTO studentDTO) {
        disciplineService.removeStudentFromDiscipline(disciplineId, studentDTO);
    }
}