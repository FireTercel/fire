package com.poicom.function.app.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

import cn.dreampie.sqlinxml.SqlKit;
import cn.dreampie.tablebind.TableBind;
import cn.dreampie.web.model.Model;

@TableBind(tableName = "com_order")
public class Order extends Model<Order> {

	public static Order dao = new Order();

	/**
	 * 根据报障人员id，查询其申报的故障工单
	 * @param pageNumber
	 * @param pageSize
	 * @param paras
	 * @return
	 */
	public Page<Record> getReportOrderPage(int pageNumber, int pageSize,
			Object... paras) {
		return Db.paginate(pageNumber, pageSize,
				SqlKit.sql("order.findReportFullOffersBySelect") + blank,
				SqlKit.sql("order.findReportFullOffersByFrom"), paras);
	}
	
	/**
	 * 根据故障工单id，查询该工单的详细信息（报障人员、运维人员查询）
	 * @param paras
	 * @return
	 */
	public Record getCommonOrder(Object... paras){
		return Db.findFirst(SqlKit.sql("order.findReportOfferBySelect") + blank
				+ SqlKit.sql("order.findReportOfferByFrom"), paras);
	}
	
	/**
	 * @描述 根据故障描述，查询相应的故障类型
	 * @param pageNumber
	 * @param pageSize
	 * @param paras
	 * @return
	 */
	public Page<Record> getOverOrdersPage(int pageNumber, int pageSize,String where,
			Object... paras) {
		
		return Db.paginate(pageNumber, pageSize,
				SqlKit.sql("order.findReportOfferBySelect") + blank,
				SqlKit.sql("order.findOverOrderByFrom")+blank+where, paras);
	}
	
	/**
	 * 获得所有故障类型（通用）
	 * @return
	 */
	public List<Record> getAllType(){
		return Db.find("select * from com_type");
	}
	
	/**
	 * 根据运维人员id，查询其处理范围的故障工单
	 * @param pageNumber
	 * @param pageSize
	 * @param paras
	 * @return
	 */
	public Page<Record> getOperateOrderPage(int pageNumber,int pageSize,Object... paras){
		return Db.paginate(pageNumber, pageSize,
				SqlKit.sql("order.findOperateFullBySelect") + blank,
				SqlKit.sql("order.findOperateFullByFrom"), paras);
	}
	
	

}
