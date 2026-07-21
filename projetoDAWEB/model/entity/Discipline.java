package br.edu.ifpb.daweb.herllan.projetoDAWEB.model.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int codigo;
    private String nomeDisciplina;
    private String professor;

    @OneToMany
    private List<Student> students;

    public Discipline() {
        this.students = new ArrayList<>();
    }

    public Discipline(int codigo, String nomeDisciplina, String professor) {
        this.codigo = codigo;
        this.nomeDisciplina = nomeDisciplina;
        this.professor = professor;
        this.students = new ArrayList<>();
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNomeDisciplina() { return nomeDisciplina; }
    public void setNomeDisciplina(String nomeDisciplina) { this.nomeDisciplina = nomeDisciplina; }

    public String getProfessor() { return professor; }
    public void setProfessor(String professor) { this.professor = professor; }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }

    public void addStudent(Student student) {
        if (student != null && !students.contains(student)) {
            students.add(student);
        }
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    @Override
    public String toString() {
        return "Disciplina {" +
                " id=" + id +
                ", código=" + codigo +
                ", nome='" + nomeDisciplina + '\'' +
                ", professor='" + professor + '\'' +
                ", total de alunos=" + students.size() +
                '}';
    }
}