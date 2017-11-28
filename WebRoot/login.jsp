<%@ page language="java" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String app = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>全国老龄网管理系统登录</title>
<link href="<%=app %>css/public.css" rel="Stylesheet" type="text/css" />
<link href="<%=app %>css/style.css" rel="Stylesheet" type="text/css" />

	<link rel="icon" href="<%=app%>favicon.ico" type="image/x-icon"> 
</head> 
<body onload="shouMsg();">
		<div class="login">
		<div class="login_div">
	<form action="<%=app%>user_login.action" name="frm" method="post">
		  <h2>用户登录</h2>
		  <input type="hidden" id="msg" value="${message}">
			<p>
				<label><img src="<%=app%>images/login_user.png" ></label>
				 <input onkeypress=enter(event,this.form) name="user.name"
					id="loginName" class="btn" type="text" maxlength="11"/></label>
			</p>
			<p>
				<label><img src="<%=app%>images/login_pwd.png" ></label>
				 <input onkeypress=enter(event,this.form)
					type="password" class="btn" name="user.password" id="password" maxlength="10"/></label>
			</p>
			<p>
				<label><img src="<%=app%>images/login_num.png" ></label>
				<span><input onkeypress=enter(event,this.form) value=""
					type="text" class="btn" name="rand" maxlength="4" />
				</span>&nbsp;&nbsp;<a href="javascript:loadimage();"><img alt="看不清点我"
					name="randImage" id="randImage" src="<%=app%>jsp/sys/image.jsp">
				</a>
			</p>
			<div>
				<input name="" class="dl" type="button" value="登录" onclick="chkSubmit(frm);">&nbsp;&nbsp;<input
					name="" class="cz" type="button" value="重置" onclick="reset(frm);">
			</div>
	</form>
		</div>
</div>

</body>
<script>

 if (top != window)    
      top.location.href = window.location.href;    
</script>
<SCRIPT language=JavaScript type=text/javascript>

  var focusControl = document.forms["frm"].elements["loginName"];
  if (focusControl.type != "hidden" && !focusControl.disabled) {
     focusControl.focus();
  }
function reset(frm){
  frm.loginName.value ="";
  frm.password.value="";
  frm.rand.value="";
}
function chkSubmit(frm) {

 /*    if (frm.loginName.value.length==0) {
    	alert("登录账号不允许为空!");
    	return false;
    }
    if (frm.password.value.length==0) {
    	alert("密码不允许为空!");
    	return false;
    }

    if (frm.rand.value.length==0) {
    	alert("请输入图形验证码!");
    	return false;
    }   */

    frm.submit();
}

function enter(event,frm) {
   var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode==13){  {
		chkSubmit(frm);
	}
 
  }
	
}

function loadimage(){ 
document.getElementById("randImage").src = "<%=app%>jsp/sys/image.jsp?"+ Math.random();
	}

function shouMsg() {
   if (window != top) 
       top.location.href = location.href; 
		var msg = document.getElementById("msg").value;
		if (msg.length != 0) {
			alert(msg);

		}
	 document.getElementById("loginName").focus();
	 
	}
	
 
</SCRIPT>

</html>
