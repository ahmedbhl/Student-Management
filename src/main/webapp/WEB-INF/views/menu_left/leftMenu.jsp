<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
			<li class="sidebar-search">
				<div class="input-group custom-search-form">
					<input type="text" class="form-control" placeholder="<fmt:message code="common.recherche"/>">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div> 
			</li>
			<li>
			<c:url value="/admin/" var="home"></c:url>
			<a href="${home}"><i class="fa fa-dashboard fa-fw"></i> <fmt:message code="common.dashboard"/> </a></li>
			<li>
			<a href="#"><i class="glyphicon glyphicon-user  "></i>  <fmt:message code="common.etudiants"/><span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<c:url value="/etudiants/" var="etudiants"></c:url>
					<li><a href="${etudiants}"> <fmt:message code="common.listEtudiants"/></a></li>
				</ul>
			</li>
			
			<li>
			<a href="#"><i class="fa fa-graduation-cap"></i>  <fmt:message code="common.parcours"/> <span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
				<c:url value="/parcours/" var="parcours"></c:url>
					<li><a href="${parcours}"> <fmt:message code="common.listParcours"/></a></li>
				</ul>
			</li>
			
			<li>
			<a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>  <fmt:message code="common.classes"/><span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
				<c:url value="/classes/" var="classes"></c:url>
					<li><a href="${classes}"> <fmt:message code="common.listClasses"/></a></li>
				</ul>
			</li>
			
			<li>
			
			<a href="#"><i class="fa fa-level-up "></i>  <fmt:message code="common.niveau"/><span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
				<c:url value="/niveau/" var="niveau"></c:url>
					<li><a href="${niveau}"> <fmt:message code="common.listNiveau"/></a></li>
				</ul>
			</li>
			
			<li>
			<a href="#"><i class="fa fa-users "></i>  <fmt:message code="common.admins"/><span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
				<c:url value="/admins/" var="admins"></c:url>
					<li><a href="${admins}"> <fmt:message code="common.listAdmins"/></a></li>
				</ul>
			</li>
			
			<li><a href="#"><i class="fa fa-exclamation-circle"></i> <fmt:message code="common.apropos"/></a></li>
					
					
			
			
			
			
		</ul>
	</div>
	
</div>