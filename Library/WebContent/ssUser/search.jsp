<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<Link href="${pageContext.request.contextPath }/css/unit.css" rel="stylesheet" type="text/css">
<Link href="${pageContext.request.contextPath }/css/search.css" rel="stylesheet" type="text/css">
<title>search</title>
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
		<form action="${pageContext.request.contextPath}/search/byName.action" method="post">
			<table border="1">
				<tr>
					<td><input type="text" size=100 maxlength=100 required name="bookName"></td><td colspan="2"><input type="submit" value="搜索" ></td>
				</tr>
			</table>

		</form>
	</div>
	<div id="forSearch">
		<a href="${pageContext.request.contextPath }/search/changePage.action?page=${pageBean.currentPage-1 }" id="lastPage">上一页</a>
		<a href="${pageContext.request.contextPath }/search/changePage.action?page=${pageBean.currentPage+1 }" id="nextPage">下一页</a>
		<div style="clear: both"></div>
		<c:forEach var="book" items="${books }" varStatus="sta">
			<div class="imgdiv" >
				<div>
					<a href="${pageContext.request.contextPath }/search/bookInfo.action?bookId=${book.bookId } "  target=_blank>
						<img alt="Error" src="../${book.imageSrc }" ></a>
				</div>
				<div>
					<p>${book.bookName }</p><p>${book.press }</p><p>${book.author }</p>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>