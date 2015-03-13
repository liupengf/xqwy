<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="constants.jsp"></jsp:include>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>登录页 </title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<%@ include file="styles.jsp"%>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link href="${baseUrl}/res/ui/metronic/css/login-soft.css" rel="stylesheet"
	type="text/css" /> 
<!-- END PAGE LEVEL STYLES -->
<link rel="shortcut icon"
	href="${baseUrl}/res/ui/metronic/image/favicon.ico" />
</head>
<body class="login">
	<div class="logo">
		<%-- <img src="${baseUrl}/res/ui/metronic/image/logo-big.png" alt="Chinese Academy of Governance" />   --%>
	</div>
	<div class="content" id="loginDivId">
		<form class="form-vertical login-form" action="/b/thuFormLogin" method="POST">
			<h3 class="form-title">请输入用户名密码</h3>
			<div class="alert alert-error hide">
				<button class="close" data-dismiss="alert"></button>
				<span id="errorMsgSpanId">&nbsp;</span>
			</div>
			<div class="control-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">Username</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i> <input class="m-wrap placeholder-no-fix"
							type="text" placeholder="用户名" name="j_username" />
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">Password</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i> <input class="m-wrap placeholder-no-fix"
							type="password" placeholder="密码" name="j_password" />
					</div>
				</div>
			</div>
			<div class="form-actions">
				<label class="checkbox"> &nbsp; </label>
				<button type="submit"
					class="btn blue pull-right enterPressButton">
					登录 <i class="m-icon-swapright m-icon-white"></i>
				</button>
			</div>
			<div class="forget-password">
				<p>
					
				</p>
			</div>
		    <div class="create-account">
				<p>
					请使用统一身份认证用户名和密码登录!
				</p>
			</div> 
		</form>
	</div>

	<%@ include file="scripts.jsp"%>
	
	<script type="text/javaScript" src="${baseUrl}/res/js/common/login.js"></script>
</body>
</html>