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
@Table(name="donhang")
public class donhangEntity {
@Id
@Column(name="id", nullable = false)
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
 @Column(name="idkhachhang" ,nullable=false)
 private int idkhachhang;
 @Column(name="thanhtien", nullable=false)
 private int thanhtien;
 @Column(name="timedathang", nullable=false)
 @Temporal(TemporalType.TIMESTAMP)
 private Date timedathang;
 @Column(name="trangthai", nullable=false)
 private int trangthai;
 @Column(name="timenhanhang", nullable = true)
 @Temporal(TemporalType.TIMESTAMP)
 private Date timenhanhang;
public donhangEntity(int id, int idkhachhang,  int thanhtien, Date timedathang, int trangthai,
		Date timenhanhang) {
	
	this.id = id;
	this.idkhachhang = idkhachhang;

	this.thanhtien = thanhtien;
	this.timedathang = timedathang;
	this.trangthai = trangthai;
	this.timenhanhang = timenhanhang;
}
public donhangEntity() {

}
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

public int getThanhtien() {
	return thanhtien;
}
public void setThanhtien(int thanhtien) {
	this.thanhtien = thanhtien;
}
public Date getTimedathang() {
	return timedathang;
}
public void setTimedathang(Date timedathang) {
	this.timedathang = timedathang;
}
public int getTrangthai() {
	return trangthai;
}
public void setTrangthai(int trangthai) {
	this.trangthai = trangthai;
}
public Date getTimenhanhang() {
	return timenhanhang;
}
public void setTimenhanhang(Date timenhanhang) {
	this.timenhanhang = timenhanhang;
}
 
 

}
