<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String allHrefRootPath = (String) request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ "/";
	String bUrl=allHrefRootPath;
	String iurl = allHrefRootPath,furl = allHrefRootPath,scrawlsUrl = allHrefRootPath; 
	
%>

<script type="text/javascript">
			
			bootUrl = "<%=bUrl%>";//编辑器根路径
			// 设置ueditor的默认文件上传路径
			 imgUrl = "<%=iurl%>";//图片上传
			 fileUrl = "<%=furl%>";//文件上传
			 scrawlsUrl = "<%=scrawlsUrl%>";//涂鸦上传 
			
	window.UEDITOR_HOME_URL=bootUrl+"res/ui/plugins/ueditor/";
	window.UEDITOR_HOME_IMGURL = imgUrl;
	window.UEDITOR_HOME_FURL = fileUrl;
	window.UEDITOR_HOME_SCRAWLURL = scrawlsUrl;
</script>
	<script type="text/javascript"  src="/res/ui/plugins/ueditor/third-party/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="/res/ui/plugins/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/res/ui/plugins/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<!--     <script type="text/javascript" charset="utf-8" src="/res/ui/plugins/ueditor/lang/zh-cn/zh-cn.js"></script> -->
    
<div class="dialog-content">
<textarea id="content1" name="hid_content1"></textarea>
<br>
<br>
<br>
<input type="button" id="subbtn" value="SubBtn"  style="float: right; margin-right: 9px;"/>

 <br>
<br>
<br>
<br>
<br>
<br>
<br>

<script type="text/javascript">

	/*定制编辑器工具栏*/
	 var tool= [
	            [
	               'undo', //撤销
	               'redo', //重做
	               'bold', //加粗
	               'indent', //首行缩进
	               'italic', //斜体
	               'underline', //下划线
	               'strikethrough', //删除线
	               'subscript', //下标
	               'fontborder', //字符边框
	               'superscript', //上标
	               'formatmatch', //格式刷
	               'blockquote', //引用
	               'pasteplain', //纯文本粘贴模式
	               'selectall', //全选
	               'preview', //预览
	               'horizontal', //分隔线
	               'removeformat', //清除格式
	               'time', //时间
	               'date', //日期
	               'unlink', //取消链接
	               'insertcode', //代码语言
	               'fontfamily', //字体
	               'fontsize', //字号
	               'paragraph', //段落格式
	               'emotion', //表情
	               'spechars', //特殊字符
	               'searchreplace', //查询替换
	               'help', //帮助
	               'justifyleft', //居左对齐
	               'justifyright', //居右对齐
	               'justifycenter', //居中对齐
	               'justifyjustify', //两端对齐
	               'forecolor', //字体颜色
	               'backcolor', //背景色
	               'fullscreen', //全屏
	               'directionalityltr', //从左向右输入
	               'directionalityrtl', //从右向左输入
	               'rowspacingtop', //段前距
	               'rowspacingbottom', //段后距
	               'pagebreak', //分页
	               'insertframe', //插入Iframe
	               'imagenone', //默认
	               'imageleft', //左浮动
	               'imageright', //右浮动
	               'imagecenter', //居中
	               'lineheight', //行间距
	               'edittip ', //编辑提示
	               'customstyle', //自定义标题
	               'touppercase', //字母大写
	               'tolowercase', //字母小写
	               'background', //背景
	           ]
	       ]; 
	var wzeditor = UE.getEditor('content1',{toolbars:tool}); 
	var initval="这里用于测试后台返回的数据，并将数据写入编辑框中";
	wzeditor.ready(function(){
		wzeditor.setContent(initval);//设置编辑器的内容的方法：ueditor.setContent('value');
	});
	$("#subbtn").click(function(){
		  var nr=wzeditor.getContent();//读取编辑器的内容的方法ueditor.getContent()
		  alert(nr);
		  $.post("/b/xt/all/xtfkb/add",{fknr:nr},function(data){
         	$.messager.alert(data);
         }) 
	})
</script>
</div>