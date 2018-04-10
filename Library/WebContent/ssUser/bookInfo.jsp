<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<Link href="${pageContext.request.contextPath }/css/unit.css" rel="stylesheet" type="text/css">
<title>bookInfo</title>
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
	<table border=1>
		<tr>
			<th>图书预览</th><th>书名</th><th>出版社</th><th>作者</th>
		</tr>
		<tr>
			<td><img alt="Error" src="../${book.imageSrc }" ></td>
			<td>${book.bookName }</td><td>${book.press }</td><td>${book.author }</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/cart/addBook.action?userId=${userInfo.id }&bookId=${book.bookId }" >加入购物车</a>
	<a href="${pageContext.request.contextPath}/cart/seeCart.action?userId=${userInfo.id }" target=_blank>查看购物车</a>
</body>
</html>