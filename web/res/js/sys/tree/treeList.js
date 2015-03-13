/** ************************ init start ************************* */
var dataTable;
var dataTableSearchCondition = new Array();// 查询条件
var dataTableAoData = null;// 导出列配置
var treeFatherContext;
// jquery
loadingTreeDtDivId = $('#dataListDivId #loadingDiv');
var dataTableForm = $("#dataTableForm");
var aoDataInput = $("#aoDataInputId");
var groupCheckable = $('#dataTableId .group-checkable');
var columnToggler =$('#dataTable_column_toggler input[type="checkbox"]');
// url
var  dataTableUrl=baseUrl + '/f/sys/tree/beforePageList';
var dataTableReqUrl = baseUrl + '/b/sys/tree/pageList'; // 请求url
var dataTableDelUrl = baseUrl + '/b/sys/tree/del'; // 删除url

var dataTableBeforeViewUrl = baseUrl + '/f/sys/tree/beforeView';// 查看url
var dataTableBeforeEditUrl = baseUrl + '/f/sys/tree/beforeEdit';// 编辑url
var dataTableExportUrl = baseUrl + '/b/sys/tree/genExcel';// 数据导出url
var addUrl = baseUrl + "/b/sys/tree/add";
var editUrl = baseUrl + "/b/sys/tree/edit";
var loadTreeDataUrl=baseUrl + "/b/sys/tree/treeList";
/** ************************节点列表页面 init start ****************************************** */
$.init = function(){
	$.initDataTable();
	$.initButtonClick();
	$.loadTreeData();
}
/*
 * init dataTable start 
 */
