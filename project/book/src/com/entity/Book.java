package com.entity;

import java.io.Serializable;

public class Book implements Serializable {
	private Long id;// id
	private String name;// 书名
	private String author;// 作者
	private String time;// 时间
	private String type;// 类型
	public Book() {

	}
	public Book(Long id, String name, String author, String time, String type) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.time = time;
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "book [id=" + id + ", name=" + name + ", author=" + author + ", time=" + time + ", type=" + type + "]";
	}
}
