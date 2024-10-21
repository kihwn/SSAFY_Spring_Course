<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
</head>
<body>
<!--  얘가 어떻게 변수명만으로 넘어오지? -->
	${fileName}
	<a href="/img/${fileName}"> ${fileName}</a>
	<img src="/img/${fileName}">
	
	<!-- 이 버튼을 누르면 디스패처 서블릿으로 "/downLoad라는 요청이 날아가는데 이 때 쿼리 스트링으로 파일 이름이 날아감 -->
	<a href="/download?fileName=${fileName}">이미지 다운로드</a>
	

</body>
</html>