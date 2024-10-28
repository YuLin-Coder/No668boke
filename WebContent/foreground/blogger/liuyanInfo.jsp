<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <script type="text/javascript">
 
	function submitData() {
		var content = $("#content").val();
		
		 <c:if test="${sessionScope.user==null}">
		     alert("请先登录");
		 </c:if>
	   <c:if test="${sessionScope.user!=null}">
		if(content == null || content == "") {
			alert("请输入提问内容");
		} else{
			$.post(
				"${pageContext.request.contextPath}/blogger/savely.do",
				{"content":content},
				function(result) {
					if(result.success) {
						alert("感谢您的反馈");
						window.location.reload();
					} else {
						alert(result.errorInfo);
					}
				},"json");
		}
		
		 </c:if>
	}
	
</script>


<div class="data_list">
	<div class="data_list_title">
		<img
			src="${pageContext.request.contextPath}/static/images/comment_icon.png" />&nbsp;在线提问
		 
	</div>
	<div class="commentDatas">
		<ul style="margin-left: -40px;">
			<c:choose>
				<c:when test="${lylist.size()==0 }">
						暂无留言
				</c:when>
				<c:otherwise>
					<c:forEach items="${lylist }" var="liuyan" varStatus="status">
						 
							   <div class="comment">
									<div style="width:100%;overflow: hidden;">
										<font style="float:left; width:90px;text-align: left;height: 32px;line-height: 32px;">
											【${liuyan.bloggerVO.nickname }】：
										</font>
										<div style="float:left;width: 730px;min-height: 20px;padding: 5px; ">
											${liuyan.content }
										</div>
										
									</div>
									<div style="text-align:left;font-size: 13px;margin-left: 90px;">
											${liuyan.cdate }
									</div>
									<c:if test="${liuyan.rcontent!=null && liuyan.rcontent!=''}">
									<div style="    padding: 10px;background: #ddd;margin-left: 10px;">
										<font>回复：</font>${liuyan.rcontent}
									</div>
									</c:if>
								</div>
							 
						 
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>

<div class="data_list">
	<div class="data_list_title">
		<img
			src="${pageContext.request.contextPath}/static/images/publish_comment_icon.png" />&nbsp;在线提问
	</div>
	<div class="publish_comment">
		<div>
			<textarea style="width: 100%" rows="3" id="content" name="content" required="required"
				placeholder="来说两句吧..."></textarea>
		</div>
		 
		<div class="publishButton">
			<button class="btn btn-primary" type="button" onclick="submitData()">提交问题</button>
		</div>
		</form>
	</div>

</div>