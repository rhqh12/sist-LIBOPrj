<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
		<meta name="viewport"
		content="width-device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalavble=no">
<meta charset="UTF-8">
<link href="../css/style.css" type="text/css" rel="stylesheet" />
<title>회원 정보 수정</title>
<style>
#main>h1{
	display: none;
}
table{
	border-collapse: collapse;
}
td{
	padding: 0px;
}
.table{
	width: 100%;
	border-top: 2px solid #000;
	table-layout: fixed;
	background: #fff;
}
</style>
</head>
<body>
	<div id="body" class="full-screen bg-morning">
		<header id="header">
			<div class="content-container clearfix">
				<section>
					<h1><a href="./menu/set/list">&lt; 회원 정보 수정</a></h1>
				</section>
			</div>
		</header>
		<div class="flex-container">
		<main id="main">
	<h1>회원 정보 수정 폼</h1>
	<form action="update" method="post">
	<section id="update-table">
		<table border="1" class="table">
		<tr>
		<th>아이디</th>
		<td>${member.id }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
		<td><input type="password" required="required" name="password"/>
		</tr>
		<tr>
			<td colspan = "2"><input type="submit"></td>
		</tr>
		</table>
		</section>
		</form>

		</header>
	</div>

</body>
</html>