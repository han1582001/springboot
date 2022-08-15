package com.example.mybook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "theloai")
public class theloaiEntity {
@Id
@Column(name="id", nullable = false)
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(name="tentheloai", nullable = false)
private String tentheloai;
@Column(name="mota", nullable=false)
private String mota;
@Column(name="anh", nullable = true)
private String anh;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTentheloai() {
	return tentheloai;
}
public void setTentheloai(String tentheloai) {
	this.tentheloai = tentheloai;
}
public String getMota() {
	return mota;
}
public void setMota(String mota) {
	this.mota = mota;
}
public String getAnh() {
	return anh;
}
public void setAnh(String anh) {
	this.anh = anh;
}
public theloaiEntity(int id, String tentheloai, String mota, String anh) {
	
	this.id = id;
	this.tentheloai = tentheloai;
	this.mota = mota;
	this.anh = anh;
}
public theloaiEntity(String tentheloai, String mota) {
	
	this.tentheloai = tentheloai;
	this.mota = mota;
}
public theloaiEntity(int id, String tentheloai, String mota) {
	
	this.id = id;
	this.tentheloai = tentheloai;
	this.mota = mota;
}
public theloaiEntity() {

}

}
