<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="notice.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<div id="header">
			<div class="top-wrapper">
				<h2 class="hidden">메인메뉴</h2>
				<ul id="mainmenu" class="block_hlist">
					<li>
						<a href="../index.jsp">HOME</a>
					</li>
					<li>
						<a href="../joinus/logout.do">로그아웃</a>
					</li>
					<li>
						<a href="../joinus/join.jsp">회원가입</a>
					</li>
				</ul>
			</div>
		</div>
		<div id="main">
			<div class="top-wrapper clear">
				<div id="content">
					<h2>게시판</h2>
					<h3 class="hidden">게시판 목록</h3>
					<table class="article-list margin-small">
						<caption class="hidden">
							공지사항
						</caption>
						<thead>
							<tr>
								<th class="seq">번호</th>
								<th class="title">제목</th>
								<th class="writer">작성자</th>
								<th class="regdate">작성일</th>
								<th class="hit">조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="n">
							<tr>
								<td class="seq">${n.seq}</td>
								<td class="title"><a href="noticeDetail.do?seq=${n.seq}">${n.title}</a></td>
								<td class="writer">${n.writer}</td>
								<td class="regdate">${n.regdate}</td>
								<td class="hit">${n.hit}</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					<p class="article-comment margin-small">
						<a class="btn-write button" href="noticeReg.do">글쓰기</a>
					</p>
				</div>
				<div id="navi">
					
				</div>
			</div>
		</div>
		<div id="footer">
			<div class="top-wrapper">
				
			</div>
		</div>
	</body>
</html>
