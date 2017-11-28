<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%
	String path = request.getContextPath();
	String app = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<%@ include file="../../../js/meta.jsp"%>

<script src="<%=app%>js/common/jquery-1.4.4.min.js"
	type="text/javascript"></script>
<link rel="stylesheet" href="<%=app%>css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<link rel="stylesheet" href="<%=app%>css/zTreeStyle/demo.css"
	type="text/css">
<script type="text/javascript"
	src="<%=app%>js/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript"
	src="<%=app%>js/ztree/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="<%=app%>js/ztree/search_tree.js"></script>
<script language="javascript">

function chkSubmit(frm) {

	var roleId = document.getElementById("roleId").value;

	var bureauid = document.getElementById("bureauid").value;
	if (bureauid == "") {
		alert("请选择绑定教育局！");
		return false;
	}
	if (roleId == "201509081049509941") {
	var schoolid = document.getElementById("schoolid").value;
		if (schoolid == " ") {
			alert("请选择所属学校！");
			return false;
		}
	}

	if (frm.username.value == "") {
		alert("用户名称不能为空！");
		return false;
	}

	var phonenum = document.getElementById("phonenum").value;
	if(phonenum==""){
		alert("联系电话不能为空！");
			return false;
	}else{
	if(!isPhoneNo(phonenum)&&!isMobileNo(phonenum)){
	alert("联系电话输入不正确！");
			return false;
	}
	}
	
	var useremail=document.getElementById("useremail").value;
	if(useremail!=""){
		if(!isEmail(useremail)){
			alert("电子邮箱不正确！");
			return false;
		}
		
	}
	frm.submit();
}



</script>

<!--栏目导航开始-->
<div id=portal-navigator-top>
	<img src="<%=app%>js/common/images/nav_triangle.gif">&nbsp;<span
		class="nav_label">用户修改</span>
</div>
<!--栏目导航结束-->

</br>

</head>

<div id="body">
	<div class="newborder" style="width:880px;">
		<form action="<%=app%>user_update.action" name="frm"
			 method="post">
			
			<input name="user.userid" id="userid" type="hidden" value="<s:property value='user.userid'/>" />
			<table cellspacing="0">
				<tr>
					<td>账号:</td>
					<td><s:property value='user.account'/></td>
				</tr>
				<tr>
					<td>账号类型:</td>
					<td>
					<c:if test="${user.roleid=='201509081049509941'||user.roleid=='201510061029556606'||user.roleid=='201509171038294150'||user.roleid=='201510231405267837'}">
					<s:property value='user.rolename'/>
					<input name="roleId" id="roleId" type="hidden" value="<s:property value='user.roleid'/>" />
					</c:if>
					<c:if test="${user.roleid!='201509081049509941'&&user.roleid!='201510061029556606'&&user.roleid!='201509171038294150'&&user.roleid!='201510231405267837'}">
					<select name="roleId" id="roleId">
							<c:forEach items="${sysRoleList}" var="list">
								<option value="${list.roleid }" <c:if test="${list.roleid==user.roleid}">selected="selected"</c:if>>${list.rolename }</option>

							</c:forEach>

					</select>&nbsp;&nbsp;<font
						color="red">*</font>
					</c:if>
					
					</td>
				</tr>

				<tr>
					<td>绑定教育局:</td>
					<td>
					<input
						type="hidden" name="bureauid" id="bureauid" value="${bureau.bureauid }"/>
						<div>
							

								<input id="citySel" type="text" readonly size="30"
									onclick="showMenu();" />
					<font color="red">*</font>
								

							
						</div>



						<div id="menuContent" style="display:none; position: absolute;  top:80px; *top:35px;z-index:111;">
							<ul id="treeDemo" class="ztree"
								style="margin-top:0; width:180px; height: 300px;">

							</ul>
							
							<input id="search_condition" type="text" placeholder="输入搜索条件"
								 style="font-size:12px; width:82px; *width:95px;" size="10"/>&nbsp;<button type="button" 
								onclick="search_ztree('treeDemo', 'search_condition')">搜索</button>&nbsp;<button type="button" 
								onclick="hideMenu()">关闭</button>
						</div>
					</td>
				</tr>