$.initDataTable = function() {
	dataTable = $('#dataTableId').dataTable(
					{
						"oLanguage" : {
							// "sSearch": "搜索:",//搜索
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
						"bSort" : true, // 排序
						"bInfo" : true, // Showing 1 to 10 of 23 entries
						// 总记录数中显示多少等信息
						"bAutoWidth" : false, // 自动计算列宽度
						"sPaginationType" : "bootstrap",
						"sDom" : "<'row-fluid'<'span6'l>r>C<'clear'>t<'row-fluid'<'span6'i><'span6'p>>",
						"aaSorting" : [[ 4, 'asc' ], [ 5, 'asc' ]],
						"aLengthMenu" : [ [ 15, 20, 30, -1 ],
								[ 15, 20, 30, "All" ] ],
						"bProcessing" : false,
						"bServerSide" : true,
						"sAjaxSource" : dataTableReqUrl, // 传递请求的地址
						"aoColumns" : [
								{
									"mDataProp" : function(row) {
										return '<input type="checkbox" class="checkboxes" name="treeSeq" value='+ row.treeSeq + ' />';
									},
									'sWidth' : '15px',
									"bSortable" : false
								},
								{
									"mDataProp" : "treeId","bVisible" : false
								}, // 节点ID
								{
									"mDataProp" : 'treeName'
								}, // 节点名称
								{
									"mDataProp" : "treeFatherName"
								},
								{
									"mDataProp" : 'treeLevel'
								},
								{
									"mDataProp" : "sortNum"
								},
								{
									"mDataProp" : "isRoot","bVisible" : false
								}, // 是否根节点
								{
									"mDataProp" : function(row){
										return '<i class="'+row.treeImage+'"></i>';
									},"bSortable" : false
								},
								{
									"mDataProp" : "memo"
								},
								{
									"mDataProp" : "createUserId","bVisible" : false
								}, // 创建人
								{
									"mDataProp" : function(row) {
										var beforeEditUrl = dataTableBeforeEditUrl + '/' + row.treeSeq;
										return '<a href=javaScript:void(0); onclick=$.page.editTree("'+beforeEditUrl+'");>修改</a>'
												+'&nbsp;||&nbsp;'
												+'<a href=javaScript:void(0); onclick=$.page.viewTree("'+row.treeSeq+'");>查看</a>';;
									},
									"bSortable" : false,
									'sWidth' : '80px'
								} // 操作
						],
						"fnServerData" : function(sSource, aoData, fnCallback){
							$.rest.fnServerData(loadingTreeDtDivId,dataTableSearchCondition,sSource,aoData,fnCallback);
							dataTableAoData = aoData;
						},
						 "fnDrawCallback" : function(oSettings) {
								if (oSettings.aiDisplay.length == 0) {
									return;
								}
								$.rest.TrCheckboxStatus("click",$("#dataTableId tbody tr"));
						}
					});
	$.rest.allSelectOrNot(groupCheckable);							//列表选择 全选/全不选
	$.rest.columnTogglerHideOrShow(columnToggler);					//可选列的显示与隐藏
};

/*
 * init button start 
 * 
 */
$.initButtonClick = function() {
	// 01新增班级
	$("#addButtonId").click(function() {
		$.page.addTree();
	});
	//02删除班级
	$("#delButtonId").click(function(){
		$.page.delTree();
	});
	// 02导出
	$("#exportExcelButtonId").click(function(){
		$.rest.exportExcel(dataTableAoData,dataTableForm,aoDataInput,dataTableExportUrl);
	});
}
/*
 *  init load tree data start 
 * 
 */
$.loadTreeData = function(){
	$("#treeDirectoryId #loadingDiv").showLoading();
	var setting = {
			view: {showLine: true},//表示显示虚线
	       check: {enable: false},//设置为true时表示在 文件名 前面 显示 复选框;设置为flase时,表示在 文件名 前面 不显示 复选框。
	       data:  {simpleData:{enable:true}},
	       callback: {
				onClick: zTreeOnClick,
				beforeClick: zTreeBeforeClick
			}
	};
	var zNodes = new Array();
	$.post(loadTreeDataUrl,function(data){
		$(data.object).each(function(i,tree) {
			zNodes.push({id:tree.treeSeq,pId:tree.treeFatherSeq,name:tree.sortNum+'-'+tree.treeName,open:true});
		});
		$.fn.zTree.init($("#treeContent"), setting, zNodes);
		$("#treeDirectoryId #loadingDiv").hideLoading();
	});
 };
function zTreeBeforeClick(treeId, treeNode, clickFlag) {
	    return (treeNode.children == null);
	};
function zTreeOnClick(event, treeId, treeNode) {
	$.post(dataTableBeforeViewUrl + '/' + treeNode.id, function(data){
		var pageContentBody = $('#dataListDivId');
		pageContentBody.html(data);
	});
};
/** ************************节点列表页面 init end ****************************************** */
/** ************************节点列表页面 click operate start *********************************/
//添加节点
$.page.addTree = function(){
	var addPageUrl = baseUrl + '/f/sys/tree/beforeAdd'; // 添加url
	var type="add";
	var title="节点";
	 $dialog=$.art.page.showDialog(type,title,addPageUrl,$.rest.addTree);
}
$.rest.addTree = function(){
	 var form = $('#operateFormId');
		if (!form.valid()) {
			App.scrollTo();
			return;
		} else {
			$.post(addUrl, form.serialize(), function(data) {
				if (data.result == "success") {
					$.art.page.msgAndcnFn('succeed', data.msg, function(){
						$dialog.close();
						$.loadTreeData();
						dataTable.fnDraw();
					});
				} else {
					$.art.page.message("error", data.msg);
				}
			});
		}
}
//修改节点
$.page.editTree = function(beforeEditUrl){
	var type="edit";
	var title="节点";
	 $dialog=$.art.page.showDialog(type,title,beforeEditUrl,$.rest.editTree);
}
$.rest.editTree = function(){
	 var form = $('#operateFormId');
		if (!form.valid()) {
			App.scrollTo();
			return;
		} else {
			$.post(editUrl, form.serialize(), function(data) {
				if (data.result == "success") {
					$.art.page.msgAndcnFn('succeed', data.msg, function(){
						$dialog.close();
						$.loadTreeData();
						dataTable.fnDraw();
					});
				} else {
					$.art.page.message("error", data.msg);
				}
			});
		}
}
//删除节点
$.page.delTree = function(){
	$.art.page.del(dataTableDelUrl, dataTableForm, dataTable,$.rest.delTree)
};
$.rest.delTree = function(){
	$.post(dataTableDelUrl,dataTableForm.serialize(),function(data){
		if (data.result == "success") {
			$.art.page.msgAndcnFn('succeed', data.msg, function(){
				$.loadTreeData();
				dataTable.fnDraw();
				$.common.clearChecked();
			});
		}else{
			$.art.page.message("error",data.msg);
		}
	});
};
//查看节点
$.page.viewTree = function(id){ 
	var treeObj = $.fn.zTree.getZTreeObj("treeContent");
	var node = treeObj.getNodeByParam("id",id, null);
	treeObj.selectNode(node);
	treeObj.setting.callback.onClick(null, "treeContent", node);
}
/** ************************节点列表页面 click operate end *********************************/