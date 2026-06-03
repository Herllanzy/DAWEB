package ArquiteturaDe3Camadas.Business.service;

import java.util.Scanner;

public class ReaderService {

    private Scanner scanner = new Scanner(System.in);

    public String nextLine(){
        return scanner.nextLine();
    }

    public int nextInt(){
        return scanner.nextInt();
    }
}