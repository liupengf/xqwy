/***************************用户角色信息 start**********************************/

//定义全局变量
var dataTableSearchCondition = new Array();//查询条件
var dataTable;//定义dataTable变量

var loadingDivId = $('#dataTableLoadingDivId');
var dataTableForm= $("#dataTableForm");
var groupCheckable = $('#dataTableId .group-checkable');
var columnToggler=$('#dataTable_column_toggler input[type="checkbox"]');

var rolesinfo='';

$.initDataTable = function(){
	var dataTableReqUrl = baseUrl + '/b/sys/userRole/pageList'; //请求url,获取用户的角色列表
	dataTable = $('#dataTableId').dataTable({
		//dataTable的汉化
		"oLanguage": {
        	//"sSearch": "搜索:",//搜索
            "sLengthMenu": "_MENU_ 条/页",
            "sZeroRecords": "该用户尚未分配任何角色！", 
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
						  var userRoleSeq = row.userRoleSeq;
						  return '<input type="checkbox" class="checkboxes" name="userRoleSeq" value='+userRoleSeq+' />';
						  },'sWidth':'15px', "bSortable": false
					  }, 
                      { "mDataProp": "roleId"},                 //角色ID
                      { "mDataProp": "roleName"},               //角色名称
                      { "mDataProp": 'isSysRole'},               //是否是系统角色
                      { "mDataProp": "dataPermTypeName"},        //数据权限类型名称
                      { "mDataProp": "dataPermValue" },          //数据权限值
                      { "mDataProp": function(row){
                    	  var setDataPerm='<a href=javaScript:void(0); onclick=$.beforeUserQxAdd("'+row.userRoleSeq+'")>设置数据权限值</a>';
                    	  if(row.dataPermTypeName =='' ||row.dataPermTypeName == null){
                    		  return '';
                    	  }else{
                    		  return setDataPerm;
                    	  }
                    	  
                      },"bSortable": false,'sWidth':'100PX'}  //操作
        ],
       //向后台发送请求,并将获得的数据交由dataTable处理
	   "fnServerData" : function(sSource, aoData,fnCallback){
		   aoData.push({"name":"userSeq","value":userSeq});
		   $.rest.fnServerData(loadingDivId,dataTableSearchCondition,sSource,aoData,fnCallback)
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
//************************** 01 init dataTable  end**************************//*
//************************** 02 init button  start **************************//*
$.initButtonClick=function(){
	//01添加角色
	$("#addButtonId").click(function(){
		var loadRoleDataUrl=baseUrl + '/b/sys/role/exclusiveListForUser/'+ userSeq;//动态加载角色url
		$.post(loadRoleDataUrl,function(data){
			if(data.result == 'error'){
				$.art.page.message('warning',data.msg);
			}else{
				rolesinfo = data.object;
				$.beforeUserRoleAdd();
				//$.page.operate("addRole","分配角色",roleBeforeAddUrl,roleAddUrl);
			}
		});
	});
	//02删除角色
	$("#delButtonId").click(function(){
		var delUrl = baseUrl +  '/b/sys/userRole/del';//实现用户角色的删除
		$.art.page.del(delUrl,dataTableForm,dataTable);
		//$.page.del(roleDelUrl,dataTableForm,dataTable);
	});
	//03 返回用户主列表页面
	$(".cancelButtonClass").click(function(){
		var dataTableUrl= baseUrl +'/f/sys/user/beforePageList';
		$.page.contentBody(dataTableUrl);
		App.scrollTo();
	});
}

//************************** 02 init button  end **************************/

/************************** init operate **************************/
//添加对话框
$.beforeUserRoleAdd=function(){
	var addPageUrl =  baseUrl + '/f/sys/user/beforeAddRole/'+ userSeq;//分配角色页面url 
	var type="分配";
	var title="角色";
	 $dialog=$.art.page.showDialog(type,title,addPageUrl,fnAdd);
}
//执行添加
function fnAdd(){
	 var formId="operateFormId";
	 var formType="";
	 var addUrl = baseUrl +  '/b/sys/userRole/add';//实现分配角色功能的url
	 var fnCallback=function(data){
		 $.art.page.fnShowResult(data,function(){
			 $dialog.close();
			 dataTable.fnDraw();
		 });
	 }
	 $.art.rest.toAdd(formId,formType,addUrl,fnCallback);
}
//数据权限添加对话框
$.beforeUserQxAdd=function(userRoleSeq){
	var addPageUrl=baseUrl + '/f/sys/user/beforeSetDataPerm'+ '/' + userRoleSeq;//分配数据权限页面url
	var type="分配";
	var title="数据权限";
	 $dialog=$.art.page.showDialog(type,title,addPageUrl,fnQxAdd);
}
//执行添加
function fnQxAdd(){
	 var formId="operateFormId";
	 var formType="";
	 var addUrl=baseUrl + '/b/sys/userRole/setUserDataPerm';//实现添加数据权限值的Url
	 var fnCallback=function(data){
		 $.art.page.fnShowResult(data,function(){
			 $dialog.close();
			 dataTable.fnDraw();
		 });
	 }
	 $.art.rest.toAdd(formId,formType,addUrl,fnCallback);
}
/************************** init operate **************************/
//加载 用户查看
$.rest.loadData = function(userSeq){
	var postUrl = searchDataByKey + '/' + userSeq;
	$('#loadingDiv').showLoading();
	$.post(postUrl, function(data){
		    var user = data.object;
			$("#userSeq").val(user.userSeq);	
			$("#userId").html(user.userId);	
			$("#userName").html(user.userName);
			$("#userPass").html(user.userPass);
			$("#isValid").html(user.isValid);
			$("#memo").html(user.memo);
			$('#loadingDiv').hideLoading();
	});
};
//动态加载用户剩余的角色数据
$.rest.loadRoleData = function(rolesinfo){
	var startInput='<label class="checkbox"><input type="checkbox" id="roleAll" onclick="$.UserRoleAllOrNotSelect()"><span id="change">全选</span></input></label><br/>';
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
	$("#addUserRoleId").append(endInput);
};
//实现点击全选按钮后，让下面的全部选中;点击"全不选"时就让其全部不选中
$.UserRoleAllOrNotSelect= function(){
	var $idValue=$("#roleAll");
	var nameValue="roleSeq";
	$.common.selectAllOrNot($idValue,nameValue);
};

//获取已有的数据权限值
$.rest.getHasExitDataPermVlaue =function(userRoleSeq){
	var getHasExitDataPremValueUrl = baseUrl + '/b/sys/userRole/detail';//获取已有数据权限值的Url
	var postUrl = getHasExitDataPremValueUrl +'/'+ userRoleSeq;
	$.post(postUrl,function(data){
		var str= data.object.dataPermValue;
		var values= str.split(',');
		$("input[name='dataPermValue']").each(function(){
			 for(var i=0; i<values.length;i++){
				 if($(this).val() == values[i]){
					 $(this).attr("checked",true);
				 }
			 }
		});
	});
};
//实现点击全选按钮后，让下面的全部选中;点击"全不选"时就让其全部不选中
$.dataPermValueAllOrNotSelect = function(){
	var $idValue=$("#datapermValueAll");
	var nameValue="dataPermValue";
	$.common.selectAllOrNot($idValue,nameValue);
};

/***************************用户角色信息 end**********************************/