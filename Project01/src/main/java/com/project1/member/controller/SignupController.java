package com.project1.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project1.member.model.dto.MemberDTO;
import com.project1.member.model.service.MemberService;


@WebServlet("/join")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SignupController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 인코딩
		request.setCharacterEncoding("UTF-8");
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String email = request.getParameter("email");
		
		MemberDTO member = new MemberDTO(memberId, memberPw, memberName, email, null);
		
		// request 처리
		int result = new MemberService().signUp(member);
		
		/////////////
		String path = request.getContextPath();
		
		response.sendRedirect(result != 0 ? path + "/sign-up" : path);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
