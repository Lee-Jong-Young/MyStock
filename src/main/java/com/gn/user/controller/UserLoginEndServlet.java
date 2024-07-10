package com.gn.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gn.user.service.UserService;
import com.gn.user.vo.User;


@WebServlet(name="userLoginEnd",urlPatterns="/user/loginEnd")
public class UserLoginEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UserLoginEndServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 -> 비밀번호 확인 (사용자 입력 == 회원 가입)
		//회원가입 비밀번호 암호화 != 사용자입력(원래대로임)(그래서 다시 암호화시킴(필터이용))
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		
//		User u = new UserService().loginUser(id,pw);
		User u = new User(1,"admin","ovGuikcCTW3QfbWwvUdY/npgSaqhj77bvDo54HHSamqp4EozjlVZg0y4WrK2UwoIb6EajL719jOtjHI6guKgcg=="
,"님아");
//		User u = null;
		
		
		if(u != null) {
			HttpSession session = request.getSession(true);
			if(session.isNew() || session.getAttribute("user" )== null) {
				session.setAttribute("user", u);
				session.setMaxInactiveInterval(60*30);
			}
			response.sendRedirect("/");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/views/user/login_fail.jsp");
			view.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}