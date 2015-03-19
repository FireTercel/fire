package com.poicom.function.user.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import cn.dreampie.sqlinxml.SqlKit;
import cn.dreampie.tablebind.TableBind;
import cn.dreampie.web.model.Model;

/**
 * 用户信息表
 * @author DONGYU
 *
 */
@TableBind(tableName = "sec_user_info")
public class UserInfo extends Model<UserInfo> {
	
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
		return Db.findFirst(SqlKit.sql("user.findInfoBySelect") + blank
				+ SqlKit.sql("user.findInfoByFrom"), paras);
	}
	
	/**
	 * 根据用户id，获得该用户的分公司信息
	 * @param paras
	 * @return
	 */
	public Record getUserBranch(Object... paras){
		return Db.findFirst(SqlKit.sql("user.findUserBranchBySelect") + blank
				+ SqlKit.sql("user.findUserBranchByFrom"), paras);
	}
	
}