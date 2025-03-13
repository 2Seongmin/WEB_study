<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카페 홈페이지</title>
    <link rel="stylesheet" href="resources/css/Main.css">
</head>
<body>

    <div class="hero-section">
        <h1>Welcome Page !</h1>
    </div>

    <div class="menu-section">
        <h2>우리의 인기 메뉴</h2>
        <div class="menu-item">
            <span>카페 라떼</span>
            <span>4,500원</span>
        </div>
        <div class="menu-item">
            <span>아메리카노</span>
            <span>3,500원</span>
        </div>
        <div class="menu-item">
            <span>카푸치노</span>
            <span>4,000원</span>
        </div>
        <div class="menu-item">
            <span>핸드드립 커피</span>
            <span>5,000원</span>
        </div>
    </div>

    <jsp:include page="../include/footer.jsp" />

</body>
</html>
