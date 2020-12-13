<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<meta charset="UTF-8">
		<title>관리자_공지등록</title>
	<script type="text/javascript" src="list.js">
	
	</script>
	</head>
		<style>
		th { text-align: left; margin: 0 auto; }
		td { text-align: left; margin: 0 auto; }
		h2 { margin-left:  auto; margin-right: auto;}
		
		table {
		        margin-left: auto; margin-right: auto;
		      }
		    
	</style>
	<body>
	<jsp:include page="anavbar.jsp" />
	
	<div class="container" align = "center">
  <h2> 글 작성 페이지</h2>
  </div>
<form action = "anotice_write.cnd">
	<input type ="submit" value = "입력완료" style="float: right" >

  	<table class="table table-striped" id ="postboard" >
			<tr>
				<td>제목</td>
				<td><input type="text" name="nTitle" size="50" id="nTitle"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td> <textarea col="50" row="50" name =nContent style="resize: none;"></textarea>
				
			</tr>
	</form>
	<form action = "anotice.cnd">
	<input type="submit" value = "목록으로" style="float: right">
	</form>
		</table>
	</body>
</html>