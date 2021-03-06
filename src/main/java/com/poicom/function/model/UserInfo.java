package com.poicom.function.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.poicom.basic.plugin.sqlxml.SqlXmlKit;

import cn.dreampie.tablebind.TableBind;

/**
 * 用户信息表
 * @author DONGYU
 *
 */
@TableBind(tableName = "sec_user_info")
public class UserInfo extends BaseModel<UserInfo> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3424907544751263092L;
	public static UserInfo dao=new UserInfo();
	
	/**
	 * 根据用户id，获得该用户的所有信息
	 * @param paras
	 * @return
	 */
	public Record getAllUserInfo(Object... paras){
		return Db.findFirst(SqlXmlKit.sql("user.findInfoBySelect") + blank
				+ SqlXmlKit.sql("user.findInfoByFrom"), paras);
	}
	
	/**
	 * 根据用户id，获得该用户的分公司信息
	 * @param paras
	 * @return
	 */
	public Record getUserBranch(Object... paras){
		return Db.findFirst(SqlXmlKit.sql("user.findUserBranchBySelect") + blank
				+ SqlXmlKit.sql("user.findUserBranchByFrom"), paras);
	}
	
	/**
	 * @描述 根据用户Branch_id，查找该部门用户详细信息 Page
	 * @param pageNumber
	 * @param pageSize
	 * @param paras
	 * @return
	 */
	public Page<Record> getUserByBranch(int pageNumber,int pageSize,String where,Object... paras){
		return Db.paginate(pageNumber, pageSize,
				SqlXmlKit.sql("user.findBranchUserBySelect") + blank,
				SqlXmlKit.sql("user.findBranchUserByFrom")+getWhere(where),paras);
	}
	
	/**
	 * @描述 根据用户apartment_id，查找该部门用户详细信息 List
	 * @param where
	 * @param paras
	 * @return
	 */
	public List<Record> getUserByApartment(String where,Object... paras){
		return Db.find(SqlXmlKit.sql("user.findBranchUserBySelect") +
				SqlXmlKit.sql("user.findBranchUserByFrom")+getWhere(where),paras);
	}
	
	@SuppressWarnings("unchecked")
	public UserInfo get(String attr,Object paras){
		return findFirst("select * from sec_user_info where " + attr + " =? ", paras);
	}
	
}
