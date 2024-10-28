<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div class="data_list">
	<div class="data_list_title">
		<img
			src="${pageContext.request.contextPath}/static/images/byType_icon.png" />
		文章分类
	</div>
	<div class="datas">
		<ul>
			<c:forEach items="${blogTypeList }" var="blogType">
				<li><span> <a
						href="${pageContext.request.contextPath}/index.action?typeId=${blogType.id }">${blogType.typename }（${blogType.blogCount }）
					</a></span></li>
			</c:forEach>
		</ul>
	</div>
</div>

 
<div class="data_list">
	<div class="data_list_title">
		<img
			src="${pageContext.request.contextPath}/static/images/link_icon.png" />
		文章标签
	</div>
	<div class="datas" style="overflow: hidden;
    padding: 5px;">
		
	<c:forEach items="${tagList }" var="tag">
		<span style="float: left;
		   margin: 3px 0;
		   padding: 0 7px;
		   height: 16px;
		   line-height: 16px;
		   white-space: nowrap;"><a href="${pageContext.request.contextPath}/index.action?tagId=${tag.id }" target="_blank">${tag.tagname }</a></span>

	</c:forEach>
		
	</div>
</div>


 
