/** ************************artdialog start*********************************** */
if (typeof $.art.page == "undefined") {
	$.art.page = {};
}
if (typeof $.art.rest == "undefined") {
	$.art.rest = {};
}
/** ************************edit by gm start*********************************** */
var dialogLock=true;//弹出框高度固定开关
var dialogLockHeight=500;//弹出框固定高度

//** ************************弹出框样式开始********************************** */
// 固定弹出框顶部高度 
$.dialogHeightLock = function() {
	$(".aui_state_focus .aui_content").addClass("overScroll");
	$('.overScroll').css("height", "0px");
	$('.overScroll').css("overflow", "hidden");
}

//如果内容少 弹出框高度自适应
$.dialogHeightAuto = function() {
	var contentHeight=$(".dialog-content").height();
	var contentWidth=$(".dialog-content").width();
	if (contentHeight<dialogLockHeight) {
		$(".aui_state_focus .aui_content").animate({
			height:contentHeight
		});
	}else{
		$('.overScroll').css("overflow", "auto");
		if (dialogLock==true) {
			$(".aui_state_focus .aui_content").animate({
				height:dialogLockHeight
			});
		}else{
			$(".aui_state_focus .aui_content").animate({
				height:contentHeight
			});
		}
	}
}

// 取消固定弹出框的高度
$.dialogHeightUnlock = function() {
	if ($(".aui_state_focus").length < 1) {
		$(".aui_content").removeClass("overScroll");
		$('.aui_content').attr("style", "padding: 20px 25px;");
	}
}

// 让滚动条滚动到指定位置
$.dialogScrollTo = function(element) {
	var container = $('.overScroll'), scrollTo = element;
	if (typeof scrollTo == "undefined") {
		container.animate({
			scrollTop :  container.offset().top-90
		});
	}else{
		container.animate({
			scrollTop : scrollTo.offset().top - container.offset().top - 50
					+ container.scrollTop()
		});
		/*
		 * container.scrollTop(scrollTo.offset().top - container.offset().top +
		 * container.scrollTop());
		 */
	}
}
//** ************************弹出框样式结束********************************** */


//** ************************基础对话框开始********************************** */
// 基础操作对话框(gm)
$.baseDialog = function(id, title, okVal, okFn) {
	var $dialog = $.dialog({
		id : id,
		lock : true,
		width : '850px',
		title : title,
		left : '60%',
		top : '10%',
		drag : true,
		resize : false,
		// zIndex:9997,
		ok : okFn == false ? false : function() {
			okFn();
			return false;
		},
		okVal : okVal,
		cancel : true,
		cancelVal : "关闭"
	});
	$.dialogHeightLock();// 固定高度
	return $dialog;
}

// 基础消息对话框(gm)
$.baseMsgDialog = function(type, msg, okVal, okFn, cnVal, cnFn) {
	$.dialogHeightUnlock();// 取消固定高度
	$.dialog({
		id : 'message',
		content : '<strong>' + msg + '</strong>',
		icon : type,
		lock : true,
		left : '50%',
		top : '30%',
		ok : okFn == false ? false : function() {
			okFn();
		},
		okVal : okVal,
		cancel : cnFn == true ? true : function() {
			cnFn();
		},
		cancelVal : cnVal
	});
}
//** ************************基础对话框结束********************************** */


//** ************************各种消息框开始********************************** */
//弹出带回调函数确定、取消消息框(gm)
$.art.page.msgAndokFn = function(type, msg, okVal, okFn) {
	if (typeof okFn == "undefined") {
		okFn=okVal;
		okVal="确定";
	}
	var cnFn =true;
	var cnVal = "取消";
	$.baseMsgDialog(type, msg, okVal, okFn, cnVal, cnFn);
};

// 弹出带回调函数消息框(gm)
$.art.page.msgAndcnFn = function(type, msg,cnVal, cnFn) {
	var okVal = "";
	var okFn = false;
	if (typeof cnFn == "undefined") {
		 cnFn=cnVal;
		 cnVal = "关闭";
	}
	$.baseMsgDialog(type, msg, okVal, okFn, cnVal, cnFn);
};

// 弹出消息框
$.art.page.message = function(type, msg) {
	var cnFn = true;
	$.art.page.msgAndcnFn(type, msg, cnFn);
};
//** ************************各种消自己框结束********************************** */


