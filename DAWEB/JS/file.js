function feedback() {

    var nome = document.querySelector('input[placeholder="Digite seu nome:"]').value;
    var matricula = document.querySelector('input[placeholder="Digite sua matrícula:"]').value;
    
    nome = nome.trim();
    matricula = matricula.trim();
    
    if (nome !== "" && matricula !== "") {
        alert("Salvo com sucesso!");
        
    } else {
        
        if (nome === "" && matricula === "") {
            alert("Por favor, preencha o nome e a matrícula!");
        } else if (nome === "") {
            alert("Por favor, preencha o campo Nome!");
        } else if (matricula === "") {
            alert("Por favor, preencha o campo Matrícula!");
        }
    }
}