<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 라이브러리 시작화면</title>
</head>
<body>
	<!-- jsp  action tag -->
	<h1>include file vs jsp:include</h1>
	<%@include file="views/include_01.jsp" %>
	
	<%-- <jsp:include page = "views/include_02.jsp"> --%>
	
	<jsp:include page="views/include_02.jsp">
		<jsp:param value="41" name="age"/>
		<jsp:param value="탭 제목" name="title"/>
	</jsp:include>
	<ul>
		<li>
			Directive tag : <%=str %>
		</li>
		<li>
			<%-- 표준 액션 태크 : <%=level %> --%>
			
		</li>
	</ul>
	<a href="views/login.jsp">로그인 페이지로 이동</a>
	<h1>EL/JSTL</h1>
	<h2>EL(Expression Language)</h2>
	<a href="/elBasic">1. el의 기본구문</a>
	<!-- EL 연산자 -->
	<a href="/elOperation">2. el의 연산자</a>
	<h2>JSTL 연습하기</h2>
	<h3>1. JSTL Core Library</h3>
	<a href="/views/jstl/01_core.jsp">core Library</a>
	
	
	
	
	
	
</body>
</html>