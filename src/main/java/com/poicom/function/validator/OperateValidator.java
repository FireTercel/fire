package com.poicom.function.validator;

import org.apache.commons.lang3.ArrayUtils;

import cn.dreampie.ValidateKit;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import com.poicom.function.model.Order;

public class OperateValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		if(getActionKey().equals("/operate/update")){
			Order order=Order.dao.findById(c.getParaToInt("oorderid"));//查询将要处理工单的信息。
			if(!ValidateKit.isNullOrEmpty(order.get("deleted_at"))){
				addError("state","失败：工单已撤销，无法提交！");
			}
			else if(!ValidateKit.isDateTime(c.getPara("comment.add_at"))){
				addError("state","请选择处理时间！");
			}else if(c.getParaToInt("progress")==-1){
				addError("state","请选择处理进度！");
			}else if(!valiProcess(c.getParaToInt("progress"))){
				
				addError("state","处理进度参数错误！");//防止人为修改参数。
			}
			else if(ValidateKit.isNullOrEmpty(c.getPara("comment.context"))){
				addError("state","处理意见不能为空！");
			}
		}

	}

	@Override
	protected void handleError(Controller c) {
		if(getActionKey().equals("/operate/update")){
			c.renderJson("state", c.getAttr("state"));
		}

	}
	
	/**
	 * 判断处理情况参数是否有异常
	 * @param process
	 * @return
	 */
	public static boolean valiProcess(int process){
		int[] paras={-1,0,1,2,3};
		return ArrayUtils.contains(paras, process);
	}

}
