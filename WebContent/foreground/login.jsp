<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录</title>
<link href="<%=path%>/static/bootstrap3/css/bootstrap.css"
	rel="stylesheet" type="text/css">
<script src="<%=path%>/static/js/jquery.js"></script>
<script src="<%=path%>/static/bootstrap3/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="page-content">
		<div class="panel panel-default">

			<div class="panel-body">
				<form action="<%=path%>/blogger/login.do" method="post" id="addForm">

					<div class="container-fluid">
						<div class="row rowmargin">
							<div class="col-sm-7">
								<div class="form-group">
									<label class="col-sm-3 control-label">用户名 </label>
									<div class="col-sm-9 form-inline">
										<input id="uname" name="uname" size="35" class="form-control"
											required="required" type="text" value="" placeholder="请输入用户名" />
									</div>
								</div>
							</div>
						</div>
						<div class="row rowmargin">
							<div class="col-sm-7">
								<div class="form-group">
									<label class="col-sm-3 control-label">密码 </label>
									<div class="col-sm-9 form-inline">
										<input id="upwd" name="upwd" size="35" class="form-control"
											required="required" type="password" value="" placeholder="请输入密码" />
									</div>
								</div>
							</div>
						</div>




						<div class="row" align="center">
							<div class="col-sm-2"></div>
							<div class="col-sm-4" style="margin-left: 20px;">
								<button type="button" onclick="check();" class="btn btn-primary"
									style="margin-top: 40px;">提交</button>
								<button type="button" id="closeBtn" class="btn btn-default"
									style="margin-top: 40px; margin-left: 20px;">关闭</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
     $("#closeBtn").click(function(){
	    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index);
	 });
  
});

function check(){
	var uname = $('#uname').val();
	var upwd = $('#upwd').val();
	$.post("<%=path%>/blogger/login.do", {
			username : uname,
			password : upwd
		}, function(result) {
			var res = $.parseJSON(result);
			console.log(res.success);
			if ($.trim(res.success) == "Y") {
				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引

				parent.layer.close(index);
				parent.location.reload();
			} else {
				alert("用户名密码错误");
			}
		});

	}
</script>
</html>