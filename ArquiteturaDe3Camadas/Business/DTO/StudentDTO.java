package ArquiteturaDe3Camadas.Business.DTO;

public class StudentDTO {

    private String nome;
    private int matricula;
    private int idade;
    private int turma;

    public StudentDTO(String nome, int matricula, int idade, int turma) {
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

}
