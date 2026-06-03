package ArquiteturaDe3Camadas.presentation;

import ArquiteturaDe3Camadas.Business.service.PrinterService;
import ArquiteturaDe3Camadas.Business.service.ReaderService;
import ArquiteturaDe3Camadas.presentation.controller.DisciplineController;
import ArquiteturaDe3Camadas.presentation.controller.StudentController;

public class Main {

    public static ReaderService readerService = new ReaderService();
    public static PrinterService printerService = new PrinterService();
    public static StudentController studentController = new StudentController();
    public static DisciplineController disciplineController = new DisciplineController();

    public static void main(String [] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int option = readerService.nextInt();
            readerService.nextLine();

            switch (option){
                case 1:
                    createStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    showAllStudents();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    createDiscipline();
                    break;
                case 6:
                    editDiscipline();
                    break;
                case 7:
                    showAllDisciplines();
                    break;
                case 8:
                    deleteDiscipline();
                    break;
                case 9:
                    addStudentToDiscipline();
                    break;
                case 10:
                    showStudentsFromDiscipline();
                    break;
                case 0:
                    running = false;
                    printerService.println("Saindo do sistema...");
                    break;
                default:
                    printerService.println("Opção inválida!");
            }
        }
    }

    private static void showMenu() {
        printerService.println("\n=== SISTEMA DE GESTÃO ESCOLAR ===");
        printerService.println("--- Estudantes ---");
        printerService.println("(1) - Criar estudante");
        printerService.println("(2) - Editar estudante");
        printerService.println("(3) - Listar todos os estudantes");
        printerService.println("(4) - Excluir estudante");
        printerService.println("\n--- Disciplinas ---");
        printerService.println("(5) - Criar disciplina");
        printerService.println("(6) - Editar disciplina");
        printerService.println("(7) - Listar todas as disciplinas");
        printerService.println("(8) - Excluir disciplina");
        printerService.println("\n--- Matrículas ---");
        printerService.println("(9) - Matricular estudante em disciplina");
        printerService.println("(10) - Listar estudantes de uma disciplina");
        printerService.println("\n(0) - Sair");
        printerService.println("Digite sua opção: ");
    }

    private static void createStudent() {
        printerService.println("\n--- Cadastro de Estudante ---");

        printerService.println("Digite seu nome: ");
        String nome = readerService.nextLine();

        printerService.println("Digite sua matrícula: ");
        int matricula = readerService.nextInt();

        printerService.println("Digite sua idade: ");
        int idade = readerService.nextInt();

        printerService.println("Digite sua série: ");
        int turma = readerService.nextInt();

        studentController.create(nome, matricula, idade, turma);
    }

    private static void editStudent() {
        printerService.println("\n--- Edição de Estudante ---");
        showAllStudents();

        printerService.println("Digite a matrícula do estudante que deseja alterar: ");
        int oldMatricula = readerService.nextInt();
        readerService.nextLine();

        printerService.println("Digite o novo nome: ");
        String newName = readerService.nextLine();

        printerService.println("Digite a nova matrícula: ");
        int newMatricula = readerService.nextInt();

        boolean result = studentController.update(oldMatricula, newName, newMatricula);
        if (result){
            printerService.println("Estudante atualizado com sucesso!");
        } else {
            printerService.println("Erro: Estudante não encontrado!");
        }
    }

    private static void showAllStudents(){
        printerService.println("\n--- Lista de Estudantes ---");
        studentController.showAll();
    }

    private static void deleteStudent() {
        printerService.println("\n--- Exclusão de Estudante ---");
        showAllStudents();

        printerService.println("Digite a matrícula do estudante que deseja excluir: ");
        int matricula = readerService.nextInt();

        boolean result = studentController.delete(matricula);
        if (result) {
            printerService.println("Estudante excluído com sucesso!");
        } else {
            printerService.println("Erro: Estudante não encontrado!");
        }
    }
    //case 5
    private static void createDiscipline() {
        printerService.println("\n--- Cadastro de Disciplina ---");

        printerService.println("Digite o código da disciplina: ");
        int codigo = readerService.nextInt();
        readerService.nextLine();

        printerService.println("Digite o nome da disciplina: ");
        String nome = readerService.nextLine();

        printerService.println("Digite o nome do professor: ");
        String professor = readerService.nextLine();

        disciplineController.create(nome, codigo, professor);
    }
    //case 6
    private static void editDiscipline() {
        printerService.println("\n--- Edição de Disciplina ---");
        showAllDisciplines();

        printerService.println("Digite o código da disciplina que deseja alterar: ");
        int oldCodigo = readerService.nextInt();

        printerService.println("Digite o novo código: ");
        int newCodigo = readerService.nextInt();
        readerService.nextLine();

        printerService.println("Digite o novo nome da disciplina: ");
        String newNome = readerService.nextLine();

        printerService.println("Digite o novo nome do professor: ");
        String newProfessor = readerService.nextLine();

        boolean result = disciplineController.update(oldCodigo, newCodigo, newNome, newProfessor);
        if (result) {
            printerService.println("Disciplina atualizada com sucesso!");
        } else {
            printerService.println("Erro: Disciplina não encontrada!");
        }
    }
    //case 7
    private static void showAllDisciplines() {
        printerService.println("\n--- Lista de Disciplinas ---");
        disciplineController.showAll();
    }
    //case 8
    private static void deleteDiscipline() {
        printerService.println("\n--- Exclusão de Disciplina ---");
        showAllDisciplines();

        printerService.println("Digite o código da disciplina que deseja excluir: ");
        int codigo = readerService.nextInt();

        boolean result = disciplineController.delete(codigo);
        if (result) {
            printerService.println("Disciplina excluída com sucesso!");
        } else {
            printerService.println("Erro: Disciplina não encontrada!");
        }
    }
    //case 9
    private static void addStudentToDiscipline() {
        printerService.println("\n--- Matricular Estudante em Disciplina ---");

        showAllStudents();
        printerService.println("Digite a matrícula do estudante: ");
        int matricula = readerService.nextInt();

        var student = studentController.findByRegister(matricula);
        if (student == null) {
            printerService.println("Erro: Estudante não encontrado!");
            return;
        }

        showAllDisciplines();

        printerService.println("Digite o código da disciplina: ");
        int codigo = readerService.nextInt();

        disciplineController.addStudentToDiscipline(codigo, student);
    }
    //case 10
    private static void showStudentsFromDiscipline() {
        printerService.println("\n--- Listar Estudantes por Disciplina ---");
        showAllDisciplines();

        printerService.println("Digite o código da disciplina: ");
        int codigo = readerService.nextInt();
        disciplineController.showStudentsFromDiscipline(codigo);
    }
}