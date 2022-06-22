<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="../css/customer.css" type="text/css" rel="stylesheet" />
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
					<h3 class="hidden">방문페이지위치</h3>
					<div id="notice-article-detail" class="article-detail margin-large" >						
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								제목
							</dt>
							<dd class="article-detail-data">
								${notice.title}
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								작성일
							</dt>
							<dd class="article-detail-data">
								${notice.regdate}
							</dd>
						</dl>
						<dl class="article-detail-row half-row">
							<dt class="article-detail-title">
								작성자
							</dt>
							<dd class="article-detail-data half-data" >
								${notice.writer}
							</dd>
						</dl>
						<dl class="article-detail-row half-row">
							<dt class="article-detail-title">
								조회수
							</dt>
							<dd class="article-detail-data half-data">
								${notice.hit}
							</dd>
						</dl>
						<dl class="article-detail-row" hidden>
							<dt class="article-detail-title">
								첨부파일
							</dt>
							<dd class="article-detail-data">
								<a href="">${notice.fileSrc}</a>
							</dd>
						</dl>

						<div class="article-content" >
							${notice.content}
						</div>
					</div>
					<p class="article-comment margin-small">
						<a class="btn-list button" href="notice.do">목록</a>						
						<a class="btn-edit button" href="noticeEdit.do?seq=${notice.seq}">수정</a>
						<a class="btn-del button" href="noticeDel.do?seq=${notice.seq}">삭제</a>
					</p>
									
				</div>				
				<div id="navi">
					
				</div>
			</div>
		</div>
		<div id="footer">
			<div class="top-wrapper">
				<h2><img src="" alt=""/></h2>
				<p>				
					
				</p>				
				<p>
				
				</p>
			</div>
		</div>
	</body>
</html>
