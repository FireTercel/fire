package com.poicom.function.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.dreampie.ValidateKit;
import cn.dreampie.routebind.ControllerKey;
import cn.dreampie.shiro.core.ShiroKit;
import cn.dreampie.shiro.core.SubjectKit;
import cn.dreampie.shiro.hasher.Hasher;
import cn.dreampie.shiro.hasher.HasherInfo;
import cn.dreampie.shiro.hasher.HasherKit;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.poicom.function.system.model.User;
import com.poicom.function.system.model.UserInfo;

@ControllerKey(value="/user",path="/page/app/user")
public class UserController extends Controller {
	
	protected Logger logger=LoggerFactory.getLogger(UserController.class);
	
	private final static String CENTER_PAGE="center.html";
	private final static String PWD_PAGE="pwd.html";
	
	public void index(){
		redirect("/user/center");
	}
	
	/**
	 * 进入修改用户密码页面
	 */
	public void center(){
		User user=SubjectKit.getUser();
		if(!ValidateKit.isNullOrEmpty(user)){
			setAttr("userInfo",UserInfo.dao.getAllUserInfo(user.get("id")));
			setSessionAttr("current_user", user);
		}
		render(CENTER_PAGE);
		
	}
	
	
	/**
	 * 
	 */
	public void pwdPage(){
		User user=SubjectKit.getUser();
		if(!ValidateKit.isNullOrEmpty(user)){
			setAttr("user", user);
		}
		render(PWD_PAGE);
	}
	
	/**
	 * 修改用户密码
	 */
	@Before({UserValidator.class,Tx.class})
	public void updatePwd(){
		keepModel(User.class);
		User upUser=getModel(User.class);
		User user=SubjectKit.getUser();
		upUser.set("id", user.get("id"));
		HasherInfo passwordInfo=HasherKit.hash(upUser.getStr("password"),Hasher.DEFAULT);
		upUser.set("password", passwordInfo.getHashResult());
		upUser.set("hasher", passwordInfo.getHasher().value());
		upUser.set("salt", passwordInfo.getSalt());
		
		if (upUser.update()) {
			SubjectKit.getSubject().logout();
			setAttr("state", "success");
			redirect("/tosignin");
			return;
		}else {
			setAttr("state", "falure");
			render("/page/app/user/center.html");
		}
		
	}
	
	/**
	 * 测试权限管理
	 */
	public void addPermission(){
		//User user=SubjectKit.getUser();
		
		//要先插入到sec_permission中，在执行下面的代码
		ShiroKit.addJdbcAuthz("/test/1", "P_TEST_1");
		//删除权限
		ShiroKit.removeJdbcAuthz("/test/1");
		//如果是修改权限，则先删除，然后修改。
	}
	
	

}
