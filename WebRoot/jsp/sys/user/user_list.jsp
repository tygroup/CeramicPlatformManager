<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/displaytag" prefix="display" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%
	
	String path = request.getContextPath();
String app = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	

<html>
<head>
<%@ include file="../../../js/meta.jsp" %>
<%@ include file="../../../js/ext-yui.jsp"%>
 
<script language="javascript">
function doForward(param){
	document.location.href='<%=app%>'+param;
	
}
function clean(){
	document.location.href='<%=app%>user_list.action';
}
</script>
</head>

<body>

<div class="title">
		<img src="<%=app%>images/weizhi.png">
		当前位置：
		<a href="<%=app%>jsp/sys/content.jsp">首页</a>
		>
		<a href="user_list.action">用户管理</a> 
	</div>
<!--操作栏开始-->
<div class="con mk">
		<div class="mk_top">
		<!--<input class="input_button" type="button" value="新增" name="add"  onclick="doForward('user_toAdd.action')"/> -->
			<input class="input_button1" type="button" value="密码重置" name="delete"  onclick="chkForResetPass(document.frm);"/>
		</div>
<!--    <td width=60><input class="input_button" type="button" value="删除" name="delete"  onclick="chkForDelete(document.frm);"/></td>-->
<div class="sousuo">
		<form method="get" action="user_list.action" >
		 用户账号: <input type="text" name="account" maxlength="20" value="${account }"/>
		 用户名称:<input type="text" name="userName" maxlength="20" value="${userName }"/>
		<%-- <label>状态:</label><select  name="state"  style="width: 80px" class="choice">
					<option value="" >全部</option>
					<option value="0"<c:if test="${state=='0' }">selected</c:if>>启用</option>
					<option value="1" <c:if test="${state=='1' }">selected</c:if>>禁用</option>
				</select> --%>
			<input class="input_sel"  type="submit" value="查询" name="" />
			<input class="input_reset" type="button" value="重置"  onclick="clean();" />
		</form>
	</div>
	<div class="clr"></div>

<!--操作栏结束-->


<form action="<%=app %>user_resetPassBatch.action" name="frm" style="padding:12px">
<display:table name="usersList" class="con" cellspacing="1" sort="list" excludedParams="message" id="row" defaultsort="0"   requestURI="/user_list.action" defaultorder="ascending"  pagesize="${pageSize}"  partialList ="true"  size ="totalCount">

	<display:setProperty name="paging.banner.placement">bottom</display:setProperty>
		<display:column title="序号" style="width:50px"><span class="number">${row_rowNum}</span></display:column>	
		<display:column title='<input type="checkbox" class="allbox" name="allbox" onclick="changeAll(this.form,0)">' style="width:50px">
			<input type="checkbox" name="id" value='${row.userid}' onClick="changeOne(this,'trLine<c:out value="${((row_rowNum+1) mod 2)+1 }" />');">
		</display:column>
		<display:column title="用户账号" style="white-space:nowrap;">
			${row.account}
		</display:column>
		<display:column title="昵称" style="white-space:nowrap">
			${row.petname}
		</display:column>
		<display:column title="详细地址" style="white-space:nowrap">
			${row.address}
		</display:column>
		<display:column title="出生日期" style="white-space:nowrap">
			<fmt:formatDate value="${row.birthday}" pattern="yyyy-MM-dd"/>
		</display:column>
		<display:column title="性别" style="white-space:nowrap">
		<c:if test="${row.sex==1}">男</c:if>
		<c:if test="${row.sex==0}">女</c:if>
		</display:column>
		<display:column title="状态" style="width:40px">
		<c:if test="${row.state==0}">启用</c:if>	
		<c:if test="${row.state==1}">禁用</c:if>	
		</display:column>
		<display:column title="操作" style="width:150px">
			<%-- <input class="input_button" type="button" value="修改" name="edit"  onclick="doForward('user_edit.action?userId=${row.userid}')"/>
 --%><input class="input_add" type="button" value="重置密码" name="edit"  onclick="deletes('user_resetPassBatch.action?id=${row.userid}')"/>
		</display:column>						
							
	</display:table>
</form>
</div>
</body>
<script type="text/javascript">

function deletes(param){
	if(confirm("您确定要重置密码吗？")){
		document.location.href='<%=app%>'+param;
	}else{
		return ;
	}

}


</script>
</html>

