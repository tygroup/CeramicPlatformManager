<%@ page language="java" pageEncoding="utf-8"%>
<%@ page
	import="com.cpf.bean.sys.Users"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String app = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + path + "/";
	Users user=(Users)request.getSession().getAttribute("user");		
			
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=app%>css/style.css" rel="Stylesheet" type="text/css" />
	<link href="<%=app%>css/public.css" rel="Stylesheet" type="text/css" />
<script src="<%=app%>js/common/jquery.js" type="text/javascript"></script>
<title>密码修改</title>
</head>
<body onload="shouMsg();">

<div class="title">
		<img src="<%=app%>images/weizhi.png">
		当前位置：
		<a >修改密码</a>
		
<div class="list_tit">
	<form action="<%=app%>user_chagePass.action" name="frm" method="post">
		<input type="hidden" id="msg" value="${message}">
			<table class="form_table">
			<tr>
				<td style="text-align:right;" width="100">登录帐号：</td>
				<td><%=user.getAccount() %></td>
			</tr>
			<tr>
				<td style="text-align:right;">新密码：</td>
				<td><input onkeypress=enter(event,this.form)
					type="password"  name="newPass" id="newPass" maxlength="16"/></td>
					</tr>
			<tr>
				<td style="text-align:right;">确认新密码：</td>
				<td><input onkeypress=enter(event,this.form)	type="password" name="newPassSecond" id="newPassSecond" maxlength="16"/>
			</td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align:center;">
				<input class="bt_add" type="button" value="提交" onclick="chkSubmit(frm);"><input
					class="bt_add" type="button" value="重置" onclick="reset(frm);"></td>
					</tr></table>

	</form>
		</div>

</body>
<SCRIPT language=JavaScript type=text/javascript>
  var focusControl = document.forms["frm"].elements["newPass"];
  if (focusControl.type != "hidden" && !focusControl.disabled) {
     focusControl.focus();
  }
function reset(frm){
  frm.newPass.value ="";
  frm.newPassSecond.value="";
 
}
function chkSubmit(frm) {
    var newPass=frm.newPass.value;
    if (newPass.length==0) {
    	alert("请输入新密码!");
    	return false;
    }
    if (frm.newPassSecond.value.length==0) {
    	alert("请输入确认新密码!");
    	return false;
    }

  if(frm.newPass.value != frm.newPassSecond.value){
		alert("两次密码输入不一致，请重新输入！");
			return false;
	}

    frm.submit();
}

function enter(evt,frm) {
  if(window.event != null){
    if (window.event.keyCode==13) {
		chkSubmit(frm);
	}
  }else {
     if(evt.keyCode==13){
        chkSubmit(frm);
     }
  }
	
}
function shouMsg() {
		var msg = document.getElementById("msg").value;
		if (msg.length != 0) {
			alert(msg);

		}
		}

</SCRIPT>

</html>
