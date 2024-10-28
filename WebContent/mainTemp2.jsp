<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/blog.css">
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
 
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/static/js/layer/layer.js"></script>

<title>${title }</title>
<script type="text/javascript">
	function changeClass(obj) {
		var li = obj.parentNode; //获取父节点
		li.className = "active";
	}
</script>
<style type="text/css">
	body{
		
		padding-bottom:40px;
		background-color: #F5F5F5;
		font-family: microsoft yahei;
	}
</style>
</head>

<body>
	<div class="container" style="width: 1200px">
	
		<div class="row">
			<jsp:include page="/foreground/common/head.jsp"/>
		</div>
	
		<div class="row" style="padding-top: 20px">
			<jsp:include page="/foreground/common/menu2.jsp"/>
		</div>
				
		<div class="row">		  	  
			  <div class="col-xs-9">
				  <jsp:include page="${commonPage}"/>
			  </div>	
			  <div class="col-xs-3">
				  <jsp:include page="/foreground/blog/rightList2.jsp"/>		  	
			  </div>		  
		</div>
		
		<div class="row">
			<jsp:include page="/foreground/common/footer.jsp"/>
		</div>
		
	</div>
 
</body>


<script type="text/javascript">
function register(){
	   
	      layer.open({
		      type: 2,
		      offset:"100px",
		      title: '注册',
		      maxmin: false,
		      shadeClose: true, //点击遮罩关闭层
		      area : ['600px' , '600px'],
		      content: '${pageContext.request.contextPath}/foreground/register.jsp'
	    });
	 
}


function login(){
	   
    layer.open({
	      type: 2,
	      title: '登录',
	      maxmin: false,
	      shadeClose: true, //点击遮罩关闭层
	      area : ['500px' , '400px'],
	      content: '${pageContext.request.contextPath}/foreground/login.jsp'
  });

}


function loginout(){
	   
     window.location.href = '${pageContext.request.contextPath}/blogger/loginout.do';

}



</script>


</html>
