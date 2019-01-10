package com.baopinghui.bin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_kecheng", schema = "")
@SuppressWarnings("serial")
public class CourseEntity implements java.io.Serializable {
	/** 主键 课程id*/
	private int id;
	/** 课程名 */
	private String course_name;
	/** 课程描述*/
	private String course_desc;
	/** 课程封面图*/
	private String course_url;
	/** 花絮图片*/	
	private String huaxu_url;
	/**课程店面*/
	private int dianmian_id;
	/**课程时间段*/
	private String course_date;
	/**年龄范围*/
	private String year;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "course_name", nullable = true)
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	@Column(name = "course_desc", nullable = false)
	public String getCourse_desc() {
		return course_desc;
	}
	
	public void setCourse_desc(String course_desc) {
		this.course_desc = course_desc;
	}
	@Column(name = "course_url", nullable = false)
	public String getCourse_url() {
		return course_url;
	}
	public void setCourse_url(String course_url) {
		this.course_url = course_url;
	}
	@Column(name = "huaxu_url", nullable = false)
	public String getHuaxu_url() {
		return huaxu_url;
	}
	
	public void setHuaxu_url(String huaxu_url) {
		this.huaxu_url = huaxu_url;
	}
	@Column(name = "dianmian_id", nullable = true)
	public int getDianmian_id() {
		return dianmian_id;
	}
	public void setDianmian_id(int dianmian_id) {
		this.dianmian_id = dianmian_id;
	}
	@Column(name = "course_date")
	public String getCourse_date() {
		return course_date;
	}
	public void setCourse_date(String course_date) {
		this.course_date = course_date;
	}
	@Column(name = "year")
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

}
