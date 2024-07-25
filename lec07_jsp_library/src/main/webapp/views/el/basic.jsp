<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Basic</title>
</head>
<body>
	<h3>1. 기존방식으로 작성(스크립틀릿)</h3>
	<%@ page import = "com.jy.vo.Person" %>
	<%
		Person s = (Person)request.getAttribute("student");
		Person t = (Person)session.getAttribute("teacher");
	%>
	<!-- 실제 태그 -->
	<ol>
		<li>학생 : <%=s.getName() %></li>
		<li>강사 : <%=t.getName() %></li>
	</ol>
	<h3>2. El방식</h3>
	<ol>
		<!-- el방식으로 학생 입력값을 가져올꺼
		알아서 getter로 읽음 -->
		<li>${student.age}세</li>
		<li>${teacher.age}세</li>
		
	</ol>
	<h3>3. 여러 내장객체에 저장된 key값이 동일할 때 <h3></h3>
	<% pageContext.setAttribute("test","페이지"); %>
	<span>${test}</span>
	<p>
		page 에 담긴 값 : ${pageScope.test }<br>
		request 에 담긴 값 : ${requestScope.test }<br>
		session 에 담긴 값 : ${sessionScope.test }<br>
		application 에 담긴 값 : ${applicationScope.test }    
	</p>
	
</body>
</html>