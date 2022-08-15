package com.example.mybook.model;

import java.util.Date;

public class ChitietdonhangInfo {
	private int id;
	private int iddonhang;
	private String nguoimua;
	private int idsanpham;
	private String sanpham;
	private int soluong;
	private int gia;
	private String anh;
	private Date thoigian;
	private String trangthai;

	public ChitietdonhangInfo() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIddonhang() {
		return iddonhang;
	}
	public void setIddonhang(int iddonhang) {
		this.iddonhang = iddonhang;
	}
	public String getNguoimua() {
		return nguoimua;
	}
	public void setNguoimua(String nguoimua) {
		this.nguoimua = nguoimua;
	}
	public String getSanpham() {
		return sanpham;
	}
	public void setSanpham(String sanpham) {
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
	public String getTrangthai() {
		return trangthai;
	}
	
	
	public ChitietdonhangInfo(int id, int iddonhang, String nguoimua, int idsanpham, String sanpham, int soluong,
			int gia, String anh, Date thoigian, String trangthai) {
		
		this.id = id;
		this.iddonhang = iddonhang;
		this.nguoimua = nguoimua;
		this.idsanpham = idsanpham;
		this.sanpham = sanpham;
		this.soluong = soluong;
		this.gia = gia;
		this.anh = anh;
		this.thoigian = thoigian;
		this.trangthai = trangthai;
	}
	
	public ChitietdonhangInfo(int idsanpham, String sanpham, int soluong, int gia, String anh) {
		super();
		this.idsanpham = idsanpham;
		this.sanpham = sanpham;
		this.soluong = soluong;
		this.gia = gia;
		this.anh = anh;
	}
	public int getIdsanpham() {
		return idsanpham;
	}
	public void setIdsanpham(int idsanpham) {
		this.idsanpham = idsanpham;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public void setTrangthai(int trangthaix) {
		if(trangthaix==0) {
		this.trangthai ="Chưa Giao";
		}
		if(trangthaix==1) {
			this.trangthai="Đã Nhận Hàng";
		}
	}
	
	@Override
	public String toString() {
		
		return "cartitem[idsanpham="+idsanpham+", sanpham="+sanpham+", soluong"+soluong+", gia="+gia+", anh="+anh+"]";
	}
	
}
