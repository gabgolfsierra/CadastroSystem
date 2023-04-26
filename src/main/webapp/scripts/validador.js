

function validar() {
  
  let nome = document.getElementsByName('nome')[0].value
  let categoria = document.getElementsByName('categoria')[0].value
  let total = document.getElementsByName('total')[0].value

  if (nome === "") {
    alert('Preencha o campo Nome.')
    document.getElementsByName('nome')[0].focus()
    return false
  }
  else if (categoria === "") {
    alert("Preencha o campo Categoria")
    document.getElementsByName('categoria')[0].focus()
    return false
  }
  else if (total === "") {
    alert("Preencha o campo Total")
    document.getElementsByName('total')[0].focus()
    return false
  }
  else if (nome !== "" && categoria !== "" && total !== "") {
    // todos os campos estão preenchidos, submeter o formulário
    document.forms["frmAtletas"].submit()
    return false
  }
}