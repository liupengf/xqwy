<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="row-fluid" style="height: 20px;"></div>
	<div class="row-fluid">
	<div class="span8">
	&nbsp;&nbsp;&nbsp;&nbsp;楼盘编号：<input type="text" id="lpbh">
	房屋编号：<input type="text" id="fwbh">
	所在小区：<input type="text" id="xqmc">
	<a id="searchfxzlButton" class="btn" href="javaScript:void(0)" style="float: right;">查询</a>
	</div>
	<div class="span4">
	<a id="addfxzl" class="btn" href="javaScript:void(0)"  style="float: left;">添加</a>
	</div>
	</div>
		<div class="portlet-body" id="loadingDiv">
									<form id="dataTableForm" name="dataTableForm">
										<input id="aoDataInputId" name="aoData" type="hidden" />
			<table class="table table-striped table-bordered table-hover"
															id="dataTableId">
															<thead>
																<tr> 
																<th class="hidden-480">小区名称</th>
																	<th class="hidden-480">楼盘编号</th>
																	<th class="hidden-480">房屋编号</th>
																	<th class="hidden-480">所在楼层</th>
																	<th class="hidden-480">使用面积</th>
																	<th class="hidden-480">建筑面积</th>
																	<th class="hidden-480">户型</th>
																	<th class="hidden-480">操作</th>
																</tr>
															</thead>
															<tbody id="qjblListTbody">
													
															</tbody>
														</table>
														</form>
														
				</div>
	<script
	src="${baseUrl}/res/js/xqwy/jbxx/fxzl/fxzllist.js"
	type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(function(){
	$.initDataTable();
	$.initButtonClick();
	});
</script>
