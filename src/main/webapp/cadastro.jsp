<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>

<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("atletas");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>CBLB Cadastro</title>
<link rel="icon" href="imagens/plates.png">
<link rel="stylesheet" href="style.css">

<style>
body {
	background-image: linear-gradient(to left, #1b1e23, #1e2229, #21252d, #272c36, #2c313c);
	text-align: center;
}

h1 {
	text-align: center;
	color: #fff;
}
</style>


</head>
<body>
	<h1>CADASTRO DE ATLETAS</h1>
	<a href="novo.html" class="Botao1">Novo Atleta</a>
	<table id ="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Categoria</th>
				<th>Total</th>
				<td>Opções</td>
			</tr>
		</thead>
		<tbody>
			<% for (int i = 0; i < lista.size(); i++){ %>
				<tr>
					<td><%=lista.get(i).getIdcon()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getCategoria()%></td>
					<td><%=lista.get(i).getTotal()%></td>
					<td><a href="select?idcon<%=lista.get(i).getIdcon() %>" class = "Botao1">Editar</a></td>
					<td><a href="javascript: confirmar(<%=lista.get(i).getIdcon() %>)" class = "Botao2">Excluir</a></td>
				</tr>
			<% } %>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>


</body>
</html>