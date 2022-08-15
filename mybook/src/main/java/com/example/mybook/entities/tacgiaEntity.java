package com.example.mybook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tacgia")
public class tacgiaEntity {
@Id
@Column(name="id", nullable = false)
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(name="tentacgia", nullable = false)
private String tentacgia;
@Column(name="mota", nullable = false)
private String mota;
@Column(name="anh")
private String anh;
public tacgiaEntity(int id, String tentacgia, String mota, String anh) {
	
	this.id = id;
	this.tentacgia = tentacgia;
	this.mota = mota;
	this.anh = anh;
}
public tacgiaEntity(String tentacgia, String mota, String anh) {
	
	this.tentacgia = tentacgia;
	this.mota = mota;
	this.anh = anh;
}
public tacgiaEntity(String tentacgia, String mota) {
	
	this.tentacgia = tentacgia;
	this.mota = mota;
}
public tacgiaEntity() {

}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTentacgia() {
	return tentacgia;
}
public void setTentacgia(String tentacgia) {
	this.tentacgia = tentacgia;
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

}
