<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<Link href="${pageContext.request.contextPath }/css/unit.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/js/unit.js" type="text/javascript"></script>
<title>login</title>
</head>
<body>
	<jsp:include page="util.jsp" />
	<div id="navigation">
				<ul>
				<li class="selected"></li>
				<li><a href="${pageContext.request.contextPath }/user/rg_lg_do.action?rorl=index">首页</a></li>
				<li><a href="${pageContext.request.contextPath }/user/rg_lg_do.action?rorl=login">登录</a></li>
				<li><a href="${pageContext.request.contextPath }/user/rg_lg_do.action?rorl=register">注册</a></li>
				<li><a href="more.jsp">更多</a></li>
				<li><a href="aboutUs.jsp">关于我们</a></li>
				<li></li>
				</ul>
	</div>
	
	<div>
		<form action="${pageContext.request.contextPath}/user/login.action" method="post">
			<table border="1">
				<caption><h2>用户登录</h2></caption>
				<tr>
					<td> 账号：</td><td><input type="text" size="20" name="username" required></td>
				</tr>
				<tr>
					<td> 密码：</td><td><input type="password" size="20" name="pwd" onkeyup="checkpwd(this) " ></td>
				</tr>
				<tr>
					<td><td colspan="2"><input type="submit" value="登录" name="subbutton" disabled=true ></td>
				</tr>
			</table>
		</form>
	</div>
	<div>${msg }</div>
</body>
</html>