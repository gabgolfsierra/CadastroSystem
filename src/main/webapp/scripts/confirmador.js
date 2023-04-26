

function confirmar(idcon){
	 let resposta = confirm("Confirma a ação de excluir?")
	 if (resposta === true){
		 window.location.href="delete?idcon" + idcon
	 }
}