<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../dist/ico/favicon.png">

    <title>GES - Page avec menu application statique</title>

    <!-- Bootstrap core CSS + theme Generali -->
    <%--<link href="../../dist/css/bootstrap.css" rel="stylesheet">--%>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <!--<script src="../../dist/js/html5shiv.js"></script>-->
    <!--<script src="../../dist/js/respond.min.js"></script>-->
    <![endif]-->

    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/html5shiv.js" />"></script>
    <script src="<c:url value="/resources/js/respond.min.js" />"></script>
    <%--<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">--%>
    <%--<script src="<c:url value="/resources/js/html5shiv.js" />"></script>--%>
    <%--<script src="<c:url value="/resources/js/respond.min.js" />"></script>--%>

</head>

<body>

<!-- Static navbar -->
<div class="navbar navbar-primary navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="glyphicon glyph-lg"></span>
            </button>
            <span class="logo"></span>
            <span class="navbar-brand application-heading">GES - Titre de l'application</span>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<c:url value="/index"/>"><span class="glyphicon glyphicon-home"></span> Accueil</a></li>
                <li><a href="#">Menu</a></li>
                <li><a href="#">Autre menu</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Menu déroulant <span class="glyphicon glyphicon-chevron-down"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Une autre action</a></li>
                        <li><a href="#">Encore une action</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">Sous titre de menu</li>
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Une autre action</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="btn-quitter"><a href="<c:url value="/logout"/>" >Quitter <span class="glyphicon glyphicon-cross"></span></a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<div class="container">

    <div class="page">
        <div class="page-header">
            <h1 id="main-nav">Page avec barre de menu statique</h1>
        </div>

    </div>
</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<%--<script src="../../dist/js/dependencies/jquery-1.10.1.min.js"></script>--%>
<%--<script src="../../dist/js/bootstrap.min.js"></script>--%>
<script src="/resources/js/dependencies/jquery-1.10.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script>
      $(document).ready(function() {
        /* DEMO du comportement du menu principal
        Place l'état actif sur l'item de menu cliqué
        */
        $('.navbar-nav li:not(.dropdown) a').click(function () {
          $('.navbar-nav li a').not(this).parent().removeClass('active');
          $(this).parent().addClass('active');
          });
      });
    </script>
</body>
</html>
