package com.example.mybook.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.example.mybook.Responsitory.TaikhoanResponsitory;
import com.example.mybook.Util.SecurityUtils;
import com.example.mybook.Util.Util;
import com.example.mybook.entities.taikhoanEntity;


import com.example.mybook.model.TaiKhoanHienTai;
import com.example.mybook.model.TaiKhoanLogin;


@Controller
public class DangKyController {
@Autowired
private TaikhoanResponsitory responsitory;




@RequestMapping("/dangnhap")
public String ShowTrangDangNhap(Model model) {

	model.addAttribute("taikhoanlogin", new TaiKhoanLogin());
	return "signin"; 
}

@GetMapping(value= {"/dangky"})
public String ShowTrangDangKy(Model model) {
	taikhoanEntity tk=new taikhoanEntity();
	
	model.addAttribute("taikhoanmoi", tk);
	
	model.addAttribute("check","none");
	return "signup";
}
@PostMapping("/dangky/add")
public String saveUser(@ModelAttribute("taikhoanmoi") taikhoanEntity tk, @RequestParam("image") MultipartFile multipartFile,Model model) throws IOException {

	String matkhau=Util.hashPassword(tk.getMatkhau());
	if(responsitory.countTendangnhap(tk.getTendangnhap())>0) {
		tk.setMatkhau("");
		model.addAttribute("taikhoanmoi",tk);
		model.addAttribute("check","failedusername");
		return "signup";
	}
	
	else if(responsitory.countEmail(tk.getEmail())>0) {
		tk.setMatkhau("");
		model.addAttribute("taikhoanmoi",tk);
		model.addAttribute("check","failedemail");
		return "signup";
	}else if(responsitory.countSDT(tk.getSdt())>0) {
		tk.setMatkhau("");
		model.addAttribute("taikhoanmoi",tk);
		model.addAttribute("check","failedsdt");
		return "signup";
	}else {
		
	String fileName=StringUtils.cleanPath(multipartFile.getOriginalFilename());
	tk.setAvatar(fileName);
tk.setMatkhau(matkhau);
tk.setPhanquyen("USER");
	taikhoanEntity newuser=responsitory.save(tk);
	Util.uploadImg(multipartFile,"user", newuser.getId());
	model.addAttribute("alert","dangkythanhcong");

	return "signup";
	}
}
@RequestMapping("/dangnhap/{tendangnhap}")
public String chuyentrangdangnhap(@PathVariable String tendangnhap, Model model) {
	TaiKhoanLogin tklogin=new TaiKhoanLogin();
	tklogin.setUsername(tendangnhap);
model.addAttribute("taikhoanlogin", tklogin);
return "signin";
}
@GetMapping("/api/user/info")
public TaiKhoanLogin getLogin() {
	TaiKhoanLogin tk=new TaiKhoanLogin();
	tk.setUsername(SecurityUtils.getPrincipal().getUsername());
	tk.setPassword(SecurityUtils.getPrincipal().getPassword());
	return tk;
}
}












