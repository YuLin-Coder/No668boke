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
			<form action="<%=path%>/blogger_list.action" class="form-inline"
				method="post">
				<div class="panel panel-default">
					<div class="panel-heading">
						用户列表
					</div>
					<div class="panel-body">
						<div class="pull-left">
							<div class="form-group qinfo">
								<label>
									账号：
								</label>
								<input name="username" value="${username}" class="form-control">
							</div>
							<div class="form-group qinfo">
								<label>
									昵称：
								</label>
								<input name="nickname" value="${nickname}" class="form-control">
							</div>
							<button type="submit" class="btn btn-default">
								查询
							</button>
						</div>
					</div>
					<pg:pager url="blogger_list.action" items="${itemSize}"
						maxPageItems="${pageItem}" maxIndexPages="${pageItem}"
						isOffset="${true}" export="offset,currentPageNumber=pageNumber"
						scope="request">
						<pg:param name="username" value="${username}" />
						<pg:param name="nickname" value="${nickname}" />
						<div class="table-responsive">
							<table class="table table-striped table-hover"
								style="text-align: center;">
								<thead>
									<tr>
										<td width="120px">
											账号
										</td>
										
										<td width="120px">
											姓名昵称
										</td>
										<td width="100px">
											个人主页
										</td>
										
										<td>
											个人签名
										</td>
										<td width="160px">
											头像
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
												${info.username}
											</td>
											
											<td>
												${info.nickname}
											</td>
											<td>
												<a target="_blank" href="<%=path%>/user_index.action?bid=${info.id}">查看主页</a>
											</td>
											<td>
												${info.sign}
											</td>
											<td>
												<img  src="<%=path%>/${info.imagename}" width="150"/>
											</td>
											<td>
												
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
        window.location.href = '<%=path%>/blogger_toAdd.action';
   });
});
function delInfo(id){
	 if(confirm("是否确认删除？")){
	 window.location.href = '<%=path%>/blogger_delete.action?id=' + id;
    }
}
</script>