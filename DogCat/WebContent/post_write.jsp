<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<meta charset="UTF-8">
		<title>post_write</title>
	<script type="text/javascript" src="post.js"></script>
	</head>
		
	<body>
	 <jsp:include page="navbar.jsp" />
	<div class="container" align = "center">
	<br><h2>POST</h2>
 	<br><h3> 동물사진을 올려주세요!</h3><br>
  </div>
<form  action="post_write.cnd"  name="form"   id="newListForm" method="post" enctype="multipart/form-data">
<div class="container" align = "center">

  	<table class="table table-striped" id ="postboard" >
			<tr>
				<td>제목</td>
				<td><input type="text" name="pTitle" size="50" id="pTitle"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td> <textarea col="50" row="30" name ="pContent" id="pContent" style="resize: none;"></textarea>
				
			</tr>
			<tr>
				<td>파일 첨부</td><td><input type="file" name="file"></td>
			</tr>
	
	
		</table>
		</div>
		<div class="container" align = "center">
	<input type="submit" value="목록으로" onclick="javascript: form.action='post_list.cnd';"/ style="float : right">
	<input type="submit" value="입력완료" style="float : right">
	</div>
	</form>
	</body>
</html>