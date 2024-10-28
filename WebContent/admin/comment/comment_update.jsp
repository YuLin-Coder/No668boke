<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改</title>
	<link href="<%=path%>/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
	<script src="<%=path%>/js/jquery-3.4.1.min.js"></script>
	<script src="<%=path%>/css/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=path%>/js/jquery.validate.min.js"></script>
	<script src="<%=path%>/js/jquery.validate.extend.js"></script>
    <script src="<%=path%>/js/jquery.validate.method.js"></script>
            <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
    <link href="<%=path%>/css/pdmcontent01.css" rel="stylesheet">
</head>
<body>
<div class="page-content">
    <div class="panel panel-default">
        <div class="panel-heading">修改</div>
        <div class="panel-body">
            <form action="<%=path%>/comment_update.action" method="post" id="addForm">
                 <input name="id" type="hidden" value="${comment.id}"/>
                <div class="container-fluid">
					                        <div class="row rowmargin">
                            <div class="col-sm-7">
                                <div class="form-group">
                                                                            <label class="col-sm-3 control-label">用户 </label>
                                                                        <div class="col-sm-9 form-inline"  >
                                                                                            <select id="userid" name="userid" class="form-control">
                                                    <c:forEach items="${bloggerList}" var="info">
                                                        <option <c:if test="${comment.userid==info.id}">selected</c:if>  value="${info.id}">${info.nickname}</option>
                                                    </c:forEach>
                                                </select>
                                    </div>
                                </div>
                            </div>
                        </div>
					                        <div class="row rowmargin">
                            <div class="col-sm-7">
                                <div class="form-group">
                                                                            <label class="col-sm-3 control-label"><font color="red">*</font>评论内容 </label>
                                                                        <div class="col-sm-9 form-inline"  >
                                                                                    <textarea rows="5" cols="80" id="content" name="content" class="form-control" tip="请输入评论内容">${comment.content}</textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
					                        <div class="row rowmargin">
                            <div class="col-sm-7">
                                <div class="form-group">
                                                                            <label class="col-sm-3 control-label">评论时间 </label>
                                                                        <div class="col-sm-9 form-inline"  >
                                            <input id="cdate" name="cdate" size="35" class="form-control"   type="text" value="${comment.cdate}"  tip="请输入评论时间" />
                                    </div>
                                </div>
                            </div>
                        </div>
					                        <div class="row rowmargin">
                            <div class="col-sm-7">
                                <div class="form-group">
                                                                            <label class="col-sm-3 control-label">评论状态 </label>
                                                                        <div class="col-sm-9 form-inline"  >
                                            <input id="state" name="state" size="35" class="form-control"   type="text" value="${comment.state}"  tip="请输入评论状态" />
                                    </div>
                                </div>
                            </div>
                        </div>
					                        <div class="row rowmargin">
                            <div class="col-sm-7">
                                <div class="form-group">
                                                                            <label class="col-sm-3 control-label">博客 </label>
                                                                        <div class="col-sm-9 form-inline"  >
                                            <input id="blogid" name="blogid" size="35" class="form-control"   type="text" value="${comment.blogid}"  tip="请输入博客" />
                                    </div>
                                </div>
                            </div>
                        </div>
					                        <div class="row rowmargin">
                            <div class="col-sm-7">
                                <div class="form-group">
                                                                            <label class="col-sm-3 control-label">评论人 </label>
                                                                        <div class="col-sm-9 form-inline"  >
                                            <input id="uname" name="uname" size="35" class="form-control"   type="text" value="${comment.uname}"  tip="请输入评论人" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    <div class="row">
                      <div class="col-sm-2">
						</div>
                       <div class="col-sm-4" style="margin-left: 20px;">
                         <button type="submit" class="btn btn-primary" style="margin-top: 40px;">提交</button>
                         <button type="button" id="rebackBtn" class="btn btn-default" style="margin-top: 40px;margin-left: 20px;">返回</button>
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
	$("#rebackBtn").click(function(){
	    window.history.go(-1); 
	});
    $("#addForm").validate({
        submitHandler:function(form){//验证通过后的执行方法
                        form.submit();
        },
        rules: {
                                    content:{
                                    required:true,
                    },
                                                            },
    messages:{
                                                        content:{
                                                            required:'评论内容不能为空',
                            },
    }
});
});
    </script>
</html>