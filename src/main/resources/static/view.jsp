<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/addNotice" enctype="multipart/form-data">
		<div>
			제목 : <input type="text" name="noticeTitle">
		</div>
		<div>
			내용 : <input type="text" name="noticeContent">
		</div>
		<div>
			파일 : <input type="file" name="noticefileList" multiple="multiple">
		</div>
		<div>
			<button type="submit">입력</button>
		</div>
	</form>
</body>
</html>