<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="login.css" type="text/css" rel="stylesheet" />
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
					<h2>로그인</h2>
					<h3 class="hidden">회원가입 폼</h3>
					<div id="join-form" class="join-form margin-large" >						
						<form action="../joinus/loginConfirm.do" method="post">                            
							<fieldset>
                                <legend class="hidden">로그인 폼</legend>
                                <ul id="loginBox">
                                    <li><label for="uid">아이디</label><input name="UserName" class="text" /></li>
                                    <li><label for="pwd">비밀번호</label><input type="password" name="Password" class="text" /></li>
                                </ul>
                                <p><input type="submit" id="btnLogin" value="" /></p>
                                <ul id="loginOption">
                                    <li><span>아이디가 없으신 분은 회원가입을 해주세요.</span><a href="../joinus/join.jsp"><img alt="회원가입" src="images/btnJoin.png" /></a></li>
                                </ul>
                            </fieldset>
						</form>
					</div>
					
				</div>
				<div id="navi">
					<h2>메뉴</h2>
					<ul id="navi-menu">
						<li>
							<a href="../index.jsp">HOME</a>
						</li>
						<li>
							<a href="../joinus/login.jsp">로그인</a>
						</li>
						<li>
							<a href="../joinus/join.jsp">회원가입</a>
						</li>
						<li>
							<a href="../customer/notice.do">게시판이동</a>
						</li>				
					</ul>
                    <h3 id="fav-title"></h3>
					<ul class="margin-small">
						<li>
							<a href=""><img src="" alt="" /></a>
						</li>
						<li>
							<a href=""><img src="" alt="" /></a>
						</li>
						<li>
							<a href=""><img src="" alt="" /></a>
						</li>
					</ul> 
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
