<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
<%@ include file="include/header.jsp" %>
</head>
<body>
<%@ include file="include/menu.jsp" %>
<br><br><br><br><br><br><br>
<c:if test="${sessionScope.name != null}">
${sessionScope.name}(${sessionScope.userid})님 환영합니다.
</c:if>

<%@ include file="include/footer.jsp" %>
</body>
</html>
