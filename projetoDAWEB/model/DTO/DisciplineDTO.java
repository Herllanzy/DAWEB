package br.edu.ifpb.daweb.herllan.projetoDAWEB.model.DTO;

import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.DTO.StudentDTO;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.entity.Discipline;
import java.util.List;
import java.util.stream.Collectors;

public class DisciplineDTO {

    private Long id;
    private int codigo;
    private String nomeDisciplina;
    private String professor;
    private List<StudentDTO> students;
    private int totalAlunos;

    public DisciplineDTO(Long id, int codigo, String nomeDisciplina, String professor,
                         List<StudentDTO> students, int totalAlunos) {
        this.id = id;
        this.codigo = codigo;
        this.nomeDisciplina = nomeDisciplina;
        this.professor = professor;
        this.students = students;
        this.totalAlunos = totalAlunos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getTotalAlunos() {
        return totalAlunos;
    }

    public void setTotalAlunos(int totalAlunos) {
        this.totalAlunos = totalAlunos;
    }

    public Discipline toEntity() {
        Discipline discipline = new Discipline(
                this.codigo,
                this.nomeDisciplina,
                this.professor
        );
        discipline.setId(this.id);
        return discipline;
    }

    public static DisciplineDTO fromEntity(Discipline discipline) {
        if (discipline == null) {
            return null;
        }

        List<StudentDTO> studentDTOs = discipline.getStudents()
                .stream()
                .map(StudentDTO::fromEntity)
                .collect(Collectors.toList());

        return new DisciplineDTO(
                discipline.getId(),
                discipline.getCodigo(),
                discipline.getNomeDisciplina(),
                discipline.getProfessor(),
                studentDTOs,
                discipline.getStudents().size()
        );
    }

    @Override
    public String toString() {
        return "DisciplineDTO{" +
                "id=" + id +
                ", codigo=" + codigo +
                ", nomeDisciplina='" + nomeDisciplina + '\'' +
                ", professor='" + professor + '\'' +
                ", totalAlunos=" + totalAlunos +
                '}';
    }
}