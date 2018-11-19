<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script>
	function product_delete(){
		if(confirm("삭제하시겠습니까?")){
			document.form1.action="${path}/shop/product/skewerdelete.do";
			document.form1.submit();
		}
	}
	function product_update() {
		var product_name = document.form1.product_name.value;
		var price = document.form1.price.value;
		if (product_name == "") {
			alert("상품명을 입력하세요.");
			document.form1.product_name.focus();
			return;
		}
		if (price == "") {
			alert("가격을 입력하세요");
			document.form1.price.focus();
			return;
		}
		document.form1.action = "${path}/shop/product/skewerupdate.do";
		document.form1.submit();
	}
</script>
</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>
<br><br>
<form name="form1" method="post" enctype="multipart/form-data">
<div class="container" id="main">
   <div class="col-md-10 col-md-offset-1">
      <div class="panel panel-default">
    <h3>꼬치류 변경</h3>
    <table class="table table-hover">
	<tr>
		<td>상품명</td>
		<td><input name="product_name" id="product_name" value="${skewer.product_name}"></td>
	</tr>
	<tr>
		<td>가격</td>
		<td><input name="price" id="price" value="${skewer.price}"></td>
	</tr>
	<tr>
		<td>상품이미지</td>
		<img src="${path}/images/${skewer.picture_url}" width="400px" height="300px">
		<td><input type="file" name="picture_file" id="picture_file"></td>
	</tr>
	<tr>
		<td>상품설명</td>
		<img src="${path}/images/${skewer.description}" width="130px" height="600px">
		<td><input type="file" name="description_file" id="description_file"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="hidden" name="product_id" value="${skewer.product_id}">
			<input type="hidden" name="v" value="0">
			<!-- <button type="submit" class="btn btn-success">수정</button> -->
			<input type="button" onclick="product_update()" value="수정" class="btn btn-success">
			<input type="button" onclick="product_delete()" value="삭제" class="btn btn-success">
			<input type="button" value="목록" onclick="location.href='${path}/shop/product/skewerlist.do'" class="btn btn-success">
		</td>
	</tr>
</table>
</div>
</div>
</div>
</form>
<%@ include file="../include/footer.jsp" %>
</body>
</html>