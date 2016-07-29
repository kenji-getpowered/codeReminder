<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
    <%--<meta charset="utf-8">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="author" content="">--%>
    <%--<link rel="shortcut icon" href="/resources/ico/favicon.png">--%>

    <%--<title>Inactive state and form errors feedback</title>--%>

    <%--<!-- Bootstrap core CSS + theme Generali -->--%>
    <%--<link href="/resources/css/bootstrap.css" rel="stylesheet">--%>

    <%--<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->--%>
    <%--<!--[if lt IE 9]>--%>
    <%--<script src="/resources/js/html5shiv.js"></script>--%>
    <%--<script src="/resources/js/respond.min.js"></script>--%>
    <%--<![endif]-->--%>
<%--</head>--%>

<%--<body>--%>


<%--<div class="container">--%>


<form method="GET" class="form-horizontal" action="<c:url value="/assure/search"/>">
      <!--Form panel -->
        <div class="panel panel-inverse">
            <div class="panel-heading">
                <h2 class="panel-title">Crit&egrave;res</h2>
            </div>
            <div class="panel-body form-horizontal">
                <div class="row">
                    <div class="col-md-6 ">
                        <div class="form-group">
                            <label for="" class="col-md-3 col-lg-4 control-label  h4">Identifiant</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control numeric" name="identifiant" placeholder="Identifiant" value="${searchAssureForm.identifiant}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="" class="col-md-3 col-lg-4 control-label  h4">Identifiant Creelia</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control numeric" name="identifiantCreelia" placeholder="Identifiant Creelia" value="${searchAssureForm.identifiantCreelia}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="" class="col-md-3 col-lg-4 control-label h4">Nom</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="nom" placeholder="Nom" value="${searchAssureForm.nom}">	    	          </div>
                        </div>
                        <div class="form-group">
                            <label for="" class="col-md-3 col-lg-4 control-label h4">Pr&eacute;nom</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="prenom" placeholder="Prénom" value="${searchAssureForm.prenom}">
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="" class="col-md-3 col-lg-4 control-label h4">Regrouper lors du tri</label>
                            <label class="checkbox-inline">
                                <input type="checkbox" name="sortGroup" value="checked" ${searchAssureForm.sortGroup}>
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <p class="action-block">
                            <input type="reset" value="Effacer les filtres" class="btn btn-primary btn-lg">
                            <input type="submit" value="Filter" class="btn btn-success btn-lg">
                        </p>
                    </div>
                </div>

            </div>
        </div>
        <!-- BOUTONS D'ACTION -->

<!-- /container -->
</form>


<%--<!-- Bootstrap core JavaScript--%>
<%--================================================== -->--%>
<%--<!-- Placed at the end of the document so the pages load faster -->--%>
<%--<script src="/resources/js/dependencies/jquery-1.10.1.min.js"></script>--%>
<%--<script src="/resources/js/bootstrap.min.js"></script>--%>
<%--<script>--%>
    <%--$(document).ready(function() {--%>
        <%--/* DEMO du comportement du menu principal--%>
         <%--Place l'état actif sur l'item de menu cliqué--%>
         <%--*/--%>
        <%--$('.navbar-nav li:not(.dropdown) a').click(function () {--%>
            <%--$('.navbar-nav li a').not(this).parent().removeClass('active');--%>
            <%--$(this).parent().addClass('active');--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>