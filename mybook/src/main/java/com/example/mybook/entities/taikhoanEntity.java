package com.example.mybook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taikhoan")
public class taikhoanEntity {
@Id
@Column(name="id", nullable =false)
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(name ="tendangnhap", nullable =false)
private String tendangnhap;
@Column(name ="matkhau", nullable=false)
private String matkhau;
@Column(name="hovaten", nullable = false)
private String hovaten;
@Column(name="sdt", nullable=false)
private int sdt;
@Column(name ="email", nullable =false)
private String email;
@Column(name="diachi", nullable=false)
private String diachi;
@Column(name="phanquyen")
private String phanquyen;
@Column(name="avatar")
private String avatar;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTendangnhap() {
	return tendangnhap;
}
public void setTendangnhap(String tendangnhap) {
	this.tendangnhap = tendangnhap;
}
public String getMatkhau() {
	return matkhau;
}
public void setMatkhau(String matkhau) {
	this.matkhau = matkhau;
}
public String getHovaten() {
	return hovaten;
}
public void setHovaten(String hovaten) {
	this.hovaten = hovaten;
}
public int getSdt() {
	return sdt;
}
public void setSdt(int sdt) {
	this.sdt = sdt;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getDiachi() {
	return diachi;
}
public void setDiachi(String diachi) {
	this.diachi = diachi;
}
public String getPhanquyen() {
	return phanquyen;
}
public void setPhanquyen(String phanquyen) {
	this.phanquyen = phanquyen;
}
public String getAvatar() {
	return avatar;
}
public void setAvatar(String avatar) {
	this.avatar = avatar;
}

public  taikhoanEntity() {
	
}
public taikhoanEntity(String tendangnhap, String matkhau, String hovaten, int sdt, String email, String diachi,
		String phanquyen, String avatar) {
	this.tendangnhap = tendangnhap;
	this.matkhau = matkhau;
	this.hovaten = hovaten;
	this.sdt = sdt;
	this.email = email;
	this.diachi = diachi;
	this.phanquyen = phanquyen;
	this.avatar = avatar;
}
public taikhoanEntity(int id, String tendangnhap, String matkhau, String hovaten, int sdt, String email, String diachi,
		String phanquyen, String avatar) {
	
	this.id = id;
	this.tendangnhap = tendangnhap;
	this.matkhau = matkhau;
	this.hovaten = hovaten;
	this.sdt = sdt;
	this.email = email;
	this.diachi = diachi;
	this.phanquyen = phanquyen;
	this.avatar = avatar;
}
public taikhoanEntity(int id, String tendangnhap, String matkhau, String hovaten, int sdt, String email, String diachi,
		String phanquyen) {
	this.id = id;
	this.tendangnhap = tendangnhap;
	this.matkhau = matkhau;
	this.hovaten = hovaten;
	this.sdt = sdt;
	this.email = email;
	this.diachi = diachi;
	this.phanquyen = phanquyen;
}

}
