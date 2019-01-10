package com.baopinghui.bin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_student",schema="")
@SuppressWarnings("serial")
public class StudentEntity {

	/** 主键 学生id*/
	private int id;
	/** 学生名称 */
	private String student_name;
	/** 联系方式*/
	private String phone;
	/** 备注*/
	private String s_desc;
	@Column(name="id",nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="student_name",nullable=false)
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	@Column(name="phone",nullable=true)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="s_desc",nullable=true)
	public String getS_desc() {
		return s_desc;
	}
	public void setS_desc(String s_desc) {
		this.s_desc = s_desc;
	}
	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", student_name=" + student_name + ", phone=" + phone + ", s_desc=" + s_desc
				+ "]";
	}
	


}
