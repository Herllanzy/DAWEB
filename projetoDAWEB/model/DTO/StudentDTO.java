package br.edu.ifpb.daweb.herllan.projetoDAWEB.model.DTO;

import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.entity.Student;

public class StudentDTO {

    private Long id;
    private String nome;
    private String matricula;
    private int idade;
    private int turma;

    public StudentDTO(Long id, String nome, String matricula, int idade, int turma) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.idade = idade;
        this.turma = turma;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public int getTurma() { return turma; }
    public void setTurma(int turma) { this.turma = turma; }


    public static StudentDTO fromEntity(Student student) {
        if (student == null) return null;
        return new StudentDTO(
                student.getId(),
                student.getNome(),
                student.getMatricula(),
                student.getIdade(),
                student.getTurma()
        );
    }

    public Student toEntity() {
        Student student = new Student   (this.nome, this.matricula, this.idade, this.turma);
        student.setId(this.id);
        return student;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", idade=" + idade +
                ", turma=" + turma +
                '}';
    }
}