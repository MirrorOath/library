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
			<tr>
				<td>${form.id }</td><td>${form.totalPrice }</td><td>${form.address }</td><td>${form.date }</td>
			</tr>
		</table>
		<table border=1>
			<tr>
				<th>详单单号</th><th>图书预览</th><th>书名</th><th>出版社</th><th>作者</th><th>数量</th>
			</tr>
			<c:forEach var="detail" items="${details }" varStatus = "sta">
				<tr>
					<td>${detail.id }</td>
					<td><img alt="Error" src="../${detail.bookInfo.imageSrc }" ></td>
					<td>${detail.bookInfo.bookName }</td><td>${detail.bookInfo.press }</td><td>${detail.bookInfo.author }</td>
					<td>${detail.bookCount }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>