<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script>
function list(page){
	location.href="${path}/shop/product/doglist.do?curPage="+page;
}
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<c:choose>
<c:when test="${sessionScope.admin_userid != null}">
<%@ include file="../include/admin_menu.jsp" %>
</c:when>
<c:otherwise>
<%@ include file="../include/menu.jsp" %>
</c:otherwise>
</c:choose>
<br><br>
<div class="container" id="main">
   <div class="col-md-10 col-md-offset-1">
      <div class="panel panel-default">
      <h3>핫도그류 목록</h3>
      	  <table align="right">
      		<tr>
      			<td>
      			<c:if test="${sessionScope.admin_userid != null}">
					<button type="button" id="btnAdd" class="btn btn-success"
					onclick="location.href='${path}/shop/product/dogwrite.do'">상품등록</button>
				</c:if>
      			</td>
      		</tr>
		  </table>
          <table class="table table-hover">
              <thead>
                <tr>
                    <th>상품코드</th> <th>&nbsp;</th> <th>상품명</th> <th>가격</th><th></th>
                </tr>
              </thead>
              <tbody>
              <c:forEach var="dog" items="${dog}">
              	<tr>
                    <th scope="row">${dog.product_id}</th>
                    <td><img src="${path}/images/${dog.picture_url}" width="150px" height="150px"></td>
                    <td><a href="${path}/shop/product/detail/${dog.product_id}">${dog.product_name}</a>
                    <c:if test="${sessionScope.admin_userid != null }">
					<a href="${path}/shop/product/dogedit/${dog.product_id}">
					<button type="button" id="btnAdd" class="btn btn-success">편집</button>
					</a>
					</c:if>
                    <td><fmt:formatNumber value="${dog.price}" pattern="#,###"/></td>
                </tr>
               </c:forEach>
              </tbody>
              <tr>
					<td colspan="5" align="center">
					<c:if test="${map.pager.curBlock > 1}">
					<a href="#" onclick="list('1')">[처음]</a>
					</c:if>
					<c:if test="${map.pager.curBlock > 1}">
					<a href="#" onclick="list('${map.pager.prevPage}')">[이전]</a></c:if>
					<c:forEach var="num" begin="${map.pager.blockBegin}" end="${map.pager.blockEnd}">
					<c:choose>
					<c:when test="${num == map.pager.curPage}">
					<!-- 현재 페이지인 경우 하이퍼링크 제거 -->
						<span style="color:red;">${num}</span>
					</c:when>
					<c:otherwise>
						<a href="#" onclick="list('${num}')">${num}</a>
					</c:otherwise>
					</c:choose>
					</c:forEach>
					<c:if test="${map.pager.curBlock < map.pager.totBlock}">
					<a href="#" onclick="list('${map.pager.nextPage}')">[다음]</a>
					</c:if>
					<c:if test="${map.pager.curPage < map.pager.totPage}">
					<a href="#" onclick="list('${map.pager.totPage}')">[끝]</a>
					</c:if>
					</td>
				</tr>
          </table>
        </div>
    </div>
</div>

<%@ include file="../include/footer.jsp" %>

</body>
</html>