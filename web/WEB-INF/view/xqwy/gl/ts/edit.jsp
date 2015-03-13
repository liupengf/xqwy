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
									<label class="control-label" for="tsr">投诉人<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text"  id="tsr" class="m-wrap" placeholder=""
											name="tsr"/>
											<input type="hidden" name="tsid" id="tsid"/>
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span12 ">
								<div class="control-group">
									<label class="control-label" for="tssj">投诉日期<span
										class="required">*</span></label>

									<div class="input-append date" id="datetimepicker"
										data-date-format="yyyy-mm-dd">
										<input type="text" id="tssj" name="tssj"> <span class="add-on"><i
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
									<label class="control-label" for="jzxq">投诉类别<span
										class="required">*</span></label>
									<div class="controls">
										<select id="tslb" name="tslb">
										<option value="噪音">噪音</option>
										<option value="污染">污染</option>
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
									<label class="control-label" for="tsnr">投诉内容<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text" id="tsnr" class="m-wrap" placeholder=""
											name="tsnr" value="">
									</div>
								</div>
							</div>
						</div>		
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function(){
$.rest.loadData("${tsid}");
$('#datetimepicker').datetimepicker({minView:2});
});
</script>