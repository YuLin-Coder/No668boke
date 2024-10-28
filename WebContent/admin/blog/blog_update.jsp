<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>修改</title>
		<link href="<%=path%>/css/bootstrap/css/bootstrap.css"
			rel="stylesheet" type="text/css">
		<script src="<%=path%>/js/jquery-3.4.1.min.js"></script>
		<script src="<%=path%>/css/bootstrap/js/bootstrap.min.js"></script>
		<script src="<%=path%>/js/jquery.validate.min.js"></script>
		<script src="<%=path%>/js/jquery.validate.extend.js"></script>
		<script src="<%=path%>/js/jquery.validate.method.js"></script>
		<script type="text/javascript" charset="utf-8"
			src="<%=path%>/js/ueditor/ueditor.config.js"></script>
		<script type="text/javascript" charset="utf-8"
			src="<%=path%>/js/ueditor/ueditor.all.min.js"> </script>
		<script type="text/javascript" charset="utf-8"
			src="<%=path%>/js/ueditor/lang/zh-cn/zh-cn.js"></script>
		<script language="javascript" type="text/javascript"
			src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<link href="<%=path%>/css/pdmcontent01.css" rel="stylesheet">
	</head>
	<body>
		<div class="page-content">
			<div class="panel panel-default">
				<div class="panel-heading">
					修改
				</div>
				<div class="panel-body">
					<form action="<%=path%>/blog_update.action" method="post"
						id="addForm">
						<input name="id" type="hidden" value="${blog.id}" />
						<input name="clickhit" type="hidden" value="${blog.clickhit}" />
						<input name="Replyhit" type="hidden" value="${blog.id}" />
						<input name="likenum" type="hidden" value="${blog.likenum}" />
						<div class="container-fluid">
							
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>博客题目
										</label>
										<div class="col-sm-9 form-inline">
											<input id="title" name="title" size="35" class="form-control"
												type="text" value="${blog.title}" tip="请输入博客题目" />
										</div>
									</div>
								</div>
							</div>
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>博客摘要
										</label>
										<div class="col-sm-9 form-inline">
											<textarea rows="5" cols="80" id="summary" name="summary"
												class="form-control" tip="请输入博客摘要">${blog.summary}</textarea>
										</div>
									</div>
								</div>
							</div>
							
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>博客内容
										</label>
										<div class="col-sm-9 form-inline">
											<script id="container" type="text/plain"
												style="width:850px;height:300px;"></script>
											<input id="content" name="content" type="hidden" />
										</div>
									</div>
								</div>
							</div>
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>关键字
										</label>
										<div class="col-sm-9 form-inline">
											<input id="keyword" name="keyword" size="35"
												class="form-control" type="text" value="${blog.keyword}"
												tip="请输入关键字" />
										</div>
									</div>
								</div>
							</div>
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>分类
										</label>
										<div class="col-sm-9 form-inline">
										
											
											
											<select id="typeid" name="typeid" class="form-control">
												<c:forEach items="${blogtypeList}" var="info">
													<option
														<c:if test="${blog.typeid==info.id}">selected</c:if>
														value="${info.id}">
														${info.typename}
													</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
							</div>
							
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>标签
										</label>
										<div class="col-sm-9 form-inline">
											<select id="tagid" name="tagid" class="form-control">
												<c:forEach items="${tagList}" var="info">
													<option <c:if test="${blog.tagid==info.id}">selected</c:if> 
													value="${info.id}">
														${info.tagname}
													</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-sm-2">
								</div>
								<div class="col-sm-4" style="margin-left: 20px;">
									<button type="submit" class="btn btn-primary"
										style="margin-top: 40px;">
										提交
									</button>
									<button type="button" id="rebackBtn" class="btn btn-default"
										style="margin-top: 40px; margin-left: 20px;">
										返回
									</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
$(document).ready(function() {
    var ue = UE.getEditor('container');
    ue.ready(function() {
        //设置编辑器的内容
        ue.setContent('${blog.content}');
    });
    $("#rebackBtn").click(function() {
        window.history.go( - 1);
    });
    $("#addForm").validate({
        submitHandler: function(form) { //验证通过后的执行方法
            var htmlv = ue.getContent();
            if (htmlv == null || htmlv == '') {
                alert("内容不能为空");
                return false;
            }
            document.getElementById("content").value = htmlv;
            form.submit();
        },
        rules: {
            title: {
                required: true,
            },
            summary: {
                required: true,
            },
            content: {
                required: true,
            },
            keyword: {
                required: true,
            },
            typeid: {
                required: true,
            },
            xq: {
                required: true,
            },
        },
        messages: {
            title: {
                required: '博客题目不能为空',
            },
            summary: {
                required: '博客摘要不能为空',
            },
            content: {
                required: '博客内容不能为空',
            },
            keyword: {
                required: '关键字不能为空',
            },
            typeid: {
                required: '标签不能为空',
            },
            xq: {
                required: '是否可见不能为空',
            },
        }
    });
});
    </script>
</html>