<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="row-fluid" style="height: 20px;"></div>
	<div class="row-fluid">
	<div class="span8">
	&nbsp;&nbsp;&nbsp;&nbsp;投诉人：<input type="text" id="tsr">
	投诉类别：<input type="text" id="tslb">
	<a id="searchtsButton" class="btn" href="javaScript:void(0)" style="float: right;">查询</a>
	</div>
	<div class="span4">
	<a id="addts" class="btn" href="javaScript:void(0)" style="float: left;">添加</a>
	</div>
	</div>
		<div class="portlet-body" id="loadingDiv">
									<form id="dataTableForm" name="dataTableForm">
										<input id="aoDataInputId" name="aoData" type="hidden" />
			<table class="table table-striped table-bordered table-hover"
															id="dataTableId">
															<thead>
																<tr> 
																<th class="hidden-480">投诉人</th>
																	<th class="hidden-480">投诉日期</th>
																	<th class="hidden-480">投诉人地址</th>
																	<th class="hidden-480">投诉类别</th>
																	<th class="hidden-480">投诉内容</th>
																	<th class="hidden-480">操作</th>
																</tr>
															</thead>
															<tbody id="qjblListTbody">
													
															</tbody>
														</table>
														</form>
														
				</div>
	<script
	src="${baseUrl}/res/js/xqwy/gl/ts/tslist.js"
	type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(function(){
	$.initDataTable();
	$.initButtonClick();
	});
</script>
