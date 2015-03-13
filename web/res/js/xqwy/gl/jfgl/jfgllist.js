/** ************************ 用户信息 start ************************* */
var dataTable;
var dataTableSearchCondition = new Array();// 查询条件
var loadingDivId = $('#loadingDiv');
var dataTableForm = $("#dataTableForm");
var groupCheckable = $('#dataTableId .group-checkable');
var dataTableReqUrl = baseUrl + '/b/xqwy/gl/jfgl/pageList'; // 请求url
var dataTableViewUrl=baseUrl+'/b/xqwy/gl/jfgl/view'
var fwtype;
/** ************************ 01 init dataTable start************************* */
$.initDataTable = function() {
	// 列表
	dataTable = $('#dataTableId')
			.dataTable(
					{
						"oLanguage" : {
							"sSearch" : "搜索:",// 搜索
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
						"bPaginate" : true, // 分页按钮
						"bFilter" : false, // 搜索栏
						"bLengthChange" : true, // 每行显示记录数
						"iDisplayLength" : 15, // 每页显示行数
						"bSort" : false, // 排序
						"bInfo" : true, // Showing 1 to 10 of 23 entries
						// 总记录数中显示多少等信息
						"bAutoWidth" : false, // 自动计算列宽度
						"sPaginationType" : "bootstrap",
						"sDom" : "<'row-fluid'<'span6'l>r>C<'clear'>t<'row-fluid'<'span6'i><'span6'p>>",

						"aaSorting" : [ [ 1, 'asc' ] ],
						"aLengthMenu" : [ [ 15, 20, 30],
								[ 15, 20, 30] ],
						"bProcessing" : false,
						"bServerSide" : true,
						"sAjaxSource" : dataTableReqUrl, // 传递请求的地址
						"aoColumns" : [					

								{
									"mDataProp" : "sfz",
									'sWidth' : '10%'
								},
								{
									"mDataProp" : "xm",
									'sWidth' : '10%'
								},
								{
									"mDataProp" : "xqmc",
									'sWidth' : '10%'
								},
								{
									"mDataProp" : "address",
									'sWidth' : '20%'
								},
								{
									"mDataProp" : "sfmc",
									'sWidth' : '10%'
								},
								{
									"mDataProp" : "je",
									'sWidth' : '10%'
								},
								{
									"mDataProp" : "yjje",
									'sWidth' : '10%'
								},
								{
									"mDataProp" : "sfrq",
									'sWidth' : '10%'
								},
								
								{
									"mDataProp" : function(row) {
										
											
											return	'<a href=javaScript:void(0); onclick="$.beforejfglEdit('+"'"
											+ row.jfid+"'"
											+ ')">修改</a>'+'||<a href=javaScript:void(0); onclick="$.deletezb('+"'"
											+ row.jfid+"'"
											+ ')">删除</a>';
										
										
									},
									"bSortable" : false,
									'sWidth' : '6%'
								} // 操作
								
						],

						"fnServerData" : function(sSource, aoData, fnCallback) {
							$.rest.fnServerData(loadingDivId,
									dataTableSearchCondition, sSource, aoData,
									fnCallback);
						},

						"fnDrawCallback" : function(oSettings) {
							if (oSettings.aiDisplay.length == 0) {
								return;
							}

						}

					});
	$.rest.allSelectOrNot(groupCheckable); // 列表选择 全选/全不选
};

/** ************************ 01 init dataTable end ************************* */

/** ************************ 02 init button start ************************* */
$.deletezb=function(id){
	var delUrl=baseUrl+'/b/xqwy/gl/jfgl/delete';
	$.deletebyid(delUrl, id, dataTable,function(){
		dataTable.fnDraw();
	});
}

$.initButtonClick = function() {
$("#addjfgl").click(function(){
	$.beforejfglAdd();
});
$("#searchjfglButton").click(function(){
	dataTableSearchCondition.length = 0;
	dataTableSearchCondition.push({
		"name" : "sfz",
		"value" : $("#sfz").val()
	});
	dataTableSearchCondition.push({
		"name" : "xm",
		"value" : $("#xm").val()
	});
	dataTable.fnDraw();

});
}
/** ************************ 02 init button end ************************* */

/** ************************ init operate ************************* */
//添加对话框
$.beforejfglAdd = function() {
	var addPageUrl = baseUrl + '/f/xqwy/gl/jfgl/beforeAdd/';
	var type = "add";
	var title = "新增收费";
	$dialog = $.art.page.showDialog("提交", title, addPageUrl, fnAddjfgl);
}
// 执行添加
function fnAddjfgl() {
	var formId = "operateFormId";
	var formType = "";
	var addUrl = baseUrl + "/b/xqwy/gl/jfgl/add";
	var fnCallback = function(data) {
		$.art.page.fnShowResult(data, function() {
			$dialog.close();
			dataTable.fnDraw();

		});
	}
	$.art.rest.toAdd(formId, formType, addUrl, fnCallback);
}

$.beforejfglEdit = function(xxid) {
	var editPageUrl = baseUrl + '/f/xqwy/gl/jfgl/beforeEdit/' + xxid;// 编辑url
	var type = "edit";
	var title = "信息修改";
	$dialog = $.art.page.showDialog(type, title, editPageUrl, fnjfglEdit);
}
// 执行修改
function fnjfglEdit() {
	var formId = "operateFormId";
	var formType = "";
	var editUrl = baseUrl + "/b/xqwy/gl/jfgl/edit";
	var fnCallback = function(data) {
		$.art.page.fnShowResult(data, function() {
			$dialog.close();
			dataTable.fnDraw();
		});
	}
	$.art.rest.toEdit(formId, formType, editUrl, fnCallback);
}

// 加载 用户修改的数据
$.rest.loadData = function(id) {
	var postUrl = baseUrl + '/b/xqwy/gl/jfgl/detail/' + id;
	$.post(postUrl, function(data) {
		var jfgl = data.object;
		$("#jfid").val(jfgl.jfid);
		$("#sfz").val(jfgl.sfz);
		$("#xm").val(jfgl.xm);
		$("#xqmc").val(jfgl.xqmc);
		$("#address").val(jfgl.address);
		$("#sfmc").val(jfgl.sfmc);
		$("#je").val(jfgl.je);
		$("#yjje").val(jfgl.yjje);
		$("#sfrq").val(jfgl.sfrq);
		//$.common.handleUniform();
	});
};

