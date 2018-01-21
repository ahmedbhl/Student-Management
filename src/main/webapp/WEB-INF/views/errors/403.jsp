<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>403 (FORBIDDEN)</title>
<!-- Custom CSS -->
<link href="<%=request.getContextPath()%>/resources/dist/css/403.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/dist/css/Lato401.css"
	rel="stylesheet">

</head>

<body>
	<div class="page-wrap">
		<h1>403</h1>
		<h2>forbidden</h2>
		<p>Area 51! I mean 403. I did not say 51 ...</p>
		<c:url value="${url403}" var="back" />
		<p>
			<a href="${back}">Accueil</a>
		</p>
	</div>


</body>
</html>
	