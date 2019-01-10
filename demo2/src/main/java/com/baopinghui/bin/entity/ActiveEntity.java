package com.baopinghui.bin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_active", schema = "")
@SuppressWarnings("serial")
public class ActiveEntity implements java.io.Serializable{
	
	/** 主键 活动id*/
	private int id;
	/** 活动名 */
	private String active_name;
	/** 活动描述*/
	private String active_desc;
	/** 活动地址*/
	private String address;
	/** 花絮图片*/	
	private String huaxu_url;
	/**活动封面图*/
	private String active_url;
	/**活动时间*/
	private String active_date;
	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "active_name", nullable = false)
	public String getActive_name() {
		return active_name;
	}
	public void setActive_name(String active_name) {
		this.active_name = active_name;
	}
	@Column(name = "active_desc", nullable = true)
	public String getActive_desc() {
		return active_desc;
	}
	public void setActive_desc(String active_desc) {
		this.active_desc = active_desc;
	}
	@Column(name = "address", nullable = false)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "huaxu_url", nullable = true)
	public String getHuaxu_url() {
		return huaxu_url;
	}
	public void setHuaxu_url(String huaxu_url) {
		this.huaxu_url = huaxu_url;
	}
	@Column(name = "active_url", nullable = true)
	public String getActive_url() {
		return active_url;
	}
	public void setActive_url(String active_url) {
		this.active_url = active_url;
	}
	@Column(name = "active_date", nullable = true)
	public String getActive_date() {
		return active_date;
	}
	public void setActive_date(String active_date) {
		this.active_date = active_date;
	}
    
}
