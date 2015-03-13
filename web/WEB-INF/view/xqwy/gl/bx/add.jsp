<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="dialog-content">
	<div class="row-fluid">
		<form id="operateFormId" class="form-horizontal">
			<div class="tabbable tabbable-custom tabbable-full-width"
				style="width: 800px; height: auto;">
				<div class="tab-content">
					<div class="row-fluid" id="swformdiv">
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span12 ">
								<div class="control-group">
									<label class="control-label" for="bxr">报修人<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text"  id="bxr" class="m-wrap" placeholder=""
											name="bxr"/>
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span12 ">
							<div class="control-group">
									<label class="control-label" for="tssj">报修日期<span
										class="required">*</span></label>

									<div class="input-append date" id="datetimepicker"
										data-date-format="yyyy-mm-dd">
										<input type="text" id="bxsj" name="bxsj"> <span class="add-on"><i
											class="icon-th"></i></span>
									</div>

								</div>
							</div>
						</div>		
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span12 ">
								<div class="control-group">
									<label class="control-label" for="jzxq">地址<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text" id="jzxq" class="m-wrap" placeholder=""
											name="jzxq" value="">
									</div>
								</div>
							</div>
						</div>		
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span12 ">
								<div class="control-group">
									<label class="control-label" for="jzxq">报修类别<span
										class="required">*</span></label>
									<div class="controls">
										<select id="bxlb" name="bxlb">
										<option value="水电">水电</option>
										<option value="煤气">煤气</option>
										<option value="其他">其他</option>
										<option></option>
										</select>
									</div>
								</div>
							</div>
						</div>		
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span12 ">
								<div class="control-group">
									<label class="control-label" for="bxnr">报修内容<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text" id="bxnr" class="m-wrap" placeholder=""
											name="bxnr" value="">
									</div>
								</div>
							</div>
						</div>		
					</div>
				</div>
			</div>
		</form>
	</div>
		<script type="text/javascript">
	$(document).ready(function(){
		$('#datetimepicker').datetimepicker({minView:2});
	});
	</script>
</div>