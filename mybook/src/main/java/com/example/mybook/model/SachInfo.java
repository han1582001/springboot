package com.example.mybook.model;

import java.util.Date;

public class SachInfo {
private int id;
private String tensach;
private String tacgia;
private String nxb;
private String theloai;
private int gia;
private String noidung;
private int soluong;
private String nguoidang;
private Date thoigiandang;
private String anh;
public SachInfo(String tensach, String tacgia, String nxb, String theloai, int gia, String noidung, int soluong,
		String nguoidang, Date thoigiandang, String anh) {
	
	this.tensach = tensach;
	this.tacgia = tacgia;
	this.nxb = nxb;
	this.theloai = theloai;
	this.gia = gia;
	this.noidung = noidung;
	this.soluong = soluong;
	this.nguoidang = nguoidang;
	this.thoigiandang = thoigiandang;
	this.anh = anh;
}
public SachInfo(int id, String tensach, String tacgia, String nxb, String theloai, int gia, String noidung, int soluong,
		String nguoidang, Date thoigiandang, String anh) {
	
	this.id = id;
	this.tensach = tensach;
	this.tacgia = tacgia;
	this.nxb = nxb;
	this.theloai = theloai;
	this.gia = gia;
	this.noidung = noidung;
	this.soluong = soluong;
	this.nguoidang = nguoidang;
	this.thoigiandang = thoigiandang;
	this.anh = anh;
}
public SachInfo() {
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTensach() {
	return tensach;
}
public void setTensach(String tensach) {
	this.tensach = tensach;
}
public String getTacgia() {
	return tacgia;
}
public void setTacgia(String tacgia) {
	this.tacgia = tacgia;
}
public String getNxb() {
	return nxb;
}
public void setNxb(String nxb) {
	this.nxb = nxb;
}
public String getTheloai() {
	return theloai;
}
public void setTheloai(String theloai) {
	this.theloai = theloai;
}
public int getGia() {
	return gia;
}
public void setGia(int gia) {
	this.gia = gia;
}
public String getNoidung() {
	return noidung;
}
public void setNoidung(String noidung) {
	this.noidung = noidung;
}
public int getSoluong() {
	return soluong;
}
public void setSoluong(int soluong) {
	this.soluong = soluong;
}
public String getNguoidang() {
	return nguoidang;
}
public void setNguoidang(String nguoidang) {
	this.nguoidang = nguoidang;
}
public Date getThoigiandang() {
	return thoigiandang;
}
public void setThoigiandang(Date thoigiandang) {
	this.thoigiandang = thoigiandang;
}
public String getAnh() {
	return anh;
}
public void setAnh(String anh) {
	this.anh = anh;
}

}
