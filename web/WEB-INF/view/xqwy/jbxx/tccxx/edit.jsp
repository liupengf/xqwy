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
									<label class="control-label" for="xqmc">小区名称<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text"  id="xqmc" class="m-wrap" placeholder=""
											name="xqmc"/>
											<input type="hidden" name="xxid" id="xxid">
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span12 ">
								<div class="control-group">
									<label class="control-label" for="tccmc">停车场名称<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text" id="tccmc" class="m-wrap" placeholder=""
											name="tccmc" value="">
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span6 ">
								<div class="control-group">
									<label class="control-label" for="cwh">车位号<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text" id="cwh" class="m-wrap" placeholder=""
											name="cwh" value="">
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
$.rest.loadData("${xxid}");
});
</script>