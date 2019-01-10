package com.baopinghui.bin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_dianmian", schema = "")
@SuppressWarnings("serial")
public class DianMianEntity implements java.io.Serializable{
	/** 主键 */
	private int id;
	/** 店面名字 */
	private String dmname;
	/** 地址*/
	private String address;
	/** 电话*/
	private String phone;
	/** 备注*/	
	private String dmdesc;
	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="dm_name",nullable=false)
	public String getDmname() {
		return dmname;
	}
	public void setDmname(String dmname) {
		this.dmname = dmname;
	}
	@Column(name="address",nullable=true)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="phone",nullable=true)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="desc",nullable=true)
	public String getDmdesc() {
		return dmdesc;
	}
	public void setDmdesc(String dmdesc) {
		this.dmdesc = dmdesc;
	}
	@Override
	public String toString() {
		return "店面:"+dmname+"地址:"+address+"手机:"+phone+"描述:"+dmdesc;
	}
	
	

}
