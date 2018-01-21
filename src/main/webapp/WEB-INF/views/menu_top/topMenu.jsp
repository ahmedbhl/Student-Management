<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<div class="navbar-header">
	<button type="button" class="navbar-toggle" data-toggle="collapse"
		data-target=".navbar-collapse">
		<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
		<span class="icon-bar"></span> <span class="icon-bar"></span>
	</button>
	<a class="navbar-brand" href="index.html"><fmt:message code="common.topMenu.titre"/></a>
</div>
<!-- /.navbar-header -->

<ul class="nav navbar-top-links navbar-right">
	<li class="dropdown"><a class="dropdown-toggle"
		data-toggle="dropdown" href="#"> <i class="fa fa-envelope fa-fw"></i>
			<i class="fa fa-caret-down"></i>
	</a>
		<ul class="dropdown-menu dropdown-messages">
			<li><a href="#">
					<div>
						<strong>John Smith</strong> <span class="pull-right text-muted">
							<em>Yesterday</em>
						</span>
					</div>
					<div>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Pellentesque eleifend...</div>
			</a></li>
			<li class="divider"></li>
			<li><a href="#">
					<div>
						<strong>John Smith</strong> <span class="pull-right text-muted">
							<em>Yesterday</em>
						</span>
					</div>
					<div>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Pellentesque eleifend...</div>
			</a></li>
			<li class="divider"></li>
			<li><a href="#">
					<div>
						<strong>John Smith</strong> <span class="pull-right text-muted">
							<em>Yesterday</em>
						</span>
					</div>
					<div>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Pellentesque eleifend...</div>
			</a></li>
			<li class="divider"></li>
			<li><a class="text-center" href="#"> <strong>Read
						All Messages</strong> <i class="fa fa-angle-right"></i>
			</a></li>
		</ul> 
		<!-- /.dropdown-messages --></li>
		

	<li class="dropdown"><a class="dropdown-toggle"
		data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
			<i class="fa fa-caret-down"></i>
	</a>
		<ul class="dropdown-menu dropdown-user">
			<li><a href="#"><i class="fa fa-user fa-fw"></i> <fmt:message code="common.profil"/></a></li>
			<li><a href="#"><i class="fa fa-gear fa-fw"></i> <fmt:message code="common.paramettre"/></a></li>
			<li class="divider"></li>
			<c:url value="/changelocale/fr" var="frUrl"></c:url>
			<c:url value="/changelocale/en" var="enUrl"></c:url>
			<c:url value="/changelocale/ar" var="arUrl"></c:url>
			<li><a href="${frUrl}"><i class="fa fa-globe fa-fw"></i> <fmt:message code="locale.fr"/></a></li>
			<li><a href="${enUrl}"><i class="fa fa-globe fa-fw"></i> <fmt:message code="locale.en"/></a></li>
			<li><a href="${arUrl}"><i class="fa fa-globe fa-fw"></i> <fmt:message code="locale.ar"/></a></li>
			<li class="divider"></li>
			<c:url value="/j_spring_security_logout" var="logout" />
			<li><a href="${logout}"><i class="fa fa-sign-out fa-fw"></i><fmt:message code="common.deconnection"/></a></li>
		</ul> <!-- /.dropdown-user --></li>
	<!-- /.dropdown -->
</ul>
<!-- /.navbar-top-links -->