//** ************************增删改查操作开始********************************** */
// 新增，修改，查看对话框(gm)
$.art.page.showDialog = function(type, title, pageUrl, fnOperate) {
	if ("add" == type) {
		var id = "add";
		var okVal = "添加";
		title=title;
	} else if ("edit" == type) {
		var id = "edit";
		var okVal = "修改";
	
	} else if ("view" == type) {
		var id = "view";
		title=title;
		fnOperate = false;
	} else {
		var id="other";
		var okVal=type;
	}
	//App.scrollTo();// 页面滚动到顶部
	var $dialog = $.baseDialog(id, title, okVal, fnOperate);
	$.post(pageUrl, function(data) {
		$dialog.content(data);
		$.dialogHeightAuto();//高度自适应内容
		
		if (dialogLock==true) {
			//$.dialogScrollTo();// 滚动到弹出框最项部
		}
		
	});
	
	return $dialog;
}

// 新增操作(gm)
$.art.rest.toAdd = function(formId, formType, addUrl, fnCallback) {
	if (!$("#" + formId).valid()) {
		if (dialogLock==true) {
			  if(typeof elements != undefined ){
					//App.scrollTo();// 页面滚动到顶部
					$.dialogScrollTo($(elements[0]));// 弹出框滚动到错误元素位置
					elements.splice(0, elements.length);// 清空放错误元素的数组
			  }
		}
		return false;
	} else {
		if ("fileForm" == formType) {
			$.fileUpload(addUrl, formId, function(data) {
				fnCallback(data);
			});
		} else {
			$.post(addUrl, $("#" + formId).serialize(), function(data) {
				fnCallback(data);
			});
		}
	}
}

// 修改操作(gm)
$.art.rest.toEdit = function(formId, formType, editUrl, fnCallback){
	$.art.rest.toAdd(formId, formType, editUrl, fnCallback);
}

//删除前检查(gm)
$.art.page.deleteValid = function(count){
	if (count == 0) {
		$.art.page.message('warning', '请至少选择一条要删除的数据!');
		return false;
	}else{
		return true;
	}
}
$.art.page.shValid = function(count){
	if (count == 0) {
		$.art.page.message('warning', '请至少选择一条数据!');
		return false;
	}else{
		return true;
	}
}

//确认删除框(gm)
$.art.page.isDelete = function(name,fnOperate){
	var type="question";
	var msg="确定要删除"+name+"吗？";
	var okVal="确定";
	var okFn=fnOperate;
	$.art.page.msgAndokFn(type, msg, okVal, okFn)
}
$.art.page.isSh = function(fnOperate){
	var type="question";
	var msg="确定要执行此操作吗？";
	var okVal="确定";
	var okFn=fnOperate;
	$.art.page.msgAndokFn(type, msg, okVal, okFn)
}


//删除操作(gm)
$.art.rest.toDelete = function(form, deleteUrl, fnCallback){
	$.post(deleteUrl, form.serialize(), function(data) {
		fnCallback(data);
	});
}
$.art.rest.toSh = function(form, deleteUrl, fnCallback){
	$.post(deleteUrl, form.serialize(), function(data) {
		fnCallback(data);
	});
}

//显示操作结果(gm)
$.art.page.fnShowResult = function(data, cnFn) {
	if (data.result == "success") {
		var type = "succeed";
		var msg = data.msg;
		$.art.page.msgAndcnFn(type, msg, cnFn);
	} else {
		$.art.page.message("error", data.msg);
	}
}

//删除操作一条龙
$.art.page.del = function(deleteUrl, dataTableForm, dataTable,okFn) {
	var count = $.common.getCheckBoxCheckedCount();
	var isOk=$.art.page.deleteValid(count);
	if (isOk) {//是否有选中的记录
		var name=count+"条信息";
		//弹出确定删除吗
		$.art.page.isDelete(name,function(){
			//删除操作
			$.art.rest.toDelete(dataTableForm, deleteUrl, function(data){
				//显示操作结果
				$.art.page.fnShowResult(data, function(){
					if (typeof okFn=="undefined") {
						//操作成功后刷新表格 去除勾选
						dataTable.fnDraw();
						$.common.clearChecked();
					}else{
						okFn();
					}
				});
			});
		});
	}
};
$.art.page.sh = function(deleteUrl, dataTableForm, dataTable,dataTable1) {
	var count = $.common.getCheckBoxCheckedCount();
	var isOk=$.art.page.shValid(count);
	if (isOk) {//是否有选中的记录
		//弹出确定删除吗
		$.art.page.isSh(function(){
			//删除操作
			$.art.rest.toSh(dataTableForm, deleteUrl, function(data){
				//显示操作结果
				$.art.page.fnShowResult(data, function(){
					
						//操作成功后刷新表格 去除勾选
						dataTable.fnDraw();
						if(typeof dataTable1=="undefined"){
							
						}else{
							dataTable1.fnDraw();
							
						}
		
						$.common.clearChecked();
					
				});
			});
		});
	}
};
//** ************************增删改查操作结束********************************** */



