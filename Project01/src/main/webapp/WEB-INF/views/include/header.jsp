<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet">

    <link rel="stylesheet" href="resources/css/Header.css">
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">
            <img src="resources/img/coffee_logo.png" alt="카페 로고" style="width:130px; height: 100px;">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
            메뉴 <i class="fas fa-bars"></i>
        </button>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="index.jsp">홈</a></li>
                <li class="nav-item"><a class="nav-link" href="menu.jsp">메뉴</a></li>
                <li class="nav-item"><a class="nav-link" href="store.jsp">매장찾기</a></li>
                <li class="nav-item"><a class="nav-link" href="order.jsp">멤버십</a></li>
	
                <c:choose>
                    <c:when test="${empty loginMember}">
                        <li class="nav-item"><a class="nav-link" href="#" data-toggle="modal" data-target="#log-in">로그인</a></li>
                        <li class="nav-item"><a class="nav-link" href="join.jsp">회원가입</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item"><a class="nav-link" href="myPage.jsp">내정보</a></li>
                        <li class="nav-item">
                            <a class="nav-link" href="logout.jsp" onclick="return confirm('로그아웃 하시겠습니까?')">로그아웃</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>


  <!-- 로그인 Modal-->
	<div class="modal fade" id="log-in">
		<div class="modal-dialog">
			<div class="modal-content">
			
				<!-- Modal body -->
				<div class="modal-body">
	
					<form action="/firstweb/sign-in" name="sign-in" method="post" id="signInForm"
						style="margin-bottom: 0;">
						<table style="cellpadding: 0; cellspacing: 0; margin: 0 auto; width: 100%">
							<tr>
								<td style="text-align: left">
									<p><strong>아이디를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="idCheck"></span></p>
								</td>
							</tr>
							<tr>
								<td><input type="text" name="memberId" id="signInId"
									class="form-control tooltipstered" maxlength="10"
									required="required" aria-required="true"
									style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
									placeholder="최대 15자"></td>
							</tr>
							<tr>
								<td style="text-align: left">
									<p><strong>비밀번호를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="pwCheck"></span></p>
								</td>
							</tr>
							<tr>
								<td><input type="password" size="17" id="signInPw"
									name="memberPw" class="form-control tooltipstered" 
									maxlength="20" required="required" aria-required="true"
									style="ime-mode: inactive; margin-bottom: 25px; height: 40px; border: 1px solid #d9d9de"
									placeholder="최소 20자"></td>
							</tr>
							
							<tr>
								<td style="width: 100%; text-align: center; colspan: 2;"><input
									type="submit" value="로그인" class="btn form-control tooltipstered" id="signIn-btn"
									style="background-color: #52b1ff; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
