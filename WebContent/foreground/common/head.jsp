<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row" >

<div class="col-md-6">
	<div class="blog" style="    margin-left: 15px;">
		<a href="${pageContext.request.contextPath}/index.action" style="text-decoration:none">
			<h1><strong>个人博客系统</strong></h1>
		</a>
	</div>
</div>

 
<div align="right" style="margin-right: 60px;margin-top:30px;">
	<div >
	
		
	    <c:if test="${sessionScope.user!=null}">
	      	<a href="#" style="text-decoration:none">
				 欢迎你：${sessionScope.user.nickname}
			</a>
			<a href="${pageContext.request.contextPath}/blogger/indexinfo.do"  style="text-decoration:none">
				个人中心
			</a>
			<a href="javascript:loginout();"  style="text-decoration:none">
				退出
			</a>
	    </c:if>
	    
	     <c:if test="${sessionScope.user==null}">
	      <a href="javascript:register();" style="text-decoration:none">
			注册
		</a>
		
		<a href="javascript:login();"  style="text-decoration:none">
			登录
		</a>
	    </c:if>
	    
	    
		
	</div>
</div>
 
</div>

