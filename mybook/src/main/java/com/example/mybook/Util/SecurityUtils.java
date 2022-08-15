package com.example.mybook.Util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.example.mybook.model.TaiKhoanHienTai;

public class SecurityUtils {
public static TaiKhoanHienTai getPrincipal() {
	return (TaiKhoanHienTai) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
}
}
