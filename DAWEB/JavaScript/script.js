function validarCadastro() {
   
    var confirmacao = confirm("Deseja realmente salvar os dados desta disciplina?");
    
    
    if (confirmacao) {
        alert("Disciplina salva com sucesso!");
        return true;
    } else {
        alert("Cadastro cancelado.");
        return false;
    }
}


function avaliarMeta() {
    
    var horas = prompt("Quantas horas por semana você pretende dedicar às disciplinas?");
    
  
    if (horas === null || horas === "") {
        alert("Por favor, digite um valor válido.");
        return;
    }
    
    
    var horasInt = parseInt(horas);
    

    if (isNaN(horasInt)) {
        alert("Por favor, digite um número válido.");
        return;
    }
    
    
    if (horasInt >= 10) {
        alert("Excelente meta! Você terá um ótimo rendimento.");
    } else {
        alert("Cuidado! Pode ser necessário dedicar mais tempo aos estudos.");
    }
}

function validarCadastroEstudante() {
    var confirmacao = confirm("Deseja realmente salvar os dados deste estudante?");
    
    if (confirmacao) {
        alert("Estudante salvo com sucesso!");
        return true;
    } else {
        alert("Cadastro cancelado.");
        return false;
    }
}