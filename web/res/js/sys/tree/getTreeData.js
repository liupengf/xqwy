 var searchDataByKey = baseUrl + '/b/sys/tree/detail';
/************************** view and edit page load data start ******************/
$.rest.loadData = function(treeSeq){
	var postUrl = searchDataByKey + '/' + treeSeq;
	$.post(postUrl, function(data){
		    var tree = data.object;
	        $("#isRoot").html(tree.isRoot);
	        $("#isRoot1").val(tree.isRoot);
		    $("#treeId").val(tree.treeId);
			$("#treeName").val(tree.treeName);
			$("#treeImageId").val(tree.treeImage);
			$("#sortNumId").val(tree.sortNum);
			$("#treeLevelId").val(tree.treeLevel);
			$("#memo").val(tree.memo);
			if(tree.isRoot =='否'){
				$("#treeFatherDivId").show();
				$("#treeFatherDivId").append(treeFatherContext);
				$("#treeFatherName").html(tree.treeFatherName);
				$("#treeFatherSeq").val(tree.treeFatherSeq);
			}
			$("#treeImageId, #treeLevelId").select2({
				allowClear : true
			});
	});
};
/************************** view and edit page load data end **********************/ 