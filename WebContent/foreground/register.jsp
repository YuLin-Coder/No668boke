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
<title>注册</title>
<link href="<%=path%>/static/bootstrap3/css/bootstrap.css"
	rel="stylesheet" type="text/css">
<script src="<%=path%>/static/js/jquery.js"></script>
<script src="<%=path%>/static/bootstrap3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/popup.js"></script>
</head>
<body>
	<div class="page-content">
		<div class="panel panel-default">

			<div class="panel-body">
				<form action="<%=path%>/blogger/register.do" method="post"
					onsubmit="return check();" id="addForm">
					<div class="container-fluid">
						<div class="row rowmargin">
							<div class="col-sm-7">
								<div class="form-group">
									<label class="col-sm-3 control-label">用户名 </label>
									<div class="col-sm-9 form-inline">
										<input id="username" name="username" size="35"
											class="form-control" required="required" type="text" value=""
											tip="请输入用户名" />
									</div>
								</div>
							</div>
						</div>
						<div class="row rowmargin">
							<div class="col-sm-7">
								<div class="form-group">
									<label class="col-sm-3 control-label">密码 </label>
									<div class="col-sm-9 form-inline">
										<input id="password" name="password" size="35"
											class="form-control" required="required" type="password"
											value="" tip="请输入密码" />
									</div>
								</div>
							</div>
						</div>

						<div class="row rowmargin">
							<div class="col-sm-7">
								<div class="form-group">
									<label class="col-sm-3 control-label">昵称 </label>
									<div class="col-sm-9 form-inline">
										<input id="nickname" name="nickname" size="35"
											class="form-control" required="required" type="text" value=""
											tip="请输入昵称" />
									</div>
								</div>
							</div>
						</div>

						<div class="row rowmargin">
							<div class="col-sm-7">
								<div class="form-group">
									<label class="col-sm-3 control-label">头像</label>
									<div class="col-sm-9 form-inline">
										<input id="imagename" name="imagename" size="35"
											class="form-control" required="required" type="text" value=""
											readonly="readonly" /> <input type="button" value="上传"
											onclick="up('imagename',0)" />
									</div>
								</div>
							</div>
						</div>


						<div class="row rowmargin">
							<div class="col-sm-7">
								<div class="form-group">
									<label class="col-sm-3 control-label">个性签名 </label>
									<div class="col-sm-9 form-inline">
										<input id="sign" name="sign" size="35" class="form-control"
											required="required" type="text" value="" tip="请输入个性签名" />
									</div>
								</div>
							</div>
						</div>





						<div class="row" align="center">
							<div class="col-sm-2"></div>
							<div class="col-sm-4" style="margin-left: 20px;">
								<button type="submit" class="btn btn-primary"
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

var errinfo = '${errinfo}';
if(errinfo!=null && errinfo!=''){
	alert(errinfo);
} 


var closeDiv = '${closeDiv}';
if(closeDiv=='Y'){
	var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	parent.layer.close(index);
} 



var pop;
function up(fname, type) {
    pop = new Popup({
        contentType: 1,
        isReloadOnClose: false,
        width: 400,
        height: 200
    });
    pop.setContent("contentUrl", "<%=path%>/upload/upload.jsp?fname="
				+ fname + "&pt=" + type);
		pop.setContent("title", "文件上传");
		pop.build();
		pop.show();
	}
	function popupClose() {
		pop.close();
	}

	function check() {
		/* var tel = $('#tel').val();
		if(!(/^1[3456789]\d{9}$/.test(tel))){ 
		  alert("请输入正确的电话号码"); 
		  return false; 
		} */
		return true;

	}
</script>
</html>