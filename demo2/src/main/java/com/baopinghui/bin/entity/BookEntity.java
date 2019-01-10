package com.baopinghui.bin.entity;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_book",schema="")
@SuppressWarnings("serial")
	public class BookEntity implements java.io.Serializable{
	
	/** 主键 id*/
	private int id;
	/** 预约名字 */
	private String username;
	/** 选的课程*/
	private String course;
	/** 选的活动*/
	private String active;
	/** 联系电话*/	
	private String phone;
	/**选的店面*/
	private String dianmian;
	/**时间*/
	private Date create_date;
	/**操作*/
	private int statu;
	
	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "username", nullable = false)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "course", nullable = true)
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Column(name = "active", nullable = true)
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Column(name = "phone", nullable = false)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name = "dianmian", nullable = false)
	public String getDianmian() {
		return dianmian;
	}
	public void setDianmian(String dianmian) {
		this.dianmian = dianmian;
	}
	@Column(name = "create_date", nullable = false)
	public Date getdCreate_date() {
		return create_date;
	}
	public void setdCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	@Column(name = "statu", nullable = true)
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	
	
	}
