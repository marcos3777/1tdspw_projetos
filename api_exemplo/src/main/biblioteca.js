fetch('http://localhost:8080/resource/times')
  .then(response => response.json())
  .then(data => {
    tabela = "<table>"

    for(i=0; i < data.length; i++) {
        tabela = tabela + "<tr>"
        tabela = tabela + "<td>" + data[i].nome
        tabela = tabela + "<td>" + data[i].pontos
        tabela = tabela + "<td>" + data[i].saldoGols
        tabela = tabela + "<td>" + data[i].aproveitamento

        //console.log(data[i])
    }
    tabela = tabela + "</table>"
    div = document.querySelector("#tab")
    div.innerHTML = tabela
  })
  .catch(error => {
    console.error('Erro na requisição:', error);
  });