//** ************************兼容旧版本开始********************************** */
// 弹出操作页面(弹出 查看,新增,修改页面)
$.page.operate = function(id, title, loadPageUrl, operateUrl) {
	var okVal = "确定";
	var okFn = (id == 'pageView') ? false : function() {
		$.rest.operate(id, operateUrl);
	}
	var $dialog = $.baseDialog(id, title, okVal, okFn);

	$.post(loadPageUrl, function(data) {
		$dialog.content(data);
	});
};
// 实现弹出框操作功能(实现查看,新增和修改)
$.rest.operate = function(id, operateUrl) {
	var postUrl;
	var form = $('#operateFormId');
	if (!form.valid()) {
		return false;
	} else {
		$.post(operateUrl, form.serialize(), function(data) {
			if (data.result == "success") {
				var type = "succeed";
				var msg = data.msg;
				var cnFn = function() {
					$dialog.close();
					dataTable.fnDraw();
				};
				$.art.page.msgAndcnFn(type, msg, cnFn);
			} else {
				$.art.page.message("error", data.msg);
			}
		});
	}
	;
};
/** ************没有涉及刷新树的 start**************** */
/** ************涉及刷新树的 start**************** */
// 弹出删除确认信息框
$.page.delRushTree = function(dataTableDelUrl, dataTableForm, dataTable) {
	var count = $.common.getCheckBoxCheckedCount();
	if (count == 0) {
		$.art.page.message('warning', '请至少选择一条要删除的数据!');
	} else {
		var type = 'question';
		var msg = '您确认要删除' + count + '条信息吗？';
		var okVal = "确定";
		var okFn = function() {
			// 调用删除参数信息的函数
			$.rest.delRushTree(dataTableDelUrl, dataTableForm, dataTable);
		};
		var cnVal = "取消";
		var cnFn = true;
		$.baseMsgDialog(type, msg, okVal, okFn, cnVal, cnFn);
	}
};
// 实现删除操作功能
$.rest.delRushTree = function(dataTableDelUrl, dataTableForm, dataTable) {
	$.post(dataTableDelUrl, dataTableForm.serialize(), function(data) {
		if (data.result == "success") {
			var type = "succeed";
			var msg = data.msg;
			var cnFn = function() {
				$.loadTreeData();
				dataTable.fnDraw();
				$.common.clearChecked();
			};
			$.art.page.msgAndcnFn(type, msg, cnFn);
		} else {
			$.art.page.message("error", data.msg);
		}
	});
};

// 弹出操作页面(弹出新增,修改页面)
$.page.operateRushTree = function(id, title, loadPageUrl, operateUrl) {
	var okVal = "确定";
	var okFn = (id == 'pageView') ? false : function() {
		$.rest.operateRushTree(id, operateUrl);
	}
	var $dialog = $.baseDialog(id, title, okVal, okFn);

	$.post(loadPageUrl, function(data) {
		$dialog.content(data);
	});
};
// 实现弹出框操作功能(实现查看,新增和修改)
$.rest.operateRushTree = function(id, operateUrl) {
	var postUrl;
	var form = $('#operateFormId');
	if (!form.valid()) {
		return false;
	} else {
		$.post(operateUrl, form.serialize(), function(data) {
			if (data.result == "success") {
				var type = "succeed";
				var msg = data.msg;
				var cnFn = function() {
					$dialog.close();
					$.loadTreeData();
					dataTable.fnDraw();
				};
				$.art.page.msgAndcnFn(type, msg, cnFn);
			} else {
				$.art.page.message("error", data.msg);
			}
		});
	}
	;
};
/** ************涉及刷新树的 end**************** */

