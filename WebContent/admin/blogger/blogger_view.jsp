<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>详情</title>
    <link href="<%=path%>/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="<%=path%>/js/jquery-3.4.1.min.js"></script>
    <script src="<%=path%>/css/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=path%>/js/jquery.validate.min.js"></script>
    <script src="<%=path%>/js/jquery.validate.extend.js"></script>
    <link href="<%=path%>/css/pdmcontent01.css" rel="stylesheet">
</head>
<body>
<div class="page-content">
    <div class="panel panel-default">
        <div class="panel-heading">详情</div>
        <div class="panel-body">
                <div class="container-fluid">
					                        <div class="row rowmargin">
                            <div class="col-sm-7">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><font color="red">*</font>账号   </label>
                                    <div class="col-sm-9 form-inline" >
                                                                                    <input id="username" name="username" size="35" value="${blogger.username}" readonly="readonly" class="form-control" type="text"  />
                                    </div>
                                </div>
                            </div>
                        </div>
					                        <div class="row rowmargin">
                            <div class="col-sm-7">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><font color="red">*</font>密码   </label>
                                    <div class="col-sm-9 form-inline" >
                                                                                    <input id="password" name="password" size="35" value="${blogger.password}" readonly="readonly" class="form-control" type="text"  />
                                    </div>
                                </div>
                            </div>
                        </div>
					                        <div class="row rowmargin">
                            <div class="col-sm-7">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><font color="red">*</font>个人主页   </label>
                                    <div class="col-sm-9 form-inline" >
                                                                                    <input id="profile" name="profile" size="35" value="${blogger.profile}" readonly="readonly" class="form-control" type="text"  />
                                    </div>
                                </div>
                            </div>
                        </div>
					                        <div class="row rowmargin">
                            <div class="col-sm-7">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><font color="red">*</font>姓名昵称   </label>
                                    <div class="col-sm-9 form-inline" >
                                                                                    <input id="nickname" name="nickname" size="35" value="${blogger.nickname}" readonly="readonly" class="form-control" type="text"  />
                                    </div>
                                </div>
                            </div>
                        </div>
					                        <div class="row rowmargin">
                            <div class="col-sm-7">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><font color="red">*</font>个人签名   </label>
                                    <div class="col-sm-9 form-inline" >
                                                                                    <textarea rows="5" readonly="readonly" cols="80" id="sign" name="sign" class="form-control" tip="请输入个人签名">${blogger.sign}</textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
					                        <div class="row rowmargin">
                            <div class="col-sm-7">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label"><font color="red">*</font>头像   </label>
                                    <div class="col-sm-9 form-inline" >
                                                                                    <input id="imagename" name="imagename" size="35" value="${blogger.imagename}" readonly="readonly" class="form-control" type="text"  />
                                    </div>
                                </div>
                            </div>
                        </div>
                    <div class="row">
                        <div class="col-sm-2">
                        </div>
                        <div class="col-sm-4" style="margin-left: 20px;">
                            <button type="button" id="rebackBtn" class="btn btn-default" style="margin-top: 40px;margin-left: 20px;">返回</button>
                        </div>
                    </div>
                </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function(){
        $("#rebackBtn").click(function(){
            window.history.go(-1);
        });
    });
</script>
</html>
