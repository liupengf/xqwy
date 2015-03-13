<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page-sidebar nav-collapse collapse">
<div class="page-top" style="height:43px;">     
    <div style="float:left;width:80%;height:10px;margin-top:6px"><div id="jxpgtitle">物业管理系统</div></div><div style="float:right;width:20%;height:10px;margin-top:6px"><i class="sidebar-toggler hidden-phone" ></i></div>
    </div> 
	<ul class="page-sidebar-menu">
		
		
		<!-- 下面的li就是右侧出现的目录内容 -->

		<!--基础信息管理star-->
		<li class=""><a href="javascript:;"><i class="icon-list-alt"></i> <span class="title">基础数据录入</span><span class="selected"></span><span class="arrow"></span></a>
			<ul class="sub-menu"> 
				<li><a class="ajaxify"	href="${baseUrl}/f/xqwy/jbxx/fxzl/beforePageList"><i class="icon-list-alt"></i>小区及房屋资料录入</a></li>
				<li><a class="ajaxify"	href="${baseUrl}/f/xqwy/jbxx/zhxx/beforePageList"><i class="icon-th-list"></i>住户资料录入</a></li>
				<li><a class="ajaxify"	href="${baseUrl}/f/xqwy/jbxx/sfxm/beforePageList"><i class="icon-th-list"></i>物业收费项目管理</a></li>
				<li><a class="ajaxify"	href="${baseUrl}/f/xqwy/jbxx/tccxx/beforePageList"><i class="icon-th-list"></i>停车场车位资料录入</a></li>
			</ul>
		</li>
		<li class=""><a href="javascript:;"><i class="icon-list-alt"></i> <span class="title">物业管理</span><span class="selected"></span><span class="arrow"></span></a>
			<ul class="sub-menu">
				<li><a class="ajaxify"	href="${baseUrl}/f/xqwy/gl/ts/beforePageList"><i class="icon-list-alt"></i>投诉管理</a></li>
				<li><a class="ajaxify"	href="${baseUrl}/f/xqwy/gl/bx/beforePageList"><i class="icon-th-list"></i>报修管理</a></li>
				<li><a class="ajaxify"	href="${baseUrl}/f/xqwy/gl/zhtcw/beforePageList"><i class="icon-th-list"></i>住户停车位管理</a></li>
				<li><a class="ajaxify"	href="${baseUrl}/f/xqwy/gl/jfgl/beforePageList"><i class="icon-th-list"></i>物业缴费管理</a></li>
			</ul>
		</li>
		<li class=""><a href="javascript:;"><i class="icon-list-alt"></i> <span class="title">统计报表</span><span class="selected"></span><span class="arrow"></span></a>
			<ul class="sub-menu">
				<li><a class="ajaxify"	href="${baseUrl}/f/xqwy/bb/xtbb/beforeBb"><i class="icon-list-alt"></i>各类数据统计报表</a></li>
			
			</ul>
		</li>
		<li class=""><a href="javascript:;"><i class="icon-list-alt"></i> <span class="title">系统管理</span><span class="selected"></span><span class="arrow"></span></a>
			<ul class="sub-menu">
				<li><a class="ajaxify"	href="${baseUrl}/f/xqwy/xtgl/user/beforeBf"><i class="icon-list-alt"></i>系统备份</a></li>
				<c:if test="${username=='admin'}">
				<li><a class="ajaxify"	href="${baseUrl}/f/xqwy/xtgl/user/beforePageList"><i class="icon-th-list"></i>用户管理</a></li>
			</c:if>
			</ul>
		</li>
	
		
	</ul>
</div>