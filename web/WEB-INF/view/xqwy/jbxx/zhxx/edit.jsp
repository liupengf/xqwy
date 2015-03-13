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
									<label class="control-label" for="sfz">身份证号<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text"  id="sfz" class="m-wrap" placeholder=""
											name="sfz"/>
											<input name="ysfz" id="ysfz" type="hidden"/>
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span12 ">
								<div class="control-group">
									<label class="control-label" for="xqmc">小区名称<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text"  id="xqmc" class="m-wrap" placeholder=""
											name="xqmc"/>
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span12 ">
								<div class="control-group">
									<label class="control-label" for="xm">姓名<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text" id="xm" class="m-wrap" placeholder=""
											name="xm" value="">
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span6 ">
								<div class="control-group">
									<label class="control-label" for="address">地址<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text" id="address" class="m-wrap" placeholder=""
											name="address" value="">
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
$.rest.loadData("${sfz}");
});
</script>