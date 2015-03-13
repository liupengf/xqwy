<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="styles.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>²âÊÔ±¨±í</div>
<div id="pie_chart">

</div>
</body>
	<%@ include file="scripts.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
	
	
var data = [];
var series = Math.floor(Math.random() * 10) + 1;
series = series < 5 ? 5 : series;

for (var i = 0; i < series; i++) {
    data[i] = {
        label: "Series" + (i + 1),
        data: Math.floor(Math.random() * 100) + 1
    }
}

// DEFAULT
$.plot($("#pie_chart"), data, {
        series: {
            pie: {
                show: true
            }
        }
    });
});
</script>
</html>
