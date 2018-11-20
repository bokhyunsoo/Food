<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script src="${path}/ckeditor/ckeditor.js"></script>
<script>
$(function(){
	$("#btnSave").click(
			function(){
				
				var title = document.form1.title.value;
				var content = document.form1.content.value;
				
				if (title == "") {
					alert("제목을 입력하세요.");
					document.form1.title.focus();
					return;
				}
				
				document.form1.submit();
	});
});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<div class="container" id="main">
   <div class="col-md-6 col-md-offset-3">
      <div class="panel panel-default content-main">
      <h3>글쓰기</h3>
          <form id="form1" name="form1" method="post" action="${path}/board/insert.do">
              <div class="form-group">
                  <label for="title">제목</label>
                  <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요">
              </div>
              <div style="width:800px;" class="form-group">
                  <label for="price">내용</label>
                  <textarea id="content" name="content" rows="3" cols="80" placeholder="내용을 입력하세요"></textarea>
                  <script>
		CKEDITOR.replace("content",{ width:'500px',
			filebrowserUploadUrl : "${path}/imageUpload.do"
		});
		</script>
              </div>
              <div align="center">
              <button type="button" id="btnSave" class="btn btn-success">확인</button>
              </div>
          </form>
        </div>
    </div>
</div>
<%@ include file="../include/footer.jsp" %>
</body>
</html>