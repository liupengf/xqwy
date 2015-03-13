/** ************************ 用户信息 start ************************* */
var dataTable;
var zbfladd = "kc";
var dataTableSearchCondition = new Array();// 查询条件
var loadingDivId = $('#loadingDiv');
var dataTableForm = $("#dataTableForm");
var groupCheckable = $('#dataTableId .group-checkable');
var dataTableReqUrl = baseUrl + '/b/jxpg/zbtjb/jpzx/pageList'; // 请求url
var dataTableViewUrl = baseUrl + '/f/jxpg/zbtjb/jpzx/beforeView'; // 查看url
var searchDataByKey = baseUrl + '/b/jxpg/zbtjb/jpzx/detail';// 查看教师指标的详细信息
var dataTableForm_1 = $("#dataTableForm_1");
var dataTable_1;
var dataTableSearchCondition_1 = new Array();//查询条件
var dataTableSearchConditionTemp = new Array();
var dataTableAoData_1 = null;//导出列配置
var loadingDivId_1 = $('#loadingDiv');

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
									"mDataProp" : "zbmc",
									'sWidth' : '7%'
								}, // 指标名称
								{
									"mDataProp" : "zbsx",
									'sWidth' : '5%'

								}, // 指标描述
								{
									"mDataProp" : "zbms",
									'sWidth' : '19%'
								}, // 分数区间
								{
									"mDataProp" : "sfsx",
									'sWidth' : '5%'
								}, // 分数区间
								
								{
									"mDataProp" : "kcpgflmc",
									'sWidth' : '5%',
									'bVisible':false
								}, // 分数区间
								
