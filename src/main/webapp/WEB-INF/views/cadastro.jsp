<%@page import="java.util.ArrayList"%>
<%@page import="br.com.model.Aluno"%>
<%@page import="java.util.List"%>
<%@ page isELIgnored ="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Cadastro de Alunos</title>
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
	
	<form:errors path="aluno.matricula"></form:errors>
	<form:errors path="aluno.rg"></form:errors>
	<form:errors path="aluno.cpf"></form:errors>
	
	<div class="container">
		<div class="panel panel-primary ">
			<div class="panel-heading text-center">
				<h1>Aluno faça já seu cadastro!</h1>
			</div>					
			<form class="form-cadastro" action="cadastrar" method="post">
				<div class="row">
					<c:if test="${msg.cadastrado }">
						<div class="alert alert-success" role="alert">
							<div class="glyphicon glyphicon-ok"></div>
							<strong>  Cadastro realizado com sucesso!</strong>
						</div>
					</c:if>
					<c:if test="${msg.excluido}">
						<div class="alert alert-success" role="alert">
							<div class="glyphicon glyphicon-ok"></div>
							<strong>  Cadastro Excluido com sucesso!</strong>
						</div>
					</c:if>
					<c:if test="${msg.alterado }">
						<div class="alert alert-success" role="alert">
							<div class="glyphicon glyphicon-ok"></div>
							<strong>  Cadastro Alterado com sucesso!</strong>
						</div>
					</c:if>
					
					<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
						<input name="matricula" class="form-control" type="text" placeholder="Matricula"/>
					</div>
					
					<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
						<input name="nome" class="form-control" type="text" placeholder="Nome"/>
					</div>
					
					<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
						<input name="rg" class="form-control" type="text" placeholder="RG"/>
					</div>
					
					<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
						<input name="cpf" class="form-control" type="text" placeholder="CPF"/>
					</div>
					
					<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
						<input name="dataNascimento" class="form-control" type="date" placeholder="Data de Nascimento"/>
					</div>
					
					<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
						<button class="form-control text-center glyphicon glyphicon-floppy-disk btn btn-success" type="submit">
							Cadastrar
						</button>
					</div>
				</div>
			</form>
		</div>
	
		<c:if test="${msg.existeRegistro }">
		<h3>Lista de Alunos Cadstrados</h3>
			<table class="table table-bordered table-responsive col-sm-12 col-md-12 col-lg-12 col-xl-12">
				<tr>
					<th>Matricula</th>
					<th>Nome</th>
					<th>RG</th>
					<th>CPF</th>
					<th>Data de nascimento</th>
					<th></th>
				</tr>
				<c:forEach items="${alunos }" var="aluno">
					<tr>
						<td>${aluno.matricula }</td>
						<td>${aluno.nome }</td>
						<td>${aluno.rg }</td>
						<td>${aluno.cpf }</td>
						<td>${aluno.dataNascimento }</td>
						<td>
							<a href="deletar?matricula=${aluno.matricula }">
								<span class="glyphicon glyphicon-trash"></span>
							</a>
						</td>
					</tr>
				
				</c:forEach>
				<tr>						
			</table>			
		</c:if>					
	</div>
</body>
</html>