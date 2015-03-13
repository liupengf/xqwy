/**************************dataTable start************************************/
//实现数据的导出
/*$.rest.exportExcel = function(dataTableAoData,dataTableForm,aoDataInput){
	var exportAoData = $.common.getColumnChecked(dataTableAoData.concat());
	dataTableForm.attr('action',dataTableExportUrl);
	dataTableForm.attr('method','post');
	aoDataInput.attr('value',JSON.stringify(exportAoData));
    dataTableForm.submit();
};
//实现数据的导出 重载
$.rest.exportExcel = function(dataTableAoData,dataTableForm,aoDataInput,dataTableExportUrl){
	var exportAoData = $.common.getColumnChecked(dataTableAoData.concat());
	dataTableForm.attr('action',dataTableExportUrl);
	dataTableForm.attr('method','post');
	aoDataInput.attr('value',JSON.stringify(exportAoData));
    dataTableForm.submit();
};*/
//实现数据的导出 重载
$.rest.exportExcel = function(dataTableAoData,dataTableForm,aoDataInput,dataTableExportUrl,id){
	var exportAoData = $.common.getColumnChecked(dataTableAoData.concat(),id);
	dataTableForm.attr('action',dataTableExportUrl);
	dataTableForm.attr('method','post');
	aoDataInput.attr('value',JSON.stringify(exportAoData));
	dataTableForm.submit();
};
//dataTable 全选/全不选的操作
$.rest.allSelectOrNot =function(groupCheckable){
	groupCheckable.change(function (){
		var set= $(this).attr("data-set");
		var checked = $(this).is(":checked");
		$(set).each(function(){
			if (checked) {
	        	$(this).attr("checked", true);
	        } else {
	        	$(this).attr("checked", false);
	        }
		});
		//jquery.uniform.update(set);
    });
}
//可选列的隐藏与显示的操作
$.rest.columnTogglerHideOrShow = function(columnToggler){
	columnToggler.change(function(){
		
        var iCol = parseInt($(this).attr("data-column"));//获取 可选列中 设置列的 data-column属性值,并将其转化为整型
       
        var bVis = dataTable.fnSettings().aoColumns[iCol].bVisible;//就会 获取 在dataTable中配置的aoColumns中 对应的第 iCol个字段的 bVisible属性值
      //alert(dataTable.fnSettings().aoColumns[iCol].bVisible);//可知其 返回值是 true/false
        dataTable.fnSetColumnVis(iCol, (bVis ? false : true),false);//如果第iCol个列   的bVisible属性为true,就将其设置为false;反之再将其设置为true   
    });	
}

//实现  触发某一行就改变该行字体的样式
$.rest.TrFontChangeStyle =function(eventType,styleType,styleContext){
	$("#dataTableId tbody tr").unbind().bind(eventType, function () {
		var $this=$(this);
		$this.siblings("tr").each(function(){//先向 上和 向下查找 所有兄弟元素即其他 <tr>对象将其CSS样式先移除。
			$(this).removeAttr("style").find("a").removeAttr("style");
		}).end()//end()方法返回到上一层
		.css(styleType,styleContext)//再为该行<tr>添加CSS样式
		.find("a").css(styleType,styleContext);//再查找 该行<tr>后代中的 <a>元素并为其添加CSS样式	
	});
}
//实现 触发某一行就改变复选框的选中状态
$.rest.TrCheckboxStatus =function(eventType,$dataTableTr){
	$dataTableTr.unbind().bind("click",function(e){
		e = e || window.event;  
		var target =  e.target || e.srcElement;
		if(target.tagName.toLowerCase() == 'td'){  
			if($(this).find(":checkbox").prop("checked")){
				$(this).find(":checkbox").prop("checked",false);
			}else{
				$(this).find(":checkbox").prop("checked",true);
			}
		}
    });
}
//dataTable 发送请求操作
$.rest.fnServerData =function(loadingDivId,dataTableSearchCondition,sSource, aoData,fnCallback){
	   loadingDivId.hideLoading();
	   loadingDivId.showLoading();
		//将查询条件中的数据存放到 aoData中
		for(var i = 0;i<dataTableSearchCondition.length;i++){
			aoData.push(dataTableSearchCondition[i]);
		}
		$.ajax({
			"type" : 'POST',                            //请求方式
			"url" : sSource,                           //发送的请求地址
			"dataType" : "json",                       //返回的数据类型 
			"data" : {	                               //发送的参数				
				aoData : JSON.stringify(aoData)       //前面这个参数名是可以进行修改的，但是要与后台的参数名一致
			},
			"success" : function(data) {
				if(data.result == 'success'){
					fnCallback(data.object);
				}else{
					alert(data.msg);
				}
				loadingDivId.hideLoading();
			}
		});
};
//查找dataTable列表中最近操作过的记录 
$.rest.ViewOperateOrder = function(name,id){
	if (id==null||id=="null"||id== 0) {
		$.art.page.message("warning",'<strong>您当前还未操作!</strong>');
	}else{
		dataTableSearchCondition.length = 0;
		if ($('[id="hand"]>i').attr("class")=="icon-hand-down") {
			$('[id="hand"]>i').attr("class","icon-hand-left");
			$('[id="hand"]').attr("data-content","查看所有记录");
			dataTableSearchCondition.push({"name" : name ,"value" : id});
		}else{
			$('[id="hand"]>i').attr("class","icon-hand-down");
			$('[id="hand"]').attr("data-content","查看操作记录");
		}
		dataTable.fnDraw();
	}
}

/**************************dataTable start************************************/