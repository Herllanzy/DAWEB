package ArquiteturaDe3Camadas.model.repository;

import ArquiteturaDe3Camadas.model.entity.Discipline;
import ArquiteturaDe3Camadas.model.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class DisciplineRepository {
    private List<Discipline> disciplines = new ArrayList<>();

    public void save(Discipline discipline) {
        disciplines.add(discipline);
    }

    public List<Discipline> findAll() {
        return disciplines;
    }

    public Discipline findByCode(int codigo) {
        for (Discipline discipline : disciplines) {
            if (discipline.getCodigo() == codigo) {
                return discipline;
            }
        }
        return null;
    }

    public boolean deleteByCode(int codigo) {
        Discipline discipline = findByCode(codigo);
        if (discipline != null) {
            disciplines.remove(discipline);
            return true;
        }
        return false;
    }

    public boolean addStudentToDiscipline(int codigo, Student student) {
        Discipline discipline = findByCode(codigo);
        if (discipline != null && student != null) {
            discipline.addStudent(student);
            return true;
        }
        return false;
    }

    public boolean removeStudentFromDiscipline(int codigo, Student student) {
        Discipline discipline = findByCode(codigo);
        if (discipline != null && student != null) {
            discipline.removeStudent(student);
            return true;
        }
        return false;
    }

    public boolean delete(Discipline discipline) {
        return disciplines.remove(discipline);
    }
}