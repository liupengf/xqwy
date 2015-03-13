//URL
//为节点分配功能 页面 的URL
var dataTableUnAllocatedMoudleReqUrl=baseUrl+'/b/sys/module/exclusiveList';//获取该节点没有分配的模块的Url
var addModuleToTreeUrl = baseUrl + '/b/sys/treeModule/addForTree'; //真正实现 添加 模块到 节点的Url

//为节点分配功能  页面 的全局变量
var dtUnAllocatedModuleList;
var dtAddModuleForm = $("#addModuleFormId");
var dataTableSearchCondition = new Array();// 查询条件
var groupCheckable = $('#dtUnAllocatedModuleListId .group-checkable');
/**************************添加班级页面 start***********************************************/

$.initAddModulePage =function(){
	$.initAddModuleDataTable();
}

/*
 * 
 * 添加模块界面  dataTable 初始化
 */
$.initAddModuleDataTable = function() {
	dtUnAllocatedModuleList = $('#dtUnAllocatedModuleListId').dataTable({
		"oLanguage" : {
			"sSearch": "<strong>搜索:</strong>",//搜索
			"sLengthMenu" : "_MENU_ 条/页",
			"sZeroRecords" : "对不起,搜索数据不存在！",
			"sInfo" : "显示第  _START_ 条到第  _END_ 条记录,一共  _TOTAL_ 条记录",
			"sInfoEmpty" : "", 
			"sInfoFiltered" : "",
			"oPaginate" : {
				"sPrevious" : "上一页",
				"sNext" : "下一页"
			}
		},
		"aLengthMenu": [
		    [15, 20, 30, -1],
            [5, 10, 15, "All"]
		 ],
		"sDom" : "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span6'i><'span6 center'p>>",
		// "sDom" : "<'row-fluid'<f>>t",
		"sPaginationType" : "bootstrap",
		"aaSorting" : [ [ 1, 'asc' ] ],
		"aoColumnDefs": [ { "bSortable": false, "aTargets": [ 0 ] }],
		"bPaginate" : true,// 分页按钮
		"bFilter" : true,// 搜索栏
		"bLengthChange" : false,// 每行显示记录数
		"iDisplayLength" : 10,// 每页显示行数
		"bSort" : true,// 排序
		"bInfo" : true,// Showing 1 to 10 of 23 entries 总记录数没也显示多少等信息
		"bAutoWidth" : true, // 自动计算列宽度
		 "fnDrawCallback" : function(oSettings) {
				if (oSettings.aiDisplay.length == 0) {
					return;
				}
				$.rest.TrCheckboxStatus("click",$("#dtUnAllocatedModuleListId tbody tr"));
		}
	});					
	$.rest.allSelectOrNot(groupCheckable);// 列表选择 全选/全不选
 };
 /*
  * 给 dataTable 中填充值
  */
 //加载方案课程信息
 $.rest.loadUnAllocatedModuleData = function(){
 	$.ajax({
 		  "type":"post",
 		  "url":dataTableUnAllocatedMoudleReqUrl,
 		  "async":false,
 		  "data" :{"treeSeq":treeSeq},
 		  "datatype":"json",
 		  "success":function(data){
 			    var moduleinfo = data.object;
 				if(moduleinfo.length > 0){
 					var tr = "<tr>";
 					for(var i=0;i<moduleinfo.length;i++){
 						 tr+='<td><input type="checkbox" class="checkboxes" name="moduleSeq" value='+moduleinfo[i].moduleSeq+' />'
 						      +'</td>'
 						 tr += "<td>"+moduleinfo[i].moduleId+"</td>";
 						 tr += "<td>"+moduleinfo[i].moduleName+"</td>";
 						 tr += "<td>"+moduleinfo[i].moduleValue+"</td>";
 						 tr += "</tr>";
 					 }
 					 $("#moduleListTbodyId").append(tr);
 				}
 				
 		    }
    });
 };
/** ***********************添加模块页面 click start ************************* */
/*
*  实现添加模块的功能
*/
$.rest.addModuleToTree = function(){
		$.post(addModuleToTreeUrl, dtAddModuleForm.serialize(), function(data) {
			if (data.result == "success") {
				$.art.page.msgAndcnFn('succeed', data.msg , function(){
					$dialog.close();
					 $.loadTreeData();
					 dtAllocatedModuleList.fnDraw();
				});
			} else {
				$.art.page.message("error", data.msg);
			}
		});
};
/** ***********************为节点分配模块 click 结束 ************************* */