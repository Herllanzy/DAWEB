package ArquiteturaDe3Camadas.Business.service;

import ArquiteturaDe3Camadas.Business.DTO.DisciplineDTO;
import ArquiteturaDe3Camadas.Business.DTO.StudentDTO;
import ArquiteturaDe3Camadas.model.entity.Discipline;
import ArquiteturaDe3Camadas.model.entity.Student;
import ArquiteturaDe3Camadas.model.repository.DisciplineRepository;
import ArquiteturaDe3Camadas.model.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DisciplineService {
    private DisciplineRepository disciplineRepository = new DisciplineRepository();
    private StudentRepository studentRepository = new StudentRepository();

    public void create(int codigo, String nomeDisciplina, String professor) {
        Discipline discipline = new Discipline(codigo, nomeDisciplina, professor);
        disciplineRepository.save(discipline);
    }

    public List<DisciplineDTO> findAll() {
        List<Discipline> disciplines = disciplineRepository.findAll();
        return disciplines.stream()
                .map(DisciplineDTO::new)
                .collect(Collectors.toList());
    }

    public boolean update(int oldCodigo, int newCodigo, String newNome, String newProfessor) {
        Discipline discipline = disciplineRepository.findByCode(oldCodigo);
        if (discipline != null) {
            discipline.setCodigo(newCodigo);
            discipline.setNomeDisciplina(newNome);
            discipline.setProfessor(newProfessor);
            return true;
        }
        return false;
    }

    public boolean addStudentToDiscipline(int codigoDisciplina, StudentDTO studentDTO) {
        if (studentDTO == null) {
            return false;
        }

        // Buscar o estudante real no repositório
        Student student = studentRepository.findByRegister(studentDTO.getMatricula());
        if (student == null) {
            return false;
        }

        return disciplineRepository.addStudentToDiscipline(codigoDisciplina, student);
    }

    public DisciplineDTO findDisciplineByCode(int codigo) {
        Discipline discipline = disciplineRepository.findByCode(codigo);
        if (discipline != null) {
            return new DisciplineDTO(discipline);
        }
        return null;
    }

    public List<StudentDTO> getStudentsFromDiscipline(int codigo) {
        Discipline discipline = disciplineRepository.findByCode(codigo);
        if (discipline != null) {
            return discipline.getStudents().stream()
                    .map(s -> new StudentDTO(s.getNome(), s.getMatricula(), s.getIdade(), s.getTurma()))
                    .collect(Collectors.toList());
        }
        return null;
    }

    public boolean delete(int codigo) {
        Discipline discipline = disciplineRepository.findByCode(codigo);
        if (discipline != null) {
            return disciplineRepository.delete(discipline);
        }
        return false;
    }
}