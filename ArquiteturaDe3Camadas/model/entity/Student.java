package ArquiteturaDe3Camadas.model.entity;

public class Student {

    String nome;
    int matricula;
    int idade;
    int turma;

    public Student(String nome, int matricula, int idade, int turma) {
        this.nome = nome;
        this.matricula = matricula;
        this.idade = idade;
        this.turma = turma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String newNome) {
        this.nome = newNome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int newMatricula) {
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
                " nome = " + nome +
                ", matrícula = " + matricula +
                ", idade = " + idade +
                ", turma = " + turma +
                '}';
    }
}