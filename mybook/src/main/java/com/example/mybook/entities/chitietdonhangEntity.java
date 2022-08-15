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
@Table(name="chitietdonhang")
public class chitietdonhangEntity {
@Id
@Column(name="id", nullable = false)
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(name="iddonhang", nullable = false)
private int iddonghang;
@Column(name="nguoimua", nullable=false)
private int nguoimua;
@Column(name="sanpham", nullable=false)
private int sanpham;
@Column(name="soluong", nullable = false)
private int soluong;
@Column(name="gia", nullable=false)
private int gia;
@Column(name="thoigian", nullable=false)
@Temporal(TemporalType.TIMESTAMP)
private Date thoigian;
@Column(name="trangthai", nullable=false)
private int trangthai;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getIddonghang() {
	return iddonghang;
}
public void setIddonghang(int iddonghang) {
	this.iddonghang = iddonghang;
}
public int getNguoimua() {
	return nguoimua;
}
public void setNguoimua(int nguoimua) {
	this.nguoimua = nguoimua;
}
public int getSanpham() {
	return sanpham;
}
public void setSanpham(int sanpham) {
	this.sanpham = sanpham;
}
public int getSoluong() {
	return soluong;
}
public void setSoluong(int soluong) {
	this.soluong = soluong;
}
public int getGia() {
	return gia;
}
public void setGia(int gia) {
	this.gia = gia;
}
public Date getThoigian() {
	return thoigian;
}
public void setThoigian(Date thoigian) {
	this.thoigian = thoigian;
}
public int getTrangthai() {
	return trangthai;
}
public void setTrangthai(int trangthai) {
	this.trangthai = trangthai;
}
public chitietdonhangEntity(int id, int iddonghang, int nguoimua, int sanpham, int soluong, int gia, Date thoigian,
		int trangthai) {
	
	this.id = id;
	this.iddonghang = iddonghang;
	this.nguoimua = nguoimua;
	this.sanpham = sanpham;
	this.soluong = soluong;
	this.gia = gia;
	this.thoigian = thoigian;
	this.trangthai = trangthai;
}
public chitietdonhangEntity() {

}
public chitietdonhangEntity(int sanpham, int soluong, int gia) {

	this.sanpham = sanpham;
	this.soluong = soluong;
	this.gia = gia;
}


}
