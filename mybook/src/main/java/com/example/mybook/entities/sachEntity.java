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
@Table(name = "sach")
public class sachEntity {
@Id
@Column(name="id", nullable = false)
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name="tensach", nullable = false)
private String tensach;

@Column(name="tacgia", nullable = false)
private int tacgia;
 @Column(name="nxb", nullable=false)
 private String nxb;
 @Column(name="theloai", nullable = false)
 private int theloai;
 @Column(name="gia", nullable=false)
 private int gia;
 @Column(name="noidung", nullable = false)
 private String noidung;
 @Column(name="soluong", nullable = false)
 private int soluong;
 @Column(name="nguoidang", nullable = false)
 private int nguoidang;
 @Column(name="thoigiandang", nullable=false)
 @Temporal(TemporalType.TIMESTAMP)
 private Date thoigiandang;
 @Column(name="anh", nullable = false)
 private String anh;
public sachEntity(int id, String tensach, int tacgia, String nxb, int theloai, int gia, String noidung, int soluong,
		int nguoidang, Date thoigiandang, String anh) {
	
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
public sachEntity(String tensach, int tacgia, String nxb, int theloai, int gia, String noidung, int soluong,
		int nguoidang, Date thoigiandang, String anh) {

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
public sachEntity(int id, String tensach, int tacgia, String nxb, int theloai, int gia, String noidung, int soluong,
		int nguoidang, Date thoigiandang) {
	
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
}
public sachEntity(String tensach, int tacgia, String nxb, int theloai, int gia, String noidung, int soluong,
		int nguoidang, Date thoigiandang) {

	this.tensach = tensach;
	this.tacgia = tacgia;
	this.nxb = nxb;
	this.theloai = theloai;
	this.gia = gia;
	this.noidung = noidung;
	this.soluong = soluong;
	this.nguoidang = nguoidang;
	this.thoigiandang = thoigiandang;
}
public sachEntity() {
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
public int getTacgia() {
	return tacgia;
}
public void setTacgia(int tacgia) {
	this.tacgia = tacgia;
}
public String getNxb() {
	return nxb;
}
public void setNxb(String nxb) {
	this.nxb = nxb;
}
public int getTheloai() {
	return theloai;
}
public void setTheloai(int theloai) {
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
public int getNguoidang() {
	return nguoidang;
}
public void setNguoidang(int nguoidang) {
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
