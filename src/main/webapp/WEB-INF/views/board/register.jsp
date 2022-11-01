<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<my:navBar active="register"></my:navBar>
		<c:url value="/board/modify" var="modifyLink">
		<c:param name="id" value="${board.id }"></c:param>
	</c:url>
	<div class="container-md">
		<div class="row">
			<div class="col">	
				<h1>게시물 작성</h1>
				<form class="mb-3" id="registerForm" action="" method="post">
					<label for="" class="form-label">제목</label> 
					<input class="form-control" type="text" name="title"> <br>
					<label for="" class="form-label">저자</label> 
					<input class="form-control" type="text" name="writer"> <br>
					<label for="" class="form-label">본문</label> 
					<textarea class="form-control" name="content" id="" cols="30" rows="10"></textarea> <br>
				</form>
				<input type="submit" value="등록" data-bs-toggle="modal" data-bs-target="#registerModal">
				
				<!-- registerModal -->
				<div class="modal fade" id="registerModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h1 class="modal-title fs-5" id="exampleModalLabel">등록 확인</h1>
				        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				      </div>
				      <div class="modal-body">
				        등록하시겠습니까?
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
				        <button id="registerConfirmButton" type="button" class="btn btn-primary">확인</button>
				      </div>
				    </div>
				  </div>
				</div>	
			</div>
		</div>
	</div>		
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script>
	document.querySelector("#registerConfirmButton").addEventListener("click", function() {
		document.querySelector("#registerForm").submit();
	});
</script>
</body>
</html>