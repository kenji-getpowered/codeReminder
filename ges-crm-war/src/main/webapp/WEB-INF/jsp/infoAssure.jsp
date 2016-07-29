<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-15" pageEncoding="ISO-8859-15"%>--%>
<!DOCTYPE html>
<%--<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>--%>
<%--<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="<c:url value="/resources/ico/favicon.png"/>">
    <title>GES - CRM</title>

    <link href="<c:url value="/resources/css/components/tablesorter/tablesorter.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">

    <style >
        .panel-body {  position: relative;}
        .wrapper {
            position: relative;
            padding: 0 5px;
            height: 500px;
            overflow-y: auto;
        }
        .wrapper .table {
            margin-top: 0;
        }
    </style>

</head>
<body>

<jsp:include page="navigation_bar.jsp"></jsp:include>

<div class="container">
    <div class="page">
        <div class="page-header"><h1><em>Consultation :</em> ${assure.prenom} ${assure.nom}</h1></div>
        <div class="panel panel-inverse">
            <div class="panel-heading"><h2 class="panel-title">Identit&eacute;</h2></div>
            <div class="panel-body form-horizontal form-static">
                <div class="row">
                    <div class="col-md-4 fixed-label-md">
                        <div class="form-group form-static">
                            <label class="control-label">Civilit&eacute; </label>
                            <span class="form-control-static">${assure.idCivilite}</span>
                        </div>
                        <div class="form-group form-static">
                            <label class="control-label">Nom </label>
                            <span class="form-control-static">${assure.nom}</span>
                        </div>
                        <div class="form-group form-static">
                            <label class="control-label">Pr&eacute;nom </label>
                            <span class="form-control-static">${assure.prenom}</span>
                        </div>
                    </div>
                    <div class="col-md-4 fixed-label-md">
                        <div class="form-group form-static">
                            <label class="control-label">Identifiant GES</label>
                            <span class="form-control-static">${assure.identifiant}</span>
                        </div>
                        <div class="form-group form-static">
                            <label class="control-label">Identifiant Creelia</label>
                            <span class="form-control-static">${assure.identifiantCreelia}</span>
                        </div>
                        <div class="form-group form-static">
                            <label class="control-label">R&eacute;seau </label>
                            <span class="form-control-static">${assure.idReseau} - ${assure.reseau}</span>
                        </div>
                    </div>
                    <div class="col-md-4 fixed-label-md">
                        <div class="form-group form-static">
                            <label class="control-label">Entreprise</label>
                            <span class="form-control-static">${assure.nomEntrepise}</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <a href="<c:url value="/loginCRM?identifiant=${assure.identifiant}&id_reseau=${assure.idReseau}"/>"  target="_blank" class="btn btn-primary btn-lg">
                            <span class="glyphicon glyphicon-log-in"></span> Espace Perso
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="panel panel-inverse">
            <div class="panel-heading"><h2 class="panel-title">Informations personnelles</h2></div>
            <div class="panel-body form-horizontal form-static">
                <div class="row">
                    <div class="col-md-4 fixed-label-md">
                        <div class="form-group form-static">
                            <label class="control-label">Code postal</label>
                            <span class="form-control-static">${assure.cindCodePostal}</span>
                        </div>
                    </div>
                    <div class="col-md-8 fixed-label-md">
                        <div class="form-group form-static">
                            <label class="control-label">Ville</label>
                            <span class="form-control-static">${assure.cindVille}</span>
                        </div>
                    </div>
                </div>
                <hr/>
                <div class="row">
                    <div class="col-md-4 fixed-label-md">
                        <div class="form-group form-static">
                            <label class="control-label">Lieu de naissance</label>
                            <span class="form-control-static">${assure.lieuNaissance}</span>
                        </div>
                    </div>
                    <div class="col-md-8 fixed-label-md">
                        <div class="form-group form-static">
                            <label class="control-label">Code agent</label>
                            <span class="form-control-static">${assure.codeAgent}</span>
                        </div>
                    </div>
                </div>
                <hr/>
                <div class="row">
                    <div class="col-md-4 fixed-label-md">
                        <div class="form-group form-static">
                            <label class="control-label">Statut familial </label>
                            <span class="form-control-static">${assure.statutFamilial}</span>
                        </div>
                    </div>
                    <div class="col-md-8 fixed-label-md">
                        <div class="form-group form-static">
                            <label class="control-label">R&eacute;gime matrimonial</label>
                            <span class="form-control-static">${assure.regime}</span>
                        </div>
                    </div>
                    <div class="col-md-12 fixed-label-md">
                        <div class="form-group form-static">
                            <label class="control-label">Montant total encours</label>
                            <span class="form-control-static">${assure.montantTotalAvoirs}</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--         Panel CONTRAT-->
        <div class="navigation">
            <ul class="nav nav-tabs tab-inverse has-close" id="maintabs">
                <li class="active"><a href="#contrats" data-toggle="tab"><h2 class="panel-title">Contrats</h2></a></li>
                <c:forEach items="${contrats}" var="contrat">
                    <%--<div class="tab-pane" id="contrat_${contrat.idContrat}">--%>
                    <li><a href="#contrat_${contrat.idContrat}" data-toggle="tab"><h2 class="panel-title">Contrat ${contrat.prodAbrev} ${contrat.idContratEnt}</h2></a></li>
                </c:forEach>
            </ul>
        </div>

        <div class="tab-content main-tab-content" style="min-height:200px" id="maintabcontent">


            <div class="tab-pane active" id="contrats">
                <div class="panel panel-inverse">
                    <div class="panel-body form-horizontal">
                        <table class="table table-bordered head-centered table-hover" id="rowselectable">
                            <thead>
                            <tr>
                                <th colspan="6">Liste des contrats souscrits</th>
                                <th colspan="2">Vente crois&eacute;e</th>
                                <th colspan="2">Relance</th>
                                <th colspan="2">&nbsp;</th>
                            </tr>
                            <tr>
                                <th colspan="2">R&eacute;seau</th>
                                <th colspan="1">Produit</th>
                                <th colspan="2">Entreprise</th>
                                <th data-field="contrat" colspan="1">Contrat</th>
                                <th colspan="1">E</th>
                                <th colspan="1">C</th>
                                <th colspan="1">E</th>
                                <th colspan="1">C</th>
                                <th colspan="2">Encours</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${contrats}" var="contrat">
                                <tr id="${contrat.idContrat}">
                                    <td  colspan="2">${contrat.nomReseau}</td>
                                    <td colspan="1" class="center">${contrat.prodAbrev}</td>
                                    <td colspan="2">${contrat.entrNom}</td>
                                    <td colspan="1" class="center">${contrat.idContrat}</td>

                                    <td colspan="1" class="center">
                                        <c:choose>
                                            <c:when test="${contrat.centAutoCrosselling==1}">
                                                <span class="glyphicon glyphicon-dot" style="color:lightgreen"></span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="glyphicon glyphicon-dot color:red" style="color:red"></span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td colspan="1" class="center">
                                        <c:choose>
                                            <c:when test="${contrat.centAutoRelance==1}">
                                                <span class="glyphicon glyphicon-dot" style="color:lightgreen"></span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="glyphicon glyphicon-dot color:red" style="color:red"></span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>


                                    <td colspan="1" class="center">
                                        <c:choose>
                                            <c:when test="${contrat.utilAutoRelance==1}">
                                                <span class="glyphicon glyphicon-dot" style="color:lightgreen"></span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="glyphicon glyphicon-dot color:red" style="color:red"></span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td colspan="1" class="center">
                                        <c:choose>
                                            <c:when test="${contrat.utilAutoCrosselling==1}">
                                                <span class="glyphicon glyphicon-dot" style="color:lightgreen"></span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="glyphicon glyphicon-dot color:red" style="color:red"></span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>

                                    <td colspan="2" class="numeric">
                                            ${contrat.siglAvoirTot}
                                        <span class="legend-unit"> &euro;</span>
                                    </td>
                                </tr>
                           </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <c:forEach items="${contrats}" var="contrat">
                <div class="tab-pane" id="contrat_${contrat.idContrat}">
                    <div class="panel-heading"><h2 class="panel-title">Contrat</h2></div>
                    <div class="panel-body form-horizontal form-static">
                        <div class="row">
                            <div class="col-md-4 fixed-label-md" style="background-color:lightblue">
                                <div class="form-group form-static">
                                    <label class="control-label">N Dispositif CREELIA : </label>
                                    <span class="form-control-static">${contrat.refContratCreelia}</span>
                                </div>
                                <div class="form-group form-static">
                                    <label class="control-label">Montant En-cours : </label>
                                    <span class="form-control-static">${contrat.siglAvoirTot}</span>
                                </div>
                                <div class="form-group form-static">
                                    <label class="control-label">Nb arbitrage gratuit :  </label>
                                    <span class="form-control-static">${contrat.cindArbGratuit}</span>
                                </div>
                                <div class="form-group form-static">
                                    <label class="control-label">Date ouverture de compte : </label>
                                    <span class="form-control-static">${contrat.cindOuverContrat}</span>
                                </div>
                                <div class="form-group form-static">
                                    <label class="control-label">Date fermeture contrat : </label>
                                    <span class="form-control-static">${contrat.cindFermeContrat}</span>
                                </div>
                                <div class="form-group form-static">
                                    <label class="control-label">Entreprise : </label>
                                    <span class="form-control-static">${assure.nomEntrepise}</span>
                                </div>
                                <div class="form-group form-static">
                                    <label class="control-label">Matricule : </label>
                                    <span class="form-control-static">${contrat.cindMatricule}</span>
                                </div>
                                <div class="form-group form-static">
                                    <label class="control-label">Profession : </label>
                                    <span class="form-control-static">${contrat.cindProfession}</span>
                                </div>
                                <div class="form-group form-static">
                                    <label class="control-label">CSP : </label>
                                    <span class="form-control-static">${contrat.cspLibelle}</span>
                                </div>
                                <div class="form-group form-static">
                                    <label class="control-label">Date Entr&eacute; : </label>
                                    <span class="form-control-static">${contrat.cindEntreEnt}</span>
                                </div>
                                <div class="form-group form-static">
                                    <label class="control-label">Date Sortie : </label>
                                    <span class="form-control-static">${contrat.cindDepartEnt}</span>
                                </div>
                                <div class="form-group form-static">
                                    <label class="control-label">Date Retraite : </label>
                                    <span class="form-control-static">${contrat.cindDepRetraite}</span>
                                </div>
                                <div class="form-group form-static">
                                    <label class="control-label">TNS : </label>
                                    <span class="form-control-static">XXXXX</span>
                                </div>
                                <div class="form-group form-static">
                                    <label class="control-label">RIB : </label>
                                    <span class="form-control-static">XXXXX</span>
                                </div>
                                <div class="form-group form-static">
                                    <span class="form-control-static">${contrat.cindAdr1}</span>
                                </div>
                                <div class="form-group form-static">
                                    <label class="control-label">NPAI : </label>
                                    <%--<div class="selectContainer">--%>
                                        <select class="form-control-static" name="npai">
                                            <option value="non">Non</option>
                                            <option value="oui">Oui</option>
                                        </select>
                                    <%--</div>--%>
                                </div>
                                <div class="form-group form-static">
                                    <span class="form-control-static">${contrat.cindAdr2}</span>
                                </div>
                                <div class="form-group form-static">
                                    <span class="form-control-static">${contrat.cindAdr3}</span>
                                </div>
                                <div class="form-group form-static">
                                    <span class="form-control-static">${contrat.cindCodPostal}</span>
                                </div>
                                <div class="form-group form-static">
                                    <span class="form-control-static">${contrat.cindVille}</span>
                                </div>
                                <div class="form-group form-static">
                                    <span class="form-control-static">${contrat.cindPays}</span>
                                </div>
                            </div>
                            <div class="col-md-8 fixed-label-md">
                                <div class="panel panel-inverse">
                                    <div class="panel-heading"><h2 class="panel-title">Services</h2></div>
                                    <div class="panel-body">
                                            <table class="tablesorter table table-bordered" id="tablesorterfixed3">
                                                <thead>
                                                <tr>
                                                    <th>Libell&eacute; </th>
                                                    <th>Activ&eacute; le</th>
                                                    <th>Agent</th>
                                                    <th>Montant</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${contrats}" var="contact">
                                                    <tr>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                    </div>
                </div>
                        <%--<div class="panel-body form-horizontal form-static">--%>
                        <%--<div class="row">--%>
                        <%--<div class="col-md-4 fixed-label-md">--%>
                        <%--<div class="form-group form-static">--%>
                        <%--<label class="control-label">Code postal</label>--%>
                        <%--<span class="form-control-static">${assure.cindCodePostal}</span>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-8 fixed-label-md">--%>
                        <%--<div class="form-group form-static">--%>
                        <%--<label class="control-label">Ville</label>--%>
                        <%--<span class="form-control-static">${assure.cindVille}</span>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <%--<hr/>--%>
                        <%--<div class="row">--%>
                        <%--<div class="col-md-4 fixed-label-md">--%>
                        <%--<div class="form-group form-static">--%>
                        <%--<label class="control-label">Lieu de naissance</label>--%>
                        <%--<span class="form-control-static">${assure.lieuNaissance}</span>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-8 fixed-label-md">--%>
                        <%--<div class="form-group form-static">--%>
                        <%--<label class="control-label">Code agent</label>--%>
                        <%--<span class="form-control-static">${assure.codeAgent}</span>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <%--<hr/>--%>
                        <%--<div class="row">--%>
                        <%--<div class="col-md-4 fixed-label-md">--%>
                        <%--<div class="form-group form-static">--%>
                        <%--<label class="control-label">Statut familial </label>--%>
                        <%--<span class="form-control-static">${assure.statutFamilial}</span>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-8 fixed-label-md">--%>
                        <%--<div class="form-group form-static">--%>
                        <%--<label class="control-label">R&eacute;gime matrimonial</label>--%>
                        <%--<span class="form-control-static">${assure.regime}</span>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-12 fixed-label-md">--%>
                        <%--<div class="form-group form-static">--%>
                        <%--<label class="control-label">Montant total encours</label>--%>
                        <%--<span class="form-control-static">${assure.montantTotalAvoirs}</span>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                </div>
            </c:forEach>
            <%--<div class="tab-pane" id="contrat">--%>
                <%--<div class="page-header">--%>
                    <%--<h1 id="main-nav"><em>Sinistre</em> E6325407</h1>--%>
                <%--</div>--%>
                <%--<div class="panel-heading"><h2 class="panel-title">Contrat</h2></div>--%>
                <%--<div class="panel-body form-horizontal form-static">--%>
                    <%--<div class="row">--%>
                        <%--<div class="col-md-4 fixed-label-md">--%>
                            <%--<div class="form-group form-static">--%>
                                <%--<label class="control-label">N° Dispositif CREELIA : </label>--%>
                                <%--<span class="form-control-static">${contrats.get(id).refContratCreelia}</span>--%>
                            <%--</div>--%>
                            <%--<div class="form-group form-static">--%>
                                <%--<label class="control-label">Montant En-cours : </label>--%>
                                <%--<span class="form-control-static">${assure.nom}</span>--%>
                            <%--</div>--%>
                            <%--<div class="form-group form-static">--%>
                                <%--<label class="control-label">Pr&eacute;nom </label>--%>
                                <%--<span class="form-control-static">${assure.prenom}</span>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-4 fixed-label-md">--%>
                            <%--<div class="form-group form-static">--%>
                                <%--<label class="control-label">Identifiant GES</label>--%>
                                <%--<span class="form-control-static">${assure.identifiant}</span>--%>
                            <%--</div>--%>
                            <%--<div class="form-group form-static">--%>
                                <%--<label class="control-label">Identifiant Creelia</label>--%>
                                <%--<span class="form-control-static">${assure.identifiantCreelia}</span>--%>
                            <%--</div>--%>
                            <%--<div class="form-group form-static">--%>
                                <%--<label class="control-label">R&eacute;seau </label>--%>
                                <%--<span class="form-control-static">${assure.idReseau} - ${assure.reseau}</span>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-4 fixed-label-md">--%>
                            <%--<div class="form-group form-static">--%>
                                <%--<label class="control-label">Entreprise</label>--%>
                                <%--<span class="form-control-static">${assure.nomEntrepise}</span>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="form-group">--%>
                            <%--<a href="<c:url value="/loginCRM?identifiant=${assure.identifiant}&id_reseau=${assure.idReseau}"/>"  target="_blank" class="btn btn-primary btn-lg">--%>

                                <%--&lt;%&ndash;<button type="button" class="btn btn-primary btn-lg">&ndash;%&gt;--%>
                                <%--<span class="glyphicon glyphicon-log-in"></span> Espace Perso--%>
                                <%--&lt;%&ndash;</button>&ndash;%&gt;--%>
                            <%--</a>--%>
                        <%--</div>--%>

                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="panel panel-inverse">--%>
                <%--<div class="panel-heading"><h2 class="panel-title">Informations personnelles</h2></div>--%>
                <%--<div class="panel-body form-horizontal form-static">--%>
                    <%--<div class="row">--%>
                        <%--<div class="col-md-4 fixed-label-md">--%>
                            <%--<div class="form-group form-static">--%>
                                <%--<label class="control-label">Code postal</label>--%>
                                <%--<span class="form-control-static">${assure.cindCodePostal}</span>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-8 fixed-label-md">--%>
                            <%--<div class="form-group form-static">--%>
                                <%--<label class="control-label">Ville</label>--%>
                                <%--<span class="form-control-static">${assure.cindVille}</span>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<hr/>--%>
                    <%--<div class="row">--%>
                        <%--<div class="col-md-4 fixed-label-md">--%>
                            <%--<div class="form-group form-static">--%>
                                <%--<label class="control-label">Lieu de naissance</label>--%>
                                <%--<span class="form-control-static">${assure.lieuNaissance}</span>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-8 fixed-label-md">--%>
                            <%--<div class="form-group form-static">--%>
                                <%--<label class="control-label">Code agent</label>--%>
                                <%--<span class="form-control-static">${assure.codeAgent}</span>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<hr/>--%>
                    <%--<div class="row">--%>
                        <%--<div class="col-md-4 fixed-label-md">--%>
                            <%--<div class="form-group form-static">--%>
                                <%--<label class="control-label">Statut familial </label>--%>
                                <%--<span class="form-control-static">${assure.statutFamilial}</span>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-8 fixed-label-md">--%>
                            <%--<div class="form-group form-static">--%>
                                <%--<label class="control-label">R&eacute;gime matrimonial</label>--%>
                                <%--<span class="form-control-static">${assure.regime}</span>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-12 fixed-label-md">--%>
                            <%--<div class="form-group form-static">--%>
                                <%--<label class="control-label">Montant total encours</label>--%>
                                <%--<span class="form-control-static">${assure.montantTotalAvoirs}</span>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        </div>





        <%--<div class="panel panel-inverse">--%>
        <%--<div class="panel-heading">--%>
        <%--<h2 class="panel-title">Contrats</h2>--%>
        <%--</div>--%>
        <%--<div class="panel-body form-horizontal">--%>
        <%--<table class="table table-bordered head-centered table-hover" id="rowselectable">--%>
        <%--<thead>--%>
        <%--<tr>--%>
        <%--<th colspan="6">Liste des contrats souscrits</th>--%>
        <%--<th colspan="2">Vente crois&eacute;e</th>--%>
        <%--<th colspan="2">Relance</th>--%>
        <%--<th colspan="2">&nbsp;</th>--%>
        <%--</tr>--%>
        <%--<tr>--%>
        <%--<th colspan="2">R&eacute;seau</th>--%>
        <%--<th colspan="1">Produit</th>--%>
        <%--<th colspan="2">Entreprise</th>--%>
        <%--<th colspan="1">Contrat</th>--%>
        <%--<th colspan="1">E</th>--%>
        <%--<th colspan="1">C</th>--%>
        <%--<th colspan="1">E</th>--%>
        <%--<th colspan="1">C</th>--%>
        <%--<th colspan="2">Encours</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <%--<tbody>--%>
        <%--&lt;%&ndash;<div class="panel panel-sub">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="list-group list-group-hover">&ndash;%&gt;--%>
        <%--<c:forEach items="${contrats}" var="contrat">--%>
        <%--<tr>--%>
        <%--<td  colspan="2">${contrat.nomReseau}</td>--%>
        <%--<td colspan="1" class="center">${contrat.prodAbrev}</td>--%>
        <%--<td colspan="2">${contrat.entrNom}</td>--%>
        <%--<td colspan="1" class="center">${contrat.idContrat}</td>--%>

        <%--<td colspan="1" class="center">--%>
        <%--<c:choose>--%>
        <%--<c:when test="${contrat.centAutoCrosselling==1}">--%>
        <%--<span class="glyphicon glyphicon-dot" style="color:lightgreen"></span>--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
        <%--<span class="glyphicon glyphicon-dot color:red" style="color:red"></span>--%>
        <%--</c:otherwise>--%>
        <%--</c:choose>--%>
        <%--</td>--%>
        <%--<td colspan="1" class="center">--%>
        <%--<c:choose>--%>
        <%--<c:when test="${contrat.centAutoRelance==1}">--%>
        <%--<span class="glyphicon glyphicon-dot" style="color:lightgreen"></span>--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
        <%--<span class="glyphicon glyphicon-dot color:red" style="color:red"></span>--%>
        <%--</c:otherwise>--%>
        <%--</c:choose>--%>
        <%--</td>--%>


        <%--<td colspan="1" class="center">--%>
        <%--<c:choose>--%>
        <%--<c:when test="${contrat.utilAutoRelance==1}">--%>
        <%--<span class="glyphicon glyphicon-dot" style="color:lightgreen"></span>--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
        <%--<span class="glyphicon glyphicon-dot color:red" style="color:red"></span>--%>
        <%--</c:otherwise>--%>
        <%--</c:choose>--%>
        <%--</td>--%>
        <%--<td colspan="1" class="center">--%>
        <%--<c:choose>--%>
        <%--<c:when test="${contrat.utilAutoCrosselling==1}">--%>
        <%--<span class="glyphicon glyphicon-dot" style="color:lightgreen"></span>--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
        <%--<span class="glyphicon glyphicon-dot color:red" style="color:red"></span>--%>
        <%--</c:otherwise>--%>
        <%--</c:choose>--%>
        <%--</td>--%>

        <%--<td colspan="2" class="numeric">--%>
        <%--${contrat.siglAvoirTot}--%>
        <%--<span class="legend-unit"> &euro;</span>--%>
        <%--</td>--%>
        <%--</tr>--%>

        <%--&lt;%&ndash;<div class="list-group-item">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="list-group-item-text">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="row">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="col-md-2">${contrat.nomReseau}</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="col-md-2">${contrat.prodAbrev}</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="col-md-2">${contrat.entrNom}</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="col-md-2">${contrat.idContrat}</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="col-md-2">${contrat.siglAvoirTot}</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--</c:forEach>--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--</tbody>--%>
        <%--</table>--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--</div>--%>
        <%--</div>--%>


        <%--</div>--%>
        <!-- /page -->

        <%--@Column(name="id_contrat") private String  idContrat;--%>
        <%--@Column(name="prod_abrev") private String  prodAbrev;--%>
        <%--@Column(name="PROD_CLASSE") private String  prodClasse;--%>
        <%--@Column(name="id_produit") private String  idProduit;--%>
        <%--@Column(name="ENTR_NOM") private String  entrNom;--%>
        <%--@Column(name="ENTR_CODE") private String  entrCode;--%>
        <%--@Column(name="CENT_NUM_CONTRAT") private String  centNumContrat;--%>
        <%--@Column(name="sigl_avoir_tot") private String  siglAvoirTot;--%>
        <%--@Column(name="id_contrat_ent") private String  idContratEnt;--%>
        <%--@Column(name="cind_insee") private String  cindInsee;--%>
        <%--@Column(name="cind_numero") private String  cindNumero;--%>
        <%--@Column(name="cind_matricule") private String  cindMatricule;--%>
        <%--@Column(name="cind_profession") private String  cindProfession;--%>
        <%--@Column(name="cind_npai") private String  cindNpai;--%>
        <%--@Column(name="id_csp") private String  idCsp;--%>
        <%--@Column(name="csp_libelle") private String  cspLibelle;--%>
        <%--@Column(name="cind_ouver_contrat") private String  cindOuverContrat;--%>
        <%--@Column(name="cind_ferme_contrat") private String  cindFermeContrat ;--%>
        <%--@Column(name="cind_depart_ent") private String  cindDepartEnt;--%>
        <%--@Column(name="cind_entre_ent") private String  cindEntreEnt;--%>
        <%--@Column(name="cind_dep_retraite") private String  cindDepRetraite;--%>
        <%--@Column(name="cind_adr1") private String  cindAdr1;--%>
        <%--@Column(name="cind_adr2") private String  cindAdr2;--%>
        <%--@Column(name="cind_adr3") private String  cindAdr3;--%>
        <%--@Column(name="cind_cod_postal")    private String  cindCodPostal;--%>
        <%--@Column(name="cind_ville") private String  cindVille;--%>
        <%--@Column(name="cind_pays") private String  cindPays;--%>
        <%--//    @Column(name="cind_usmaj") private Date  cindUsmaj;--%>
        <%--//    @Column(name="cind_dtmaj") private Date cindDtmaj;--%>
        <%--@Column(name="id_reseau_distrib") private String  idReseauDistrib;--%>
        <%--@Column(name="CIND_NON_ASSUJETI_TAXE") private String  cindNonAssujetiTaxe;--%>
        <%--@Column(name="CIND_ARB_GRATUIT") private String  cindArbGratuit;--%>
        <%--@Column(name="UTIL_AUTO_CROSSELLING") private String  utilAutoCrosselling;--%>
        <%--@Column(name="UTIL_AUTO_RELANCE") private String  utilAutoRelance;--%>
        <%--@Column(name="CENT_AUTO_CROSSELLING") private String  centAutoCrosselling;--%>
        <%--@Column(name="CENT_AUTO_RELANCE") private String  centAutoRelance;--%>
        <%--@Column(name="AGT_ID") private String  agtId;--%>
        <%--@Column(name="AGT_CD") private String  agtCd;--%>
        <%--@Column(name="AGT_PRENOM") private String  agtPrenom;--%>
        <%--@Column(name="AGT_NOM") private String  agtNom;--%>
        <%--@Column(name="ENTR_CODE_CREELIA") private String  entrCodeCreelia;--%>
        <%--@Column(name="REF_CONTRAT_CREELIA") private String  refContratCreelia;--%>

        <!--         Panel CONTACT BEGIN -->
        <div class="panel panel-inverse">
            <div class="panel-heading">
                <h2 class="panel-title">Contacts</h2>
            </div>
            <div class="panel-body">
                <div class="wrapper">
                    <table class="tablesorter table table-bordered" id="tablesorterfixed2">
                        <thead>
                        <tr>
                            <th>id </th>
                            <th>dossier</th>
                            <th>action</th>
                            <th>type</th>
                            <th>libtype</th>
                            <th>motif</th>
                            <th>sens</th>
                            <th>commentaire</th>
                            <th>agentInitiateur</th>
                            <th>dateCreation</th>
                            <%--<th>agentAffecte</th>--%>
                            <%--<th>dateEcheance</th>--%>
                            <th>statut</th>
                            <th>idtypedossier</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${contacts}" var="contact">
                            <tr>
                                <td>${contact.id} </td>
                                <td>${contact.dossier}</td>
                                <td>${contact.action}</td>
                                <td>${contact.type}</td>
                                <td>${contact.libtype}</td>
                                <td>${contact.motif}</td>
                                <td>${contact.sens}</td>
                                <td>${contact.commentaire}</td>
                                <td>${contact.agentInitiateur}</td>
                                <td>${contact.dateCreation}</td>
                                    <%--<td>${contact.agentAffecte}</td>--%>
                                    <%--<td>${contact.dateEcheance}</td>--%>
                                <td>${contact.statut}</td>
                                <td>${contact.idtypedossier}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!--   Panel CONTACT END -->
        </div>
    </div>


