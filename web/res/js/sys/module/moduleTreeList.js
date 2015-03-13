//用户数据URL
var dataTableUrl = baseUrl+"/f/sys/module/beforePageList";//返回用户列表
var searchDataByKey = baseUrl + '/b/sys/module/detail';//查询用户信息
var zTree;

//模块节点Url
var dataTableReqUrl = baseUrl + '/b/sys/treeModule/pageList'; //请求url,获取模块的节点列表

var treeAddUrl  = baseUrl +  '/b/sys/treeModule/addForModule';//实现分配节点功能的url
/*var loadTreeDataUrl=baseUrl + '/b/sys/tree/exclusiveList/'+ moduleSeq;*///动态加载节点url,这个是将页面中的




//定义全局变量
var dataTable;//定义dataTable变量
var loadingDivId = $('#dataTableLoadingDivId');
var dataTableForm = $("#dataTableForm");
var dataTableSearchCondition = new Array();//查询条件
var groupCheckable = $('#dataTableId .group-checkable');
var columnToggler =$('#dataTable_column_toggler input[type="checkbox"]');
var treesinfo = "";
/**************************模块节点 init start **************************/

/************************** dataTable  start**************************/
$.initDataTable = function(){
	dataTable = $('#dataTableId').dataTable({
		//dataTable的汉化
		"oLanguage": {
        	//"sSearch": "搜索:",//搜索
            "sLengthMenu": "_MENU_ 条/页",
            "sZeroRecords": "该模块尚未关联任何节点！", 
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
        "aaSorting": [[2, 'asc']],
        "aLengthMenu": [
            [15, 20, 30, -1],
            [15, 20, 30, "All"]
        ],
        "bProcessing" : false,
		"bServerSide" : true,
		"sAjaxSource" : dataTableReqUrl,                  //传递请求的地址
		"aoColumns": [
					  { "mDataProp": function(row){
						  var treeModuleSeq = row.treeModuleSeq;
						  return '<input type="checkbox" class="checkboxes" name="treeModuleSeq" value='+treeModuleSeq+' />';
						  },'sWidth':'15PX', "bSortable": false
					  }, 
                      { "mDataProp": "treeId"},                 //节点ID
                      { "mDataProp": "treeName"},               //节点名称
                      { "mDataProp": 'isRoot'},                //是否根节点
                      { "mDataProp": "sortNum"}               //排序值
       ],
       //向后台发送请求,并将获得的数据交由dataTable处理
	   "fnServerData" : function(sSource, aoData,fnCallback){
		   aoData.push({"name":"moduleSeq","value":moduleSeq});
		   $.rest.fnServerData(loadingDivId,dataTableSearchCondition,sSource,aoData,fnCallback);
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
/**************************  dataTable  end**************************/

/************************** 返回  节点的分配 删除按钮绑定事件  start **************************/

$.moduleTreeInitButtonClick=function(){
	//01绑定单击事件
	$(".cancelButtonClass").click(function(){
		$.page.contentBody(dataTableUrl);
		App.scrollTo();
	});
	//添加模块角色按钮
	$("#addButtonId").click(function(){
		//$.page.operate(,,beforeTreeAddUrl,treeAddUrl);
		$.page.addTree();
		
		
	});
	//删除模块角色按钮
	$("#delButtonId").click(function(){
		var treeTelUrl  = baseUrl +  '/b/sys/treeModule/del';//实现模块节点的删除
		$.art.page.del(treeTelUrl,dataTableForm,dataTable);
	});
}
/************************** 返回  节点的分配 删除按钮绑定事件 结束 **************************/
//加载节点数据
$.rest.loadData = function(moduleSeq){
	var postUrl  = searchDataByKey + '/' + moduleSeq;
	$('#loadingDiv').showLoading();
	$.post(postUrl, function(data){	
		    var module = data.object;	
				$("#moduleId").html(module.moduleId);	
				$("#moduleName").html(module.moduleName);
				$("#modulePrefixValue").html(module.modulePrefixValue);
				$("#moduleValue").html(module.moduleValue);
				$('#loadingDiv').hideLoading();
	});
};
/************************** 弹出的分配节点页面 动态添加数据 start   方式1:是以平铺的方式展现的 **************************/
/*//动态加载模块节点数据
$.rest.loadTreeData = function(treesinfo){
	var input='<label class="checkbox"><input type="checkbox" id="treeAll" onclick="$.moduleTreeAllOrNotSelect()"><span id="change">全选</span></input></label><br/>';
		for(var i=0;i<treesinfo.length;i++){
			input+='<label class="checkbox"><input type="checkbox" name="treeSeq" value='+treesinfo[i].treeSeq+'>'+ treesinfo[i].treeName +'</input></label>';
		}
		$("#addModuleTreeId").append(input);
};
//实现点击全选按钮后，让下面的全部选中;点击"全不选"时就让其全部不选中
$.moduleTreeAllOrNotSelect= function(){
	var $idValue=$("#treeAll");
	var nameValue="treeSeq";
	$.common.selectAllOrNot($idValue,nameValue);
};*/
/************************** 弹出的分配节点页面 动态添加数据 end ******************************************************/
/************************** 弹出的分配节点页面 动态添加数据 start   方式2:以树的形式展现 **************************/
function setCheck() {
	zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.setting.check.chkboxType = { "Y" : "ps", "N" : "ps" };//'Y'表示被勾选时,"N"标识取消勾选。
	//其值的含义是:P表示在    勾选/取消    的时候"父关联";"s"表示在    勾选/取消    的时候"子关联";
}
/************************** 弹出的分配节点页面 动态添加数据 end   方式2:以树的形式展现 ***************************/
//弹出 为模块 分配节点的 页面
var $dialog;
$.page.addTree = function(){
	var addPageUrl = baseUrl + '/f/sys/module/beforeAddTree/'+ moduleSeq;//分配节点页面url,
	var type="分配";
	var title="节点";
	 $dialog=$.art.page.showDialog(type,title,addPageUrl,$.rest.addTree);
	 
/*	 $dialog = $.dialog({
			id : "addNode",
			lock : true,
			width :'600px',
			title : '分配节点',
			drag:true,
			resize :false,
		    ok : function(){
		    	$.rest.addTree();
		        return false;
		    },
		    okVal :'确定',
		    cancel:true,
		    cancelVal:'关 闭'
	    });
		$.post(beforeTreeAddUrl, function(data){
		 	$dialog.content(data);
		});*/
}
//实现  为模块 分配节点的  功能
$.rest.addTree= function(){
	var getData= new Array();
	var form = $('#operateFormId');
    var checkNodesList=getChecked();
    getData.push({"name":"moduleSeq","value":moduleSeq});
    for(var i=0;i<checkNodesList.length;i++){
	  getData.push({"name":"treeSeq","value":checkNodesList[i].id})
    }
	$.post(treeAddUrl,getData,function(data){
		$.art.page.fnShowResult(data,function(){
			 $dialog.close();
			 dataTable.fnDraw();
		 });
  });
}
//获取选中的所有叶子节点
function getChecked(){
    var nodes= zTree.getCheckedNodes(true);//获取所有的节点
    if(nodes){
        for(var i=0;i<nodes.length;i++){
            var nodeChildrens=nodes[i].children;//然后遍历每一个 选中的节点, 获取当前节点的子节点
                if(nodeChildrens){//如果当前节点存在子节点
                nodes[i].nocheck=true;//就将当前节点(即非叶子节点)的属性的nocheck设置为true
                }
            }
        }
    nodes= zTree.getCheckedNodes(true);//这样在重新获取所有的节点的时候 就会将  那些  不是叶子节点的过滤掉,只保留叶子节点。
    return nodes;
}
//实现为 各个叶子节点设置小图标
/*function setIcon(){
	$('#treeDemo_1_ul span[id$=_ico]').each(function(){
		 var classIcon  = $(this).attr("class").substring(7);
		 var usefulIcon = classIcon.substring(0,classIcon.length-9);
		 $(this).removeClass().addClass('button '+usefulIcon);
	});
}*/
