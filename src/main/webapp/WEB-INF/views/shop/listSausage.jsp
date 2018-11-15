<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<br><br>
<div class="container" id="main">
   <div class="col-md-10 col-md-offset-1">
      <div class="panel panel-default">
      <h3>소시지류 목록</h3>
          <table class="table table-hover">
              <thead>
                <tr>
                    <th>상품코드</th> <th>&nbsp;</th> <th>상품명</th> <th>가격</th><th></th>
                </tr>
              </thead>
              <tbody>
              <c:forEach var="sausage" items="${sausage}">
              	<tr>
                    <th scope="row">${sausage.product_id}</th>
                    <td><img src="${path}/images/${sausage.picture_url}" width="150px" height="150px"></td>
                    <td><a href="${path}/shop/product/detail/${sausage.product_id}">${sausage.product_name}</a>
                    <td><fmt:formatNumber value="${sausage.price}" pattern="#,###"/></td>
                </tr>
               </c:forEach>
              </tbody>
          </table>
        </div>
    </div>
</div>

<%@ include file="../include/footer.jsp" %>

</body>
</html>