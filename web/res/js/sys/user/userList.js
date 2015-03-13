/************************** 用户信息 start **************************/
var dataTable;
var dataTableSearchCondition = new Array();//查询条件
var dataTableAoData = null;//导出列配置
//jquery
loadingDivId = $('#loadingDiv');
dataTableForm = $("#dataTableForm");
var aoDataInput = $("#aoDataInputId");
var groupCheckable = $('#dataTableId .group-checkable');
var columnToggler =$('#dataTable_column_toggler input[type="checkbox"]');
//url
var dataTableReqUrl = baseUrl + '/b/sys/user/pageList';     //请求url


var dataTableViewUrl = baseUrl + '/f/sys/user/beforeView';     //查看url

var dataTableExportUrl = baseUrl + '/b/sys/user/genExcel';//数据导出url
/*var getUserRoleDataUrl = baseUrl + '/b/sys/role/all';*///获取用户角色Url


var searchDataByKey = baseUrl + '/b/sys/user/detail';//查询用户信息

/************************** 01 init dataTable  start**************************/
$.initDataTable = function(){
	//列表
	dataTable = $('#dataTableId').dataTable({     
		"oLanguage": {
        	//"sSearch": "搜索:",//搜索
            "sLengthMenu": "_MENU_ 条/页",
            "sZeroRecords": "对不起,搜索数据不存在！", 
            "sInfo": "显示第  _START_ 条到第  _END_ 条记录,一共  _TOTAL_ 条记录",
            "sInfoEmpty": "搜索到0条",
            "sInfoFiltered": "",
            "oPaginate":{
                "sPrevious": "上一页",
                "sNext": "下一页"
            }
        },       
        "bPaginate" : true,          //分页按钮
		"bFilter" : false,           //搜索栏
		"bLengthChange" : true,      //每行显示记录数
		"iDisplayLength" : -1,       //每页显示行数
		"bSort" : true,              //排序
		"bInfo" : true,              //Showing 1 to 10 of 23 entries 总记录数中显示多少等信息
		"bAutoWidth" : false,         //自动计算列宽度
		"sPaginationType": "bootstrap", 
		"sDom": "<'row-fluid'<'span6'l>r>C<'clear'>t<'row-fluid'<'span6'i><'span6'p>>",
        "aaSorting": [[1, 'asc']],
        "aLengthMenu": [
            [15, 20, 30, -1],
            [15, 20, 30, "All"]
        ],
        "bProcessing" : false,
		"bServerSide" : true,
		"sAjaxSource" : dataTableReqUrl,                     //传递请求的地址
		"aoColumns": [	
					  { "mDataProp": function(row){
						  userSeq = row.userSeq;
						  return '<input type="checkbox" class="checkboxes" name="userSeq" value='+userSeq+' />';
						  },'sWidth':'15px', "bSortable": false
					  }, 
                      { "mDataProp": "userId"},                //用户ID
                      { "mDataProp": 'userName'},                //用户名称
                      { "mDataProp": "userPass"},               //用户密码
                      { "mDataProp": "isValid" },            //是否有效
                      { "mDataProp": "createUserId" },           //创建人
                      { "mDataProp": "memo"}, //备注
                      { "mDataProp": function(row){
                    	  var viewUrl = dataTableViewUrl + '/' + row.userSeq;
                    	 // var beforeEditUrl = dataTableBeforeEditUrl + '/' + row.userSeq;
                    	  return '<a href=javaScript:void(0); onclick=$.page.contentBody("'+viewUrl+'");>查看</a>'
                    	  		+'&nbsp;||&nbsp;<a href=javaScript:void(0); onclick="$.beforeUserEdit('+row.userSeq+')">修改</a>';
                    	        // +'&nbsp;||&nbsp;<a href=javaScript:void(0); onclick=$.page.operate("pageEdit","用户修改","'+beforeEditUrl+'","'+editUrl+'");>修改</a>';
                      },"bSortable": false,'sWidth':'80px'}//操作
                   ],
                   "fnServerData" : function(sSource, aoData,fnCallback){
                	   $.rest.fnServerData(loadingDivId,dataTableSearchCondition,sSource,aoData,fnCallback);
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
 /************************** 01 init dataTable end **************************/

 /************************** 02 init button  start **************************/
$.initButtonClick = function(){
	$.common.barContextShowOrHide();
	//01查询
	$("#searchButtonId").click(function(){
		$.rest.search();
	});
   //02新增
	$("#addButtonId").click(function(){
		$.beforeUserAdd();
		//$.page.operate("pageAdd","新增用户",dataTableBeforeAddUrl,addUrl);
	});
	//03删除
	$("#delButtonId").click(function(){
		var delUrl = baseUrl + '/b/sys/user/del';     //删除url
		$.art.page.del(delUrl,dataTableForm,dataTable);
		//$.page.del(dataTableDelUrl,dataTableForm,dataTable);
	});
	//04导出
	$("#exportExcelButtonId").click(function(){
		$.rest.exportExcel(dataTableAoData,dataTableForm,aoDataInput,dataTableExportUrl);   
		
	});
}
/************************** 02 init button  end **************************/

/************************** init operate **************************/
//添加对话框
$.beforeUserAdd=function(){
	var addPageUrl =  baseUrl + '/f/sys/user/beforeAdd';  
	var type="add";
	var title="用户";
	 $dialog=$.art.page.showDialog(type,title,addPageUrl,fnAdd);
}
//执行添加
function fnAdd(){
	 var formId="operateFormId";
	 var formType="";
	 var addUrl = baseUrl + "/b/sys/user/add";
	 var fnCallback=function(data){
		 $.art.page.fnShowResult(data,function(){
			 $dialog.close();
			 dataTable.fnDraw();
		 });
	 }
	 $.art.rest.toAdd(formId,formType,addUrl,fnCallback);
}

//修改对话框
$.beforeUserEdit=function(userSeq){
	var editPageUrl = baseUrl + '/f/sys/user/beforeEdit/'+userSeq;//编辑url
	var type="edit";
	var title="用户";
	 $dialog=$.art.page.showDialog(type,title,editPageUrl,fnEdit);
}
//执行修改
function fnEdit(){
	 var formId="operateFormId";
	 var formType="";
	 var editUrl = baseUrl + "/b/sys/user/edit";
	 var fnCallback=function(data){
		 $.art.page.fnShowResult(data,function(){
			 $dialog.close();
			 dataTable.fnDraw();
		 });
	 }
	 $.art.rest.toEdit(formId,formType,editUrl,fnCallback);
}
/************************** init operate **************************/



//查询操作
$.rest.search=function(){
	dataTableSearchCondition.length = 0;
	dataTableSearchCondition.push({"name":"userId","value":$("#userId").val()});
	dataTableSearchCondition.push({"name":"userName","value":$("#userName").val()});
	if($("#UserRoleId").val()!=""){
		dataTableSearchCondition.push({"name":"roleSeq","value":$("#UserRoleId").val()});
	}
	dataTable.fnDraw();
};
/**************************新增和修改页面表单元素的验证start **************************/

/**************************新增和修改页面表单元素的验证start **************************/
$.initOperateValidate = function(){
	var operateForm = $('#operateFormId');
	//新增课程验证
	operateForm.validate({
		 	errorElement: 'label', //default input error message container
	        errorClass: 'help-inline', // default input error message class
	        focusInvalid: false, // do not focus the last invalid input
		   rules: {                   		//添加各字段的限制规则
			    "userId": {             		//课程名
	                required: true,//表示为空时给出提示信息        
	                maxlength:20
	            },
	            "userName": {             		//课程号
	                required: true,
	                maxlength:20
	            },
	            userPass: {
                    required: true
                },
                userRePass: {
                    required: true,
                    equalTo: "#submit_form_password"
                },
	            "isValid":{
	                required: true
	            },
	            "createUserId":{
	            	 required: true
	            }
	        },
	        messages: {                     	
	           "userId": {             			//用户ID
        	   required: "必填",
        	   maxlength:"20个字符"
		            },
	           "userName": {             		//用户名称
                   required: "必填" ,
                   maxlength:"20个字符"
	            },
	            "userPass": {           		//用户密码
	                required: "必填"
	            },
	            "userRePass":{             		//用户再次输入密码
	            	required: "必填",
	            	equalTo: "不一致"
	            },
	            "isValid":{                     //是否有效
	                required: "必填"
	            },
	            "createUserId":{
	            	 required: "必填"
	            }
	        },
	        errorPlacement: function (error, element) {         
	        	if (element.attr("name") == "isValid") {
                    error.addClass(" help-small no-left-padding").insertAfter("#lastRadioId").css("margin-top","-4px");
	        	}else{
	        		error.addClass(" help-small no-left-padding").insertAfter(element).css({"margin-top":"8px","margin-left":"5px"});
	        	}
            },
            highlight: function (element) {
                $(element)
                    .closest('.control-group').removeClass('success').addClass('error');               
            },
            success: function (label) {	
                label
                  .addClass('valid ok')
                  .closest('.control-group').removeClass('error').addClass('success');           
            }   
	});
	//单独为 单选按钮 添加 验证样式
    $('input[type="radio"]', operateForm).change(function () {
    	operateForm.validate().element($(this));
   });
};
/**************************新增和修改页面表单元素的验证end **************************/
/**************************动态加载数据start**************************/
//加载 用户修改的数据
$.rest.loadData = function(userSeq){
	var postUrl = searchDataByKey + '/' + userSeq;
	$.post(postUrl, function(data){
		    var user = data.object;
		    oldPassword = user.userPass;
		    $("#userSeq").val(user.userSeq);
			$("#userId").val(user.userId);	
			$("#userId1").html(user.userId);	
			$("#userName").val(user.userName);
			$("#submit_form_password").val("");
			$("#userRePass").val("");
			$("input[type='radio'][name='isValid'][value='"+user.isValid+"']").attr("checked",true);//单选按钮赋值
			$("#memo").val(user.memo);
			$.common.handleUniform();
	});
};
/**************************动态加载数据end   **************************/
/***************************用户信息 end**********************************/

