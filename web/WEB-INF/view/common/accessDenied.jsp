<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>禁止访问</title>
</head>
<body>

	<script>
		$.dialog({
			id : 'message',
			content : 'Sorry,您所访问的资源受限,请联系管理员.',
			icon : 'error',
			lock : true,
			left : '50%',
			top : '30%',
			ok : function() {
			},
			okVal : ' 关  闭 '
		});
	</script>
</body>
</html>