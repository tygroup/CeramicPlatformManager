<%@ page contentType="text/html;charset=utf-8" %>


<%
	String path = request.getContextPath();
	String app = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>主页</title>
	<link href="<%=app%>css/public.css" rel="Stylesheet" type="text/css" />
	<link href="<%=app%>css/style.css" rel="Stylesheet" type="text/css" />
</head>
<body>
	<div class="main"></div>
</body>
</html>