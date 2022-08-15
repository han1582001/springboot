package com.example.mybook.model;

import java.util.Date;

public class DonHangInfo {
private int id;
private String tenkhachhang;


private int thanhtien;
private Date timedathang;
private int trangthai;
private Date timenhanhang;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTenkhachhang() {
	return tenkhachhang;
}
public void setTenkhachhang(String tenkhachhang) {
	this.tenkhachhang = tenkhachhang;
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
public DonHangInfo(int id, String tenkhachhang,  int thanhtien, Date timedathang,
		int trangthai, Date timenhanhang) {

	this.id = id;
	this.tenkhachhang = tenkhachhang;

	this.thanhtien = thanhtien;
	this.timedathang = timedathang;
	this.trangthai = trangthai;
	this.timenhanhang = timenhanhang;
}
public DonHangInfo() {
	
}


}
