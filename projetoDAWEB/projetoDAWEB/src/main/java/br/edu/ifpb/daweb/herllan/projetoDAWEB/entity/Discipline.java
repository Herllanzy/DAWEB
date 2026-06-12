package br.edu.ifpb.daweb.herllan.projetoDAWEB.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private int codigo;
    private String nomeDisciplina;
    private String professor;

    @OneToMany
    private List<Student> students;

    public Discipline(int codigo, String nomeDisciplina, String professor) {
        this.codigo = codigo;
        this.nomeDisciplina = nomeDisciplina;
        this.professor = professor;
        this.students = new ArrayList<>();
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

    public void setCodigo(int novoCodigo) {
        this.codigo = novoCodigo;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String novoNomeDisciplina) {
        this.nomeDisciplina = novoNomeDisciplina;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String novoProfessor) {
        this.professor = novoProfessor;
    }

    public List<Student> getStudents() {
        return students;
    }

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
                "código = " + codigo +
                ", nome = " + nomeDisciplina +
                ", professor = " + professor +
                ", total de alunos = " + students.size() +
                '}';
    }
}
