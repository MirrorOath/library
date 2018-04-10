<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<Link href="${pageContext.request.contextPath }/css/unit.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/js/cart.js" type="text/javascript"></script>
<title>cart</title>
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
		<form action="${pageContext.request.contextPath}/order/placeOrder.action" method="post" >
		
			<input type="checkbox" name="choseAll"
						onclick = "checkAll()">全选
			<input type="submit" value="结算" name="settlement" >
			<table border=1>
				<tr>
					<th></th><th>图书预览</th><th>书名</th><th>出版社</th><th>作者</th><th>数量</th>
				</tr>
				<c:forEach var="cart" items="${cartInfo }" varStatus = "sta">
					<tr>
						<td><input type="checkbox" name="cartBook" value="${cart.bookInfo.bookId }"></td>
						<td><img alt="Error" src="../${cart.bookInfo.imageSrc }" ></td>
						<td>${cart.bookInfo.bookName }</td><td>${cart.bookInfo.press }</td><td>${cart.bookInfo.author }</td>
						<td>${cart.bookCount }</td>
						<td><a href="${pageContext.request.contextPath}/cart/delectCart.action?bookId=${cart.bookInfo.bookId }" >删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>