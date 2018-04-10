<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<Link href="${pageContext.request.contextPath }/css/unit.css" rel="stylesheet" type="text/css">
<title>more</title>
</head>
<body>
	<jsp:include page="util.jsp" />
	<div id="navigation">
				<ul>
				<li class="selected"></li>
				<li><a href="${pageContext.request.contextPath }/user/rg_lg_do.action?rorl=index">首页</a></li>
				<li><a href="${pageContext.request.contextPath }/user/rg_lg_do.action?rorl=login">${uname }${userInfo.username }</a></li>
				<li><a href="${pageContext.request.contextPath }/user/rg_lg_do.action?rorl=register">${unameNext }</a></li>
				<li><a href="more.jsp">更多</a></li>
				<li><a href="aboutUs.jsp">关于我们</a></li>
				<li></li>
				</ul>
	</div>
	<h1>我们对你已经毫无保留啦！</h1>
</body>
</html>