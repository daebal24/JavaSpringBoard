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
						<a href="../joinus/login.jsp">로그인</a>
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
					<h2>글 수정</h2>
					<h3 class="hidden">방문페이지위치</h3>
					<form action="" method="post"  enctype="multipart/form-data">
					<div id="notice-article-detail" class="article-detail margin-large" >						
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								제목
							</dt>
							<dd class="article-detail-data">
								&nbsp;<input name="title" value="${notice.title}" />
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
								&nbsp;<input type="file" id="txtFile" name="file" />
								${notice.fileSrc}
							</dd>
						</dl>

						<div class="article-content" >
							<textarea id="txtContent" class="txtContent" name="content">
							${notice.content}
							</textarea>
						</div>						
					</div>
					<p class="article-comment margin-small">
						<input type="submit" value="수정" class="btn-save button" />
						<a class="btn-cancel button" href="noticeDetail.do?seq=${notice.seq}">취소</a>						
					</p>		
					</form>					
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
