<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ page import="com.cpf.bean.sys.*"%>
<%
	String path = request.getContextPath();
String app = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<html>
<head>
<link rel="shortcut icon" href="<%=app%>/favicon.ico" />
<script type="text/javascript" src="<%=app%>js/common/dtree/dtree.js"></script>
<link href="<%=app%>js/common/dtree/dtree.css" rel="stylesheet"
	type="text/css" />
<%@ include file="../../../js/meta.jsp"%>
<%@ include file="../../../js/ext-yui.jsp"%>
<script language="javascript">


  function getDataString(){
 	
			var substr="";
			var subids = document.all("ids");
			for(var i=0;i<subids.length;i++){
				if(subids[i].checked&&subids[i].value.length>0){
					substr+=","+subids[i].value;
				}
			}
			if(substr.length>0)document.frm.nodeDozen.value=substr.substring(1);
		
			
	  if (window.confirm("确定保存用户 ${user.username} 的角色？")) {
			document.frm.submit();
		}
  }
</script>

</head>

<body>

	<!--操作栏开始-->
	<div id=portal-operation>
		<table width="100%">
			<tbody>
				<tr>
					<td colspan=4 align="left">您现正在为用户<span class="msg">${user.username}</span>
						分配角色</td>
				</tr>
				<tr>
					<td width=400 colspan="4" align="center">
						<!--     <input  type=button id="expand" value="展开" onclick="if (document.getElementById('expand').value=='展开') {d.openAll();document.getElementById('expand').value='折叠';} else {d.closeAll();document.getElementById('expand').value='展开';}"/>-->
						<input class="input_button" type="button" value="保存" name="save"
						onclick="javascript:getDataString();" /> <input class="input_button" type="button"
						value="关闭" name="close"
						onclick="javascript:parent.layoutDialog.hide();" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!--操作栏结束-->

	<div id="body">
		<div id=line></div>


		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="0" valign="top">
			<form name="frm" action="<%=app%>user_grant.action"
				method="POST">
				<input type="hidden" name="nodeDozen" /> <input type="hidden"
					name="user.userid" value="${user.userid}"/>
				<tr valign="top" height="200">
					<td align="left" width="100%" valign="top" height="200"><script
							language="JavaScript">
         d = new dTree('d');
                             
                                d.config.target = "mainFrame";
                               	d.config.useCheckBox=true;
                                d.config.imageDir = '<%=app%>js/common/dtree/img';
                                d.reSetImagePath();
                                d.config.folderLinks = false;
                                d.config.closeSameLevel = false;
                                d.config.check=true;
                                d.config.mycheckboxName="ids";
                             //	d.add(0,-1,'角色');
                            	
                            	 <% 
                            	
                            	List<SysRole> list=(List<SysRole>)request.getAttribute("sysRoleList");
                            	 for(SysRole e:list){%>	d.add('<%=e.getRoleid()%>','0','<%=e.getRolename()%>');
							<%}%>
								document.write(d);
								d.setCheck('${checkedStr}');
								d.closeAll();
							</script></td>
				</tr>
			</form>
		</table>
		<div id=line></div>
	</div>

	<!--操作栏开始-->
	<div id=portal-operation>
		<table width="100%">
			<tbody>
				<tr>
					<td width=400 colspan="4" align="center"><input class="input_button" type="button"
						value="保存" name="save" onclick="javascript:getDataString();" /> <input
						type="button" value="关闭" name="close"
						onclick="javascript:parent.layoutDialog.hide();" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!--操作栏结束-->
</body>
</html>
