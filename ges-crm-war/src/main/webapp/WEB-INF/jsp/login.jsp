<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/2001/xhtml">

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="shortcut icon" href="<c:url value="/resources/ico/favicon.png"/>">

	<title>Login</title>

	<!-- Bootstrap core CSS + theme Generali -->
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">
	<!-- Custom styles for this template -->
	<link rel="stylesheet" href="<c:url value="/resources/css/login.css"/>">

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<!--<script src="../../dist/js/html5shiv.js"></script>-->
	<!--<script src="../../dist/js/respond.min.js"></script>-->
	<!--[endif]-->
</head>

<body>

<div class="container login-page">
	<!-- Main component -->
	<div class="panel login-panel">
		<div class="panel-heading">
			<h1 class="panel-title">
				CRM Epargne Salariale
				<span class="version-num">Version 2016.2.1</span>
			</h1>
			<div class="logo"></div>
		</div>
		<div class="panel-body">
			<%-- Messages d'erreur --%>

			<form class="form-horizontal form-lg" action="<c:url value="/perform_login"/>" method="post" autocomplete="off">
				<c:if test="${not empty param.login_error || not empty SPRING_SECURITY_LAST_EXCEPTION}">
					<div class="has-error">
						<p><strong>Echec de la connexion.</strong></p>
						<p>Raison: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" /></p>
					</div>
				</c:if>
				<div class="row">
					<div class="form-group input-group-lg">
						<label for="" class="col-xs-4 control-label input-lg">Identifiant</label>
						<div class="col-xs-8">
							<input type="text" class="form-control input-lg" name="j_username" value="<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>" id="userId" placeholder="Identifiant">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group">
						<label for="" class="col-xs-4 control-label input-lg">Mot de passe</label>
						<div class="col-xs-8">
							<input type="password" class="form-control input-lg" name="j_password" id="userPassword" placeholder="Mot de passe">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group">
						<div class="col-xs-8 col-xs-offset-4 ">
							<input type="submit" value="Connexion" class="btn btn-lg btn-primary" id="submit">

						</div>
					</div>
				</div>
				<%--<div class="row action">--%>
					<%--<div class="col-xs-8 col-xs-offset-4 ">--%>


						<%--<ul class="list-links">--%>
							<%--<li>--%>
								<%--<a href="#">Mot de passe oublié ?</a></li>--%>
						<%--</ul>--%>
					<%--</div>--%>
				<%--</div>--%>
			</form>
		</div>
	</div>
	<div class="panel-warning">
		Le contenu des applications repose sur des documents confidentiels &agrave; usage exclusif des interm&eacute;diaires de GENERALI.
		Toutes informations figurant sur le site notamment financi&egrave;res et/ou fiscales, sont donn&eacute;es &agrave; titre indicatif.
		Ces informations qui ne pr&eacute;tendent pas &agrave; l'exhaustivit&eacute; ne sauraient avoir valeur de conseil, de quelque nature que ce soit, et ne sauraient valoir dispense de l'avis d'un professionnel.
		En toute hypoth&egrave;se ces informations ne sauraient engager la responsabilit&eacute; de GENERALI.
	</div>
</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<%--<script src="../../dist/js/dependencies/jquery-1.10.1.min.js"></script>--%>
<%--<script src="../../dist/js/bootstrap.min.js"></script>--%>
<script src="<c:url value="/resources/js/dependencies/jquery-1.10.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</body>
</html>
