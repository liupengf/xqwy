/************************** 用户信息 start **************************/


var groupCheckable_1 = $('#dataTableId_1 .group-checkable');
/************************** 01 init dataTable  start**************************/
$.initDataTable_1 = function() {
	//列表
	dataTable_1 = $('#dataTableId_1')
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
						"bPaginate" : true, //分页按钮
						"bFilter" : false, //搜索栏
						"bLengthChange" : true, //每行显示记录数
						"iDisplayLength" : 15, //每页显示行数
						"bSort" : false, //排序
						"bInfo" : true, //Showing 1 to 10 of 23 entries 总记录数中显示多少等信息
						"bAutoWidth" : false, //自动计算列宽度
						"sPaginationType" : "bootstrap",
						"sDom" : "<'row-fluid'<'span6'l>r>C<'clear'>t<'row-fluid'<'span6'i><'span6'p>>",

						"aaSorting" : [ [ 1, 'asc' ] ],
						"aLengthMenu" : [ [ 15, 20, 30],
								[ 15, 20, 30] ],
						"bProcessing" : false,
						"bServerSide" : true,
						"sAjaxSource" : dataTableReqUrl, //传递请求的地址
						"aoColumns" : [
								{
									"mDataProp" : function(row) {
										return '<input type="checkbox" class="checkboxes" name="zbid" value='
												+ row.zbid + ' />';
									},
									'sWidth' : '3%'
								}, // 指标分类
								
								{
									"mDataProp" : "zbmc",
									'sWidth' : '4%'
								}, //指标名称
								{
									"mDataProp" : "zbms",
									'sWidth' : '19%'

								}, // 指标描述
//								{
//									"mDataProp" : "fsqj",
//									'sWidth' : '5%'
//								}, // 分数区间
								
								{
									"mDataProp" : "tcrxm",
									'sWidth' : '4%'
								}, // 提出人

							
								{
									"mDataProp" : 'dwmc',
									'sWidth' : '7%'
								}, // 所属院系								
							
						
								{
									"mDataProp" : function(row) {
										var viewUrl = dataTableViewUrl + '/'
												+ row.zbid;
										if (row.zbms !== null) {
											/*return '<a href=javaScript:void(0); onclick="$.beforeZbtjbView('
													+ row.zbid
													+ ')">查看</a>'
													+ '&nbsp;||&nbsp;
*/													return '<a href=javaScript:void(0); onclick="$.shtg_1('
													+ row.zbid + ')">审核通过</a>'
											+ '&nbsp;||&nbsp;<a href=javaScript:void(0); onclick="$.shbtg_1('
											+ row.zbid + ')">审核不通过</a>';
										} else {
											return "";
										}
									},
									"bSortable" : false,
									'sWidth' : '6%'
								} // 操作
						],

						"fnServerData" : function(sSource, aoData, fnCallback) {
							$.rest.fnServerData(loadingDivId_1,
									dataTableSearchCondition_1, sSource,
									aoData, fnCallback);
						},

						"fnDrawCallback" : function(oSettings) {
							if (oSettings.aiDisplay.length == 0) {
								return;
							}

						}

					});
	$.rest.allSelectOrNot(groupCheckable_1); 
};