</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

<script src="<c:url value="/resources/js/dependencies/jquery-1.10.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<%--<script src="<c:url value="/resources/js/dependencies/jquery-1.10.1.min.js"/>"></script>--%>
<script src="<c:url value="/resources/js/components/tablesorter/tablesorter.js"/>"></script>
<script src="<c:url value="/resources/js/components/tablesorter/tablesorterwidgets.min.js"/>"></script>
<script src="<c:url value="/resources/js/components/tableselection/tableselection.js"/>"></script>

<%--<script src="<c:url value="/resources/js/html5shiv.js" />"></script>--%>
<%--<script src="<c:url value="/resources/js/respond.min.js" />"></script>--%>

<script>
    $(function(){
        $('#simpletablesorter').tablesorter({
            sortList : [[0,0]]
        });
        $('#tablesorter').tablesorter({
            sortList : [[0,0]],
            widgets: [ 'filter', 'zebra' ],
            widgetOptions : {
                // jQuery selector string of an element used to reset the filters
                filter_reset : 'button.reset'
            }
        });
        $('#tablesorterfixed').tablesorter({
            sortList : [[0,0]],
            widgets: [ 'stickyHeaders' ],
            widgetOptions : {}
        });

        $('#tablesorterfixed2').tablesorter({
            sortList : [[0,0]],
            widgets: [ 'stickyHeaders' ],
            widgetOptions : {
                stickyHeaders_attachTo : '.wrapper'
            }
        });

        $('#addTab').click(function(){
            var i= $('.nav-tabs li').length + 1;
            var id = $('#tabId').val() ? $('#tabId').val() + i : "tabid" + i;
            var label = $('#tabLabel').val();
            var content = $('#tabContent').val();
            $(document).addTab({"id": id, "label": label, "content": content, "tabWrapper" : "#maintabs", "contentWrapper": "#maintabcontent" });
        });


            // get add event
        $(document).on('added.bs.tab', function(e){
            console.log('add tab event' + e.target)
        });

        // get close/remove tab event
        $(document).on('remove.bs.tab', function(e){
            console.log('close tab event' + e.target)
        });

    });
</script>

</body>esanchez
</html>
