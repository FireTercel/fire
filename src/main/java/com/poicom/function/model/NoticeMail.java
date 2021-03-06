package com.poicom.function.model;

import com.jfinal.plugin.activerecord.Page;

import cn.dreampie.tablebind.TableBind;

@TableBind(tableName="com_notice_email")
public class NoticeMail extends BaseModel<NoticeMail> {
	
	private static final long serialVersionUID = -1681227459242627679L;
	public final static NoticeMail dao =new NoticeMail();
	
	public Page<NoticeMail> page(int pageNumber,int pageSize,String where,Object... paras){
		return paginateBy(pageNumber, pageSize, where, paras);
	}

}
