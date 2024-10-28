<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="data_list">
 
	<div class="datas search">
		<ul>
			<c:choose>
				<c:when test="${blogList.size()==0 }">
					<div align="center" style="padding-top:20px">未查询到结果，请换个关键字试试>_<</div>
				</c:when>
				<c:otherwise>
					<c:forEach items="${blogList }" var="blog">
						 <li style="margin-bottom: 20px">
						  	<span class="title">
						  		<img alt="文章类型" src="${pageContext.request.contextPath}/static/userImages/yuan.jpg">
						  		<a href="${pageContext.request.contextPath}/blog/articles/${blog.id }.action" target="_blank">${blog.title }</a></span>
						  	<span class="summary">摘要: ${blog.content }...</span>
						  	 
						 </li>						
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
 
</div>