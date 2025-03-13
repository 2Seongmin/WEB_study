package com.project1.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project1.member.model.dto.MemberDTO;
import com.project1.member.model.service.MemberService;


@WebServlet("/sign-in")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 요청 방식 = POST 방식 -> 인코딩 작업
		request.setCharacterEncoding("UTF-8");
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		// 요청 값 2개 이상 -> 객체 생성 
		MemberDTO member = new MemberDTO();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		// service단 이동
		MemberDTO loginMember = new MemberService().login(member);
		
		// Session을 이용해서 request값 전달
		HttpSession session = request.getSession();
		session.setAttribute("loginMember", loginMember);
		
		/* sendRedirect */
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
