<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="data_list">
  		<div class="data_list_title">
			<img src="${pageContext.request.contextPath}/static/images/list_icon.png"/>&nbsp;最新博客
		</div>	
		<div class="datas">
			<ul>	
				<c:forEach items="${blogList}" var="blog">
					<li style="margin-bottom: 30px">
					  	<span class="title">
					  		<img alt="文章类型" src="${pageContext.request.contextPath}/static/userImages/yuan.jpg">
					  		<a href="${pageContext.request.contextPath}/blog/articles/${blog.id}.action">${blog.title }</a>
					  	</span>
					  	<span class="summary">摘要: ${blog.summary }....</span>
					  	<span class="img">
					  		<font color="#999">分类：<font color="#33a5ba">${blog.blogtypeVO.typename }</font> </font> 
					  		<font color="#999">标签：<font color="#33a5ba">${blog.tagVO.tagname}</font> </font> 
	
					  	</span>
					  	<span class="info">
					  		<font color="#999">${blog.cdate}</font> &nbsp;&nbsp;
					  		<font color="#33a5ba">阅读<font color="#999">(${blog.clickhit })</font>&nbsp;&nbsp;</font>
					  		<font color="#33a5ba">评论<font color="#999">(${blog.replyhit })</font>&nbsp;&nbsp;</font>
					  		<font color="#33a5ba">点赞<font color="#999">(${blog.likenum })</font>&nbsp;&nbsp;</font>  	
					  	</span>
					</li>
					<hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:10px;" />	
				</c:forEach>																											
			</ul>			
		</div>  
		
		<div style="text-align: center;">
			<nav>
			  <ul class="pagination">
			    ${pageCode }
			 </ul>
			</nav>
		</div>			
</div>
