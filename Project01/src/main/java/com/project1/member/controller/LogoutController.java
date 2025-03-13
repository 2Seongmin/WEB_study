package com.project1.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/log-out")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LogoutController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Session 로그인 방식에서 로그아웃
		request.getSession().removeAttribute("loginMember");
		
		/* 로그인에서 생성된 contextPath
		 * 	response.sendRedirect(contextPath);
		 */
		response.sendRedirect(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
