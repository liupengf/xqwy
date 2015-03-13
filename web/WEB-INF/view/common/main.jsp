<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<jsp:include page="constants.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv = "X-UA-Compatible" content = "IE=edge">
<title>主页 -${sysName}</title>
<%@ include file="head.jsp"%>
</head>
<body class="">
	<!--顶部-->
	<%@ include file="topbar.jsp"%>
	<!--主体--> 
	<div class="page-container row-fluid">
		<!--左边主菜单-->
		<%@ include file="menu.jsp"%>
		<!--中间主体内容-->
		<div class="page-content" style="min-height: 1024px">
			<div class="page-content-body">
<div class="row-fluid" style="background-color: #FFFAFA;min-height: 1024px;text-align: center;">
<div style="margin-top: 260px;">
<span>
<font style="font-size: 60px;font-family:KaiTi_GB2312;font-style: italic;">欢迎使用小区物业管理系统</font>

</span>
</div>
</div>
			</div>
		</div>
	</div>
	
	<!--底部-->
	<%@ include file="footbar.jsp"%>
	<!--引入的公共js-->
	<%@ include file="scripts.jsp"%>
	<script>
		var baseUrl = '${baseUrl}';
		jQuery(document).ready(function() {
			App.init();
			//加载目录树
			$("#fwguanli").click();
		});
	</script>
	
</body>
</html>