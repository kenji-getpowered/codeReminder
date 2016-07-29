<!DOCTYPE html>
<html>


<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<%--<html xmlns="http://www.w3.org/2001/xhtml">--%>

<%--<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>--%>
<%--<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="<c:url value="/resources/ico/favicon.png"/>">

    <title>GES - CRM</title>

    <!-- Bootstrap core CSS + theme Generali -->

    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/components/tablesorter/tablesorter.css"/>" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]-->
    <!--<script src="../../dist/js/html5shiv.js"></script>-->
    <!--<script src="../../dist/js/respond.min.js"></script>-->
    <!--[endif]-->
</head>

<body>


<jsp:include page="navigation_bar.jsp"></jsp:include>

<div class="container">
    <div class="page">
        <div class="page-header">
            <h1 id="main-nav">Gestion des assur&eacute;s</h1>
        </div>

        <%-- Basic search form --%>
        <%--<%@include file="recherche_assure.jsp" %>--%>
        <%@include file="recherche_assure.jsp" %>

        <%-- // Pagination --%>
        <jsp:useBean id="pagedListHolder" scope="request" type="org.springframework.beans.support.PagedListHolder"/>

        <%@include file="pager.jsp" %>


        <div class="panel panel-inverse">
            <div class="panel-heading">
                <h2 class="panel-title">Assur&eacute;s</h2>
            </div>
            <div class="panel-body form-horizontal">

                <table class="tablesorter table" id="simpletablesorter">
                    <thead>
                    <tr>
                        <th>Identifiant </th>
                        <th>Creelia</th>
                        <th>Civilit&eacute;</th>
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>Reseau</th>
                        <th>Id Reseau</th>
                        <th>Nom Entreprise</th>
                        <th>Produit</th>
                        <th>CodePostal</th>
                        <th>Ville</th>
                        <th>TotalAvoirs</th>
                        <th>Code Agent</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <c:forEach items="${pagedListHolder.pageList}" var="assure">
                        <tr>
                            <td>${assure.identifiant} </td>
                            <td>${assure.identifiantCreelia}</td>
                            <td>${assure.idCivilite}</td>
                            <td>${assure.nom}</td>
                            <td>${assure.prenom}</td>
                            <td>${assure.reseau}</td>
                            <td>${assure.idReseau}</td>
                            <td>${assure.nomEntrepise}</td>
                            <td>${assure.prod_abrev}</td>
                            <td>${assure.cindCodePostal}</td>
                            <td>${assure.cindVille}</td>
                            <td>${assure.montantTotalAvoirs}</td>
                            <td>${assure.codeAgent}</td>
                            <td>
                                <a href="<c:url value="/assure/get?id_util=${assure.identifiant}"/>"><span style="color:blue" class="glyphicon glyphicon-info" title="Infos"></span></a>
                                <a href="<c:url value="/loginCRM?identifiant=${assure.identifiant}&id_reseau=${assure.idReseau}"/>" target="_blank"><span style="color:green" class="glyphicon glyphicon-log-in" title="Espace Perso"></span></a>
                                <a href="<c:url value="/assure/resetmdp?id_util=${assure.identifiant}"/>"><span style="color:red" class="glyphicon glyphicon-reset" title="Reset Mdp"></span></a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

            </div>
        </div>

        <%@include file="pager.jsp" %>
    </div>

    </div>
        <!-- Bootstrap core JavaScript
   ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <%--<script src="../../dist/js/dependencies/jquery-1.10.1.min.js"></script>--%>
        <%--<script src="../../dist/js/bootstrap.js"></script>--%>
        <script src="<c:url value="/resources/js/dependencies/jquery-1.10.1.min.js"/>"></script>
        <script src="<c:url value="/resources/js//bootstrap.js"/>"></script>
        <script src="<c:url value="/resources/js/components/tablesorter/tablesorter.js"/>"></script>
        <%--<script>--%>
            <%--// add tab--%>
            <%--$('#addTab').click(function(){--%>
                <%--var i= $('.nav-tabs li').length + 1;--%>
                <%--var id = $('#tabId').val() ? $('#tabId').val() + i : "tabid" + i;--%>
                <%--var label = $('#tabLabel').val();--%>
                <%--var content = $('#tabContent').val();--%>
                <%--$(document).addTab({"id": id, "label": label, "content": content, "tabWrapper" : "#maintabs", "contentWrapper": "#maintabcontent" });--%>
            <%--});--%>

            <%--// get add event--%>
            <%--$(document).on('added.bs.tab', function(e){--%>
                <%--console.log('add tab event' + e.target)--%>
            <%--});--%>

            <%--// get close/remove tab event--%>
            <%--$(document).on('remove.bs.tab', function(e){--%>
                <%--console.log('close tab event' + e.target)--%>
            <%--});--%>

        <%--</script>--%>

</body>
</html>
