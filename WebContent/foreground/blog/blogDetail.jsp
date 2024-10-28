<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/ueditor1_4_3_3/third-party/SyntaxHighlighter/shCore.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/ueditor1_4_3_3/third-party/SyntaxHighlighter/shCoreDefault.css">
	
		<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	SyntaxHighlighter.all(); //ueditor代码高亮

	function showOtherComment() {
		$(".otherComment").show();
	}
	
	function loadimage(){
		document.getElementById("randImage").src="${pageContext.request.contextPath}/images.jsp?"+Math.random();
	}
	
	function submitData() {
		
      <c:if test="${sessionScope.user==null}">
	     alert("请先登录");
	 </c:if>
	 
	 <c:if test="${sessionScope.user!=null}">
		var content = $("#content").val();
		var imageCode = $("#imageCode").val();
		if(content == null || content == "") {
			alert("请输入评论内容");
		} else if( imageCode == null || imageCode == "") {
			alert("请填写验证码");
		} else {
			$.post(
				"${pageContext.request.contextPath}/comment/save.do",
				{"content":content,"imageCode":imageCode,"blogid":"${blog.id}"},
				function(result) {
					if(result.success) {
						//alert("评论已提交成功，博主审核后添加");
						window.location.reload();
					} else {
						alert(result.errorInfo);
					}
				},"json");
		}
		</c:if>
	}
	function dianzan(bkid){
		
		<c:if test="${sessionScope.user==null}">
	         alert("请先登录");
	         return;
	    </c:if>
	    $.post("${pageContext.request.contextPath}/likeAdd.action", {bkid:bkid},
	  			   function(data){
	   		        	var datas = eval('data');
	   		       		datas = $.trim(datas);
	   		       
	  			        if(datas=="false"){
	  			            alert('操作错误');
	  	    		        return false;
	  			        }else{
	  			        	$("#like_a1").css('display','none');
	  			  			$("#like_a2").css('display','inline');
	  			        	//获取当前点赞数
	  			        	var value = $("#like_num").text();
	  			        	
	  			        	var num = parseInt(value)+1;
	  			        
	  			        	$("#like_num").html(num);
	  			        }
	   		      
	  		   });
		    
	}
	
	function quxiao(bkid){
	
		<c:if test="${sessionScope.user==null}">
	         alert("请先登录");
	         return;
	    </c:if>
	    $.post("${pageContext.request.contextPath}/likeDel.action", {bkid:bkid},
  			   function(data){
   		        	var datas = eval('data');
   		       		datas = $.trim(datas);
   		       
  			        if(datas=="false"){
  			            alert('操作错误');
  	    		        return false;
  			        }else{
  			        	$("#like_a2").css('display','none');
  			  			$("#like_a1").css('display','inline');
  			        	//获取当前点赞数
  			        	var value = $("#like_num").text();
  			        	
  			        	var num = parseInt(value)-1;
  			        
  			        	$("#like_num").html(num);
  			        }
   		      
  		   });
	    
	}
	
	
	
</script>

