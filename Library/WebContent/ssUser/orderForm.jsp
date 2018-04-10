<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<Link href="${pageContext.request.contextPath }/css/unit.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="util.jsp" />
	<div id="navigation">
				<ul>
				<li class="selected"></li>
				<li><a href="${pageContext.request.contextPath }/user/rg_lg_do.action?rorl=index">首页</a></li>
				<li><a href="${pageContext.request.contextPath }/user/rg_lg_do.action?rorl=login">${uname }${userInfo.username }</a></li>
				<li><a href="${pageContext.request.contextPath }/user/rg_lg_do.action?rorl=register">${unameNext }</a></li>
				<li><a href="${pageContext.request.contextPath }/User/more.jsp">更多</a></li>
				<li><a href="${pageContext.request.contextPath }/User/aboutUs.jsp">关于我们</a></li>
				<li></li>
				</ul>
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