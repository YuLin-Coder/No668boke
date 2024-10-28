<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %> 
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">  
	<link href="<%=path%>/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="<%=path%>/css/left.css" rel="stylesheet" type="text/css">
	<link href="<%=path%>/css/pdmcontent01.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="<%=path%>/js/jquery-3.4.1.min.js"></script>
    <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
	<script src="<%=path%>/css/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-pdm.js"></script>
	<title>菜单栏</title>
</head>
<body>
<div class="page-content">
    <form action="<%=path%>/comment_list.action"   class="form-inline" method="post">
    <div class="panel panel-default">
        <div class="panel-heading">评论列表</div>
                 <div class="panel-body">
            <div class="pull-left">
			                                                <label>用户：</label>
                                                                            <select id="userid" name="userid" class="form-control">
                                <option value="0">全部</option>
                                <c:forEach items="${bloggerList}" var="info">
                                    <option <c:if test="${userid==info.id}">selected</c:if>  value="${info.id}">${info.nickname}</option>
                                </c:forEach>
                            </select>
                     				                                             <div class="form-group qinfo">
                             <label>评论状态：</label>
                             <input name="state" value="${state}" class="form-control">
                         </div>
                    				                                             <div class="form-group qinfo">
                             <label>博客：</label>
                             <input name="blogid" value="${blogid}" class="form-control">
                         </div>
                    				                <button type="submit" class="btn btn-default">查询</button>
            </div>
        </div>
         <pg:pager url="comment_list.action" items="${itemSize}" maxPageItems="${pageItem}" maxIndexPages="${pageItem}" isOffset="${true}" export="offset,currentPageNumber=pageNumber" scope="request">
                     <pg:param name="userid" value="${userid}"/>
                    <pg:param name="state" value="${state}"/>
                    <pg:param name="blogid" value="${blogid}"/>
                  <div class="table-responsive">
            <table class="table table-striped table-hover" style="text-align: center;">
                <thead>
                <tr >
					                        <td>用户</td>
					                        <td>评论内容</td>
					                        <td>评论时间</td>
					                        <td>评论状态</td>
					                        <td>博客</td>
					                        <td>评论人</td>
                    <th width="12%">操作</th>
                </tr>
                </thead>
                <tbody>
    <c:forEach items="${list}" var="info">
     <tr>
						                                 <td><a style="color:#000000" href="<%=path%>/comment_toView.action?id=${info.id}">${info.userid}</a></td>
                                                                    <td>${info.content}</td>
                                                                    <td>${info.cdate}</td>
                                                                    <td>${info.state}</td>
                                                                    <td>${info.blogid}</td>
                                                                    <td>${info.uname}</td>
                            						        <td>
            <a href="<%=path%>/comment_toUpdate.action?id=${info.id}" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-edit"></span>编辑</a>
            <a href="javascript:void();" onclick="delInfo('${info.id}');"  class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash"></span>删除</a>
            <!--a href="#" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-eye-open"></span> 查看</a-->
        </td>
    </tr>
                   </c:forEach>
                </tbody>
            </table>
            <div class="panel-footer clearfix">
                <div class="pull-left">
                    <button type="button"  id="addBtn"  class="btn btn-info">新增</button>
                </div>
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
        window.location.href = '<%=path%>/comment_toAdd.action';
   });
});
function delInfo(id){
	 if(confirm("是否确认删除？")){
	 window.location.href = '<%=path%>/comment_delete.action?id=' + id;
    }
}
</script>