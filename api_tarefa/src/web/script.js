const cadastra = () => {
    tit = document.querySelector('[name="titulo"]')
    desc = document.querySelector('[name="descricao"]')
    pri = document.querySelector('[name="prioridade"]')
    sta = document.querySelector('[name="status"]')
    ini = document.querySelector('[name="ini"]')
    fim = document.querySelector('[name="fim"]')

    dado_json = {
        titulo: tit.value, descricao: desc.value,
        prioridade: parseInt(pri.value),
        status: sta.value, inicio: ini.value, fim: fim.value
    }
    //console.log(dado_json)
    fetch("http://localhost:8080/tarefas", {
        method: "POST",
        body: JSON.stringify(dado_json),
        headers: {"Content-type": "application/json"}
    })
        .then(resp => resp.json())
        .then(data => console.log(data))
}

const consulta = () => {
    var tabela = "<table><tr><td>Titulo<td>Prioridade<td>Status<td>Data inicio</tr>"
    fetch("http://localhost:8080/tarefas")
        .then(resp => resp.json())
        .then(data => {
            data.forEach(element => {
                //console.log(element)
                tabela = tabela + "<tr><td>" + element.titulo
                tabela = tabela + "<td>" + element.prioridade
                tabela = tabela + "<td>" + element.status
                tabela = tabela + "<td>" + element.inicio
            })
            tabela = tabela + "</table>"
            document.querySelector("#tab").innerHTML = tabela
        })

}



botao_insere = document.querySelector("#insere")
botao_insere.addEventListener("click", cadastra)

botao_ve = document.querySelector("#ve")
botao_ve.addEventListener("click", consulta)