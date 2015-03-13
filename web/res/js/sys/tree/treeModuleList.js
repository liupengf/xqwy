
//节点查看页面URL
//f
var backTreeListPageUrl= baseUrl+'/f/sys/tree/beforePageList';//返回到任务列表主页

var dataTableViewUrl = baseUrl + '/f/sys/tree/beforeView/'+treeSeq; // 查看url
//b
var dataTableAllocatedModuleReqUrl = baseUrl + '/b/sys/treeModule/pageList'; //获取用户的角色列表
var searchDataByKey = baseUrl + '/b/sys/tree/detail';//查询用户信息
var treeModuleSortUrl=baseUrl + '/b/sys/treeModule/sort';//节点模块排序
var treeModuleDelUrl= baseUrl + '/b/sys/treeModule/del';//删除节点下面的 模块

//节点查看页面全局变量
var dtAllocatedModuleList;//定义dataTable变量
var dataTableSearchCondition = new Array();//查询条件
var loadingModuleDtDivId = $('#moduleDtLoadingDiv');
var dataTableForm = $("#dtAllocatedModuleForm");
var columnToggler =$('#dataTable_column_toggler input[type="checkbox"]');
var groupCheckable = $('#dtAllocatedMoudleListId .group-checkable');


/** ************************ init start *************************** */
$.initTreeView= function(){
	$.initDataTable();
	$.initButtonClick();
}
/*
* 初始化查看页面的dataTable
*/
$.initDataTable = function(){
	dtAllocatedModuleList = $('#dtAllocatedMoudleListId').dataTable({
		//dataTable的汉化
		"oLanguage": {
        	//"sSearch": "搜索:",//搜索
            "sLengthMenu": "_MENU_ 条/页",
            "sZeroRecords": "该节点尚未关联任何模块！", 
            "sInfo": "显示第  _START_ 条到第  _END_ 条记录,一共  _TOTAL_ 条记录",
            "sInfoEmpty": "搜索到0条",
            "sInfoFiltered": "",
            "oPaginate":{
                "sPrevious": "上一页",
                "sNext": "下一页"
            }
        },
        //进行dataTable的配置
        "bPaginate" : true,          //分页按钮
		"bFilter" : false,           //搜索栏
		"bLengthChange" : true,      //每行显示记录数
		"iDisplayLength" : 15,       //每页显示行数
		"bSort" : true,              //排序
		"bInfo" : true,              //Showing 1 to 10 of 23 entries 总记录数中显示多少等信息
		"bAutoWidth" : false,         //自动计算列宽度
		"sPaginationType": "bootstrap", 
		"sDom": "<'row-fluid'<'span6'l>r>C<'clear'>t<'row-fluid'<'span6'i><'span6'p>>",
        "aaSorting": [[4, 'asc']],
        "aLengthMenu": [
            [15, 20, 30, -1],
            [15, 20, 30, "All"]
        ],
        "bProcessing" : false,
		"bServerSide" : true,
		"sAjaxSource" : dataTableAllocatedModuleReqUrl,                           //传递请求的地址
		"aoColumns": [
					   {
						"mDataProp" : function(row) {
							return '<input type="checkbox" class="checkboxes" name="treeModuleSeq" value='+ row.treeModuleSeq +'></input>';
						},
						'sWidth' : '15px',
					 	"bSortable" : false
					  },
		              { "mDataProp": "moduleId"},               //模块名称
                      { "mDataProp": "moduleName"},               //模块名称
                      { "mDataProp": "moduleValue"},       		  //模块值
                      { "mDataProp": function(row){               //排序值
                    	  return '<input type="text" name="sortNum" value="'+row.sortNum+'" class="m-wrap">';
                  		 }
                      }//排序值
        ],
       //向后台发送请求,并将获得的数据交由dataTable处理
	   "fnServerData" : function(sSource, aoData,fnCallback){
		    aoData.push({"name":"treeSeq","value":treeSeq});
		    $.rest.fnServerData(loadingModuleDtDivId,dataTableSearchCondition,sSource,aoData,fnCallback);
	  },
	  "fnDrawCallback" : function(oSettings) {
			if (oSettings.aiDisplay.length == 0) {
				return;
			}
			$.rest.TrCheckboxStatus("click",$("#dtAllocatedMoudleListId tbody tr"));
	  }
	});
	$.rest.allSelectOrNot(groupCheckable);							//列表选择 全选/全不选
	columnToggler.change(function(){
        var iCol = parseInt($(this).attr("data-column"));
        var bVis = dtAllocatedModuleList.fnSettings().aoColumns[iCol].bVisible;
        dtAllocatedModuleList.fnSetColumnVis(iCol, (bVis ? false : true),false);
    });	
};