//								
								{
									"mDataProp" : "tcrxm",
									'sWidth' : '4%'
								}, // 提出人
							
							

								{
									"mDataProp" : function(row) {
										var viewUrl = dataTableViewUrl + '/'
												+ row.zbid;
										if (row.zbms !== null) {
											return	'<a href=javaScript:void(0); onclick="$.beforeZbtjbEdit('
													+ row.zbid
													+ ')">修改</a>'+'||<a href=javaScript:void(0); onclick="$.deletezb('
													+ row.zbid
													+ ')">删除</a>';
										} else {
											return "";
										}
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
	var delUrl=baseUrl+'/b/jxpg/zbtjb/jpzx/delete';
	$.deletebyid(delUrl, id, dataTable,function(){
		dataTable.fnDraw();
	});
}

$.initButtonClick = function() {
	$("#zbkAddButton").click(function() {
		$.beforeZbkAdd();

	});
	$('#jslbzb').click(function() {
		 dataTable.fnSetColumnVis(4,true);
		zbfladd = "lb";
		dataTableSearchCondition.length = 0;
		dataTableSearchCondition.push({
			"name" : "zbjb",
			"value" : "类别"
		});
		dataTableSearchCondition_1.length = 0;
		dataTableSearchCondition_1.push({
			"name" : "zbjb",
			"value" : "类别"
		});
		dataTableSearchConditionTemp.length = 0;
		dataTableSearchConditionTemp.push({
			"name" : "zbjb",
			"value" : "类别"
		});
		
		
		//$("#secondtable").show();
		dataTable.fnDraw();
		//dataTable_1.fnDraw();
	});
	$('#jsyxzb').click(function() {

		 dataTable.fnSetColumnVis(4,false);
		zbfladd = "yx";  
		dataTableSearchCondition.length = 0;
		dataTableSearchCondition.push({
			"name" : "zbjb",
			"value" : "院系"

		});
		dataTableSearchCondition_1.length = 0;
		dataTableSearchCondition_1.push({
			"name" : "zbjb",
			"value" : "院系"

		});
		dataTableSearchConditionTemp.length = 0;
		dataTableSearchConditionTemp.push({
			"name" : "zbjb",
			"value" : "院系"
		});
		
		
		dataTable.fnDraw();
	});
	$('#jsgrzb').click(function() {
		 dataTable.fnSetColumnVis(4,false);
		zbfladd = "gr";
		dataTableSearchCondition.length = 0;
		dataTableSearchCondition.push({
			"name" : "zbjb",
			"value" : "个人"

		});
	
		dataTable.fnDraw();
	});
	$('#kczb').click(function() {
		 dataTable.fnSetColumnVis(4,false);
		zbfladd = "kc";
		dataTableSearchCondition.length = 0;
		dataTableSearchCondition.push({
			"name" : "zbfl",
			"value" : "课程"

		});

		dataTable.fnDraw();
	
	});
	$('#zjzb').click(function() {
		 dataTable.fnSetColumnVis(4,false);
		zbfladd = "zj";
		dataTableSearchCondition.length = 0;
		dataTableSearchCondition.push({
			"name" : "zbfl",
			"value" : "助教"

		});

		dataTable.fnDraw();
	
	});
	$('#jsxjzb').click(function() {
		 dataTable.fnSetColumnVis(4,false);
		zbfladd = "js";
		dataTableSearchCondition.length = 0;
		dataTableSearchCondition.push({
			"name" : "zbjb",
			"value" : "学校"
		});
		dataTableSearchCondition.push({
			"name" : "zbfl",
			"value" : "教师"
		});

		//$("#secondtable").hide();
		dataTable.fnDraw();
	
	});
}
/** ************************ 02 init button end ************************* */

/** ************************ init operate ************************* */


// 删除
$.zbtjbDel = function(zbid) {
	dataTableForm.find("input[name='zbid']").attr("checked", false);
	dataTableForm_1.find("input[type='checkbox']").attr("checked", false);
	var delUrl = baseUrl + '/b/jxpg/zbtjb/jpzx/delete'// 编辑url
	dataTableForm.find("input[value='" + zbid + "']").attr("checked", true);
	$.art.page.del(delUrl, dataTableForm, dataTable);
}
// 添加对话框
$.beforeZbkAdd = function() {
	var addPageUrl = baseUrl + '/f/jxpg/zbtjb/jpzx/beforeAdd/' + zbfladd;
	var type = "add";
	var title = "指标";
	$dialog = $.art.page.showDialog(type, title, addPageUrl, fnAdd);

}
// 执行添加
function fnAdd() {
	var formId = "operateFormId";
	var formType = "";
	var addUrl = baseUrl + "/b/jxpg/zbtjb/jpzx/add";
	var fnCallback = function(data) {
		$.art.page.fnShowResult(data, function() {
			$dialog.close();
			dataTable.fnDraw();
			getzbcount();

		});
	}
	$.art.rest.toAdd(formId, formType, addUrl, fnCallback);
}
// 修改对话框
$.beforeZbtjbEdit = function(zbid) {
	var editPageUrl = baseUrl + '/f/jxpg/zbtjb/jpzx/beforeEdit/' + zbid;// 编辑url
	var type = "edit";
	var title = "指标库指标";
	$dialog = $.art.page.showDialog(type, title, editPageUrl, fnEdit);
}
// 查看对话框
/*$.beforeZbtjbView = function(zbid) {
	var viewUrl = baseUrl + '/f/jxpg/zbtjb/jpzx/beforeView/' + zbid;
	var type = "view";
	var title = "指标";
	$dialog = $.art.page.showDialog(type, title, viewUrl, false);
}*/
// 执行修改
function fnEdit() {
	var formId = "operateFormId";
	var formType = "";
	var editUrl = baseUrl + "/b/jxpg/zbtjb/jpzx/edit";
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
$.rest.loadData = function(zbid) {
	var postUrl = searchDataByKey + '/' + zbid;
	$.post(postUrl, function(data) {
		var zbtjb = data.object;
		$("#zbms").val(zbtjb.zbms);
		$("#fsqj").val(zbtjb.fsqj);
		$("#zbmc").val(zbtjb.zbmc);
		$("#zbsx").val(zbtjb.zbsx);
		$("#sfsx").val(zbtjb.sfsx);
		$("#zbid").val(zbtjb.zbid);
		$("#fsqj").val(zbtjb.fsqj);
		//$.common.handleUniform();
	});
};
function getzbcount() {
	$.post(baseUrl+"/b/jxpg/zbtjb/jpzx/shuliang", function(data) {
		if (data.result == "success") {
			var resultobj = data.object;
			for (var i = 0; i < resultobj.length; i++) {
			 $("#"+resultobj[i].csywm).html(resultobj[i].con);

			}
		} else {
			$.art.page.message("error", data.msg);
		}
	});
}


