/************************** edit page elements init start ******************/
$.initElements = function(){
	$.initDeltreeFatherDivDom();
	$.treeImageBindChangeEvent();
}
//初始化的时候默认是根节点,所以其treeFatherDiv就要删除
$.initDeltreeFatherDivDom=function(){
	treeFatherContext =$("#treeFatherDivId").clone().html();
	$("#treeFatherDivId").children().remove();
};
//如果是根节点就隐藏父节点,如果不是就显示父节点
$.page.changeFatherTree = function(isRoot){
	if(isRoot == '否'){
		$("#treeFatherDivId").show();
		$("#treeFatherDivId").children().remove();
		$("#treeFatherDivId").append(treeFatherContext);
		$("#treeFatherSeqId").change(function () {
			$('#operateFormId').validate().element($(this));
	    });
		$("#treeFatherSeqId").select2({
			allowClear : true
		});
		
	}else{
		$("#treeFatherDivId").hide();
		$("#treeFatherDivId").children().remove();
	}
};
//动态加载Html片段
$.treeImageBindChangeEvent = function(){
	$("#treeImageId").bind("change",function(){
		$("#iconImageId").removeClass();
		$("#iconImageId").addClass($("#treeImageId").val());
	});
};
/************************** edit page elements init end ******************/