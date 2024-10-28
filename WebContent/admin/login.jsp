<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">

		<link rel="stylesheet" href="<%=path%>/css/login.css">
		<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
		<title>欢迎登录个人博客系统</title>
	
		
	</head>
	<body>
		<div id="login_top">
			<div id="welcome">
				欢迎使用个人博客系统
			</div>
			<!--
		<div id="back">
			<a href="#">返回首页</a>&nbsp;&nbsp; | &nbsp;&nbsp;
			<a href="#">帮助</a>
		</div>
		-->
		</div>
		<div id="login_center">
			
			<div id="login_area">
				<div class="login-content" style="letter-spacing: 10px;">
					个人博客系统
				</div>
				<div id="login_form">
					<form action=""  name="ThisForm" method="post">
						
							<div id="login_tip" >
								登&nbsp;陆&nbsp;
							</div>
							
		                
						<div>
							
							<div id="alert-error" class="alert alert-danger" style="margin-left: 20px;padding:6px; display:none;float:left">
			                                                      用户名或密码错误
			                </div>
						</div>
						
						<div>
							<input type="text" id="uname" class="username" placeholder="用户名" name="uname" maxlength="50" />
						</div>
						<div>
							<input type="password" id="upwd" class="pwd" placeholder="密码"  name="userPw" maxlength="50">
						</div>
						<div id="btn_area">
							<input type="button" onClick="login()" id="sub_btn"
								value="登&nbsp;&nbsp;录">
							&nbsp;&nbsp;
							
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="login_bottom">
		</div>
	</body>
	<script type="text/javascript">
      function login(){
    	  var uname = $('#uname').val();
    	  var upwd = $('#upwd').val();
    	  if(!uname){
    		  $('#alert-error').text("用户名不能为空");
    		  $('#alert-error').show();
    		  return false;
    	  }
    	  if(!upwd){
    		  $('#alert-error').text("密码不能为空");
    		  $('#alert-error').show();
    		  return false;
    	  }
    	  
    	  $.post("<%=path%>/tadmin_login.action", { uname:uname,upwd:upwd,utype:0},
   			   function(data){
    		        var datas = eval(data);
    		        datas = $.trim(datas)
   			        if(datas=="false"){
   			            $('#alert-error').text("用户名密码错误");
   	    		        $('#alert-error').show();
   	    		        return false;
   			        }else{
   			        	window.location.href = '<%=path%>/admin/index.jsp';
   			        }
    		      
   		   });
    	  
      }
    
</script>
</html>