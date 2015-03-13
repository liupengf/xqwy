$.initOperateValidate = function() {
	var operateForm = $('#operateFormId');
	// 新增课程验证
	operateForm.validate({
		errorElement : 'label',
		errorClass : 'help-inline',
		focusInvalid : false,
		rules : {
			"treeId" : {                       // 节点id
				required : true
			},
			"treeName" : {                    // 节点名称
				required : true
			},
			"isRoot" : {                      // 是否根节点
				required : true
			},
			"treeFatherSeq" : {                   // 父节点节点序号
				required : true
			},
			"treeLevel" : {                   // 父节点节点序号
				required : true
			},
			"treeImage" : {                     // 节点小图标
				required : true
			},
			"createUserId" : {                   // 创建人
				required : true
			},
			"sortNum" : {                   // 序列值
				required : true,
				digits:true
			}
		},

		messages : {
			"treeId" : {               // 节点ID
				required : "必填"
			},
			"treeName" : {             // 节点名称
				required : "必填"
			},
			"isRoot" : {                //是否根节点
				required : "必填"
			},
			"treeFatherSeq" : {           //父节点序号
				required : "必填"
			},
			"treeLevel" : {           //父节点序号
				required : "必填"
			},
			"treeImage" : {             //节点小图标
				required : "必填"
			},
			"createUserId" : {            //创建人
				required : "必填"
			},
			"sortNum" : {             //排序值
				required : "必填",
				digits:"整数"
			}
		},
		errorPlacement : function(error, element) {
			if (element.attr("name") == "isRoot") {
                error.addClass(" help-small no-left-padding").insertAfter("#lastRadioId").css({"margin-top":"-5px","margin-left":"55px"});
        	}else if(element.attr("name") == "treeImage"){
        		error.addClass(" help-small no-left-padding").insertAfter("#iconImageId").css({"margin-top" : "8px","margin-left" : "5px"});
        	}else{
        		error.addClass(" help-small no-left-padding").insertAfter(element)
				.css({
					"margin-top" : "8px",
					"margin-left" : "5px"
				});
        	}			
		},
		highlight : function(element) {
			$(element).closest('.control-group').removeClass('success')
					.addClass('error');
		},
		success : function(label) {
			label.addClass('valid ok').closest('.control-group').removeClass(
					'error').addClass('success');
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