/*
* 初始化查看页面的 按钮单击事件
*/
$.initButtonClick=function(){
	//01添加模块
	$("#addModuleButtonId").click(function(){
		$.page.addModuleToTree();
	});
	//02为排序按钮绑定单击事件
	$("#sortNumButtonId").click(function(){
		var sortNumData = new Array();
		$("#treeModuleListTbodyId  tr").each(function(){
			var treeModuleSeq = $(this).find(":checkbox").val();
			var sortNum= $(this).find(":text").val();
			sortNumData.push({"name":"treeModuleSeq","value":treeModuleSeq});
			sortNumData.push({"name":"sortNum","value":sortNum});
		});
		$.post(treeModuleSortUrl,sortNumData,function(data){
			if (data.result == "success") {
				$.dialog({
					id : 'message',
					content : '<strong>' + data.msg + '</strong>',
					icon : 'succeed',
					lock : true,
					left : '50%',
					top : '30%',
					ok : function(){
						dtAllocatedModuleList.fnDraw();
					},
					okVal : ' 关  闭 '
				});
			}else{
				$.art.page.message("error",data.msg);
			}
		});
	});
	//03 删除节点下面的模块
	$("#delModuleButtonId").click(function(){
		$.page.delModuleFromTree();
	});
	//04返回到班级列表页面
	$(".cancelButtonClass").click(function(){
		$.page.contentBody(backTreeListPageUrl);
	});
};
/** ************************节点查看页面 click start ************************* */
/*
 * load  view page date 
 */
$.rest.loadData = function(treeSeq){
	var postUrl = searchDataByKey + '/' + treeSeq;
	$('#treeInfoDiv').showLoading();
	$.post(postUrl, function(data){	
		    var tree = data.object;
			    $("#treeId").html(tree.treeId);
				$("#treeName").html(tree.treeName);
				$("#isRoot").html(tree.isRoot);
				$("#treeFatherSeq").html(tree.treeFatherSeq);
				$("#treeImage").html(tree.treeImage);
				$("#createUserId").html(tree.createUserId);
				$("#sortNum").html(tree.sortNum);
				$("#memo").html(tree.memo);
				$('#treeInfoDiv').hideLoading();
	});
};
/*
*
*  弹出 为节点分配模块 的界面
*/

$.page.addModuleToTree = function(){
	var addPageUrl = baseUrl +'/f/sys/tree/beforeAddModule/'+treeSeq;//弹出为节点分配模块的url
	var type="分配";
	var title="模块";
	 $dialog= $.art.page.showDialog(type,title,addPageUrl,function(){
		 var count=$.common.getCheckBoxCheckedCount();
		    if(count==0){
		    	$.art.page.message('warning','请至少选择一条要分配的模块信息!');
			}else{
				$.art.page.msgAndokFn ('question', '您确认要添加吗？', function(){
					$.rest.addModuleToTree();
				})
			}   
	 });
};
/*
*
*  弹出   删除该节点下已分配模块 的界面
*/
$.page.delModuleFromTree = function(){
	$.art.page.del(treeModuleDelUrl, dataTableForm, dataTable,function(){
		$.rest.delModuleFromTree();
	})
};
/*
*
*  实现 删除该节点下 选中的模块
*/
$.rest.delModuleFromTree= function(){
	$.post(treeModuleDelUrl, dataTableForm.serialize(), function(data) {
		if (data.result == "success") {
			$.art.page.msgAndcnFn ('succeed', data.msg , function(){
				$.loadTreeData();
				dtAllocatedModuleList.fnDraw();
				if ($('#dtAllocatedMoudleListId .group-checkable').prop('checked')){
					$('#dtAllocatedMoudleListId .group-checkable').prop({
						checked : false
				    });
				}
			})
		} else {
			$.art.page.message("error", data.msg);
		}
	});
};
