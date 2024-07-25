package com.jy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jy.vo.Person;


@WebServlet("/elBasic")
public class ELBasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ELBasicServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request scope에 데이터 담기
		//Person p1 = new Person("김철수",25)랑 같음 p1 키값임 이거랑 밑에 꺼랑 같음
		//어디로 도착할 것인지 정하는 거지 바로가는 게 아님
		request.setAttribute("student", new Person("김철수",25));
		//session scope가 request보다 큼 
		
		HttpSession session = request.getSession(true);
		session.setAttribute("teacher", new Person("홍길동",56));
		
		//다른 application scope에 데이터 담기
		ServletContext application = request.getServletContext();
		application.setAttribute("test", "애플리케이션");
		// 똑같은 key값을 가진 데이터 다른 scope로 보내기 
		request.setAttribute("test", "리쿠에스트");
		session.setAttribute("test", "세션");
		
		
		
		//어디에 데이터를 전달할 것인가
		RequestDispatcher view = request.getRequestDispatcher("/views/el/basic.jsp");
		//실제 전달하는 forward
		view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
