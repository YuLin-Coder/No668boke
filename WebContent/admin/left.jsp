<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=path%>/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/css/left.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/js/jquery-3.4.1.min.js"></script>
<script src="<%=path%>/css/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-pdm.js"></script>
<title>菜单栏</title>
</head>
<body>


	<!--main-->
	<div class="container-fluid mybody">
		<div class="main-wapper">
			<!--菜单-->
			<div id="siderbar" class="siderbar-wapper">

				<div class="panel-group menu" id="accordion" role="tablist" aria-multiselectable="true">
                   
                   
                    <c:if test="${sessionScope.utype==0}">
					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
									<span class="glyphicon glyphicon-list-alt"></span>
									系统管理
								</a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							<div class="list-group list-group-self">
								<a href="<%=path%>/tadmin_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									管理员管理
								</a>
                                <a href="<%=path%>/admin/tadmin/tadmin_upwd.jsp" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									修改密码
								</a>
								
							</div>
						</div>
					</div>
                
					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="heading1">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse1" aria-expanded="false" aria-controls="collapse1">
									<span class="glyphicon glyphicon-th-large"></span>
								  用户信息管理
								</a>
							</h4>
						</div>
						<div id="collapse1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading1">
							<div class="list-group list-group-self">
								<a href="<%=path%>/blogger_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									用户信息
								</a>
							</div>
						</div>
					</div>
					
					
					
					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="heading2">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse2" aria-expanded="false" aria-controls="collapse2">
									<span class="glyphicon glyphicon-th"></span>
									博客信息管理
								</a>
							</h4>
						</div>
						<div id="collapse2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading2">
							<div class="list-group list-group-self">
								
							    <a href="<%=path%>/blog_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									博客信息
								</a>
							</div>
						</div>
					</div>
					
					
					
					
					
					
					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="heading3">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse3" aria-expanded="false" aria-controls="collapse3">
									<span class="glyphicon glyphicon-th"></span>
									博客分类管理
								</a>
							</h4>
						</div>
						<div id="collapse3" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading3">
							<div class="list-group list-group-self">
								  <a href="<%=path%>/blogtype_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									博客分类
								</a>
							 
							</div>
						</div>
					</div>
					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="heading4">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse4" aria-expanded="false" aria-controls="collapse4">
									<span class="glyphicon glyphicon-th"></span>
									博客标签管理
								</a>
							</h4>
						</div>
						<div id="collapse4" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading4">
							<div class="list-group list-group-self">
								 <a href="<%=path%>/tag_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									博客标签
								</a>
							 
							</div>
						</div>
					</div>
					
					
					
					 
					
					
               </c:if>		
               
                <c:if test="${sessionScope.utype==1}">
                	<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
									<span class="glyphicon glyphicon-list-alt"></span>
									个人信息
								</a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							<div class="list-group list-group-self">
								<a href="<%=path%>/admin/blogger/blogger_info.jsp" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									个人信息
								</a>
								
								<a href="<%=path%>/admin/blogger/blogger_zhuye.jsp" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									个人主页
								</a>
								
								<a href="<%=path%>/admin/blogger/blogger_upwd.jsp" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									修改密码
								</a>
                              
							</div>
						</div>
					</div>
					
					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="heading2">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse2" aria-expanded="false" aria-controls="collapse2">
									<span class="glyphicon glyphicon-th"></span>
									博客管理
								</a>
							</h4>
						</div>
						<div id="collapse2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading2">
							<div class="list-group list-group-self">
								 
							    <a href="<%=path%>/blog_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									博客管理
								</a>
							</div>
						</div>
					</div>
					
					
					
					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="heading3">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse3" aria-expanded="false" aria-controls="collapse3">
									<span class="glyphicon glyphicon-th"></span>
									我的关注/粉丝
								</a>
							</h4>
						</div>
						<div id="collapse3" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading3">
							<div class="list-group list-group-self">
								<a href="<%=path%>/fav_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									我的关注
								</a>
							    <a href="<%=path%>/fan_list.action" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									我的粉丝
								</a>
								
								
							</div>
						</div>
					</div>
                </c:if>
                
                



				</div>

			</div>
			<!--菜单-->
			<!--内容-->
			<div id="content" class="main-content">
			   <c:if test="${sessionScope.utype==0}">
				<iframe src="<%=path%>/tadmin_list.action" style="width: 100%; height: 100%;" id="appiframe" name="appiframe" frameborder="0"></iframe>
				</c:if>

				<c:if test="${sessionScope.utype==1}">
				<iframe src="<%=path%>/admin/blogger/blogger_info.jsp" style="width: 100%; height: 100%;" id="appiframe" name="appiframe" frameborder="0"></iframe>
				</c:if>
				
				
			</div>
			<!--内容-->
		</div>

	</div>

	<!--main-->

</body>
</html>