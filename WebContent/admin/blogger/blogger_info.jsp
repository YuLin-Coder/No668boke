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
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
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
					<form action="<%=path%>/blogger_info.action" method="post"
						id="addForm">
						<input name="id" type="hidden" value="${user.id}" />
						<input name="password" type="hidden" value="${user.password}" />
						<div class="container-fluid">
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>账号
										</label>
										<div class="col-sm-9 form-inline">
											<input id="username" name="username" size="35" readonly="readonly"
												class="form-control" type="text" value="${user.username}" />
										</div>
									</div>
								</div>
							</div>
							
							
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>姓名昵称
										</label>
										<div class="col-sm-9 form-inline">
											<input id="nickname" name="nickname" size="35"
												class="form-control" type="text" value="${user.nickname}"
												tip="请输入姓名昵称" />
										</div>
									</div>
								</div>
							</div>
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>个人签名
										</label>
										<div class="col-sm-9 form-inline">
											<textarea rows="5" cols="80" id="sign" name="sign"
												class="form-control" tip="请输入个人签名">${user.sign}</textarea>
										</div>
									</div>
								</div>
							</div>
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>头像
										</label>
										<div class="col-sm-9 form-inline">
											<input id="imagename" readonly="readonly" name="imagename"
												value="${user.imagename}" size="35" class="form-control"
												type="text" tip="请上传文件" />
											<input type="button" value="上传" onclick="up('imagename',0)" />
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
    
    $("#rebackBtn").click(function() {
        window.history.go( - 1);
    });
    $("#addForm").validate({
        submitHandler: function(form) { //验证通过后的执行方法
           
            form.submit();
        },
        rules: {
          
            
            nickname: {
                required: true,
            },
            sign: {
                required: true,
            },
            imagename: {
                required: true,
            },
        },
        messages: {
            
            nickname: {
                required: '姓名昵称不能为空',
            },
            sign: {
                required: '个人签名不能为空',
            },
            imagename: {
                required: '头像不能为空',
            },
        }
    });
});
var pop;
function up(fname, type) {
    pop = new Popup({
        contentType: 1,
        isReloadOnClose: false,
        width: 400,
        height: 200
    });
    pop.setContent("contentUrl", "<%=path %>/upload/upload.jsp?fname=" + fname + "&pt=" + type);
    pop.setContent("title", "文件上传");
    pop.build();
    pop.show();
}
function popupClose() {
    pop.close();
}
    </script>
</html>