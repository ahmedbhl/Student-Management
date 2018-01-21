<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title><fmt:message code="etudiant.ajouter.titre"/></title>

<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<%=request.getContextPath()%>/resources/dist/css/sb-admin-2.css"
	rel="stylesheet">
	<link
	href="<%=request.getContextPath()%>/resources/dist/css/checkbox.css"
	rel="stylesheet">
<!-- DataTables CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">
<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<link
	href="<%=request.getContextPath()%>/resources/jquery_datetimepicker/bootstrap-datetimepicker.min.css"
	rel="stylesheet" type="text/css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">

			<%@ include file="/WEB-INF/views/menu_top/topMenu.jsp"%>
			<%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp"%>
			<!-- /.navbar-static-side -->
		</nav>


		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header"><fmt:message code="etudiant.ajouter.titre"/></h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>

				<div class="row">
					<div class="col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading"><fmt:message code="etudiant.ajouter.titreBar"/></div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								  <!-- Nav tabs -->
	                            <ul class="nav nav-tabs">
	                                <li class="active"><a aria-expanded="true" href="#profile" data-toggle="tab"><fmt:message code="etudiant.ajouter.profil"/></a>
	                                </li>
	                                <li><a aria-expanded="false" href="#info" data-toggle="tab"><fmt:message code="etudiant.ajouter.info"/></a>
	                                </li>
	                                <li><a aria-expanded="false" href="#Adresse" data-toggle="tab"><fmt:message code="etudiant.ajouter.addresse"/></a>
	                                </li>
	                            </ul>
	                            
	                             <c:url value="/etudiants/enregistrer" var="enregistrer"></c:url>
								<f:form modelAttribute="etudiant" action="${enregistrer}" method="Post" role="form" id="formId" enctype="multipart/form-data">
								<f:hidden path="idPersonne" />
								<f:hidden path="photos" />
								<f:hidden path="oldEmail" />
								<f:hidden path="oldCIN" />
								
							 	 <!-- Tab panes -->
                           		 <div class="tab-content">
                           		 
                           		
									
                           		 	<div class="tab-pane fade active in" id="profile">
                                    <h4><fmt:message code="etudiant.ajouter.profil.cordoone"/> </h4><hr>
                                    
	                                    <div class="form-group">
											<label><fmt:message code="etudiant.ajouter.classe"/></label>
											<f:select path="classe.idClasse" class="form-control" items="${listclasse}" itemLabel="codeClasse" itemValue="idClasse"></f:select>
											<f:errors path="classe.idClasse" class="text-danger" />
										</div>
	                                    <div class="form-group">
											<label><fmt:message code="etudiant.ajouter.nomFr"/></label>
											<f:input path="nomFr" class="form-control" placeholder="Nom En Francçais" />
											<f:errors path="nomFr" class="text-danger" />
										</div>
										
										<div class="form-group">
											<label><fmt:message code="etudiant.ajouter.nomAr"/></label>
											<f:input path="nomAr" class="form-control" placeholder="Nom en Arabe" />
											<f:errors path="nomAr" class="text-danger" />
										</div>
										
										<div class="form-group">
											<label><fmt:message code="etudiant.ajouter.prenomFr"/></label>
											<f:input path="prenomFr" class="form-control" placeholder="Prénom En Français" />
											<f:errors path="prenomFr" class="text-danger" />
										</div>
										
										<div class="form-group">
											<label><fmt:message code="etudiant.ajouter.prenomAr"/></label>
											<f:input path="prenomAr" class="form-control" placeholder="Prénom en Arabe" />
											<f:errors path="prenomAr" class="text-danger" />
										</div>
	                                   										
										<div class="form-group">
											<label><fmt:message code="etudiant.ajouter.cin"/></label>
											<f:input path="cin" class="form-control" placeholder="CIN" pattern="\d*"/>
											<f:errors path="cin" class="text-danger" />
										</div>	
										
										<div class="form-group">
											<label><fmt:message code="etudiant.ajouter.codeCNSS"/></label>
											<f:input path="codeCNSS" class="form-control" placeholder="Code CNSS" />
											<f:errors path="codeCNSS" class="text-danger" />
										</div>	
										
										<div class="form-group">
											<label><fmt:message code="etudiant.ajouter.email"/></label>
											<f:input path="email" class="form-control" placeholder="E-mail" />
											<f:errors path="email" class="text-danger" />
									   </div>	
									    
									    <div class="form-group">
											<label><fmt:message code="etudiant.ajouter.datePremierInscri"/></label>
											<div class='input-group date' id='datetimepicker10'>
												<f:input  path="datePremierInscri" size="16" type="text" class="form-control" placeholder="Date de Premiére inscription" readonly="true" id="form_datetime" />
												<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
											</div>
											<f:errors path="datePremierInscri" class="text-danger" />
										</div>
										
										<div class="form-group">
											<label><fmt:message code="etudiant.ajouter.sexe"/>&nbsp;&nbsp;</label>
											<label class="radio-inline"><f:radiobutton path="sexe" value="Homme" /><fmt:message code="etudiant.ajouter.sexe.Homme"/></label>
											<label class="radio-inline"><f:radiobutton path="sexe" value="Femme" /><fmt:message code="etudiant.ajouter.sexe.Femme"/></label>
											<br><f:errors path="sexe" class="text-danger" />
										</div>
										
										<div class="form-group">
											<label><fmt:message code="etudiant.ajouter.disposport"/></label>
											<div class="slideTwo" >
												<f:checkbox path="dispoSport"  id="slideTwo" name="check" label="" for="slideTwo" />
												<f:errors path="dispoSport" class="text-danger" />
											</div>
										</div>
									
										<div class="form-group">
											<label><fmt:message code="etudiant.ajouter.photos"/></label>
											<input type= "file"  name="file" class="form-control" placeholder="Photos" />
											<f:errors path="photos" class="text-danger" />
										</div>
									 </div>
									 
                                	<div class="tab-pane fade" id="info">
                                    <h4><fmt:message code="etudiant.ajouter.info.descinfo"/></h4><hr>
                                    	
                                    	<div class="form-group">
											<label><fmt:message code="etudiant.ajouter.nationalite"/></label>
											<f:input path="nationalite" class="form-control" placeholder="Nationalité" />
											<f:errors path="nationalite" class="text-danger" />
										</div>
										
										 <div class="form-group">
											<label><fmt:message code="etudiant.ajouter.dateNaissance"/></label>
											<div class='input-group date' id='datetimepicker10'>
												<f:input  path="dateNaissance" size="16" type="text" class="form-control" placeholder="Date de Naissance" readonly="true" id="form_dateNaissance" />
												<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
											</div>
											<f:errors path="dateNaissance" class="text-danger" />
										</div>
										
                                    	<div class="form-group">
											<label><fmt:message code="etudiant.ajouter.lieuNaissanceFr"/></label>
											<f:input path="lieuNaissanceFr" class="form-control" placeholder="Lieu De Naissance En Français" />
											<f:errors path="lieuNaissanceFr" class="text-danger" />
										</div>
									
										<div class="form-group">
											<label><fmt:message code="etudiant.ajouter.lieuNaissanceAr"/></label>
											<f:input path="lieuNaissanceAr" class="form-control" placeholder="Lieu De Naissance En Arabe" />
											<f:errors path="lieuNaissanceAr" class="text-danger" />
										</div>
										
										<div class="form-group">
											<label><fmt:message code="etudiant.ajouter.situationdepart"/></label>
											<f:input path="situationdepart" class="form-control" placeholder="Situation De département" />
											<f:errors path="situationdepart" class="text-danger" />
									   </div>	
									   
										<div class="form-group">
											<label><fmt:message code="etudiant.ajouter.tel"/></label>
											<f:input path="tel" class="form-control" placeholder="Numéro De Tel" pattern="\d*"/>
											<f:errors path="tel" class="text-danger" />
										</div>	
										
										<div class="form-group">
											<label><fmt:message code="etudiant.ajouter.profMere"/></label>
											<f:input path="profMere" class="form-control" placeholder="Profession de Mère" />
											<f:errors path="profMere" class="text-danger" />
									   </div>	
									   
									   <div class="form-group">
											<label><fmt:message code="etudiant.ajouter.profPere"/></label>
											<f:input path="profPere" class="form-control" placeholder="Profession de Père" />
											<f:errors path="profPere" class="text-danger" />
									   </div>	

                                	</div>
                                	
                                	<div class="tab-pane fade" id="Adresse">
                                    <h4><fmt:message code="etudiant.ajouter.addresse.descAdresse"/></h4><hr>
                                    
	                                    <div class="form-group">
											<label><fmt:message code="etudiant.ajouter.addresseFr"/></label>
											<f:input path="addresseFr" class="form-control" placeholder="Addresse En Français" />
											<f:errors path="addresseFr" class="text-danger" />
										</div>
										
										<div class="form-group">
											<label><fmt:message code="etudiant.ajouter.addresseAr"/></label>
											<f:input path="addresseAr" class="form-control" placeholder="Addresse En Arabe" />
											<f:errors path="addresseAr" class="text-danger" />
										</div>
										
										<div class="form-group">
											<label><fmt:message code="etudiant.ajouter.villeFr"/></label>
											<f:input path="villeFr" class="form-control" placeholder="Ville En Français" />
											<f:errors path="villeFr" class="text-danger" />
										</div>
										
										<div class="form-group">
											<label><fmt:message code="etudiant.ajouter.villeAr"/></label>
											<f:input path="villeAr" class="form-control" placeholder="Ville En Arabe" />
											<f:errors path="villeAr" class="text-danger" />
										</div>
										
	                                    <div class="form-group">
											<label><fmt:message code="etudiant.ajouter.codePostal"/></label>
											<f:input path="codePostal" class="form-control" placeholder="Code Postal" />
											<f:errors path="codePostal" class="text-danger" />
										</div>	

                                	</div>
                                	
								
																	
								
								
								
								</div>
									
									
										<div class="panel-footer">
										<button class="btn btn-primary" type="submit">
											<i class="fa fa-save">&nbsp;<fmt:message code="etudiant.ajouter.enregistrer"/></i>
										</button>
										<a href="<c:url value="/etudiants/" />" class="btn btn-danger"
											type="submit"><i class="fa  fa-arrow-left ">&nbsp;<fmt:message code="etudiant.annuler"/></i></a>

									</div>
								</f:form>
											
									
							</div>
							<!-- /.panel-body -->
						</div>
						<!-- /.panel -->
					</div>
					<!-- /.col-lg-12 -->
				</div>

			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->



	</div>
	<!-- /#wrapper -->
	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/dist/js/sb-admin-2.js"></script>
		<script	src="<%=request.getContextPath()%>/resources/dist/js/checkbsox.js"></script>
	<!-- DataTables JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
		<script	src="<%=request.getContextPath()%>/resources/jquery_datetimepicker/jquery-1.8.3.min.js"></script>
	<script	src="<%=request.getContextPath()%>/resources/jquery_datetimepicker/bootstrap.min.js"></script>
	<script	src="<%=request.getContextPath()%>/resources/jquery_datetimepicker/bootstrap-datetimepicker.js"></script>
	<script	src="<%=request.getContextPath()%>/resources/jquery_datetimepicker/locales/bootstrap-datetimepicker.fr.js"></script>
	<script type="text/javascript">
    $("#form_datetime").datetimepicker({language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0,
		format: 'yyyy-mm-dd'});
    $("#form_dateNaissance").datetimepicker({language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0,
		format: 'yyyy-mm-dd'});
</script> 

	<script
		src="<%=request.getContextPath()%>/resources/jquery_datetimepicker/jquery-1.8.3.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/jquery_datetimepicker/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/jquery_datetimepicker/bootstrap-datetimepicker.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/jquery_datetimepicker/locales/bootstrap-datetimepicker.fr.js"></script>
</body>

</html>




