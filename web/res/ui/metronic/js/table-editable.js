var TableEditable = function () {

    return {
        init: function () {
        	//alert("11111shilei");
        	//实现书目信息的取消
            function restoreRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);//此时就是 获得的数据就是 一行空数据 
                //alert(aData);
                var jqTds = $('>td', nRow);//获取的是每列
                alert(jqTds.length);
                for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                    oTable.fnUpdate(aData[i], nRow, i, false);//是使用上面获得的一行空数据 去替换  该行中要取消的数据
                }
                oTable.fnDraw();
            }
            //实现在表格中插入输入框
            function editRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML = '<input type="text" class="m-wrap" style="width:100px" value="' + aData[0] + '">';
                jqTds[1].innerHTML = '<input type="text" class="m-wrap" style="width:100px" value="' + aData[1] + '">';
                jqTds[2].innerHTML = '<input type="text" class="m-wrap" style="width:100px" value="' + aData[2] + '">';
                jqTds[3].innerHTML = '<input type="text" class="m-wrap" style="width:100px" value="' + aData[3] + '">';
                jqTds[4].innerHTML = '<input type="text" class="m-wrap" style="width:100px" value="' + aData[4] + '">';
                jqTds[5].innerHTML = '<input type="text" class="m-wrap" style="width:100px" value="' + aData[5] + '">';
                jqTds[6].innerHTML = '<input type="text" class="m-wrap" style="width:100px" value="' + aData[6] + '">';
                jqTds[7].innerHTML = '<input type="text" class="m-wrap " style="width:100px" value="' + aData[7] + '">';
                jqTds[8].innerHTML = '<a class="edit icon-save " href=""></a><input type="hidden" value="Save"/>&nbsp;||&nbsp;<a class="cancel icon-undo" href=""></a>';
            }
            //实现书目的临时保存
            function saveRow(oTable, nRow) {
            	var aData = oTable.fnGetData(nRow);
            	alert(aData);
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
                oTable.fnUpdate(jqInputs[4].value, nRow, 4, false);
                oTable.fnUpdate(jqInputs[5].value, nRow, 5, false);
                oTable.fnUpdate(jqInputs[6].value, nRow, 6, false);
                oTable.fnUpdate(jqInputs[7].value, nRow, 7, false);
                oTable.fnUpdate('<a class="edit icon-edit" href=""></a>&nbsp;||&nbsp;<a class="delete icon-trash" href=""></a>', nRow, 8, false);
                oTable.fnDraw();
                var aData = oTable.fnGetData(nRow);
            	alert(aData);
            }
            var oTable = $('#addKcSmTable').dataTable({
                "aLengthMenu": [
                    [5, 15, 20, -1],
                    [5, 15, 20, "All"]
                ],
                // set the initial value
                "sDom": "<'row-fluid'<'span6'l>r>t<'row-fluid'<'span6'i><'span6'p>>",
                "sPaginationType": "bootstrap",
                "oLanguage": {
                	"sZeroRecords": "请添加书目信息！", 
                    "sInfo": "显示第  _START_ 条到第  _END_ 条记录,一共  _TOTAL_ 条记录",
                    "sLengthMenu": "_MENU_ 条/页",
                    "bFilter" : false,// 搜索栏
                    "sInfoFiltered": "",
                    "sInfoEmpty":"",
                    "oPaginate": {
                        "sPrevious": "上一页",
                        "sNext": "下一页"
                    }
                },
                "bPaginate" : true,// 分页按钮
        		"bFilter" : false,// 搜索栏
        		"bLengthChange" : true,// 每行显示记录数
        		"iDisplayLength" : 5,//每页显示行数
        		"bSort" : true,// 排序
        		"bInfo" : true,// Showing 1 to 10 of 23 entries 总记录数中显示多少等信息
        		"bAutoWidth" : true, // 自动计算列宽度
                "aoColumnDefs": [{
                        'bSortable': false,
                        'aTargets': [0]
                    }
                ]
            });
            var nEditing = null;
            //1.为添加书目按钮绑定单击事件
            $('#addKcSmBtnId').click(function (e) {
                e.preventDefault();
                //就会在表格中插入一行空数据
                var aiNew = oTable.fnAddData(['', '', '', '','', '','','',
                        '<a class="edit icon-edit" href=""></a>&nbsp;||&nbsp;<a class="cancel icon-undo" data-mode="new" href=""></a>'
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                editRow(oTable, nRow);//调用上面 插入一行 文本输入框 的函数
                nEditing = nRow;
            });
            //4.删除临时书目信息
            $('#addKcSmTable a.delete').live('click', function (e) {
                e.preventDefault();

                if (confirm("您确定要删除该行吗 ?") == false) {
                    return;
                }
                var nRow = $(this).parents('tr')[0];
                oTable.fnDeleteRow(nRow);
               // alert("Deleted! Do not forget to do some ajax to sync with backend :)");
            });
           //3.取消临时书目数据
            $('#addKcSmTable a.cancel').live('click', function (e) {
            	
                e.preventDefault();
                
                if ($(this).attr("data-mode") == "new") {//然后再执行此操作将该行数据删除掉
                    var nRow = $(this).parents('tr')[0];
                    oTable.fnDeleteRow(nRow);
                } else {
                	//首先是先执行下面
                    restoreRow(oTable, nEditing);
                    nEditing = null;
                }
            });
            //2.保存临时书目数据
            $('#addKcSmTable a.edit').live('click', function (e) {
                e.preventDefault();
                alert($(this).next("input").val());
                var nRow = $(this).parents('tr')[0];
                if (nEditing !== null && nEditing != nRow) {//这个是什么时候执行呢？
                	alert("222222s");
                    restoreRow(oTable, nEditing);
                    editRow(oTable, nRow);
                    nEditing = nRow;
                } else if (nEditing == nRow && $(this).next("input").val() == "Save") {
                    //在第一次在输入书目数据后就进入到下面
                    saveRow(oTable, nEditing);
                    nEditing = null;//在第一次保存完后，nEditing 变为 null
                   // alert("Updated! Do not forget to do some ajax to sync with backend :)");//还需要进行异步处理
                } else {
                	//在第二次进行保存时，就执行该语句,在执行完一行数据的第二次 保存后， nEditing又变为了 nRow.
                	//alert("shilei");
                    editRow(oTable, nRow);
                    nEditing = nRow;
                }
            });
        }
    };

}();