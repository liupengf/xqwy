//定义全局变量
var dataTable;//定义dataTable变量
var dataTableSearchCondition = new Array();//查询条件
var loadingDivId = $('#dataTableLoadingDivId');
var dataTableForm = $("#dataTableForm");
var groupCheckable = $('#dataTableId .group-checkable');
var columnToggler =$('#dataTable_column_toggler input[type="checkbox"]');
var rolesinfo = "";

//用户数据URL
var dataTableUrl = baseUrl+"/f/sys/module/beforePageList";//返回用户列表
var searchDataByKey = baseUrl + '/b/sys/module/detail';//查询用户信息

//用户角色数据URL
var dataTableReqUrl = baseUrl + '/b/sys/roleModule/pageList'; //请求url,获取用户的角色列表


var loadRoleDataUrl=baseUrl + '/b/sys/role/exclusiveListForModule/'+ moduleSeq;//动态加载角色url



/**************************模块角色列表 init start **************************/
/************************** dataTable  start**************************/
$.initDataTable = function(){
	dataTable = $('#dataTableId').dataTable({
		//dataTable的汉化
		"oLanguage": {
        	//"sSearch": "搜索:",//搜索
            "sLengthMenu": "_MENU_ 条/页",
            "sZeroRecords": "该模块尚未关联任何角色！", 
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
		"sAjaxSource" : dataTableReqUrl,                     //传递请求的地址
		"aoColumns": [
					  { "mDataProp": function(row){
						  var roleModuleSeq = row.roleModuleSeq;
						  return '<input type="checkbox" class="checkboxes" name="roleModuleSeq" value='+roleModuleSeq+' />';
						  },'sWidth':'15PX', "bSortable": false
					  }, 
                      { "mDataProp": "roleId"},                 //角色ID
                      { "mDataProp": "roleName"},               //角色名称
                      { "mDataProp": 'isSysRole'},               //是否是系统角色
                      { "mDataProp": "dataPermTypeName"}        //数据权限类型名称
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
/************************** dataTable  end**************************/

/************************** 返回 添加 删除按钮绑定单击事件 start **************************/
$.moduleRoleInitButtonClick=function(){
	//01绑定单击事件
	$(".cancelButtonClass").click(function(){
		$.page.contentBody(dataTableUrl);
		App.scrollTo();
	});
	//添加用户角色按钮
	$("#addButtonId").click(function(){
		$.post(loadRoleDataUrl,function(data){
			if(data.result == 'error'){
				$.art.page.message('warning',data.msg);
			}else{
				rolesinfo = data.object;
				$.beforeRoleAdd();
				//$.page.operate("addRole",'分配角色',beforeRoleAddUrl,roleAddUrl);
			}	
		});
	});
	//删除用户角色按钮
	$("#delButtonId").click(function(){
		var roleDelUrl  = baseUrl +  '/b/sys/roleModule/del';//实现用户角色的删除
		$.art.page.del(roleDelUrl,dataTableForm,dataTable);
    });
}
/************************** 返回 添加 删除按钮绑定单击事件  end **************************/

/************************** init operate **************************/
//添加对话框
$.beforeRoleAdd=function(){
	var addPageUrl = baseUrl + '/f/sys/module/beforeAddRole/'+ moduleSeq;//分配角色页面url
	var type="分配";
	var title="角色";
	 $dialog=$.art.page.showDialog(type,title,addPageUrl,fnAdd);
}
//执行添加
function fnAdd(){
	 var formId="operateFormId";
	 var formType="";
	 var addUrl  = baseUrl + '/b/sys/roleModule/add';//实现分配角色功能的url
	 var fnCallback=function(data){
		 $.art.page.fnShowResult(data,function(){
			 $dialog.close();
			 dataTable.fnDraw();
		 });
	 }
	 $.art.rest.toAdd(formId,formType,addUrl,fnCallback);
}

/************************** init operate **************************/
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
/**************************在弹出的分配角色对话框中 动态添加数据 start**************************/
//动态加载用户剩余的角色数据
$.rest.loadRoleData = function(rolesinfo){
		var startInput='<label class="checkbox"><input type="checkbox" id="roleAll" onclick="$.moduleRoleAllOrNotSelect()"><span id="change">全选</span></input></label><br/>';
		var xjInput='';
		var xjOtherInput='';
		var jybInput='';	
		var jsInput='';
		var xsInput='';
		var xtInput='';
		var endInput='';
		for(var i=0;i<rolesinfo.length;i++){
			    var str=(rolesinfo[i].roleName).substr(0,2);
				if(str=='校级'){
					if((rolesinfo[i].roleName).substr(0,4)=='校级其他'){
						xjOtherInput+='<label class="checkbox"><input type="checkbox" name="roleSeq" value='+rolesinfo[i].roleSeq+'>' + rolesinfo[i].roleName +'</input></label>';
					}else{
						xjInput+='<label class="checkbox"><input type="checkbox" name="roleSeq" value='+rolesinfo[i].roleSeq+'>' + rolesinfo[i].roleName +'</input></label>';
					}
				}else if(str =='系统'){
					xtInput+='<label class="checkbox"><input type="checkbox" name="roleSeq" value='+rolesinfo[i].roleSeq+'>' + rolesinfo[i].roleName +'</input></label>';
					
				}else if(str =='教师'){
					jsInput+='<label class="checkbox"><input type="checkbox" name="roleSeq" value='+rolesinfo[i].roleSeq+'>' + rolesinfo[i].roleName +'</input></label>';
					
				}else if(str =='学生'){
					xsInput+='<label class="checkbox"><input type="checkbox" name="roleSeq" value='+rolesinfo[i].roleSeq+'>' + rolesinfo[i].roleName +'</input></label>';
				
				}else{
					jybInput+='<label class="checkbox"><input type="checkbox" name="roleSeq" value='+rolesinfo[i].roleSeq+'>' + rolesinfo[i].roleName +'</input></label>';
				}
			}
		endInput=startInput+xjInput+'<br/>'+xjOtherInput+'<br/>'+jybInput+'<br/>'+jsInput+'<br/>'+xsInput+'<br/>'+xtInput;
		$("#addModuleRoleId").append(endInput);
};
//实现点击全选按钮后，让下面的全部选中;点击"全不选"时就让其全部不选中
$.moduleRoleAllOrNotSelect= function(){
	var $idValue=$("#roleAll");
	var nameValue="roleSeq";
	$.common.selectAllOrNot($idValue,nameValue);
};
/************************** 在弹出的分配角色对话框中 动态添加数据 end **************************/