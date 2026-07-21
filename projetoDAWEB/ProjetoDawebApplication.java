package br.edu.ifpb.daweb.herllan.projetoDAWEB;

import br.edu.ifpb.daweb.herllan.projetoDAWEB.Controller.DisciplineController;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.Controller.StudentController;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.Service.PrinterService;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.Service.ReaderService;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.DTO.DisciplineDTO;
import br.edu.ifpb.daweb.herllan.projetoDAWEB.model.DTO.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class ProjetoDawebApplication implements CommandLineRunner {

	@Autowired
	private StudentController studentController;

	@Autowired
	private DisciplineController disciplineController;

	@Autowired
	private PrinterService printerService;

	@Autowired
	private ReaderService readerService;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDawebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int option;
		do {
			printerService.printMenu();
			option = readerService.readInt("");

			switch (option) {
				case 1 -> cadastrarEstudante();
				case 2 -> printerService.printAllStudents(studentController.findAll());
				case 3 -> buscarEstudantePorId();
				case 4 -> atualizarEstudante();
				case 5 -> deletarEstudante();
				case 6 -> cadastrarDisciplina();
				case 7 -> printerService.printAllDisciplines(disciplineController.findAll());
				case 8 -> buscarDisciplinaPorId();
				case 9 -> atualizarDisciplina();
				case 10 -> deletarDisciplina();
				case 11 -> adicionarAlunoADisciplina();
				case 12 -> removerAlunoDeDisciplina();
				case 0 -> System.out.println("Saindo do sistema...");
				default -> System.out.println("Opção inválida!");
			}
		} while (option != 0);

		readerService.close();
	}

	private void cadastrarEstudante() {
		String nome = readerService.readString("Nome: ");
		String matricula = readerService.readString("Matrícula: ");
		int idade = readerService.readInt("Idade: ");
		int turma = readerService.readInt("Turma: ");

		StudentDTO studentDTO = new StudentDTO(null, nome, matricula, idade, turma);
		StudentDTO saved = studentController.save(studentDTO);

		if (saved != null) {
			System.out.println("Estudante cadastrado com sucesso! ID: " + saved.getId());
		}
	}

	private void buscarEstudantePorId() {
		Long id = readerService.readLong("ID do estudante: ");
		Optional<StudentDTO> student = studentController.findById(id);
		student.ifPresentOrElse(
				printerService::printStudent,
				() -> System.out.println("Estudante não encontrado.")
		);
	}

	private void atualizarEstudante() {

		printerService.printAllStudents(studentController.findAll());

		String matricula = readerService.readString("Matrícula do estudante a atualizar: ");

		Optional<StudentDTO> studentOpt = studentController.findAll()
				.stream()
				.filter(s -> s.getMatricula().equals(matricula))
				.findFirst();

		if (studentOpt.isPresent()) {
			StudentDTO student = studentOpt.get();
			System.out.println("Dados atuais: " + student);

			String newNome = readerService.readString("Novo nome (ou Enter para manter): ");
			if (newNome.trim().isEmpty()) {
				newNome = student.getNome();
			}

			String newMatricula = readerService.readString("Nova matrícula (ou Enter para manter): ");
			if (newMatricula.trim().isEmpty()) {
				newMatricula = student.getMatricula();
			}

			boolean result = studentController.update(matricula, newNome, newMatricula);

			if (result) {
				System.out.println("Estudante atualizado com sucesso!");
			} else {
				System.out.println("Erro ao atualizar estudante.");
			}
		} else {
			System.out.println("Estudante não encontrado com matrícula: " + matricula);
		}
	}

	private void deletarEstudante() {
		Long id = readerService.readLong("ID do estudante a deletar: ");
		studentController.deleteById(id);
		System.out.println("Estudante deletado (se existia).");
	}

	private void cadastrarDisciplina() {
		int codigo = readerService.readInt("Código: ");
		String nome = readerService.readString("Nome da disciplina: ");
		String professor = readerService.readString("Professor: ");

		System.out.println("DEBUG - Código: " + codigo);
		System.out.println("DEBUG - Nome: " + nome);
		System.out.println("DEBUG - Professor: " + professor);

		DisciplineDTO disciplineDTO = new DisciplineDTO(null, codigo, nome, professor, null, 0);
		DisciplineDTO saved = disciplineController.save(disciplineDTO);

		if (saved != null) {
			System.out.println("Disciplina cadastrada com sucesso! ID: " + saved.getId());
			System.out.println("DEBUG - Dados salvos: " + saved);
		} else {
			System.out.println("Erro ao cadastrar disciplina!");
		}
	}

	private void buscarDisciplinaPorId() {
		Long id = readerService.readLong("ID da disciplina: ");
		Optional<DisciplineDTO> discipline = disciplineController.findById(id);
		discipline.ifPresentOrElse(
				printerService::printDiscipline,
				() -> System.out.println("Disciplina não encontrada.")
		);
	}

	private void atualizarDisciplina() {
		Long id = readerService.readLong("ID da disciplina a atualizar: ");
		Optional<DisciplineDTO> disciplineOpt = disciplineController.findById(id);

		if (disciplineOpt.isPresent()) {
			DisciplineDTO discipline = disciplineOpt.get();
			System.out.println("Dados atuais: " + discipline);

			int codigo = readerService.readInt("Novo código (ou 0 para manter): ");
			if (codigo > 0) discipline.setCodigo(codigo);

			String nome = readerService.readString("Novo nome (ou Enter para manter): ");
			if (!nome.trim().isEmpty()) discipline.setNomeDisciplina(nome);

			String professor = readerService.readString("Novo professor (ou Enter para manter): ");
			if (!professor.trim().isEmpty()) discipline.setProfessor(professor);

			disciplineController.update(discipline);
			System.out.println("Disciplina atualizada!");
		} else {
			System.out.println("Disciplina não encontrada.");
		}
	}

	private void deletarDisciplina() {
		Long id = readerService.readLong("ID da disciplina a deletar: ");
		disciplineController.deleteById(id);
		System.out.println("Disciplina deletada (se existia).");
	}

	private void adicionarAlunoADisciplina() {
		Long disciplineId = readerService.readLong("ID da disciplina: ");
		Long studentId = readerService.readLong("ID do aluno: ");

		Optional<StudentDTO> studentOpt = studentController.findById(studentId);
		if (studentOpt.isPresent()) {
			disciplineController.addStudentToDiscipline(disciplineId, studentOpt.get());
		} else {
			System.out.println("Aluno não encontrado.");
		}
	}

	private void removerAlunoDeDisciplina() {
		Long disciplineId = readerService.readLong("ID da disciplina: ");
		Long studentId = readerService.readLong("ID do aluno: ");

		Optional<StudentDTO> studentOpt = studentController.findById(studentId);
		if (studentOpt.isPresent()) {
			disciplineController.removeStudentFromDiscipline(disciplineId, studentOpt.get());
		} else {
			System.out.println("Aluno não encontrado.");
		}
	}
}