$(document).ready(function() {
	$.init();
	document.onkeydown=keyDownLogin;
});

//页面初始化
$.init = function(){
	//1.form表单添加验证
	$('.login-form').validate({
	    errorElement: 'label', //default input error message container
        errorClass: 'help-inline', // default input error message class
        focusInvalid: false, // do not focus the last invalid input
        rules: {
            j_username: {
                required: true
            },
            j_password: {
                required: true
            },
            /*remember: {
                required: false
            },*/
            /*yanzhengma:{
            	required: true
            }*/
        },
        messages: {
            j_username: {
                required: "用户名不能为空."
            },
            j_password: {
                required: "密码不能为空."
            },
            /*yanzhengma:{
            	required: "验证码不能为空."
            }*/
        },
        invalidHandler: function (event, validator) { //display error alert on form submit   
            //$('.alert-error', $('.login-form')).show();
        },
        highlight: function (element) { // hightlight error inputs
            $(element)
                .closest('.control-group').addClass('error'); //set error class to the control group
        },
        success: function (label) {
            label.closest('.control-group').removeClass('error');
            label.remove();
        },
        //这个是弹出提示错误信息的位置和字体的大小
        errorPlacement: function (error, element) {
            error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
        }
       
    });
	//涉及login背景的变化
    $.backstretch([
   		        "/res/ui/metronic/image/bg/1.jpg",
   		        "/res/ui/metronic/image/bg/2.jpg",
   		        "/res/ui/metronic/image/bg/3.jpg",
   		        "/res/ui/metronic/image/bg/4.jpg"
   		        ], {
   		          fade: 100,
   		          duration: 8000
   		      });
	//2.提交按钮添加事件
	$("#loginButtonId").click(function(){
		$.login();
	});
};

//登录处理
$.login = function(){
	//1.登录表单处理
	if(!$('.login-form').valid()){
		return;
	}
	//2.异步请求
	$('#loginDivId').showLoading();//显示
	var userLoginUrl = baseUrl + "/b/ajaxLogin";
	$.post(userLoginUrl,$('.login-form').serialize(),function(data){
		if (data == "success") {
			window.location.href = baseUrl + "/f/main";
		} else {
			$('#loginDivId').hideLoading();//隐藏
			$('#errorMsgSpanId').html(data);
			$('.alert-error', $('.login-form')).show();
		}
	});
}
