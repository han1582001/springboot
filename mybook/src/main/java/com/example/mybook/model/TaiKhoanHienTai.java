package com.example.mybook.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.example.mybook.entities.taikhoanEntity;

public class TaiKhoanHienTai extends User{

	
	
	
	 public TaiKhoanHienTai(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}
	 public TaiKhoanHienTai(String username, String password, boolean enabled, boolean accountNonExpired,
				boolean credentialsNonExpired, boolean accountNonLocked,
				Collection<? extends GrantedAuthority> authorities) {
			super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
			// TODO Auto-generated constructor stub
		}
	private taikhoanEntity taikhoan;
	
	
	public taikhoanEntity getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(taikhoanEntity taikhoan) {
		this.taikhoan = taikhoan;
	}
	


}
