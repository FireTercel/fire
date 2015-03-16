<fieldset class="solid" >
	
	<div class="tree">
	
	<div class="page-header">
		<h3>故障描述</h3>
	</div>
	
	<div>
		<label>故障类型</label><br>
		<select id="selectType" name="selectType" disabled>
			<option value="-1" >请选择</option>
		<#list typeList as type>
			<option value="${type.id}"  <#if order.typeid=type.id>selected="selected"</#if> >${type.name}</option>
		</#list>
	
		</select>
	</div>

	<div>
		<label>申报人</label><br>
		<input type="text" name="offer_user" value="${(order.offername)!}" readonly/>
	</div>
	<div>
		<label>联系电话</label><br>
		<input type="text" name="offer_phone" value="${(order.offerphone)!}" readonly />
	</div>
		<div>
		<label>所属单位</label><br>
		<input type="text" name="offer_branch" value="${(offer_branch)!}" readonly />
	</div>
	<div>
		<label>申报时间</label><br>
		<input type="text" name="offer_time" value="${(order.offertime)!}" readonly />
	</div>
	<div>
		<label>故障描述</label><br>
		<textarea name="description"  cols="80" rows="7" readonly>${(order.description)!}</textarea>
	</div>
	
	<div class="page-header">
		<h3>处理意见</h3>
	</div>
	
		<div>
		<label>处理人</label><br>
		<input type="text" name="deal_user" value="${(order.dealname)!}" readonly />
	</div>
	<div>
		<label>联系电话</label><br>
		<input type="text" name="phone" value="${(order.dealphone)!}" readonly>
	</div>
	<div>
		<label>所属单位</label><br>
		<input type="text" name="offer_branch" value="${(deal_branch)!}" readonly>
	</div>
		<div>
		<label>处理时间</label><br>
		<input type="text" name="deal_time" value="${(order.dealtime)!}" readonly>
	</div>
	<div>
		<label>处理意见</label><br>
		<textarea name="commen"  cols="80" rows="7"  readonly >${(order.commen)!}</textarea>${descriptionMsg!}
	</div>
	
	</div>

</fieldset>