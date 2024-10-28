<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function checkData() {

		var q = document.getElementById("q").value.trim();
		if(q == null || q == "") {
			alert("请输入您要查询的关键字！");
			return false;
		} else {
			return true;
		}
	}
</script>

<div class="col-md-12">	
	<nav class="navbar navbar-default">
	  <div class="container-fluid">				    
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	      	<li><a class="navbar-brand" href="${pageContext.request.contextPath}/index.do" onclick="changeClass(this)">博客首页</a></li>
	      	<li><a class="navbar-brand" href="${pageContext.request.contextPath}/user_index.action" onclick="changeClass(this)">我的博客</a></li>
	        <li><a class="navbar-brand" href="${pageContext.request.contextPath}/blogger/aboutme.action" onclick="changeClass(this)">关于博主</a></li>
			
			
	 
	      </ul>
	      
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
</div>

