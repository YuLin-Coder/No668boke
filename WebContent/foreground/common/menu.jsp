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
	        
	        
	        
	        	<c:forEach items="${blogTypeList }" var="blogType">
			 
					<li><a class="navbar-brand" href="${pageContext.request.contextPath}/index.action?typeId=${blogType.id }" onclick="changeClass(this)">${blogType.typename }</a></li>
					
					
			</c:forEach>
			
	 
	      </ul>
	      <form action="${pageContext.request.contextPath}/blog/search.action" class="navbar-form navbar-right" role="search" method="post" onsubmit="return checkData()">
	        <div class="form-group">
	          <input type="text" id="q" name="q" value="${q}" class="form-control" placeholder="请输入要查询的关键字">
	        </div>
	        <button type="submit" class="btn btn-default">搜索</button>
	      </form>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
</div>

