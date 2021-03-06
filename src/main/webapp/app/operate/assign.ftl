﻿<#include "/page/common/_layout.html" />
<@layout activebar="report" html_title="任务分配">
<div class="index-background	">
<div class="page-header">
<ul class="nav nav-tabs">
   <li ><a href="${ContextPath}/operate/task">任务分配</a></li>
   <li class="active"><a href="#">分配</a></li>
</ul>
</div>
	<form class="form-horizontal" role="form" action="${ContextPath}/operate/doassign" method="post" >
		<div class="row">
			<input type="hidden" name="userid" value="${(userinfo.uuserid)}">
			<div class="form-group">
				<label class="col-sm-2 control-label">姓名</label>
				<div class="col-sm-4">
					<input type="text" class="form-control"  name="offer_user" value="${(userinfo.ufullname)!}" readonly/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">故障类型</label>
				<div class="col-sm-4">
						<#list typeList as type>
						    <label class="checkbox inline">
						    <input type="checkbox" id="inlineCheckbox1" name="types" value="${(type.id)!}"
							    <#list usertype as t>
							    	<#if t.id=type.id>
							    	 checked
							    	</#if>
							    </#list>
						    
						    > ${(type.name)!}
						    </label>
					    </#list>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button value="提交" type="submit" class="btn btn-primary save" data-loading-text="正在提交...">提交</button>
				</div>
			</div>
		</div>
		
		
	</form>
	
</div>
</@layout>