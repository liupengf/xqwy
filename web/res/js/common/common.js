//设置点击查询条件实现让其显示/隐藏
$.common.barContextShowOrHide = function() {
	$(".portlet .portlet-title").each(
			function() {
				if ($(this).next().css('display') == "none") {
					$(this).toggle(
							function() {
								$(this).next().slideDown(200);// 元素 将由 上往下
								// 延伸显示
								jQuery(this).find("a").removeClass("expand")
										.addClass("collapse");
							},
							function() {
								$(this).next().slideUp(200);// 元素将由 下往上 缩短隐藏
								jQuery(this).find("a").removeClass("collapse")
										.addClass("expand");
							});
				}
			});
};
// 实现弹出对话框中全选/全不选的操作
$.common.selectAllOrNot = function(idVlaue, nameValue) {
	if (idVlaue.attr("checked") == "checked") {
		$("#change").text("全不选");
		$(":checkbox").filter("[name=" + nameValue + "]").each(function() {
			$(this).attr("checked", "checked");
		});
	} else {
		$("#change").html("全选");
		$(":checkbox").filter("[name=" + nameValue + "]").each(function() {
			$(this).removeAttr("checked");
		});
	}
};
// 获取列表选中列
$.common.getColumnChecked = function(exportAoData) {
	var i = 0;
	$('#dataTable_column_toggler input[type="checkbox"]').each(
			function() {
				if ($(this).attr("checked") == 'checked') {
					exportAoData.push({
						"name" : "iDisplayCol_" + i,
						"value" : $(this).attr("data-column-name") + '|'
								+ $(this).next().html()
					});
					i++;
				}
			});
	return exportAoData;
};
// 获取列表选中列
$.common.getColumnChecked = function(exportAoData,id) {
	var i = 0;
	$('#'+id+' input[type="checkbox"]').each(
			function() {
				if ($(this).attr("checked") == 'checked') {
					exportAoData.push({
						"name" : "iDisplayCol_" + i,
						"value" : $(this).attr("data-column-name") + '|'
						+ $(this).next().html()
					});
					i++;
				}
			});
	return exportAoData;
};
// 获取列表复选框选中数目
$.common.getCheckBoxCheckedCount = function() {
	var count = 0;
	$(".checkboxes").each(function() {
		if ($(this).is(":checked")) {
			count++;
		}
	});
	return count;
};
// 获取修改选中的checked
$.common.getCheckBoxCheckedValue = function() {
	var value = '';
	$(".checkboxes").each(function() {
		if ($(this).prop("checked") == true) {
			value = value + $(this).attr("value") + ",";
		}
	});
	if (null != value && value.length > 0) {
		value = value.substring(0, value.lastIndexOf(','));// 该方法是截取kch字符串中
		// 从索引0位置开始，截取到最后一个,位置之前的
		// 字符串
	}
	return value;
};
// 如果是全选，再删除后使得 复选框处于 不选中状态
$.common.clearChecked = function() {
	if ($('#dataTableId .group-checkable').prop('checked')) {
		// alert($('#dataTableId .group-checkable').parent());
		// $('#dataTableId .group-checkable').parent().removeClass("checked");
		$('#dataTableId .group-checkable').prop({
			checked : false
		});
	}
};

// 为查询条件中的各个单选按钮绑定单击事件
// 时间戳格式 年-月
$.common.dateMonthFormat = function(date) {
	return new Date(date).Format("yyyy-MM");
};
// 时间戳格式 年
$.common.dateYearFormat = function(date) {
	return new Date(date).Format("yyyy");
};

// 时间戳格式 年-月-日
$.common.dateFormat = function(date) {
	return new Date(date).Format("yyyy-MM-dd");
};

// 时间戳格式化 年-月-日 时:分:秒
$.common.dateTimeFormat = function(date) {
	return new Date(date).Format("yyyy-MM-dd hh:mm:ss");
};
// 时间戳格式化 年-月-日 时:分:秒
$.common.dateMinTimeFormat = function(date) {
	return new Date(date).Format("yyyy-MM-dd hh:mm:ss S");
};

