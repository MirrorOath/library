<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<Link href="${pageContext.request.contextPath }/css/unit.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/js/unit.js" type="text/javascript"></script>
<title>userarea</title>
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
	
	<div>
		<ul>
			<li>${userInfo.username }</li>
			<li>${userInfo.pwd }</li>
			<li>${userInfo.age }</li>
			<li>${userInfo.id }</li>
			<li>${userInfo.date }</li>
		</ul>
	</div>
	<div>
		<form action="${pageContext.request.contextPath}/admin/rePwd.action" method="post">
			<table border="1">
				<caption><h2>修改密码</h2></caption>
				<tr>
					<td><input type="text" size="20" name="repwd" required onkeyup="checkpwd(this) " ></td>
					<td colspan="2"><input type="submit" value="修改" name="subbutton" disabled=true ></td>
				</tr>
			</table>

		</form>
	</div>
	<div>
	<a href="${pageContext.request.contextPath}/cart/seeCart.action" target=_blank>查看购物车</a>
	<br>
	<a href="${pageContext.request.contextPath}/order/seeOrder.action" target=_blank>查看订单</a>
	</div>
</body>
</html>