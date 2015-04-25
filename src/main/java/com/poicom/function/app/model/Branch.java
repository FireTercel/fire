package com.poicom.function.app.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;

import cn.dreampie.tablebind.TableBind;
import cn.dreampie.web.model.Model;

@TableBind(tableName="com_branch")
public class Branch extends Model<Branch>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5240642720729773525L;
	public static Branch dao=new Branch();
	
	public List<Branch> getAllBranch(){
		return find("select * from com_branch where deleted_at is null");
	}
	
	public Page<Branch> findBranchPage(int pageNumber, int pageSize,String where,String orderby,
			Object... paras){
		return paginateBy(pageNumber, pageSize, where+orderby, paras);
	}
	

}
