<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="<%=path%>/css/bootstrap/css/bootstrap.css"
			rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/left.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/pdmcontent01.css" rel="stylesheet"
			type="text/css">
		<script type="text/javascript" src="<%=path%>/js/jquery-3.4.1.min.js"></script>
		<script language="javascript" type="text/javascript"
			src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<script src="<%=path%>/css/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery-pdm.js"></script>
		<title>菜单栏</title>
	</head>
	<body>
		<div class="page-content">
			<form action="<%=path%>/blog_list.action" class="form-inline"
				method="post">
				<div class="panel panel-default">
					<div class="panel-heading">
						博客列表
					</div>
					<div class="panel-body">
						<div class="pull-left">
							
							<div class="form-group qinfo">
								<label>
									博客题目：
								</label>
								<input name="title" value="${title}" class="form-control">
							</div>
							<div class="form-group qinfo">
								<label>
									关键字：
								</label>
								<input name="keyword" value="${keyword}" class="form-control">
							</div>
							<label>
								分类：
							</label>
							<select id="typeid" name="typeid" class="form-control">
								<option value="0">
									全部
								</option>
								<c:forEach items="${blogtypeList}" var="info">
									<option <c:if test="${typeid==info.id}">selected</c:if>
										value="${info.id}">
										${info.typename}
									</option>
								</c:forEach>
							</select>
							
							<label>
								标签：
							</label>
							<select id="tagid" name="tagid" class="form-control">
								<option value="0">
									全部
								</option>
								<c:forEach items="${tagList}" var="info">
									<option <c:if test="${tagid==info.id}">selected</c:if>
										value="${info.id}">
										${info.tagname}
									</option>
								</c:forEach>
							</select>
							
							<button type="submit" class="btn btn-default">
								查询
							</button>
						</div>
					</div>
					<pg:pager url="blog_list.action" items="${itemSize}"
						maxPageItems="${pageItem}" maxIndexPages="${pageItem}"
						isOffset="${true}" export="offset,currentPageNumber=pageNumber"
						scope="request">
						<pg:param name="title" value="${title}" />
						<pg:param name="keyword" value="${keyword}" />
						<pg:param name="typeid" value="${typeid}" />
						<pg:param name="tagid" value="${tagid}" />
						<div class="table-responsive">
							<table class="table table-striped table-hover"
								style="text-align: center;">
								<thead>
									<tr>
										<td>
											博主
										</td>
										<td>
											博客题目
										</td>
										
										<td  width="160px">
											发布日期
										</td>
										<td width="80px">
											评论次数
										</td>
										<td width="80px">
											回复次数
										</td>
										<td width="80px">
											点赞次数
										</td>
										
										<td>
											关键字
										</td>
										<td width="100px">
											分类
										</td>
										<td width="60px">
											标签
										</td>
										<th width="120px">
											操作
										</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="info">
										<tr>
											<td>
												${info.bloggerVO.nickname}
											</td>
											<td>
												<a  target="_blank" href="<%=path%>/blog/articles/${info.id}.action">${info.title}</a>
											</td>
											
											<td>
												${info.cdate}
											</td>
											<td>
												${info.clickhit}
											</td>
											<td>
												${info.replyhit}
											</td>
											<td>
												${info.likenum}
											</td>
											
											<td>
												${info.keyword}
											</td>
											<td>
												${info.blogtypeVO.typename}
											</td>
											<td>
												${info.tagVO.tagname}
											</td>
											<td>
												<c:if test="${sessionScope.utype==1}">
												<a href="<%=path%>/blog_toUpdate.action?id=${info.id}"
													class="btn btn-info btn-xs"><span
													class="glyphicon glyphicon-edit"></span>编辑</a>
												</c:if>
												<a href="javascript:void();"
													onclick="delInfo('${info.id}');"
													class="btn btn-danger btn-xs"><span
													class="glyphicon glyphicon-trash"></span>删除</a>
												<!--a href="#" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-eye-open"></span> 查看</a-->
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="panel-footer clearfix">
								<c:if test="${sessionScope.utype==1}">
								<div class="pull-left">
									<button type="button" id="addBtn" class="btn btn-info">
										新增
									</button>
								</div>
								</c:if>
								<nav class="pull-right">
								<pg:index>
									<jsp:include page="/common/pagination_tag.jsp" flush="true" />
								</pg:index>
								</nav>
							</div>
						</div>
					</pg:pager>
				</div>
			</form>
		</div>
	</body>
</html>
<script type="text/javascript">
$(document).ready(function(){
   $("#addBtn").click(function(){
        window.location.href = '<%=path%>/blog_toAdd.action';
   });
});
function delInfo(id){
	 if(confirm("是否确认删除？")){
	 window.location.href = '<%=path%>/blog_delete.action?id=' + id;
    }
}
</script>