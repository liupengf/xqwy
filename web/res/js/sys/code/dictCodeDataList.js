/************************** init start **************************/
var dataTable;
var dataTableSearchCondition = new Array();//查询条件
dataTableSearchCondition.length = 0;
dataTableSearchCondition.push({"name":"codeId","value":codeId});

//jquery
var loadingDivId = $('#loadingDiv');
var dataTableForm = $("#dataTableForm");
var dataTableAoData = null;//导出列配置
var aoDataInput = $("#aoDataInputId");
var groupCheckable = $('#dataTableId .group-checkable');
var columnToggler =$('#dataTable_column_toggler input[type="checkbox"]');

/************************** 列表dataTable初始化start***********************************************************/
//初始化表格
$.initDataTable = function(){
	//列表
	var dataTableSearchUrl = baseUrl + '/b/code/'+codeId+'/dictCodeData/pageList';
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
        "bPaginate" : true,// 分页按钮
		"bFilter" : false,// 搜索栏
		"bLengthChange" : true,// 每行显示记录数
		"iDisplayLength" : 20,//每页显示行数
		"bSort" : true,// 排序
		"bInfo" : true,// Showing 1 to 10 of 23 entries 总记录数中显示多少等信息
		"bAutoWidth" : true, // 自动计算列宽度
		"sPaginationType": "bootstrap", 
		"sDom": "<'row-fluid'<'span6'l>r>C<'clear'>t<'row-fluid'<'span6'i><'span6'p>>",
        "aaSorting": [[2, 'asc']],
        "aLengthMenu": [
            [15, 20, 30, -1],
            [15, 20, 30, "All"]
        ],
        
        "bProcessing" : false,
		"bServerSide" : true,
		"sAjaxSource" : dataTableSearchUrl,  //传递请求的地址
		"aoColumns": [	
					  { "mDataProp": function(row){ 
						  return '<input type="checkbox" class="checkboxes" name="dataSeq" value='+row.dataSeq+' />';
                          },'sWidth':'15px', "bSortable": false
					  },
                      { "mDataProp": "codeId" },  
                      { "mDataProp": "dataKey"},  
                      { "mDataProp": "dataValue" }, 
                      { "mDataProp": "dataFullValue" }, 
                      { "mDataProp": function(row){
                    	  return '<a href=javaScript:void(0); onclick=$.beforeCodeDataEdit("'+row.dataSeq+'");>修改</a>';
                      },"bSortable": false,"sWidth":"40px"}, //操作
                   ],
		 "fnServerData" : function(sSource, aoData,fnCallback) {  
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
	//根据业务判断隐藏列
	if(codeIsReadOnly == 'Y'){
		dataTable.fnSetColumnVis(0, false,false);
		dataTable.fnSetColumnVis(5, false,false);
	}
};
/************************** 列表dataTable初始化end****************************************************************/

/**************************查询 新增 删除 导出单击事件绑定start ***************************************************/
$.initButtonClick = function(){
	$.common.barContextShowOrHide();
	//01查询
	$("#searchButtonId").click(function(){
		$.rest.search();
	});
	//02新增
	$("#addButtonId").click(function(){
		$.beforeCodeDataAdd();
		//$.page.operate("pageAdd","新增代码数据",dataTableBeforeAddUrl,addUrl);
	});
	//03删除
	$("#delButtonId").click(function(){
		var dataTableDelUrl = baseUrl + '/b/code/dictCodeData/del';
		$.art.page.del(dataTableDelUrl,dataTableForm,dataTable);
	});
	//04导出
	$("#exportExcelButtonId").click(function(){
		var dataTableExportUrl = baseUrl + '/b/code/dictCodeData/genExcel';
		$.rest.exportExcel(dataTableAoData,dataTableForm,aoDataInput,dataTableExportUrl);
	});
};
/**************************查询 新增 删除 导出单击事件绑定 end ***************************************************/

/************************** init operate **************************/
//添加对话框
$.beforeCodeDataAdd=function(){
	var dataTableBeforeAddUrl = baseUrl + '/f/code/'+codeId+'/dictCodeData/beforeAdd';
	var type="add";
	var title="代码数据";
	 $dialog=$.art.page.showDialog(type,title,dataTableBeforeAddUrl,fnAdd);
}
//执行添加
function fnAdd(){
	 var addUrl = baseUrl + "/b/code/dictCodeData/add";		
	 var formId="operateFormId";
	 var formType="";
	 var fnCallback=function(data){
		 $.art.page.fnShowResult(data,function(){
			 $dialog.close();
			 dataTable.fnDraw();
		 });
	 }
	 $.art.rest.toAdd(formId,formType,addUrl,fnCallback);
}
//修改对话框
$.beforeCodeDataEdit=function(dataSeq){
	var dataTableBeforeEditUrl = baseUrl + '/f/code/'+codeId+'/dictCodeData/beforeEdit/'+dataSeq;//编辑url
	var type="edit";
	var title="代码数据";
	 $dialog=$.art.page.showDialog(type,title,dataTableBeforeEditUrl,fnEdit);
}
//执行修改
function fnEdit(){
	 var formId="operateFormId";
	 var formType="";
	 var editUrl = baseUrl + "/b/code/dictCodeData/edit";		
	 var fnCallback=function(data){
		 $.art.page.fnShowResult(data,function(){
			 $dialog.close();
			 dataTable.fnDraw();
		 });
	 }
	 $.art.rest.toEdit(formId,formType,editUrl,fnCallback);
}
/************************** init operate **************************/

/************************** 查询操作************************/
//查询操作
$.rest.search = function(){
	dataTableSearchCondition.length = 0;
	dataTableSearchCondition.push({"name":"dataValue","value":$("#dataValue").val()});
	dataTableSearchCondition.push({"name":"codeId","value":codeId});
	dataTable.fnDraw();
};
/************************** 新增和修改页面表单元素的验证start*******************************************************/
$.initOperateValidate = function(){
	var operateForm = $('#operateFormId');
	operateForm.validate({
		 	errorElement: 'label', //default input error message container
	        errorClass: 'help-inline', // default input error message class
	        focusInvalid: false, // do not focus the last invalid input
		    rules: {   
		    	"dataKey": {             		
	                required:true		
	            },
	            "dataValue": {             		
	                required:true		
	            }
	        },
	        messages: {  
	        	"dataKey": {           	
	                required: "必选"
	            },
	            "dataValue": {           	
	                required: "必选"
	            }
	        },
	        errorPlacement: function (error, element) {
	        	if (element.attr("name") == "isReadOnly") { // for uniform radio buttons, insert the after the given container
                   error.addClass("no-left-padding help-small").insertAfter("#lastRadioId").css({"margin-top":"-5px","margin-left":"55px"});
	        	}else{
	        		error.addClass("no-left-padding help-small").insertAfter(element).css({"margin-top":"8px","margin-left":"5px"});;
	        	}
           },
           highlight: function (element) {
               $(element).closest('.control-group').removeClass('success').addClass('error');               
           },
           success: function (label) {	
               label.addClass('valid ok').closest('.control-group').removeClass('error').addClass('success');           
           }   
	});
	//重新验证下拉单独为 下拉列表添加  验证样式
    $('.select2', operateForm).change(function () {
    	operateForm.validate().element($(this));
    });
    //单独为 单选按钮 添加 验证样式
    $('input[type="radio"]', operateForm).change(function () {
    	operateForm.validate().element($(this));
   });
};
/************************** 新增和修改页面表单元素的验证end*******************************************************/
/************************** 查看和修改页面数据的加载start *******************************************************/
$.rest.loadData = function(id){
	var loadDataUrl = baseUrl + "/b/code/dictCodeData/detail/";
	var postUrl = loadDataUrl + id;
	$.post(postUrl, function(data){
		var obj = data.object;
		
		$("#dataKey").val(obj.dataKey);
		$("#dataValue").val(obj.dataValue);
		$("#dataFullValue").val(obj.dataFullValue);
	});
};
/************************** 新增和修改页面表单元素的验证end*******************************************************/
