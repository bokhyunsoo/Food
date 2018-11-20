<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script src="${path}/include/js/common.js"></script>
<script src="${path}/ckeditor/ckeditor.js"></script>
<script>
$(function(){
	$("#btnUpdate").click(function(){
		if(confirm("게시글을 정말 수정하시겠습니까?")){
		document.form1.action="${path}/board/update.do";
		document.form1.submit();
		}
	});
	
	$("#btnDelete").click(function(){
		if(confirm("게시글을 정말 삭제하시겠습니까?")){
		document.form1.action="${path}/board/delete.do";
		document.form1.submit();
		}
	});
});
</script>
<style>
.my-hr1 {
    border: 0;
    height: 1px;
    background: #ccc;
  }
</style>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<div class="container" id="main">
   <div class="col-md-10 col-md-offset-1">
      <div class="panel panel-default">
      <form id="form1" name="form1" method="post">
      	<table class="table table-hover">
      	<tr>
      	<td>작성일자 : <fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd a HH:mm:ss"/></td>
      	</tr>
      	<tr>
      	<td>조회수 : ${dto.viewcnt}</td>
      	</tr>
      	<tr>
      	<td>작성자 : ${dto.writer}</td>
      	</tr>
      	<tr>
      	<td>제목 : <input name="title" value="${dto.title}" size="60"></td>
      	</tr>
      	<tr>
      	<td>내용 : <textarea rows="3" cols="80" name="content">
      	${dto.content}</textarea>
      	<script>
		CKEDITOR.replace("content",{filebrowserUploadUrl : "${path}/imageUpload.do"});
		</script>
		</td>
		</tr>
		</table>
		
		<table align="center">
		<tr><td>
		<input type="hidden" name="bno" value="${dto.bno}">
		<br><br>
		<c:if test="${sessionScope.userid == dto.writer}">
		<button type="button" id="btnUpdate" class="btn btn-success">수정</button>
		<button type="button" id="btnDelete" class="btn btn-success">삭제</button>
		</c:if>
		<button type="button" id="btnList" class="btn btn-success">목록</button>
      	</td></tr>
      	</table>
      	<br>
      	<table align="center">
      	<tr>
      	<td>
      		<div id="modifyReply" align="center"></div>
      	</td>
      	</tr>
      	</table>
      	<br>
      	<br>
      </form>
        </div>
    </div>
</div>

<%@ include file="../include/footer.jsp" %>
</body>
</html>