<div class="data_list">
	<div class="data_list_title">
		<img
			src="${pageContext.request.contextPath}/static/images/blog_show_icon.png" />&nbsp;博客信息
	</div>
	<div>
		<div class="blog_title">
			<h3>
				<strong>${blog.title }</strong>
			</h3>
			<a href="${pageContext.request.contextPath}/user_index.action?bid=${blog.uid}" >作者：${blog.bloggerVO.nickname}</a>
		</div>
		<div style="text-align: center;">
				发布于：『
				${blog.cdate}
				』&nbsp;&nbsp; 博客类别：<a>${blog.blogtypeVO.typename }</a>&nbsp;&nbsp;
				博客标签：<a>${blog.tagVO.tagname }</a>&nbsp;&nbsp;
			</div>
		<div class="blog_info">
			<div style="float: left">
				<strong>关键字</strong>：
				<c:choose>
					<c:when test="${keyWords==null }">
					&nbsp;&nbsp;无
				</c:when>
					<c:otherwise>
						<c:forEach items="${keyWords }" var="keyword">
							&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/blog/search.action?q=${keyword }">${keyword }</a>&nbsp;
						</c:forEach> 
					</c:otherwise>
				</c:choose>
			</div>
			<div style="float:right;">
				阅读(${blog.clickhit })&nbsp;&nbsp; 评论(${blog.replyhit })&nbsp;&nbsp;
				 <a id="like_a1" onclick="dianzan(${blog.id})" style="<c:if test="${likebool}">display: none;</c:if>">点赞</a>
				 <a id="like_a2" onclick="quxiao(${blog.id})" style="<c:if test="${!likebool}">display: none;</c:if>color:#f0ad4e;font-weight: 700" >已赞</a>(<label id="like_num" style="font-weight: normal;">${blog.likenum}</label>)
				 
			</div>
		</div>
		<br><br>
		<div class="xian" style="clear:both; margin:0 auto; border-top:1px solid #ddd"></div>
		<div style="line-height:3; background-color: #F8F8FF">
			<font style="color:#8B2323">作者：个人博客&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;尊重博主原创文章，转载请注明文章出于此处。</font>
		</div>
		<div class="xian" style="margin:0px auto; border-top:1px solid #ddd"></div>
		<div class="blog_content">${blog.content }</div>
		<div class="xian" style="margin:0 auto; border-top:1px solid #ddd"></div>
		<div style="margin-top: 25px;">${pageCode }</div>
	</div>
</div>

<div class="data_list">
	<div class="data_list_title">
		<img
			src="${pageContext.request.contextPath}/static/images/comment_icon.png" />&nbsp;用户评论
		<c:if test="${commentList.size()>10 }">
			<a href="javascript:showOtherComment()"
				style="float:right; padding-right:40px;">显示所有用户评论</a>
		</c:if>
	</div>
	<div class="commentDatas">
		<ul>
			<c:choose>
				<c:when test="${commentList.size()==0 }">
						暂无评论
				</c:when>
				<c:otherwise>
					<c:forEach items="${commentList }" var="comment" varStatus="status">
						<c:choose>
							<c:when test="${status.index<10 }">
								<div class="comment">
									<span><font>
											${status.index+1}楼&nbsp;&nbsp;&nbsp;&nbsp;${comment.uname}</font>
										&nbsp;&nbsp;&nbsp;&nbsp;${comment.content }&nbsp;&nbsp;&nbsp;&nbsp;
										[${comment.cdate}] </span>
								</div>
							</c:when>
							<c:otherwise>
								<div class="otherComment">
									<span><font>
											${status.index+1}楼&nbsp;&nbsp;&nbsp;&nbsp;${comment.uname }</font>
										&nbsp;&nbsp;&nbsp;&nbsp;${comment.content }&nbsp;&nbsp;&nbsp;&nbsp;
										[${comment.cdate}]</span>
								</div>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>

<div class="data_list">
	<div class="data_list_title">
		<img
			src="${pageContext.request.contextPath}/static/images/publish_comment_icon.png" />&nbsp;发表评论
	</div>
	<div class="publish_comment">
		<div>
			<textarea style="width: 100%" rows="3" id="content" name="content"
				placeholder="来说两句吧..."></textarea>
		</div>
		<div class="verCode">
			验证码：<input type="text" value="" name="imageCode" id="imageCode"
				size="10" onkeydown="if(event.keyCode==13) form1.submit()" />&nbsp;
				<img onclick="javascript:loadimage();" title="换一张试试" name="randImage"
				id="randImage" src="${pageContext.request.contextPath}/image.jsp" width="60" height="20" border="1"
				align="absmiddle">
		</div>
		<div class="publishButton">
			<button class="btn btn-primary" type="button" onclick="submitData()">发表评论</button>
		</div>
		</form>
	</div>

</div>