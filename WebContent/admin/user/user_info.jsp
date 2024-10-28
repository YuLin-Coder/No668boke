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
		<script language="javascript" type="text/javascript"
			src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<link href="<%=path%>/css/pdmcontent01.css" rel="stylesheet">
	</head>
	<body>
		<div class="page-content">
			<div class="panel panel-default">
				<div class="panel-heading">
					个人信息
				</div>
				<div class="panel-body">
					<form action="<%=path%>/user_info.action" method="post"
						id="addForm">
						<input name="id" type="hidden" value="${user.id}" />
						<input name="upwd" type="hidden" value="${user.upwd}" />
						<div class="container-fluid">
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>账号
										</label>
										<div class="col-sm-9 form-inline">
											<input id="uname" name="uname" size="35" class="form-control"
												type="text" value="${user.uname}" readonly="readonly" />
										</div>
									</div>
								</div>
							</div>
							
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>姓名
										</label>
										<div class="col-sm-9 form-inline">
											<input id="name" name="name" size="35" class="form-control"
												type="text" value="${user.name}" tip="请输入姓名" />
										</div>
									</div>
								</div>
							</div>
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>性别
										</label>
										<div class="col-sm-9 form-inline">
											<select id="sex" name="sex" class="form-control">
												<option <c:if test="${user.sex=='男'}">selected</c:if>
													value="男">
													男
												</option>
												<option <c:if test="${user.sex=='女'}">selected</c:if>
													value="女">
													女
												</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>电话
										</label>
										<div class="col-sm-9 form-inline">
											<input id="tel" name="tel" size="35" class="form-control"
												type="text" value="${user.tel}" tip="请输入电话" />
										</div>
									</div>
								</div>
							</div>
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>政治面貌
										</label>
										<div class="col-sm-9 form-inline">
											<input id="zzmm" name="zzmm" size="35" class="form-control"
												type="text" value="${user.zzmm}" tip="请输入政治面貌" />
										</div>
									</div>
								</div>
							</div>
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>学院
										</label>
										<div class="col-sm-9 form-inline">
											<input id="xueyuan" name="xueyuan" size="35"
												class="form-control" type="text" value="${user.xueyuan}"
												tip="请输入学院" />
										</div>
									</div>
								</div>
							</div>
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>所学专业
										</label>
										<div class="col-sm-9 form-inline">
											<input id="zhuanye" name="zhuanye" size="35"
												class="form-control" type="text" value="${user.zhuanye}"
												tip="请输入所学专业" />
										</div>
									</div>
								</div>
							</div>
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>是否就业
										</label>
										<div class="col-sm-9 form-inline">
											<select id="zt" name="zt" class="form-control">
												
												<option <c:if test="${user.zt==0}">selected</c:if>
													value="0">
													否
												</option>
												<option <c:if test="${user.zt==1}">selected</c:if>
													value="1">
													是
												</option>
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
										保存
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
	    $("#rebackBtn").click(function() {
	        window.history.go( - 1);
	    });
	    $("#addForm").validate({
	        submitHandler: function(form) { //验证通过后的执行方法
	            form.submit();
	        },
	        rules: {
	           
	            name: {
	                required: true,
	            },
	            sex: {
	                required: true,
	            },
	            tel: {
	                required: true,
	                telphone: true,
	            },
	            zzmm: {
	                required: true,
	            },
	            xueyuan: {
	                required: true,
	            },
	            zhuanye: {
	                required: true,
	            },
	            zt: {
	                required: true,
	            },
	        },
	        messages: {
	           
	            name: {
	                required: '姓名不能为空',
	            },
	            sex: {
	                required: '性别不能为空',
	            },
	            tel: {
	                required: '电话不能为空',
	                telphone: '电话格式错误',
	            },
	            zzmm: {
	                required: '政治面貌不能为空',
	            },
	            xueyuan: {
	                required: '学院不能为空',
	            },
	            zhuanye: {
	                required: '所学专业不能为空',
	            },
	            zt: {
	                required: '是否就业不能为空',
	            },
	        }
	    });
	});
    </script>
</html>