<%@ page isELIgnored ="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Home</title>
	
	<!-- jquery -->
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"
 	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
	
	<!-- mobile first -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>		
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/folha.css" />">
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
			  <li role="presentation" class="active"><a href="home">Home</a></li>
			  <li role="presentation"><a href="gestao-alunos">Administrar Alunos</a></li>
			  <li role="presentation"><a href="#">Messages</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${sessionScope.nome }<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="sair"><span class="glyphicon glyphicon-log-out"></span> Sair</a></li>
		          </ul>
        		</li>
	    	</ul>
    	</div>
	</nav>
	<div class="container-fluid bg-1 text-center">
		<h3><strong>Site institucional</strong></h3>
		<img src="<c:url value="/resources/home.jpg" />" class="img-circle" alt="Bird">
		<h3>Faculdade XPTO</h3>
	</div>
	
	<div class="container-fluid bg-2 text-center">
		<h3>Conceituada no mercado</h3>
		<p>N°1 no mec</p>
	</div>
	
	<div class="container-fluid bg-3 text-center">
		<h3>Aqui você encontra</h3>
		<p>varios cursos bons</p>
	</div>	
</body>
</html>