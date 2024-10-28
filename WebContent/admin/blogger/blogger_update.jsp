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
					<form action="<%=path%>/blogger_update.action" method="post"
						id="addForm">
						<input name="id" type="hidden" value="${blogger.id}" />
						<div class="container-fluid">
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>账号
										</label>
										<div class="col-sm-9 form-inline">
											<input id="username" name="username" size="35"
												class="form-control" type="text" value="${blogger.username}"
												tip="请输入账号" />
										</div>
									</div>
								</div>
							</div>
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>密码
										</label>
										<div class="col-sm-9 form-inline">
											<input id="password" name="password" size="35"
												class="form-control" type="text" value="${blogger.password}"
												tip="请输入密码" />
										</div>
									</div>
								</div>
							</div>
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>个人主页
										</label>
										<div class="col-sm-9 form-inline">
											<script id="container" type="text/plain"
												style="width:850px;height:300px;"></script>
											<input id="profile" name="profile" type="hidden" />
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
												class="form-control" type="text" value="${blogger.nickname}"
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
												class="form-control" tip="请输入个人签名">${blogger.sign}</textarea>
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
												value="${blogger.imagename}" size="35" class="form-control"
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
$(document).ready(function(){
        var ue = UE.getEditor('container');
    ue.ready(function() {
        //设置编辑器的内容
        ue.setContent('${blogger.profile}');
    });
	$("#rebackBtn").click(function(){
	    window.history.go(-1); 
	});
    $("#addForm").validate({
        submitHandler:function(form){//验证通过后的执行方法
                            var htmlv = ue.getContent();
                if (htmlv== null || htmlv == '') {
                    alert("内容不能为空");
                    return false;
                }
                document.getElementById("profile").value = htmlv;
                        form.submit();
        },
        rules: {
                        username:{
                                    required:true,
                                    remote: {
                    url: "<%=path%>/blogger_usernameExist.action",
                            type: "post",
                            dataType: "json",
                            data: {
                        username: function (){ return $("#username").val();}
                    },
                    dataFilter: function (data) {
                        return data;
                    }
                }
                    },
                                password:{
                                    required:true,
                    },
                                profile:{
                                    required:true,
                    },
                                nickname:{
                                    required:true,
                    },
                                sign:{
                                    required:true,
                    },
                                imagename:{
                                    required:true,
                    },
            },
    messages:{
                                    username:{
                                                            required:'账号不能为空',
                                                            remote:'账号已存在',
                            },
                                                password:{
                                                            required:'密码不能为空',
                            },
                                                profile:{
                                                            required:'个人主页不能为空',
                            },
                                                nickname:{
                                                            required:'姓名昵称不能为空',
                            },
                                                sign:{
                                                            required:'个人签名不能为空',
                            },
                                                imagename:{
                                                            required:'头像不能为空',
                            },
    }
});
});
        var pop;
    function up(fname,type)
    {
        pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
        pop.setContent("contentUrl","<%=path %>/upload/upload.jsp?fname="+fname + "&pt=" + type);
        pop.setContent("title","文件上传");
        pop.build();
        pop.show();
    }
    function popupClose(){
        pop.close();
    }
    </script>
</html>