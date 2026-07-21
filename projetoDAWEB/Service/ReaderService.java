package br.edu.ifpb.daweb.herllan.projetoDAWEB.Service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ReaderService {

    private Scanner scanner = new Scanner(System.in);

    public int readInt(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Digite um número: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        return value;
    }

    public String readString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public Long readLong(String message) {
        System.out.print(message);
        while (!scanner.hasNextLong()) {
            System.out.print("Entrada inválida. Digite um número (ID): ");
            scanner.next();
        }
        long value = scanner.nextLong();
        scanner.nextLine(); // Limpa o buffer
        return value;
    }

    public void close() {
        scanner.close();
    }
}