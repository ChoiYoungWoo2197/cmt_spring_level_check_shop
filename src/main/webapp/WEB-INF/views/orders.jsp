<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>cmt_spring_level_check</title>
	<link rel="stylesheet" href="./resources/css/style.css" />
</head>
<body>
<h1>
	주문 현항 테이블
</h1>

<table class= "bluetop">
 <tr>
    <th>주문 식별번호</th>
    <th>고객 식별번호</th>
    <th>고객 이름</th>
    <th>상품 식별번호</th>
    <th>상품명</th>
  </tr>    
<c:forEach var="data" items="${totalData}">
  <tr>
    <th>${data.orderId}</th>
    <th>${data.customId}</th>
    <th>${data.customName}</th>
    <th>${data.productId}</th>
    <th>${data.productName}</th>
  </tr>    
</c:forEach>
</table>
</body>
</html>
