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
											<input type="hidden" name="fxzlid" id="fxzlid"/>
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span12 ">
								<div class="control-group">
									<label class="control-label" for="lpbh">楼盘编号<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text" id="lpbh" class="m-wrap" placeholder=""
											name="lpbh" value="">
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span12 ">
								<div class="control-group">
									<label class="control-label" for="fwbh">房屋编号<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text" id="fwbh" class="m-wrap" placeholder=""
											name="fwbh" value="">
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span6 ">
								<div class="control-group">
									<label class="control-label" for="szlc">所在楼层<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text" id="szlc" class="m-wrap" placeholder=""
											name="szlc" value="">
									</div>
								</div>
							</div>
					
						</div>
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span6 ">
								<div class="control-group">
									<label class="control-label" for="hx">户型<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text" id="hx" class="m-wrap" placeholder=""
											name="hx" value="">
									</div>
								</div>
							</div>
					
						</div>
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span6 ">
								<div class="control-group">
									<label class="control-label" for="jzmj">建筑面积<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text" id="jzmj" class="m-wrap" placeholder=""
											name="jzmj" value="">
									</div>
								</div>
							</div>
					
						</div>
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span6 ">
								<div class="control-group">
									<label class="control-label" for="symj">使用面积<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text" id="symj" class="m-wrap" placeholder=""
											name="symj" value="">
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
$.rest.loadData("${fxzlid}");
});
</script>