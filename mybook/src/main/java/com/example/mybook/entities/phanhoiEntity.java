package com.example.mybook.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="phanhoi")
public class phanhoiEntity {
@Id
@Column(name="id", nullable = false )
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;	
@Column(name="idkhachhang", nullable = false)
private int idkhachhang;
@Column(name="tenkhachhang", nullable=false)
private String tenkhachhang;
@Column(name="noidung", nullable=false)
private String noidung;
@Column(name="time", nullable=false)
@Temporal(TemporalType.TIMESTAMP)
private Date time;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getIdkhachhang() {
	return idkhachhang;
}
public void setIdkhachhang(int idkhachhang) {
	this.idkhachhang = idkhachhang;
}
public String getNoidung() {
	return noidung;
}
public void setNoidung(String noidung) {
	this.noidung = noidung;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}
public String getTenkhachhang() {
	return tenkhachhang;
}
public void setTenkhachhang(String tenkhachhang) {
	this.tenkhachhang = tenkhachhang;
}



}
