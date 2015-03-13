<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
									<label class="control-label" for="sfz">户主身份证<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text"  id="sfz" class="m-wrap" placeholder=""
											name="sfz"/>
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span12 ">
								<div class="control-group">
									<label class="control-label" for="xm">户主姓名<span
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
							<div class="span12 ">
								<div class="control-group">
									<label class="control-label" for="xqmc">小区名称<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text" id="xqmc" class="m-wrap" placeholder=""
											name="xqmc" value="">
									</div>
								</div>
							</div>
						</div>		
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span12 ">
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
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span12 ">
								<div class="control-group">
									<label class="control-label" for="sfmc">收费项目<span
										class="required">*</span></label>
									<div class="controls">
										<select id="sfmc" name="sfmc">
										<c:forEach items="${sfxmlist}" var="sfxmmc">
										<option value="${sfxmmc.sfmc}"> ${sfxmmc.sfmc}</option>
										</c:forEach>
										</select>
									</div>
								</div>
							</div>
						</div>		
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span12 ">
								<div class="control-group">
									<label class="control-label" for="je">应收金额<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text" id="je" class="m-wrap" placeholder=""
											name="je" value="">
									</div>
								</div>
							</div>
						</div>		
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span12 ">
								<div class="control-group">
									<label class="control-label" for="yjje">已交金额<span
										class="required">*</span></label>
									<div class="controls">
										<input type="text" id="yjje" class="m-wrap" placeholder=""
											name="yjje" value="">
									</div>
								</div>
							</div>
						</div>		
						<div class="row-fluid ">
							<!--指标名称-->
							<div class="span12 ">
								<div class="control-group">
									<label class="control-label" for="tssj">收费日期<span
										class="required">*</span></label>

									<div class="input-append date" id="datetimepicker"
										data-date-format="yyyy-mm-dd">
										<input type="text" id="sfrq" name="sfrq"> <span class="add-on"><i
											class="icon-th"></i></span>
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