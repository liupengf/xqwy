/** ************************ 用户信息 start ************************* */
var dataTable;
var dataTableSearchCondition = new Array();// 查询条件
var loadingDivId = $('#loadingDiv');
var dataTableForm = $("#dataTableForm");
var groupCheckable = $('#dataTableId .group-checkable');
var dataTableReqUrl = baseUrl + '/b/xqwy/jbxx/zhxx/pageList'; // 请求url
var dataTableViewUrl=baseUrl+'/b/xqwy/jbxx/zhxx/view'
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
						            	   'sWidth' : '13%'
						               },
								{
									"mDataProp" : "xqmc",
									'sWidth' : '13%'
								},
								{
									"mDataProp" : "xm",
									'sWidth' : '13%'
								},
								{
									"mDataProp" : "address",
									'sWidth' : '30%'
								},
								{
									"mDataProp" : function(row) {
											return	'<a href=javaScript:void(0); onclick="$.beforezhxxEdit('+"'"
													+ row.sfz+"'"
													+ ')">修改</a>'+'||<a href=javaScript:void(0); onclick="$.deletezb('+"'"
													+ row.sfz+"'"
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
	var delUrl=baseUrl+'/b/xqwy/jbxx/zhxx/delete';
	$.deletebyid(delUrl, id, dataTable,function(){
		dataTable.fnDraw();
	});
}

$.initButtonClick = function() {
$("#addzhxx").click(function(){
	$.beforezhxxAdd();
});
$("#searchzhxxButton").click(function(){
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
$.beforezhxxAdd = function() {
	var addPageUrl = baseUrl + '/f/xqwy/jbxx/zhxx/beforeAdd/';
	var type = "add";
	var title = "添加住户";
	$dialog = $.art.page.showDialog("提交", title, addPageUrl, fnAddzhxx);
}
// 执行添加
function fnAddzhxx() {
	var formId = "operateFormId";
	var formType = "";
	var addUrl = baseUrl + "/b/xqwy/jbxx/zhxx/add";
	var fnCallback = function(data) {
		$.art.page.fnShowResult(data, function() {
			$dialog.close();
			dataTable.fnDraw();

		});
	}
	$.art.rest.toAdd(formId, formType, addUrl, fnCallback);
}

$.beforezhxxEdit = function(xxid) {
	var editPageUrl = baseUrl + '/f/xqwy/jbxx/zhxx/beforeEdit/' + xxid;// 编辑url
	var type = "edit";
	var title = "信息修改";
	$dialog = $.art.page.showDialog(type, title, editPageUrl, fnzhxxEdit);
}
// 执行修改
function fnzhxxEdit() {
	var formId = "operateFormId";
	var formType = "";
	var editUrl = baseUrl + "/b/xqwy/jbxx/zhxx/edit";
	var fnCallback = function(data) {
		$.art.page.fnShowResult(data, function() {
			$dialog.close();
			dataTable.fnDraw();
		});
	}
	$.art.rest.toEdit(formId, formType, editUrl, fnCallback);
}
/** ************************新增和修改页面表单元素的验证start ************************* */

/** ************************新增和修改页面表单元素的验证start ************************* */
$.initOperateValidate = function() {
	var operateForm = $('#operateFormId');
	// 新增课程验证
	operateForm.validate({
		errorElement : 'label', // default input error message container
		errorClass : 'help-inline', // default input error message class
		focusInvalid : false, // do not focus the last invalid input
		rules : { // 添加各字段的限制规则
			"zbms" : { // 指标描述
				required : true,
				maxlength : 25
			// 表示为空时给出提示信息
			},
			"fsqj" : { // 分数区间
			required : true		
			},
			"zbmc" : {//指标名称
				maxlength : 7,
				required:true
			}
		},
		messages : {
			"zbms" : { // 指标描述
				required : "必填",
					maxlength : "不能超过25个汉字"
			},
			"fsqj" : { // 分数区间
				required : "必填"
			},
			"zbmc" : { // 指标名称
				maxlength : "不能超过7个汉字",
				required : "必填"
			}
		},
		errorPlacement : function(error, element) {
			if (element.attr("name") == "isValid") {
				error.addClass(" help-small no-left-padding").insertAfter(
						"#lastRadioId").css("margin-top", "-4px");
			} else {
				error.addClass(" help-small no-left-padding").insertAfter(
						element).css({
					"margin-top" : "8px",
					"margin-left" : "5px"
				});
			}
		},
		highlight : function(element) {
			$(element).closest('.control-group').removeClass('success')
					.addClass('error');
		},
		success : function(label) {
			label.addClass('valid ok').closest('.control-group').removeClass(
					'error').addClass('success');
		}
	});
	// 单独为 单选按钮 添加 验证样式
	$('input[type="radio"]', operateForm).change(function() {
		operateForm.validate().element($(this));
	});
};
/** ************************新增和修改页面表单元素的验证end ************************* */
/** ************************动态加载数据start************************* */
// 加载 用户修改的数据
$.rest.loadData = function(id) {
	var postUrl = baseUrl + '/b/xqwy/jbxx/zhxx/detail/' + id;
	$.post(postUrl, function(data) {
		var zhxx = data.object;
		$("#sfz").val(zhxx.sfz);
		$("#ysfz").val(zhxx.sfz);
		$("#xqmc").val(zhxx.xqmc);
		$("#xm").val(zhxx.xm);
		$("#address").val(zhxx.address);
		//$.common.handleUniform();
	});
};

