<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><%@ page
	import="com.cpf.bean.sys.Users"%>
<%
String path = request.getContextPath();
String app = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Users user=(Users)request.getSession().getAttribute("user");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge" /> 
<title>全国老龄网管理系统</title>
<link href="<%=app%>css/style.css" rel="Stylesheet" type="text/css" />
<link href="<%=app%>css/public.css" rel="Stylesheet" type="text/css" />
<script  type="text/javascript">
//
function goHomePage(){        
	if(!confirm("确实要执行【退出】吗？")) return;
	window.location.href="<%=app%>user_loginOut.action";
}

 
</script>
</head>

<!--header开始 
	<div class="header">
		<div class="header_l fl">
			<img src="<%=app%>images/logo.png"></div>
		<div class="header_r fr">
			<p>
				欢迎您，
				<span><%=user.getAccount() %>！</span>
				&nbsp;&nbsp;<script type="text/javascript">
document.write(new Date().getFullYear()+"年"+(new Date().getMonth()+1)+"月"+new Date().getDate()+"日")
</script>
			</p>
			<p>
				<a href="<%=app %>jsp/sys/user/userChangePass.jsp"  target="select">
					<img src="<%=app%>images/icon_pwd.png"  />
					修改密码
				</a>
				<a href="#" onclick="javascript:goHomePage();">
					<img src="<%=app%>images/icon_exit.png" />
					退出
				</a>
			</p>

		</div>
	</div>
	 
	<div class="box_left">
		<div class="box_left_div">
			<div class="box_left_div_div">
				<iframe name="module" scrolling="no" width="100%" height="100%" onload="this.height=this.document.documentElement.scrollHeight" frameborder="0" src="leftmenu.jsp"></iframe>
			</div>
		</div>
	</div>

	 
<div class="box_right">
		<div class="box_right_div">
			<div class="box_right_div_div">
				<iframe name="select" scrolling="auto" width="100%" height="100%" onload="this.height=this.document.documentElement.scrollHeight" frameborder="0" src="content.jsp"></iframe>
			</div>
		</div>
	</div>
	<!--box结束-->
 <frameset rows="90px,*,35px" cols="*" name="body" id="body" frameborder="no" border="0"  framespacing="0">
  <frame src="<%=app%>jsp/sys/top.jsp"  name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
  <frameset rows="100%" cols="200px,*" framespacing="0"  frameborder="no" border="0" >
    <frame src="<%=app%>jsp/sys/leftmenu.jsp" name="leftFrame"   style="border-right:5px #0068c3 solid" scrolling="auto" noresize="noresize" id="leftFrame" />
    <frame src="<%=app%>jsp/sys/content.jsp" name="select" id="main"  scrolling="auto"    />
  </frameset>
    <frame src="<%=app%>jsp/sys/footer.jsp"  name="rightFrame" ></frame>
</frameset>
<noframes><body>
</body>
</noframes></frameset> 

</html>
