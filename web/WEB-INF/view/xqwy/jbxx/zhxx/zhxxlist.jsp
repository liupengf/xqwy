<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="row-fluid" style="height: 20px;"></div>
	<div class="row-fluid">
	<div class="span8">
	&nbsp;&nbsp;&nbsp;&nbsp;身份证：<input type="text" id="sfz">
	姓名：<input type="text" id="xm">
	<a id="searchzhxxButton" class="btn" href="javaScript:void(0)" style="float: right;">查询</a>
	</div>
	<div class="span4">
	<a id="addzhxx" class="btn" href="javaScript:void(0)" style="float: left;">添加</a>
	</div>
	</div>
	
		<div class="portlet-body" id="loadingDiv">
									<form id="dataTableForm" name="dataTableForm">
										<input id="aoDataInputId" name="aoData" type="hidden" />
			<table class="table table-striped table-bordered table-hover"
															id="dataTableId">
															<thead>
																<tr> 
																<th class="hidden-480">身份证</th>
																	<th class="hidden-480">小区名称</th>
																	<th class="hidden-480">姓名</th>
																	<th class="hidden-480">地址</th>
																	<th class="hidden-480">操作</th>
																</tr>
															</thead>
															<tbody id="qjblListTbody">
													
															</tbody>
														</table>
														</form>
														
				</div>
	<script
	src="${baseUrl}/res/js/xqwy/jbxx/zhxx/zhxxlist.js"
	type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(function(){
	$.initDataTable();
	$.initButtonClick();
	});
</script>
