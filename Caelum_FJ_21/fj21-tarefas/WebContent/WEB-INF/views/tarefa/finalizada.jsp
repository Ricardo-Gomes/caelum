<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Finalizada</title>
</head>
<body>
	<td>${tarefa.id}</td>
	<td>${tarefa.descricao}</td>
	<td>Finalizada</td>
	<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}"
			pattern="dd/MM/yyyy" /></td>
	<td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
	<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
</body>
</html>