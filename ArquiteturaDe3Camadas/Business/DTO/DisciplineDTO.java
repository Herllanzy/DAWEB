package ArquiteturaDe3Camadas.Business.DTO;

import ArquiteturaDe3Camadas.model.entity.Discipline;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DisciplineDTO {
    private int codigo;
    private String nomeDisciplina;
    private String professor;
    private List<StudentDTO> students;

    public DisciplineDTO() {
        this.students = new ArrayList<>();
    }

    public DisciplineDTO(int codigo, String nomeDisciplina, String professor) {
        this.codigo = codigo;
        this.nomeDisciplina = nomeDisciplina;
        this.professor = professor;
        this.students = new ArrayList<>();
    }

    public DisciplineDTO(Discipline discipline) {
        this.codigo = discipline.getCodigo();
        this.nomeDisciplina = discipline.getNomeDisciplina();
        this.professor = discipline.getProfessor();
        this.students = discipline.getStudents().stream()
                .map(s -> new StudentDTO(s.getNome(), s.getMatricula(), s.getIdade(), s.getTurma()))
                .collect(Collectors.toList());
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }

    public Discipline toEntity() {
        Discipline discipline = new Discipline(this.codigo, this.nomeDisciplina, this.professor);
        return discipline;
    }


}