<c:if test="${userinfo.schoolid!=null }">
				<tr id="schoolTr">
					<td>所属学校:</td>
					<td><select name="userinfo.schoolid" id="schoolid"
						style="width:160px" size="1">

							<option value="${school.schoolid}">${school.schoolname}</option>



					</select>&nbsp;&nbsp;<font
						color="red">*</font></td>
				</tr>
</c:if>
				<tr>
					<td>用户名称:</td>
					<td><input type="text" name="userinfo.username" id="username" value="<s:property value='userinfo.username'/>"
						maxlength="20" />&nbsp;&nbsp;<font color="red">*</font></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td><select type="text" name="userinfo.usersex" id="usersex" >
					<option value="0" <c:if test="${userinfo.usersex=='0'}">selected="selected"</c:if>>男</option>
					<option value="1" <c:if test="${userinfo.usersex=='1'}">selected="selected"</c:if>>女</option>
						</select>
						</td>
				</tr>
				<td>联系电话:</td>
				<td><input type="text" name="userinfo.phonenum" id="phonenum" value="<s:property value='userinfo.phonenum'/>"
					maxlength="20" />&nbsp;&nbsp;<font color="red">*</font></td>
				</tr>
				<td>电子邮箱地址:</td>
				<td><input type="text" name="userinfo.useremail" id="useremail" value="<s:property value='userinfo.useremail'/>"
					maxlength="100" />&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td>状态:</td>
					<td><select type="text" name="user.state" id="state" >
					<option value="0" <c:if test="${user.state=='0'}">selected="selected"</c:if>>启用</option>
					<option value="1" <c:if test="${user.state=='1'}">selected="selected"</c:if>>禁用</option>
						</select>
						</td>
				</tr>
			</table>
			<div align="center" style="padding-top:10px;">

				<input class="input_button" type="button" value="保存" name="save"
					onclick="chkSubmit(frm);" /> <input class="input_button" type="button"
					value="返回" name="back" onclick="javascript:window.history.go(-1);" />
			</div>
		</form>
	</div>
</div>

<SCRIPT type="text/javascript">
		<!--
		var setting = {
			view: {
				dblClickExpand: false,
					fontCss : setFontCss_ztree
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				
				onClick: onClick
			}
		};

		var zNodes =${bureauJson};

		function onClick(e, treeId, treeNode) {
		   if (treeNode) {
            var cityObj = $("#citySel");
            var bureauid=$("#bureauid");
            cityObj.attr("value", treeNode.name);
            bureauid.attr("value", treeNode.id);
              hideMenu();
            var roleId=document.getElementById("roleId").value;
//学校管理员主键

if(roleId=="201509081049509941"){
$.ajax({
             type: "post",
             url: "<%=app%>schoolManager_schoolSelect.action",
             async:false,
             data: {bureauId:treeNode.id},
             dataType: "json",
             success: function(data){
             //	var productList = eval('('+responseText+')');
             	
		var select = document.getElementById("schoolid");
		select.options.length=0;
		
		var selectopt = document.createElement("OPTION");
		selectopt.text = "请选择";
		selectopt.value=" ";
		select.add(selectopt);
		  $.each(data.schools,function(i,item){

            var opt = document.createElement("OPTION");
			opt.value =item.id;
			opt.text = item.text;
			select.add(opt);

});
	select.options[0].selected = "selected";	
	},	
	

         });
}
          
        }
			
		}

		function showMenu() {
			var cityObj = $("#citySel");
			var cityOffset = $("#citySel").offset();
			$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

			$("body").bind("mousedown", onBodyDown);
		}
		function hideMenu() {
			$("#menuContent").fadeOut("fast");
			$("body").unbind("mousedown", onBodyDown);
		}
		function onBodyDown(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
				hideMenu();
			}
		}
	//默认选中
	function setCheck() {
		
		var citySel = $("#citySel");
		citySel.val("${bureau.bureauname}");
		

	}
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			setCheck();
		});
		//-->
	</SCRIPT>
</html>
