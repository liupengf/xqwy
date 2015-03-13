/************************** init start **************************/
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
var dataTableReqUrl = baseUrl + '/b/sys/module/pageList';     //请求url


var dataTableViewUrl = baseUrl + '/f/sys/module/beforeRoleList';     //查看url

var dataTableExportUrl = baseUrl + '/b/sys/module/genExcel';//数据导出url
var dataTableBeforeHangNodeUrl = baseUrl + '/f/sys/module/beforeTreeList'; //悬挂节点


var searchDataByKey = baseUrl + '/b/sys/module/detail';
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
						  var moduleSeq = row.moduleSeq;
						  return '<input type="checkbox" class="checkboxes" name="moduleSeq" value='+moduleSeq+' />';
						  },'sWidth':'15px', "bSortable": false
					  }, 
                      { "mDataProp": "moduleId"},                //模块ID
                      { "mDataProp": 'moduleName'},              //模块名称
                      { "mDataProp": "modulePrefixValue"},       //模块标识
                      { "mDataProp": "moduleValue" },            //模块值
                      { "mDataProp": "createUserId" },           //创建用户ID
                      { "mDataProp": function(row){
                    	  var viewUrl = dataTableViewUrl + '/' + row.moduleSeq;
                    	//  var beforeEditUrl = dataTableBeforeEditUrl + '/' + row.moduleSeq;
                    	  var HangNodeUrl = dataTableBeforeHangNodeUrl + '/' + row.moduleSeq;
                    	  return '<a href=javaScript:void(0); onclick=$.page.contentBody("'+viewUrl+'");>角色</a>'
                    	      //   +'&nbsp;||&nbsp;<a href=javaScript:void(0); onclick=$.page.operate("pageEdit","模块修改","'+beforeEditUrl+'","'+editUrl+'");>修改</a>'
                    	         +'&nbsp;||&nbsp;<a href=javaScript:void(0); onclick="$.beforeModuleEdit('+row.moduleSeq+')");>修改</a>'
                    	         +'&nbsp;||&nbsp;<a href=javaScript:void(0); onclick=$.page.contentBody("'+HangNodeUrl+'");>节点</a>';
                      },"bSortable": false,'sWidth':'120px'}  //操作
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
		$.beforeModuleAdd();
		//$.page.operate("pageAdd","新增模块",dataTableBeforeAddUrl,addUrl);
	});
	//03删除
	$("#delButtonId").click(function(){
		var dataTableDelUrl = baseUrl + '/b/sys/module/del';     //删除url
		$.art.page.del(dataTableDelUrl,dataTableForm,dataTable);
	});
	//04导出
	$("#exportExcelButtonId").click(function(){
		$.rest.exportExcel(dataTableAoData,dataTableForm,aoDataInput,dataTableExportUrl);
		
	});
}
/************************** 02 init button end **************************/

/************************** init operate **************************/
//添加对话框
$.beforeModuleAdd=function(){
	var addPageUrl = baseUrl + '/f/sys/module/beforeAdd';  //添加url
	var type="add";
	var title="模块";
	 $dialog=$.art.page.showDialog(type,title,addPageUrl,fnAdd);
}
//执行添加
function fnAdd(){
	 var formId="operateFormId";
	 var formType="";
	 var addUrl = baseUrl + "/b/sys/module/add";
	 var fnCallback=function(data){
		 $.art.page.fnShowResult(data,function(){
			 $dialog.close();
			 dataTable.fnDraw();
		 });
	 }
	 $.art.rest.toAdd(formId,formType,addUrl,fnCallback);
}

//修改对话框
$.beforeModuleEdit=function(moduleSeq){
	var editPageUrl = baseUrl + '/f/sys/module/beforeEdit/'+moduleSeq;//编辑url
	var type="edit";
	var title="模块";
	 $dialog=$.art.page.showDialog(type,title,editPageUrl,fnEdit);
}
//执行修改
function fnEdit(){
	 var formId="operateFormId";
	 var formType="";
	 var editUrl = baseUrl + "/b/sys/module/edit";
	 var fnCallback=function(data){
		 $.art.page.fnShowResult(data,function(){
			 $dialog.close();
			 dataTable.fnDraw();
		 });
	 }
	 $.art.rest.toEdit(formId,formType,editUrl,fnCallback);
}
/************************** init operate **************************/
/************************** click start ************************/
//01查询操作
$.rest.search = function(){
	dataTableSearchCondition.length = 0;
	dataTableSearchCondition.push({"name":"modulePrefixValue","value":$("#modulePrefixValue").val()});
	dataTableSearchCondition.push({"name":"moduleName","value":$("#moduleName").val()});
    dataTableSearchCondition.push({"name":"moduleValue","value":$("#moduleValue").val()});
    if($("#moduleRoleId").val()!=""){
    	dataTableSearchCondition.push({"name":"roleSeq","value":$("#moduleRoleId").val()});
    }
	dataTable.fnDraw();
};
 /************************** click end ************************/
/************************** 新增和修改页面表单元素的验证 start*******************************************************/
$.initOperateValidate = function(){
	var operateForm = $('#operateFormId');
	//新增课程验证
	operateForm.validate({
		 	errorElement: 'label',
	        errorClass: 'help-inline',
	        focusInvalid: false,
		   rules: {                   		//添加各字段的限制规则
			    "moduleId": {             		//课程名
	                required: true,//表示为空时给出提示信息        
	                maxlength:20
	            },
	            "moduleName": {             		//课程号
	                required: true
	            },
	            "modulePrefixValue": {           		//课程英文名
	                required: true
	            },
	            "moduleValue":{             		//开课时间
	            	required: true
	            }
	        },
	        messages: {                     	
	           "moduleId": {             			//用户ID
        	   required: "必填"
		            },
	           "moduleName": {             		//用户名称
                   required: "必填"
	            },
	            "modulePrefixValue": {           		//用户密码
	                required: "必填"
	            },
	            "moduleValue":{             		//用户再次输入密码
	            	required: "必填"
	            }
	        },
	        errorPlacement: function (error, element) {         
	           error.addClass(" help-small no-left-padding").insertAfter(element).css({"margin-top":"8px","margin-left":"5px"});	
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
	 //重新验证下拉列表    单独为 下拉列表添加  验证样式
	 $('.select2', operateForm).change(function () {
		 operateForm.validate().element($(this));
	 });
};
/************************** 新增和修改页面表单元素的验证 end*******************************************************/
/************************** 查看和修改页面数据的加载start *******************************************************/
$.rest.loadData = function(moduleSeq){
	var postUrl  = searchDataByKey + '/' + moduleSeq;
	$.post(postUrl, function(data){
		    var module = data.object;
		    $("#moduleId").val(module.moduleId);
			$("#moduleName").val(module.moduleName);	
			$("#modulePrefixValue").val(module.modulePrefixValue);
			$("#moduleValue").val(module.moduleValue);
			$.common.handleSelect2();
	});
};
/************************** 查看和修改页面数据的加载start *******************************************************/