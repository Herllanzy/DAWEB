package br.edu.ifpb.daweb.herllan.projetoDAWEB.Service;

import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.DTO.DisciplineDTO;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.DTO.StudentDTO;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.entity.Discipline;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.entity.Student;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.repository.DisciplineRepository;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional 
    public DisciplineDTO save(DisciplineDTO disciplineDTO) {
        Discipline discipline = disciplineDTO.toEntity();
        if (validationService.validateDiscipline(discipline)) {
            Discipline saved = disciplineRepository.save(discipline);
            return DisciplineDTO.fromEntity(saved);
        }
        return null;
    }

    @Transactional(readOnly = true)
    public List<DisciplineDTO> findAll() {
        return disciplineRepository.findAll()
                .stream()
                .map(DisciplineDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<DisciplineDTO> findById(Long id) {
        return disciplineRepository.findById(id)
                .map(DisciplineDTO::fromEntity);
    }

    @Transactional
    public void deleteById(Long id) {
        if (disciplineRepository.existsById(id)) {
            disciplineRepository.deleteById(id);
        } else {
            System.out.println("Erro: Disciplina com ID " + id + " não encontrada.");
        }
    }

    @Transactional
    public DisciplineDTO update(DisciplineDTO disciplineDTO) {
        if (disciplineDTO.getId() == null || !disciplineRepository.existsById(disciplineDTO.getId())) {
            System.out.println("Erro: Disciplina não encontrada para atualização.");
            return null;
        }

        Discipline discipline = disciplineDTO.toEntity();
        discipline.setId(disciplineDTO.getId());

        if (validationService.validateDiscipline(discipline)) {
            Discipline updated = disciplineRepository.save(discipline);
            return DisciplineDTO.fromEntity(updated);
        }
        return null;
    }

    @Transactional
    public void addStudentToDiscipline(Long disciplineId, StudentDTO studentDTO) {
        Optional<Discipline> disciplineOpt = disciplineRepository.findById(disciplineId);
        if (disciplineOpt.isPresent()) {
            Discipline discipline = disciplineOpt.get();
            if (studentDTO != null && studentDTO.getId() != null) {
                Optional<Student> studentOpt = studentRepository.findById(studentDTO.getId());
                if (studentOpt.isPresent()) {
                    discipline.addStudent(studentOpt.get());
                    disciplineRepository.save(discipline);
                    System.out.println("Aluno adicionado à disciplina com sucesso.");
                } else {
                    System.out.println("Erro: Aluno não encontrado.");
                }
            } else {
                System.out.println("Erro: Aluno inválido.");
            }
        } else {
            System.out.println("Erro: Disciplina não encontrada.");
        }
    }

    @Transactional
    public void removeStudentFromDiscipline(Long disciplineId, StudentDTO studentDTO) {
        Optional<Discipline> disciplineOpt = disciplineRepository.findById(disciplineId);
        if (disciplineOpt.isPresent()) {
            Discipline discipline = disciplineOpt.get();
            if (studentDTO != null && studentDTO.getId() != null) {
                Optional<Student> studentOpt = studentRepository.findById(studentDTO.getId());
                if (studentOpt.isPresent()) {
                    discipline.removeStudent(studentOpt.get());
                    disciplineRepository.save(discipline);
                    System.out.println("Aluno removido da disciplina com sucesso.");
                } else {
                    System.out.println("Erro: Aluno não encontrado.");
                }
            } else {
                System.out.println("Erro: Aluno inválido.");
            }
        } else {
            System.out.println("Erro: Disciplina não encontrada.");
        }
    }
}