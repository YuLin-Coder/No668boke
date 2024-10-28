<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <script type="text/javascript">
 
	function submitData() {
		var neirong = $("#content").val();
		
		if(neirong == null || neirong == "") {
			alert("请输入留言建议内容");
		} else{
			$.post(
				"${pageContext.request.contextPath}/blogger/saveSuggest.do",
				{"content":neirong},
				function(result) {
					if(result.success) {
						alert("感谢您的留言建议");
						window.location.reload();
					} else {
						alert(result.errorInfo);
					}
				},"json");
		}
		
		 
	}
	
</script>



<div class="data_list">
	<div class="data_list_title">
		<img
			src="${pageContext.request.contextPath}/static/images/publish_comment_icon.png" />&nbsp;留言建议
	</div>
	<div class="publish_comment">
		<div>
			<textarea style="width: 100%" rows="10" id="content" name="content" required="required" maxlength="1000"
				placeholder="来说两句吧..."></textarea>
		</div>
		 
		<div class="publishButton">
			<button class="btn btn-primary" type="button" onclick="submitData()">提交建议</button>
		</div>
		
	</div>

</div>