<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Minha Lista de Clientes</title>
</head>
<body>
	<h1>Lista de CLientes</h1>
	
	<c:if test="${quantidade > 1}">
		<h2>Quantidade encontrada: ${quantidade}</h2>
	</c:if>
	<c:if test="${quantidade >= 4}">
		<h2>Quantidade encontrada maior ou igual a : ${quantidade}</h2>
	</c:if>
	<c:forEach items="${lista}" var="nomeCliente">
		<p> ${nomeCliente} </p>
	</c:forEach>
	
	<h1>Cliente</h1>
	<c:forEach items="${clientes}" var="cliente">
		<p> 
			${cliente.nome} -
			<f:formatDate value="${cliente.dataNascimento}" pattern="dd/MM/yyyy hh:mm"/>
			<f:formatNumber value="${cliente.salario}" type="currency"/> 
		</p> 
	</c:forEach>
</body>
</html> 