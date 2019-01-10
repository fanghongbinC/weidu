package com.baopinghui.bin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_article",schema="")
@SuppressWarnings("serial")
public class ArticleEntity implements java.io.Serializable {
	/** 作品id*/
	private int id;
	/** 作品图片 */
	private String article_url;
	/** 作品描述*/
	private String article_desc;
	/** 关联学员*/
	private int student_id;
	/** 创作时间*/	
	private Date create_date;
	/**花絮图片*/
	private String huaxu_url;
	/**可修改时间*/
	private String create_date_c;
	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "article_url", nullable = true)
	public String getArticle_url() {
		return article_url;
	}
	
	public void setArticle_url(String article_url) {
		this.article_url = article_url;
	}
	@Column(name = "article_desc", nullable = true)
	public String getArticle_desc() {
		return article_desc;
	}
	public void setArticle_desc(String article_desc) {
		this.article_desc = article_desc;
	}
	@Column(name = "student_id", nullable = false)
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	@Column(name = "create_date", nullable = true)
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	@Column(name = "id", nullable = true)
	public String getHuaxu_url() {
		return huaxu_url;
	}
	public void setHuaxu_url(String huaxu_url) {
		this.huaxu_url = huaxu_url;
	}
	@Column(name = "create_date_c", nullable = true)
	public String getCreate_date_c() {
		return create_date_c;
	}
	public void setCreate_date_c(String create_date_c) {
		this.create_date_c = create_date_c;
	}
	

}