// 实现非弹出框时的 修改操作,同时可以实现错误元素的定位 和 验证通过后去掉对勾的显示样式
$.rest.edit = function(editUrl, elements, labels, dataTableUrl) {
	var form = $('#operateFormId');
	if (!form.valid()) {
		//App.scrollTo($(elements[0]), -50);// 定位到第一个不符合要求的元素 的附近
		elements.splice(0, elements.length);// 用于清空该数组中的数据，是为了进行存放下一次的 不符合要求的 元素
		return false;
	} else {
		$.post(editUrl, form.serialize(), function(data) {
			if (data.result == "success") {
				var type = "succeed";
				var msg = data.msg;
				var cnFn = function() {
					for (var i = 0; i < labels.length; i++) {
						$(labels[i]).removeClass('valid ok').closest(
								'.control-group').removeClass('error')
								.removeClass('success');
					}
					$.page.contentBody(dataTableUrl);
					//App.scrollTo();
				};
				$.art.page.msgAndcnFn(type, msg, cnFn);
			} else {
				$.art.page.message("error", data.msg);
			}
		});
	}
};
// 实现非弹出框时的 修改操作,同时可以实现错误元素的定位 和 验证通过后去掉对勾的显示样式
$.rest.editStopoverCurrentPage = function(editUrl, elements, labels) {
	var form = $('#operateFormId');
	if (!form.valid()) {
		//App.scrollTo($(elements[0]), -50);// 定位到第一个不符合要求的元素 的附近
		elements.splice(0, elements.length);// 用于清空该数组中的数据，是为了进行存放下一次的 不符合要求的 元素
		return false;
	} else {
		$.post(editUrl, form.serialize(), function(data) {
			if (data.result == "success") {
				var type = "succeed";
				var msg = data.msg;
				var cnFn = function() {
					for (var i = 0; i < labels.length; i++) {
						$(labels[i]).removeClass('valid ok').closest(
								'.control-group').removeClass('error')
								.removeClass('success');
					}
					//App.scrollTo();
				};
				$.art.page.msgAndcnFn(type, msg, cnFn);
			} else {
				$.art.page.message("error", data.msg);
			}
		});
	}
};
// 实现非弹出框时的 添加操作,不实现错误元素的定位
$.rest.add = function(addUrl, dataTableUrl) {
	$.post(addUrl, $("#operateFormId").serialize(), function(data) {
		if (data.result == "success") {
			var type = "succeed";
			var msg = data.msg;
			var cnFn = function() {
				$.page.contentBody(dataTableUrl);
				//App.scrollTo();
			};
			$.art.page.msgAndcnFn(type, msg, cnFn);
		} else {
			$.art.page.message("error", data.msg);
		}
	});
};
// 实现非弹出框时的 添加操作,实现错误元素的定位
$.rest.addWithFixedPosition = function(addUrl, dataTableUrl) {
	var form = $('#operateFormId');
	if (!form.valid()) {
		//App.scrollTo($(elements[0]), -50);// 定位到第一个不符合要求的元素 的附近
		elements.splice(0, elements.length);// 用于清空该数组中的数据，是为了进行存放下一次的 不符合要求的 元素
		return false;
	} else {
		$.post(addUrl, $("#operateFormId").serialize(), function(data) {
			if (data.result == "success") {
				var type = "succeed";
				var msg = data.msg;
				var cnFn = function() {
					$.page.contentBody(dataTableUrl);
					//App.scrollTo();
				};
				$.art.page.msgAndcnFn(type, msg, cnFn);
			} else {
				$.art.page.message("error", data.msg);
			}
		});
	}
};
//** ************************兼容旧版本结束********************************** */
//下面的仅仅教学评估单条数据删除使用
$.deletebyid=function(url,id,dataTable,okFn){
	$.dialogHeightUnlock();// 取消固定高度
	$.dialog({
		id : 'message',
		content : '您确定要删除吗？',
		icon : 'question',
		lock : true,
		left : '50%',
		top : '30%',
		ok : function() {
			$.todeletebyid(url,id,dataTable,okFn)
			
			return true;
		},
		okVal : "确定",
		cancel :true,
		cancelVal :'关闭'
	});
	
}
$.todeletebyid=function(url,id,dataTable,okFn){
	delUrl=url+'/'+id;
	$.post(delUrl,function(data){
		
		if(data.result=='success'){
			$.dialogHeightUnlock();// 取消固定高度
			$.dialog({
				id:'message',
				content : data.msg,
				icon : 'succeed',
				lock : true,
				left : '50%',
				top : '30%',
				ok : function() {
					if (typeof okFn=="undefined"){
						
						dataTable.fnDraw();
						return true;
					} else{
						okFn();
						return true;
					}
				},
				okVal : "关闭"
			});
		}else{
			$.dialogHeightUnlock();// 取消固定高度
			$.dialog({
				id:'message',
				content : data.msg,
				icon : 'error',
				lock : true,
				left : '50%',
				top : '30%',
				ok : function() {
                if (typeof okFn=="undefined"){
						
						dataTable.fnDraw();
						return true;
					} else{
						okFn();
						return true;
					}
				},
				okVal : "关闭"
			});
		
		}
	})
	
}
/** ************************edit by gm end*********************************** */
/** ************************artdialog end*********************************** */
