<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <div class="data_list">
	<div class="data_list_title">
		<img
			src="${pageContext.request.contextPath}/static/images/user_icon.png" />
		博主信息
	</div>
	<div class="user_image">
		<img
			src="${pageContext.request.contextPath}/${blogger.imagename}" />
	</div>
	<div class="nickName"><strong><font style="color: #EE6A50">昵称：${blogger.nickname }</font></strong></div>
	
	<div class="userSign">『<strong><font style="color: #EE6A50">${blogger.sign }</font></strong>』</div>
	<div style="text-align: center;">
		<button onclick="guanzhu(${blogger.id})"  id="fav_a1" style="<c:if test="${favbool}">display: none;</c:if>background: #fff; border: 1px solid #ccc;"  >关注</button>
		 <button onclick="quxiao(${blogger.id})" id="fav_a2" style="<c:if test="${!favbool}">display: none;</c:if>background: #fff; border: 1px solid #ccc; " >取消</button>
	</div>
	
</div> 

<div class="data_list">
	<div class="data_list_title">
		<img
			src="${pageContext.request.contextPath}/static/images/byType_icon.png" />
		文章分类
	</div>
	<div class="datas">
		<ul>
			<c:forEach items="${blogTypeList }" var="blogType">
				<li><span> <a
						href="${pageContext.request.contextPath}/index_user.action?typeId=${blogType.id }">${blogType.typename }（${blogType.blogCount }）
					</a></span></li>
			</c:forEach>
		</ul>
	</div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
function guanzhu(bzid){
		
		<c:if test="${sessionScope.user==null}">
	         alert("请先登录");
	         return;
	    </c:if>
	    $.post("${pageContext.request.contextPath}/favAdd.action", {bzid:bzid},
	  			   function(data){
	   		        	var datas = eval('data');
	   		       		datas = $.trim(datas);
	   		       
	  			        if(datas=="false"){
	  			            alert('操作错误');
	  	    		        return false;
	  			        }else{
	  			        	$("#fav_a1").css('display','none');
	  			  			$("#fav_a2").css('display','inline');
	  			        }
	   		      
	  		   });
		    
	}
	
	function quxiao(bzid){
	
		<c:if test="${sessionScope.user==null}">
	         alert("请先登录");
	         return;
	    </c:if>
	    $.post("${pageContext.request.contextPath}/favDel.action", {bzid:bzid},
  			   function(data){
   		        	var datas = eval('data');
   		       		datas = $.trim(datas);
   		       
  			        if(datas=="false"){
  			            alert('操作错误');
  	    		        return false;
  			        }else{
  			        	$("#fav_a2").css('display','none');
  			  			$("#fav_a1").css('display','inline');
  			        }
   		      
  		   });
	    
	}
	</script>
 


 
