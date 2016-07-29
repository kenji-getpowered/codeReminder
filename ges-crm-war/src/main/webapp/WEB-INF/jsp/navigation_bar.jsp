<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:useBean id="gesUser"  scope="session" type="fr.generali.gef2.to.IUserTOV2"/>

<!-- Static navbar -->
<div class="navbar navbar-primary navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="glyphicon glyph-lg"></span>
            </button>
            <span class="logo"></span>
            <span class="navbar-brand application-heading">GES - CRM</span>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<c:url value="/index"/>"><span class="glyphicon glyphicon-home"></span> Accueil</a></li>
                <li><a href="<c:url value="/assure"/>"><span class="glyphicon glyphicon-home"></span> Espace assur&eacute;</a></li>
                <li><a href="<c:url value="/entreprise"/>"><span class="glyphicon glyphicon-home"></span> Espace entreprise</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <span class="navbar-text"><sec:authorize access="isAuthenticated()">Bonjour <c:out value="${gesUser.fullName}"/></sec:authorize></span>
                <li class="btn-quitter"><a href="<c:url value="/logout"/>">Se d&eacute;connecter <span class="glyphicon glyphicon-cross"></span> </a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>