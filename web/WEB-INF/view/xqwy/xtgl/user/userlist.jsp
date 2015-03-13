<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="row-fluid">
	<a id="adduser" class="btn" href="javaScript:void(0)">添加</a>
	</div>
		<div class="portlet-body" id="loadingDiv">
									<form id="dataTableForm" name="dataTableForm">
										<input id="aoDataInputId" name="aoData" type="hidden" />
			<table class="table table-striped table-bordered table-hover"
															id="dataTableId">
															<thead>
																<tr> 
																<th class="hidden-480">用户名</th>
																	<th class="hidden-480">密码</th>
																	<th class="hidden-480">操作</th>
																</tr>
															</thead>
															<tbody id="qjblListTbody">
													
															</tbody>
														</table>
														</form>
														
				</div>
	<script
	src="${baseUrl}/res/js/xqwy/xtgl/user/userlist.js"
	type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(function(){
	$.initDataTable();
	$.initButtonClick();
	});
</script>
