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
		
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login.css" />">
	</head>
	<body class=" bg-5">
	
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
				  <li role="presentation"><a href="home">Home</a></li>
				  <li role="presentation" ><a href="gestao-alunos">Administrar Alunos</a></li>
				  <li role="presentation"><a href="#">Messages</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right active">
			      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		    	</ul>
	    	</div>
		</nav>
		<div class="container">
			<div class=" text-center panel panel-info bg-4 ">
				<div class="panel text-left panel-heading cabecalho">
					<div>
						<h3><strong>Login</strong></h3>
					</div>
				</div>
  				<div class="panel-body">
					<form class="form-horizontal" action="logar" method="post">					
						<div class="row text-center">
							<c:if test="${erro}">
								<div class="alert alert-danger" role="alert">
									<div class="glyphicon glyphicon-remove"></div>
									<strong>  login ou senha incorretos!</strong>
								</div>
							</c:if>
							<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
								<div class="input-group">
								  <span class="input-group-addon" id="basic-addon1"><a href="#" class="glyphicon glyphicon-user"></a></span>
	   							  <input class="form-control" type="text" name="login" placeholder="Usuario" >
								</div>
							</div>
							<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
								<div class="input-group">
								  <span class="input-group-addon" id="basic-addon1"><a href="#" class="glyphicon glyphicon-lock"></a></span>
								  <input class="form-control" type="password" name="senha" placeholder="senha">
								</div>
							</div>
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6 col-xl-6">
							<a class="form-control btn btn-info glyphicon glyphicon-log-in" href="cadastrar-usuario">   Cadastrar-se</a>
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6 col-xl-6">
							<button class="form-control btn btn-success glyphicon glyphicon-log-in" type="submit"> Entrar</button>
						</div>
					</form>
  				</div>
			</div>
		</div>
	</body>
</html>