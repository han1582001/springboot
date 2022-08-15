package com.example.mybook.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.mybook.Responsitory.TaikhoanResponsitory;
import com.example.mybook.entities.taikhoanEntity;


import com.example.mybook.model.TaiKhoanHienTai;

@Service
public class CustomUserDetailService implements UserDetailsService{
	@Autowired
	TaikhoanResponsitory tkres;
	
	
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	// TODO Auto-generated method stub
	
	List<taikhoanEntity> listTaiKhoan=tkres.getPrin(username);
	if(listTaiKhoan.size()>0) {
		taikhoanEntity taikhoan=listTaiKhoan.get(0);
		List<GrantedAuthority> grantList=new ArrayList<GrantedAuthority>();
		grantList.add(new SimpleGrantedAuthority(taikhoan.getPhanquyen()));
		
	
		TaiKhoanHienTai userDetails=new TaiKhoanHienTai(taikhoan.getTendangnhap(), taikhoan.getMatkhau(),grantList);
		userDetails.setTaikhoan(taikhoan);
	return userDetails;
	
	}else {
		new UsernameNotFoundException("Sai Tên Đăng Nhập Hoặc Mật Khẩu");
	}
	return null;
}
}
