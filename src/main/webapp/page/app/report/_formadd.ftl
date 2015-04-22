<div class="page-header">
<ul class="nav nav-tabs">
   <li ><a href="${ContextPath}/report/reports">故障申报列表</a></li>
   <li class="active"><a href="#">故障申报</a></li>
</ul>
</div>
<div class="row">
	<div class="col-xs-2">
	</div>
	<div class="col-xs-8">

	<input type="hidden" name="uuserid" value="${(uuserid)!}">
	<input type="hidden" name="oorderid" value="${(oorderid)!}">
	<input type="hidden" name="otypeid" value="${(otypeid)!}">
	<input type="hidden" name="olevelid" value="${(olevelid)!}">
	
	<div class="form-group">
		<div >
			<h4><span class="label label-primary ">个人信息</span></h4>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">申报人员：</label>
		<div class="col-sm-2">
			<label class=" control-label"><span class="label label-info ">${(ufullname)!}</span></label>
		</div>
		<label class="col-sm-2 control-label">联系电话：</label>
		<div class="col-sm-2">
			<label class=" control-label"><span class="label label-info ">${(uphone)!}</span></label>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">单位：</label>
		<div class="col-sm-2">
			<label class=" control-label"><span class="label label-info ">${(bname)!}</span></label>
		</div>
		<label class="col-sm-2 control-label">部门：</label>
		<div class="col-sm-2">
			<label class=" control-label"><span class="label label-info ">${(aname)!}</span></label>
		</div>
		<label class="col-sm-2 control-label">职位：</label>
		<div class="col-sm-2">
			<label class=" control-label"><span class="label label-info ">${(pname)!}</span></label>
		</div>
	</div>
	<hr>
	<div class="form-group">
		<div >
			<h4><span class="label label-primary ">故障描述</span></h4>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" >标题：</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" placeholder="故障工单标题" maxlength="30" name="otitle" value="${(otitle)!}" autofocus required autocomplete="off"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" >故障类型：</label>
		<div class="col-sm-3">
			<select id="selectType" name="selectType" class="form-control" required >
			</select>
		</div>
		<label class="col-sm-2 control-label">运维人员：</label>
		<div class="col-sm-3">
			<select id="selectDeal" name="selectDeal" class="form-control" required>
			</select>
		</div>
	</div>
	
	<div class="form-group">
	<label class="col-sm-2 control-label">故障等级：</label>

		<div class="col-sm-8">
			<#if olevelid??>
				<#if olevelid="">
				<select id="selectLevel" name="selectLevel" class="form-control"  required autofocus>
				<#else>
				<select id="selectLevel" name="selectLevel" class="form-control" disabled required autofocus>
				</#if>
			<#else>
	
			<select id="selectLevel" name="selectLevel" class="form-control" required autofocus>
			
			</#if>
						<option value="" selected="selected">请选择故障等级</option>
				<#if olevelid??>
					<#list levelList as level>
						
						<option value="${level.id}"  
							<#if olevelid="">
							
							<#elseif ((olevelid!'-1')?number)=level.id>
								selected="selected"
							</#if> >
							${level.name}
						</option>
					</#list>
				<#else>
					<#list levelList as level>
						<option value="${level.id}">${level.name}</option>
					</#list>
				</#if>
			
			</select>
		</div>
	</div>
	

	<div class="form-group">
		<label class="col-sm-2 control-label">故障描述：</label>
		<div class="col-sm-8">
			<textarea id="area" name="odescription" class="form-control"
				placeholder="故障描述，不少于25字。"  maxlength="250" cols="80" rows="7"
				required>${(odescription)!}</textarea>
		</div>

	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label"></label>
		<div class="col-sm-8">
			<#if descriptionMsg??>
			<div class="alert alert-danger" role="alert">
  				${descriptionMsg!}
			</div>
				
			</#if>
		</div>
	</div>



	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button id="submit" value="提交" type="submit" class="btn btn-primary save" data-loading-text="正在提交...">提交</button>
		</div>
	</div>
	
	</div>
	<div class="col-xs-2">
	</div>
</div>
<script>
function select1() {
	$.ajax(
    {
    	type: "post",
    	url: "/report/handler",
    	data: { "type": "type" },
        success: function (msg) {
        	$("#selectType").append("<option value=''>请选择故障类型</option>");
        	for (var i = 0; i < msg.typeList.length; i++) {
            	$("#selectType").append("<option value=" + msg.typeList[i].id + ">" + msg.typeList[i].name + "</option>");
        	}
            select2();
        }
	})
};
function select2() {
	$("#selectDeal").html("");
	$.ajax(
	{
		type: "post",
		url: "/report/handler",
		data: { "type": "dealler","typeid":$('#selectType').val() },
		success: function (msg) {
			$("#selectDeal").append("<option value=''>请选择运维人员</option>");
			for (var i = 0; i < msg.dealList.length; i++) {
				$("#selectDeal").append("<option value=" + msg.dealList[i].userid + ">" + msg.dealList[i].fullname + "</option>");
			}
		}
	})
};


$(function(){
	select1();
	$('#selectType').bind("change", select2);
});
</script>

