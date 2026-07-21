package br.edu.ifpb.daweb.herllan.projetoDAWEB.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String matricula;
    private int idade;
    private int turma;

    public Student() {
    }

    public Student(String nome, String matricula, int idade, int turma) {
        this.nome = nome;
        this.matricula = matricula;
        this.idade = idade;
        this.turma = turma;
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String newNome) {
        this.nome = newNome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String newMatricula) {
        this.matricula = newMatricula;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int newIdade) {
        this.idade = newIdade;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int newTurma) {
        this.turma = newTurma;
    }

    @Override
    public String toString() {
        return "Estudante {" +
                " id=" + id +
                ", nome='" + nome + '\'' +
                ", matrícula='" + matricula + '\'' +
                ", idade=" + idade +
                ", turma=" + turma +
                '}';
    }
}