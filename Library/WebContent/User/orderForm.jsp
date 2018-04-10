<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${pageContext.request.contextPath }/easyUI/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath }/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/easyUI/themes/default/easyui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/easyUI/themes/icon.css">
<script src="${pageContext.request.contextPath }/easyUI/jquery.easyui.min.js"></script>
<script src="${pageContext.request.contextPath }/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="util.jsp" />
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default" role="navigation">
					<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="${pageContext.request.contextPath }/user/rg_lg_do.action?rorl=index">首页</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li>
							 <a href="${pageContext.request.contextPath }/user/rg_lg_do.action?rorl=login">${uname }${userInfo.username }</a>
						</li>
						<li>
							 <a href="${pageContext.request.contextPath }/user/rg_lg_do.action?rorl=register">${unameNext }</a>
						</li>
						<li>
							 <a href="${pageContext.request.contextPath }/User/more.jsp">更多</a>
						</li>
						<li>
							 <a href="${pageContext.request.contextPath }/User/aboutUs.jsp">关于我们</a>
						</li>
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">更多<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									 <a href="${pageContext.request.contextPath}/cart/seeCart.action" target=_blank>查看购物车</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
</div>
	
	<div>
		<table border=1>
			<tr>
				<th>订单号</th><th>总价</th><th>地址</th><th>日期</th>
			</tr>
			<c:forEach var="order" items="${orders }" varStatus = "sta">
				<tr>
					<td>${order.id }</td><td>${order.totalPrice }</td><td>${order.address }</td><td>${order.date }</td>
					<td><a href="${pageContext.request.contextPath}/order/seeDetail.action?formId=${order.id }" target=_blank>详细</a></td>
					<td><a href="${pageContext.request.contextPath}/order/delForm.action?formId=${order.id }" >删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>