<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="row-fluid">
	<div class="span4"></div>
	<div class="span8" id="bxgraph">
	
	</div>
	</div><div class="row-fluid">
	<div class="span4"></div>
	<div id="tsgraph" class="span8">
	
	</div>
	<script type="text/javascript">
	$(document).ready(function(){
		
	$.post(baseUrl+"/b/xqwy/bb/xtbb/pageList",function(data){
		var datalist=data.object;
	
	var bxmyChart = new JSChart('bxgraph', 'pie');
	var bxmyarray=new Array();
	for(var i=0;i<datalist.length;i++){
		if(datalist[i].lb=='bx'){
			
		var a=new Array(datalist[i].name,datalist[i].con);
		bxmyarray.push(a);
		}
	}

	bxmyChart.setDataArray(bxmyarray);
	//myChart.setDataArray([['A', 40],['B', 16],['C', 20],['D', 10],['E', 10],['F', 4]]);
	//myChart.colorize(['#99CDFB','#3366FB','#0000FA','#F8CC00','#F89900','#F76600']);
	bxmyChart.setSize(600, 300);
	bxmyChart.setTitle('报修统计报表');
	bxmyChart.setTitleFontFamily('Times New Roman');
	bxmyChart.setTitleFontSize(14);
	bxmyChart.setTitleColor('#0F0F0F');
	bxmyChart.setPieRadius(95);
	bxmyChart.setPieValuesColor('#FFFFFF');
	bxmyChart.setPieValuesFontSize(9);
	bxmyChart.setPiePosition(180, 165);
	bxmyChart.setShowXValues(true);
	bxmyChart.setLegendShow(true);
	bxmyChart.setLegendFontFamily('Times New Roman');
	bxmyChart.setLegendFontSize(10);
	bxmyChart.setLegendPosition(350, 120);
	bxmyChart.setPieAngle(30);
	bxmyChart.set3D(true);
	bxmyChart.draw();
	var tsmyChart = new JSChart('tsgraph', 'pie');
	var tsmyarray=new Array();
	for(var i=0;i<datalist.length;i++){
		if(datalist[i].lb=='ts'){
			
		var a=new Array(datalist[i].name,datalist[i].con);
		tsmyarray.push(a);
		}
	}

	tsmyChart.setDataArray(tsmyarray);
	//myChart.setDataArray([['A', 40],['B', 16],['C', 20],['D', 10],['E', 10],['F', 4]]);
	//myChart.colorize(['#99CDFB','#3366FB','#0000FA','#F8CC00','#F89900','#F76600']);
	tsmyChart.setSize(600, 300);
	tsmyChart.setTitle('投诉统计报表');
	tsmyChart.setTitleFontFamily('Times New Roman');
	tsmyChart.setTitleFontSize(14);
	tsmyChart.setTitleColor('#0F0F0F');
	tsmyChart.setPieRadius(95);
	tsmyChart.setPieValuesColor('#FFFFFF');
	tsmyChart.setPieValuesFontSize(9);
	tsmyChart.setPiePosition(180, 165);
	tsmyChart.setShowXValues(true);
	tsmyChart.setLegendShow(true);
	tsmyChart.setLegendFontFamily('Times New Roman');
	tsmyChart.setLegendFontSize(10);
	tsmyChart.setLegendPosition(350, 120);
	tsmyChart.setPieAngle(30);
	tsmyChart.set3D(true);
	tsmyChart.draw();
	});
	});
	</script>
	</div>

