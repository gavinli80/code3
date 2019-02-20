package com.zs.pms.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zs.pms.utils.DateUtil;

/**
 * 用户表的PO
 * 
 * @author Administrator
 *
 */
public class TUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5293214558214995122L;

	private int id;
	private String loginname;
	private String realname;
	private String sex;
	private Date birthday;

	private TDep dept; // 关联对象 一对一

	private String email;
	private int isenabled;
	private String password;
	private int creator;
	private Date createtime;
	private int updator;
	private Date updatetime;
	private String picurl;

	private String isenabledTxt;
	private String birthdayTxt;

	public String getIsenabledTxt() {
		if (isenabled == 1) {
			return "可用";
		}

		else {
			return "不可用";
		}

	}

	public String getBirthdayTxt() {
		return DateUtil.getStrDate(birthday);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public TDep getDept() {
		return dept;
	}

	public void setDept(TDep dept) {
		this.dept = dept;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIsenabled() {
		return isenabled;
	}

	public void setIsenabled(int isenabled) {
		this.isenabled = isenabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCreator() {
		return creator;
	}

	public void setCreator(int creator) {
		this.creator = creator;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getUpdator() {
		return updator;
	}

	public void setUpdator(int updator) {
		this.updator = updator;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

}