// 把后台传过来的时间转换为符合要求的格式(第二种方法)
$.common.toFormat = function(d, dateFormat) {
	var date = new Date();
	date.setTime(d);
	return date.Format(dateFormat);
}
Date.prototype.Format = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1,
		"d+" : this.getDate(),
		"h+" : this.getHours(),
		"m+" : this.getMinutes(),
		"s+" : this.getSeconds(),
		"q+" : Math.floor((this.getMonth() + 3) / 3),
		"S" : this.getMilliseconds()
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}
// 为单选按钮,复选框组件添加样式
$.common.handleUniform = function() {
	if (!jQuery().uniform) {
		return;
	}
	// var test = $("input[type=radio]:not(.toggle, .star)");//
	// input[type=checkbox]:not(.toggle),
	var test = $("input[type=radio]:not(.toggle, .star)");
	if (test.size() > 0) {
		test.each(function() {
			if ($(this).parents(".checker").size() == 0) {
				$(this).show();
				$(this).uniform();
			}
		});
	}
};
// 为下拉列表组件添加样式 select2
$.common.handleSelect2 = function() {
	$('.select2').select2({
		allowClear : true
	});
};

/** ************************dialog style start*********************************** */
// 单独设置弹出框的下拉列表样式，避免与原网页冲突
$.common.handleDialogSelect2 = function() {
	$('.dialog-content .select2').select2({
		allowClear : true
	});
}
/** ************************dialog style end*********************************** */
// 为下拉列表组件添加样式 chosen
$.common.handleChosen = function() {
	if (!jQuery().chosen) {
		return;
	}
	$(".chosen").each(
			function() {
				$(this).chosen(
						{
							allow_single_deselect : $(this).attr(
									"data-with-diselect") === "1" ? true
									: false
						});
			});
}
// 为日期组件添加样式 初始的面板直接就是 日期面板
$.common.handleDatePickers = function() {
	if (jQuery().datepicker) {
		$('.date-picker').datepicker({
			language : 'ch',
			format : "yyyy-mm-dd",
			startView : 0,
			minViewMode : 0,
			weekStart : 1,
			todayBtn : true
		});
		// $('.date-picker').datepicker('setDaysOfWeekDisabled',
		// [0,6]);//用来设置一周中有哪几天是不可用的
		// $('.date-picker').datepicker('setStartDate', '2013-01-01');//用来给
		// 日期选择其设置一个新的 起始日期 包含该日期
		// $('.date-picker').datepicker('setEndDate', '2014-03-18');//用来给
		// 日期选择其设置一个新的 起始日期 包含该日期
		/*
		 * $('.date-picker').datepicker().on('changeDate', function(ev){
		 * alert("当 日期面板中 选择的时间 发生变化时 就会触发该函数"); });
		 */
		/*
		 * $('.date-picker').datepicker().on('changeYear', function(ev){
		 * alert("当 年视图中 选择的 年份发生变化时,就会触发该函数 "); });
		 */
		/*
		 * $('.date-picker').datepicker().on('changeMonth', function(ev){
		 * alert("当 月视图中 选择的 月份发生变化时,就会触发该函数 "); });
		 */
		// esc键 显示/隐藏 时间控件
	}
};
// 初始的面板直接就是 月面板
$.common.handleDatePickers1 = function() {
	if (jQuery().datepicker) {
		$('.date-picker').datepicker({
			format : "yyyy-mm",
			startView : 1,
			minViewMode : 1,
			weekStart : 1,
			todayBtn : true
		});
	}
};
// 初始的面板直接就是 年面板
$.common.handleDatePickers2 = function() {
	if (jQuery().datepicker) {
		$('.date-picker').datepicker({
			format : "yyyy",
			startView : 2,
			minViewMode : 2,
			todayBtn : true
		});
	}
};
// 为查询条件中的各个单选按钮绑定单击事件
$.common.searchRadioBindClick = function(radioGroupName) {
	for (var i = 0; i < radioGroupName.length; i++) {
		$(":radio").filter("[name='" + radioGroupName[i].name + "']").each(
				function() {
					$(this).click(function() {
						$.rest.search();
					});
				});
	}
};
// 身份证号的验证
$.common.sfzhValidate = function() {
	var idCardNoUtil = {
		/* 省,直辖市代码表 */
		provinceAndCitys : {
			11 : "北京",
			12 : "天津",
			13 : "河北",
			14 : "山西",
			15 : "内蒙古",
			21 : "辽宁",
			22 : "吉林",
			23 : "黑龙江",
			31 : "上海",
			32 : "江苏",
			33 : "浙江",
			34 : "安徽",
			35 : "福建",
			36 : "江西",
			37 : "山东",
			41 : "河南",
			42 : "湖北",
			43 : "湖南",
			44 : "广东",
			45 : "广西",
			46 : "海南",
			50 : "重庆",
			51 : "四川",
			52 : "贵州",
			53 : "云南",
			54 : "西藏",
			61 : "陕西",
			62 : "甘肃",
			63 : "青海",
			64 : "宁夏",
			65 : "新疆",
			71 : "台湾",
			81 : "香港",
			82 : "澳门",
			91 : "国外"
		},
		/* 每位加权因子 */
		powers : [ "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9",
				"10", "5", "8", "4", "2" ],
		/* 第18位校检码 */
		parityBit : [ "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" ],
		/* 性别 */
		genders : {
			male : "男",
			female : "女"
		},
		/* 校验地址码 */
		checkAddressCode : function(addressCode) {
			var check = /^[1-9]\d{5}$/.test(addressCode);
			if (!check)
				return false;
			if (idCardNoUtil.provinceAndCitys[parseInt(addressCode.substring(0,
					2))]) {
				return true;
			} else {
				return false;
			}
		},
		/* 校验日期码 */
		checkBirthDayCode : function(birDayCode) {
			var check = /^[1-9]\d{3}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))$/
					.test(birDayCode);
			if (!check)
				return false;
			var yyyy = parseInt(birDayCode.substring(0, 4), 10);
			var mm = parseInt(birDayCode.substring(4, 6), 10);
			var dd = parseInt(birDayCode.substring(6), 10);
			var xdata = new Date(yyyy, mm - 1, dd);
			if (xdata > new Date()) {
				return false;// 生日不能大于当前日期
			} else if ((xdata.getFullYear() == yyyy)
					&& (xdata.getMonth() == mm - 1) && (xdata.getDate() == dd)) {
				return true;
			} else {
				return false;
			}
		},
		/* 计算校检码 */
		getParityBit : function(idCardNo) {
			var id17 = idCardNo.substring(0, 17);
			/* 加权 */
			var power = 0;
			for (var i = 0; i < 17; i++) {
				power += parseInt(id17.charAt(i), 10)
						* parseInt(idCardNoUtil.powers[i]);
			}
			/* 取模 */
			var mod = power % 11;
			return idCardNoUtil.parityBit[mod];
		},
		/* 验证校检码 */
		checkParityBit : function(idCardNo) {
			var parityBit = idCardNo.charAt(17).toUpperCase();
			if (idCardNoUtil.getParityBit(idCardNo) == parityBit) {
				return true;
			} else {
				return false;
			}
		},
		/* 校验15位或18位的身份证号码 */
		checkIdCardNo : function(idCardNo) {
			// 15位和18位身份证号码的基本校验
			var check = /^\d{15}|(\d{17}(\d|x|X))$/.test(idCardNo);
			if (!check)
				return false;
			// 判断长度为15位或18位
			if (idCardNo.length == 15) {
				return idCardNoUtil.check15IdCardNo(idCardNo);
			} else if (idCardNo.length == 18) {
				return idCardNoUtil.check18IdCardNo(idCardNo);
			} else {
				return false;
			}
		},
		// 校验15位的身份证号码
		check15IdCardNo : function(idCardNo) {
			// 15位身份证号码的基本校验
			var check = /^[1-9]\d{7}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}$/
					.test(idCardNo);
			if (!check)
				return false;
			// 校验地址码
			var addressCode = idCardNo.substring(0, 6);
			check = idCardNoUtil.checkAddressCode(addressCode);
			if (!check)
				return false;
			var birDayCode = '19' + idCardNo.substring(6, 12);
			// 校验日期码
			return idCardNoUtil.checkBirthDayCode(birDayCode);
		},
		// 校验18位的身份证号码
		check18IdCardNo : function(idCardNo) {
			// 18位身份证号码的基本格式校验
			var check = /^[1-9]\d{5}[1-9]\d{3}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}(\d|x|X)$/
					.test(idCardNo);
			if (!check)
				return false;
			// 校验地址码
			var addressCode = idCardNo.substring(0, 6);
			check = idCardNoUtil.checkAddressCode(addressCode);
			if (!check)
				return false;
			// 校验日期码
			var birDayCode = idCardNo.substring(6, 14);
			check = idCardNoUtil.checkBirthDayCode(birDayCode);
			if (!check)
				return false;
			// 验证校检码
			return idCardNoUtil.checkParityBit(idCardNo);
		},
		formateDateCN : function(day) {
			var yyyy = day.substring(0, 4);
			var mm = day.substring(4, 6);
			var dd = day.substring(6);
			return yyyy + '-' + mm + '-' + dd;
		},
		// 获取信息
		getIdCardInfo : function(idCardNo) {
			var idCardInfo = {
				gender : "", // 性别
				birthday : "" // 出生日期(yyyy-mm-dd)
			};
			if (idCardNo.length == 15) {
				var aday = '19' + idCardNo.substring(6, 12);
				idCardInfo.birthday = idCardNoUtil.formateDateCN(aday);
				if (parseInt(idCardNo.charAt(14)) % 2 == 0) {
					idCardInfo.gender = idCardNoUtil.genders.female;
				} else {
					idCardInfo.gender = idCardNoUtil.genders.male;
				}
			} else if (idCardNo.length == 18) {
				var aday = idCardNo.substring(6, 14);
				idCardInfo.birthday = idCardNoUtil.formateDateCN(aday);
				if (parseInt(idCardNo.charAt(16)) % 2 == 0) {
					idCardInfo.gender = idCardNoUtil.genders.female;
				} else {
					idCardInfo.gender = idCardNoUtil.genders.male;
				}
			}
			return idCardInfo;
		},
		/* 18位转15位 */
		getId15 : function(idCardNo) {
			if (idCardNo.length == 15) {
				return idCardNo;
			} else if (idCardNo.length == 18) {
				return idCardNo.substring(0, 6) + idCardNo.substring(8, 17);
			} else {
				return null;
			}
		},
		/* 15位转18位 */
		getId18 : function(idCardNo) {
			if (idCardNo.length == 15) {
				var id17 = idCardNo.substring(0, 6) + '19'
						+ idCardNo.substring(6);
				var parityBit = idCardNoUtil.getParityBit(id17);
				return id17 + parityBit;
			} else if (idCardNo.length == 18) {
				return idCardNo;
			} else {
				return null;
			}
		}
	};
	return idCardNoUtil;
};
// 填充右侧区域
$.page.contentBody = function(url) {
	$.post(url, function(data) {
		// App.unblockUI(pageContent);
		var pageContentBody = $('.page-content .page-content-body');
		pageContentBody.html(data);
		App.fixContentHeight(); // fix content height
	});
};
function keyDownLogin(e) {
	if (navigator.appName == "Microsoft Internet Explorer") {
		var keycode = event.keyCode;
		var realkey = String.fromCharCode(event.keyCode);

	} else {
		var keycode = e.which;
		var realkey = String.fromCharCode(e.which);

	}
	if (keycode == 13) {
		$(".enterPressButton").click();//  
	}

};
function keyDown(e) {
	if (navigator.appName == "Microsoft Internet Explorer") {
		var keycode = event.keyCode;
		var realkey = String.fromCharCode(event.keyCode);

	} else {
		var keycode = e.which;
		var realkey = String.fromCharCode(e.which);

	}

	if (keycode == 13) {
		$("#searchButtonId").click();// .enterPressButton
	}

};

