<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%
String path = request.getContextPath();
String app = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<script type="text/javascript" src="<%=app %>js/jquery-1.10.2.min.js"></script>  
<script type="text/javascript" src="<%=app %>js/showlist.js"> </script> 
<link href="<%=app %>css/style.css" rel="Stylesheet" type="text/css" />
<link href="<%=app %>css/public.css" rel="Stylesheet" type="text/css" />
</head>
<body>

<div class="list">
        <div class="nav">&nbsp;系统导航</div>  
        <div id="nav">
        <ul class="yiji">  
        	<c:forEach items="${trees}" var="trees">
				<c:forEach items="${trees.childs}" var="tree">
            	<li><a href="#" class="inactive"><img src="<%=app%>images/nav_manage.png">${tree.modulename }</a>
	                 <ul> 
	                 <c:forEach items="${tree.childs }" var="childs1"> 
	                    <li><a href="${childs1.url }"  target="select"> ${childs1.modulename }</a></li>  
	                    </c:forEach>
	                </ul>
            	</li>
              	</c:forEach>
			</c:forEach>
           
        </ul> 
        </div> 
    </div>  
<script type="text/javascript">
        $(function(){
          $("#nav ul li ul li").click(function(){
	            var index = $(".nav ul li").index(this);
	        	$(this).addClass("navdown").siblings().removeClass("navdown");
				$(".nav>a").removeClass("navdown")
            	//$("#nav ul li ul li").eq($(this).index()).addClass("navdown").siblings().removeClass("navdown");
          })
        })
</script>

<%--  <div id="left_menu"> 
			<div id="menu">
				<ul>
					<li>
						<a href="#" class="clearfix">
							<img src="<%=app%>images/home01.png" class="icon" alt=""/>
							系统模块
							<span></span>
						</a>
					</li>
				<c:forEach items="${trees}" var="trees">
				<c:forEach items="${trees.childs}" var="tree">
					<li>
						<a href="#" class="clearfix">
							<img src="<%=app%>images/plus-small.png" class="icon" alt=""/>
							${tree.modulename }
							<span></span>
						</a>
						
						 <!-- Sub items --> 
						<ol class="clearfix">
							<c:forEach items="${tree.childs }" var="childs1">
								<li>
									<a href="${childs1.url }" target="main">
										<img src="<%=app%>images/mail-small.png" class="icon" alt="Dashboard" />
										 ${childs1.modulename }
									</a>
								</li>
								
							</c:forEach>
						</ol>
					</li>
					</c:forEach>
				</c:forEach>
			</ul>
</div></div> --%>
</body>
</html>