<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<Link href="${pageContext.request.contextPath }/css/unit.css" rel="stylesheet" type="text/css">
<Link href="${pageContext.request.contextPath }/css/index.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/js/unit.js" type="text/javascript"></script>
<title>Index</title>
</head>
<body>
	<jsp:include page="User/util.jsp" />
	<div id="navigation">
				<ul>
				<li class="selected"></li>
				<li><a href="user/rg_lg_do.action?rorl=index">首页</a></li>
				<li><a href="user/rg_lg_do.action?rorl=login">${uname }${userInfo.username }</a></li>
				<li><a href="user/rg_lg_do.action?rorl=register">${unameNext }</a></li>
				<li><a href="User/more.jsp">更多</a></li>
				<li><a href="User/aboutUs.jsp">关于我们</a></li>
				<li></li>
				</ul>
	</div>
	<div id="forSearch">
		<form action="${pageContext.request.contextPath}/search/byName.action" method="post">
			<table border="1">
				<tr>
					<td><input type="text" size=100 maxlength=100 name="bookName" ></td><td colspan="2"><input type="submit" value="搜索" ></td>
				</tr>
			</table>

		</form>
	</div>
	<div id="justcenter">
		<h1>Welcome to the biggest library in this class！</h1>
	</div>
</body>
</html>