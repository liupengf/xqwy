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
									<label class="control-label" for="username">用户名<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text"  id="username" class="m-wrap" placeholder=""
											name="username"/>
											<input name="oldusername" id="oldusername" type="hidden"/>
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span12 ">
								<div class="control-group">
									<label class="control-label" for="pwd">密码<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text" id="pwd" class="m-wrap" placeholder=""
											name="pwd" value="">
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
$.rest.loadData("${username}");
});
</script>