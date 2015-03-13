/************************** 用户信息 start **************************/
var dataTable_tanchu;
var dataTableSearchCondition_tanchu=new Array();
var dataTableSearchCondition_tanchusearch=new Array();
var dataTableReqUrl_tanchu; // 请求url
var zbcount_tanchu;
/************************** 01 init dataTable  start**************************/
$.initDataTable_tanchu = function() {

	dataTable_tanchu = $('#dataTableId_tanchu')
			.dataTable(
					{
						"oLanguage" : {
							"sSearch" : "搜索:",//搜索
							"sLengthMenu" : "_MENU_ 条/页",
							"sZeroRecords" : "对不起,搜索数据不存在！",
							"sInfo" : "显示第  _START_ 条到第  _END_ 条记录,一共  _TOTAL_ 条记录",
							"sInfoEmpty" : "搜索到0条",
							"sInfoFiltered" : "",
							"oPaginate" : {
								"sPrevious" : "上一页",
								"sNext" : "下一页"
							}
						},
						"bPaginate" : false, //分页按钮
						"bFilter" : false, //搜索栏
						"bLengthChange" : true, //每行显示记录数
						"iDisplayLength" : -1, //每页显示行数
						"bSort" : false, //排序
						"bInfo" : true, //Showing 1 to 10 of 23 entries 总记录数中显示多少等信息
						"bAutoWidth" : false, //自动计算列宽度
						"sPaginationType" : "bootstrap",
						"sDom" : "<'row-fluid'<'span6'l>r>C<'clear'>t<'row-fluid'<'span6'i><'span6'p>>",

						"aaSorting" : [ [ 1, 'asc' ] ],
						"aLengthMenu" : [ [ 15, 20, 30, -1 ],
								[ 15, 20, 30, "All" ] ],
						"bProcessing" : false,
						"bServerSide" : true,
						"sAjaxSource" : dataTableReqUrl_tanchu, //传递请求的地址
						"aoColumns" : [
//								
									{
									"mDataProp" : function(row) {
										return '<input type="checkbox" class="checkboxes" onchange="zbshuliang(this)" name="zbid" value='
										+ row.zbid + ' />';
									},
									'sWidth' : '3%'
									
								},
								
								{
									"mDataProp" : "zbmc",
									'sWidth' : '8%'
										
								}, // 学号
								{
									"mDataProp" : "zbms",
									'sWidth' : '8%'
										
								}, // 学号
								/*{
									"mDataProp" : "fsqj",
									'sWidth' : '7%'
								}, // 班级
*/							
								{
									"mDataProp" : "tcr",
									'sWidth' : '6%'
										
								}
								 
						],

						"fnServerData" : function(sSource, aoData, fnCallback) {
							$.rest.fnServerData1(
									dataTableSearchCondition_tanchusearch, sSource, aoData,
									fnCallback);
						
						},
						
						"fnDrawCallback" : function(oSettings) {
							if (oSettings.aiDisplay.length == 0) {
								return;
							}
							$.rest.TrCheckboxStatus("click",
									$("#dataTableId tbody tr"));
							
						}
						

					});

};
$.rest.fnServerData1 =function(dataTableSearchCondition_tanchusearch,sSource, aoData,fnCallback){
		//将查询条件中的数据存放到 aoData中
	
		for(var i = 0;i<dataTableSearchCondition_tanchusearch.length;i++){
			aoData.push(dataTableSearchCondition_tanchusearch[i]);
		}
		$.ajax({
			"type" : 'POST',                            //请求方式
			"url" : sSource,    
			"async": false, 
			"dataType" : "json",                       //返回的数据类型 
			"data" : {	                               //发送的参数				
				aoData : JSON.stringify(aoData)       //前面这个参数名是可以进行修改的，但是要与后台的参数名一致
			},
			"success" : function(data) {
				if(data.result == 'success'){
					fnCallback(data.object);
				}else{
					alert(data.msg);
				}
			
			}
		});
};
$.tanchusearch=function(){
	dataTableSearchCondition_tanchusearch.length=0;
	dataTableSearchCondition_tanchusearch=dataTableSearchCondition_tanchu.slice();
	dataTableSearchCondition_tanchusearch.push({
		"name":"zbmc",
		"value":$("#zbmctanchu").val()
	});
	
	dataTable_tanchu.fnDraw();
}
$.yxxinzeng=function(){
	$dialog.close();
	$('#yxzbadd').trigger("click");
}
$.jsxinzeng=function(){
	$dialog.close();
	$.GrjszbAdd1();
}





