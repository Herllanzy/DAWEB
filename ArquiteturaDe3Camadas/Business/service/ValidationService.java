package ArquiteturaDe3Camadas.Business.service;

public class ValidationService {

    public boolean validateName(String nome){
        return nome != null && !nome.contains("1");
    }
}
