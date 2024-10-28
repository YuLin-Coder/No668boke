<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=path%>/css/top.css" rel="stylesheet" type="text/css">
<title>菜单栏</title>
</head>
<body>

	<header id="header">
	<div id="menu">
		<div id="logo">
			<div>
			 
			</div>
			<div id="system_title">个人博客系统</div>
		</div>
		<div id="rinfo">
			当前用户：
			  <span>
                 
                 <c:if test="${sessionScope.utype==0}">${sessionScope.cuser.name}【管理员】</c:if>
                 <c:if test="${sessionScope.utype==1}">${sessionScope.user.nickname}【博主】</c:if>
                 
             </span>
			<span id="exit">
				<c:if test="${sessionScope.utype==0||sessionScope.utype==null}">
				<a href="#" onclick="exit();">退出</a>
				</c:if>
				<c:if test="${sessionScope.utype==1}">
				<a href="#" onclick="fanhui();">返回</a>
				</c:if>
			</span>
		</div>
	</div>
	</header>
 <script type="text/javascript">
    function exit(){
    	window.top.location.href = '<%=path%>/tadmin_loginout.action';
    }
    
     function fanhui(){
    	window.top.location.href = '<%=path%>/index.action';
    }
 </script>
</body>
</html>