// 文件上传 add by gm
$.fileUpload = function(postUrl, formId, fnCallBack) {
	$.ajaxFileUpload({
		url : postUrl,
		secureuri : false,
		formId : formId,
		dataType : 'json',
		success : function(data, status) {
			fnCallBack(data);
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
};
// 数组去重 add by gm
$.toUniqueArray=function(arr1, arr2)
{
	if (typeof arr2 == undefined) {
		var n = {}, r = []; // n为hash表，r为临时数组
		for (var i = 0; i < arr1.length; i++) // 遍历当前数组
		{
			if (!n[arr1[i]]) // 如果hash表中没有当前项
			{
				n[arr1[i]] = true; // 存入hash表
				r.push(arr1[i]); // 把当前数组的当前项push到临时数组里面
			}
		}
		return r;
	} else {
		var n = {}, r1 = [], r2 = []; // n为hash表，r为临时数组
		for (var i = 0; i < arr1.length; i++) // 遍历当前数组
		{
			if (!n[arr1[i]]) // 如果hash表中没有当前项
			{
				n[arr1[i]] = true; // 存入hash表
				r1.push(arr1[i]); // 把当前数组的当前项push到临时数组里面
				r2.push(arr2[i]); // 把当前数组的当前项push到要返回的数组里面
			}
		}
		return r2;
	}
}