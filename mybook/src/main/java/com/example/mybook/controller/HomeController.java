package com.example.mybook.controller;

import java.lang.ProcessBuilder.Redirect;
import java.security.Principal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mybook.DAO.ListWrapper;
import com.example.mybook.Responsitory.ChiTietDonHangResponsitory;
import com.example.mybook.Responsitory.DonHangResponsitory;
import com.example.mybook.Responsitory.PhanHoiResponsitory;
import com.example.mybook.Responsitory.SachResponsitory;
import com.example.mybook.Responsitory.TacgiaResponsitory;
import com.example.mybook.Responsitory.TaikhoanResponsitory;
import com.example.mybook.Responsitory.TheloaiResponsitory;
import com.example.mybook.Util.Util;
import com.example.mybook.entities.chitietdonhangEntity;
import com.example.mybook.entities.donhangEntity;
import com.example.mybook.entities.phanhoiEntity;
import com.example.mybook.entities.sachEntity;
import com.example.mybook.entities.tacgiaEntity;
import com.example.mybook.entities.taikhoanEntity;
import com.example.mybook.entities.theloaiEntity;

import com.example.mybook.model.ChitietdonhangInfo;
import com.example.mybook.model.DonHangInfo;
import com.example.mybook.model.SachInfo;

import com.example.mybook.model.TaiKhoanHienTai;

@Controller
public class HomeController {

	@Autowired
	TheloaiResponsitory theloaires;
	@Autowired
	SachResponsitory sachResponsitory;
	@Autowired
	TaikhoanResponsitory tkresponsitory;

	@Autowired
	TacgiaResponsitory tgresponsitory;
	List<ChitietdonhangInfo> cart = new ArrayList<ChitietdonhangInfo>();

	@RequestMapping(value = { "/", "/home" })
	public String Home(Principal principal, Model model) {

		return "redirect:/mybook/home";
	}

	@GetMapping("/mybook/{pagecate}")
	public String loadPage(@PathVariable String pagecate, @RequestParam(name = "search", defaultValue = "") String key,
			@RequestParam(name = "theloai", defaultValue = "0") int idtheloai,
			@RequestParam(name = "sort", defaultValue = "thoigiandang") String sorte,
			@RequestParam(name = "thutu", defaultValue = "giam") String thutu, Principal principal, Model model) {
		if (principal != null) {
			TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
			taikhoanEntity tk = currenttk.getTaikhoan();
			model.addAttribute("ano", "notnull");
			model.addAttribute("taikhoan", tk);

		} else {
			model.addAttribute("ano", "none");

		}
model.addAttribute("countcart", cart.size());
		List<theloaiEntity> dstheloai = new ArrayList<theloaiEntity>();
		dstheloai = theloaires.findAll();
		model.addAttribute("dstheloai", dstheloai);
		
		switch (pagecate) {

		case "home":

			Sort sort = Sort.by("thoigiandang").descending();
			Sort sort2 = Sort.by("tensach").ascending();
			Pageable pageable = PageRequest.of(0, 8, sort);
			Pageable pageable2 = PageRequest.of(0, 8, sort2);

			model.addAttribute("listsachmoi", sachResponsitory.getListSach(pageable));
			model.addAttribute("listsachran", sachResponsitory.getListSach(pageable2));
			model.addAttribute("pagecate", "home");
			model.addAttribute("searchkey", "");
			break;
		case "phanhoi":
			phanhoiEntity mess=new phanhoiEntity();
			
			model.addAttribute("mess", mess);
			model.addAttribute("pagecate", "phanhoi");
			model.addAttribute("searchkey", "");
			model.addAttribute("anotheloai", "phanhoi");
			break;
		case "book":
			long pageSize = 12;
			int pageSizeInt = (int) pageSize;
			if(!key.isEmpty()&&!key.equals(null)) {
			if (idtheloai == 0) {
				long totalPage;
				if (sachResponsitory.countSearchByName(key) % pageSize != 0) {
					totalPage = sachResponsitory.countSearchByName(key) / pageSize + 1;
				} else {
					totalPage = sachResponsitory.countSearchByName(key) / pageSize;
				}
				List<Integer> pageList = new ArrayList<Integer>();
				int i;
				for (i = 0; i < totalPage; i++) {
					pageList.add(i + 1);
				}
				if (thutu.equals("tang")) {
					Sort sort24 = Sort.by(sorte).ascending();

					Pageable pageable3 = PageRequest.of(0, pageSizeInt, sort24);

					model.addAttribute("listsach", sachResponsitory.searchByName(pageable3, key));

				}
				if (thutu.equals("giam")) {
					Sort sort24 = Sort.by(sorte).descending();

					Pageable pageable3 = PageRequest.of(0, pageSizeInt, sort24);

					model.addAttribute("listsach", sachResponsitory.searchByName(pageable3, key));
				}
				model.addAttribute("anotheloai", "all");
				model.addAttribute("maxPage", pageList.size());
				model.addAttribute("pageList", pageList);
			} else {
				long totalPage;
				if (sachResponsitory.countSachByTheLoai(idtheloai, key) % pageSize != 0) {
					totalPage = sachResponsitory.countSachByTheLoai(idtheloai, key) / pageSize + 1;
				} else {
					totalPage = sachResponsitory.countSachByTheLoai(idtheloai, key) / pageSize;
				}
				List<Integer> pageList = new ArrayList<Integer>();
				int i;
				for (i = 0; i < totalPage; i++) {
					pageList.add(i + 1);
				}
				if (thutu.equals("tang")) {
					Sort sort24 = Sort.by(sorte).ascending();

					Pageable pageable3 = PageRequest.of(0, pageSizeInt, sort24);

					model.addAttribute("listsach", sachResponsitory.getSachTheoTheLoai(pageable3, idtheloai, key));

				}
				if (thutu.equals("giam")) {
					Sort sort24 = Sort.by(sorte).descending();

					Pageable pageable3 = PageRequest.of(0, pageSizeInt, sort24);

					model.addAttribute("listsach", sachResponsitory.getSachTheoTheLoai(pageable3, idtheloai, key));
					if (sachResponsitory.countSachByTheLoai(idtheloai, key) == 0) {
						model.addAttribute("listnull", "null");
					}
				}
				model.addAttribute("anotheloai", "ele");
				model.addAttribute("maxPage", pageList.size());
				model.addAttribute("pageList", pageList);
				Optional<theloaiEntity> theloais = theloaires.findById(idtheloai);
				if (theloais.isPresent()) {
					model.addAttribute("theloaicurrent", theloais.get());
				}
			}
			model.addAttribute("idtheloai", idtheloai);

			model.addAttribute("pagecate", "book");

			model.addAttribute("currentPage", 0);
			model.addAttribute("sort", sorte);
			model.addAttribute("thutu", thutu);
			model.addAttribute("searchkey", key);
			}
			else {
				if (idtheloai == 0) {
					long totalPage;
					if (sachResponsitory.countSearchByName(key) % pageSize != 0) {
						totalPage = sachResponsitory.countSearchByName(key) / pageSize + 1;
					} else {
						totalPage = sachResponsitory.countSearchByName(key) / pageSize;
					}
					List<Integer> pageList = new ArrayList<Integer>();
					int i;
					for (i = 0; i < totalPage; i++) {
						pageList.add(i + 1);
					}
					if (thutu.equals("tang")) {
						Sort sort24 = Sort.by(sorte).ascending();

						Pageable pageable3 = PageRequest.of(0, pageSizeInt, sort24);

						model.addAttribute("listsach", sachResponsitory.searchByName(pageable3, key));

					}
					if (thutu.equals("giam")) {
						Sort sort24 = Sort.by(sorte).descending();

						Pageable pageable3 = PageRequest.of(0, pageSizeInt, sort24);

						model.addAttribute("listsach", sachResponsitory.searchByName(pageable3, key));
					}
					model.addAttribute("anotheloai", "all");
					model.addAttribute("maxPage", pageList.size());
					model.addAttribute("pageList", pageList);
				} else {
					long totalPage;
					if (sachResponsitory.countSachByTheLoai(idtheloai) % pageSize != 0) {
						totalPage = sachResponsitory.countSachByTheLoai(idtheloai) / pageSize + 1;
					} else {
						totalPage = sachResponsitory.countSachByTheLoai(idtheloai) / pageSize;
					}
					List<Integer> pageList = new ArrayList<Integer>();
					int i;
					for (i = 0; i < totalPage; i++) {
						pageList.add(i + 1);
					}
					if (thutu.equals("tang")) {
						Sort sort24 = Sort.by(sorte).ascending();

						Pageable pageable3 = PageRequest.of(0, pageSizeInt, sort24);

						model.addAttribute("listsach", sachResponsitory.getSachTheoTheLoai(pageable3, idtheloai));

					}
					if (thutu.equals("giam")) {
						Sort sort24 = Sort.by(sorte).descending();

						Pageable pageable3 = PageRequest.of(0, pageSizeInt, sort24);

						model.addAttribute("listsach", sachResponsitory.getSachTheoTheLoai(pageable3, idtheloai));
						if (sachResponsitory.countSachByTheLoai(idtheloai) == 0) {
							model.addAttribute("listnull", "null");
						}
					}
					model.addAttribute("anotheloai", "ele");
					model.addAttribute("maxPage", pageList.size());
					model.addAttribute("pageList", pageList);
					Optional<theloaiEntity> theloais = theloaires.findById(idtheloai);
					if (theloais.isPresent()) {
						model.addAttribute("theloaicurrent", theloais.get());
					}
				}
				model.addAttribute("idtheloai", idtheloai);

				model.addAttribute("pagecate", "book");

				model.addAttribute("currentPage", 0);
				model.addAttribute("sort", sorte);
				model.addAttribute("thutu", thutu);
				model.addAttribute("searchkey", "");
			}
			break;
	
			
		

		}

		return "client/index";
	}
@RequestMapping("/mybook/profile")
public String getProfile( Model model, Principal principal) {
	if (principal != null) {
		TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
		taikhoanEntity tk = currenttk.getTaikhoan();
		model.addAttribute("ano", "notnull");
		model.addAttribute("taikhoan", tk);
List<theloaiEntity> dstheloai = new ArrayList<theloaiEntity>();
	dstheloai = theloaires.findAll();
	model.addAttribute("dstheloai", dstheloai);
	model.addAttribute("pagecate", "profile");
	model.addAttribute("searchkey", "");
	model.addAttribute("listdamua", donhangres.DonHangDaGiao(tk.getId()));
	model.addAttribute("listcho", donhangres.DonHangCho(tk.getId()));
	
	return "client/index";
	} else {
		model.addAttribute("ano", "none");
		model.addAttribute("anotheloai", "pro");
return "redirect:/dangnhap";
	}
	
}

@Autowired
TaikhoanResponsitory tkres;
@GetMapping("/doimatkhau")
public String doimk(@RequestParam("old")String old, @RequestParam("new")String newpass, Model model, Principal principal) {
	TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
	taikhoanEntity tk = currenttk.getTaikhoan();
	
		taikhoanEntity tken=new taikhoanEntity();
	tken.setId(tk.getId());
	tken.setHovaten(tk.getHovaten());
	tken.setTendangnhap(tk.getTendangnhap());
	tken.setDiachi(tk.getDiachi());
	tken.setSdt(tk.getSdt());
	tken.setEmail(tk.getEmail());
	tken.setAvatar(tk.getAvatar());
	tken.setPhanquyen(tk.getPhanquyen());
	tken.setMatkhau(Util.hashPassword(newpass));
		tkres.save(tken);
		
	
	return "redirect:/mybook/profile";
}
	@RequestMapping("/mybook/giohang")
	public String Cart(Principal principal, Model model) {
		if (principal != null) {
			TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
			taikhoanEntity tk = currenttk.getTaikhoan();
			model.addAttribute("ano", "notnull");
			model.addAttribute("taikhoan", tk);

		} else {
			model.addAttribute("ano", "none");

		}
		ListWrapper wrapper=new ListWrapper();
		wrapper.setDonhanglist(cart);
		model.addAttribute("countcart", cart.size());
		List<theloaiEntity> dstheloai = new ArrayList<theloaiEntity>();
		dstheloai = theloaires.findAll();
		model.addAttribute("dstheloai", dstheloai);
		model.addAttribute("pagecate", "giohang");
		model.addAttribute("cart", wrapper);
		model.addAttribute("anotheloai","cart");
		model.addAttribute("searchkey", "");
		return "client/index";
	}
	@GetMapping("/mybook/giohang/{id}")
	public String AddCart(@PathVariable int id) {
		Optional<sachEntity> sach=sachResponsitory.findById(id);
		if(sach.isPresent()) {
			ChitietdonhangInfo item=new ChitietdonhangInfo();
			item.setId(sach.get().getId());
			item.setIdsanpham(sach.get().getId());
			item.setSanpham(sach.get().getTensach());
			item.setGia(sach.get().getGia());
			item.setSoluong(0);
			item.setAnh(sach.get().getAnh());
			if(!Util.chechitem(cart, id)) {
			cart.add(item);
			}
			
		}
		return "redirect:/mybook/giohang";
	}

	@Autowired
	DonHangResponsitory donhangres;
	@Autowired
	ChiTietDonHangResponsitory chitietdonhangres;
@PostMapping("/mybook/dathang")
public String DatHang(@ModelAttribute("cart") ListWrapper listdathang, Principal principal, Model model) throws ParseException {
	if (principal != null) {
		TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
		taikhoanEntity tk = currenttk.getTaikhoan();

		model.addAttribute("ano", "notnull");
		model.addAttribute("taikhoan", tk);
		int tonggiatridonhang = 0;
		for (ChitietdonhangInfo chitiet : listdathang.getDonhanglist()) {
			tonggiatridonhang = tonggiatridonhang + (chitiet.getGia() * chitiet.getSoluong());
		}
		model.addAttribute("cart", listdathang);
		model.addAttribute("total",tonggiatridonhang);
		model.addAttribute("cartano", "dathang");
	} else {
		model.addAttribute("ano", "none");
return "/dangnhap";
	}
	
	return "client/chitietdonhang";
}

@RequestMapping("/mybook/tacgia/{id}")
public String Tacgia(@PathVariable int id, Model model, Principal principal) {
	if (principal != null) {
		TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
		taikhoanEntity tk = currenttk.getTaikhoan();
		model.addAttribute("ano", "notnull");
		model.addAttribute("taikhoan", tk);

	} else {
		model.addAttribute("ano", "none");

	}
	Sort sorts = Sort.by("tensach");
	Pageable pageable = PageRequest.of(0, 10, sorts);
	List<theloaiEntity> dstheloai = new ArrayList<theloaiEntity>();
	dstheloai = theloaires.findAll();
	model.addAttribute("dstheloai", dstheloai);
	model.addAttribute("countcart", cart.size());
	Optional<sachEntity> sach= sachResponsitory.findById(id);
	if (sach.isPresent()) {
		Optional<tacgiaEntity> tg=tgresponsitory.findById(sach.get().getTacgia());
		if(tg.isPresent()) {
			model.addAttribute("listsachtacgia",
					sachResponsitory.getsachTheoTacGia(pageable, tg.get().getId()));
	model.addAttribute("tacgia",tg.get());
		}
		}
	
		
	
	model.addAttribute("searchkey", "");

	model.addAttribute("pagecate", "tacgia");
	model.addAttribute("anotheloai", "tac");
	return "client/index";
	
}

@RequestMapping("/mybook/profile/chitietdonhang/{id}")
public String getChitietdonhang(@PathVariable int id, Model model, Principal principal) {
	TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
	taikhoanEntity tk = currenttk.getTaikhoan();
	model.addAttribute("TaiKhoanHienTai", tk);
	List<ChitietdonhangInfo> listchitietdonhang=new ArrayList<ChitietdonhangInfo>();
	List<chitietdonhangEntity> chitietEn= chitietdonhangres.getChiTietDonHang(id);
	

	for(chitietdonhangEntity chitiet:chitietEn) {
		Optional<sachEntity> sach=sachResponsitory.findById(chitiet.getSanpham());
		if(sach.isPresent()) {
	ChitietdonhangInfo donhanginfo= new ChitietdonhangInfo();
	donhanginfo.setId(sach.get().getId());
	donhanginfo.setAnh(sach.get().getAnh());
	donhanginfo.setGia(sach.get().getGia());
	donhanginfo.setSoluong(chitiet.getSoluong());
	donhanginfo.setSanpham(sach.get().getTensach());
	listchitietdonhang.add(donhanginfo);
		}
	}
	ListWrapper wrapper=new ListWrapper();
	wrapper.setDonhanglist(listchitietdonhang);
	int tonggiatridonhang = 0;
	for (ChitietdonhangInfo chitiet : wrapper.getDonhanglist()) {
		tonggiatridonhang = tonggiatridonhang + (chitiet.getGia() * chitiet.getSoluong());
	}
	model.addAttribute("cart", wrapper);
	model.addAttribute("total",tonggiatridonhang);
	model.addAttribute("cartano", "xemchitiet");
	return "client/chitietdonhang";
	
}
	
	@PostMapping("/mybook/dathang/confirm")
	public String Confirm(@ModelAttribute("cart") ListWrapper listdathang, Principal principal, Model model)
			throws ParseException {
		if (principal != null) {
			TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
			taikhoanEntity tk = currenttk.getTaikhoan();

			model.addAttribute("ano", "notnull");
			model.addAttribute("taikhoan", tk);
			List<chitietdonhangEntity> listhang = new ArrayList<chitietdonhangEntity>();
			int tonggiatridonhang = 0;
			for (ChitietdonhangInfo chitiet : listdathang.getDonhanglist()) {
				tonggiatridonhang = tonggiatridonhang + (chitiet.getGia() * chitiet.getSoluong());
			}
			donhangEntity donhang = new donhangEntity();
			donhang.setIdkhachhang(tk.getId());
			donhang.setThanhtien(tonggiatridonhang);
			donhang.setTimedathang(Util.getCurrentTime());
			donhang.setTrangthai(0);
			donhangEntity dh = donhangres.save(donhang);
			for (ChitietdonhangInfo chitiet : listdathang.getDonhanglist()) {
				chitietdonhangEntity item = new chitietdonhangEntity();
				item.setIddonghang(dh.getId());
				item.setNguoimua(tk.getId());
				item.setSanpham(chitiet.getIdsanpham());
				item.setSoluong(chitiet.getSoluong());
				item.setGia(chitiet.getGia());
				item.setThoigian(dh.getTimedathang());
				item.setTrangthai(dh.getTrangthai());
				listhang.add(item);
			}
			chitietdonhangres.saveAll(listhang);
		} else {
			model.addAttribute("ano", "none");
return "/dangnhap";
		}
		
		return "redirect:/mybook/book";

	}

	@GetMapping("/mybook/chitietsach")
	public String DetailSach(@RequestParam(name = "id", required = true) int idsach, Principal principal, Model model) {
		if (principal != null) {
			TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
			taikhoanEntity tk = currenttk.getTaikhoan();
			model.addAttribute("ano", "notnull");
			model.addAttribute("taikhoan", tk);

		} else {
			model.addAttribute("ano", "none");

		}
		Sort sorts = Sort.by("tensach");
		Pageable pageable = PageRequest.of(0, 5, sorts);
		List<theloaiEntity> dstheloai = new ArrayList<theloaiEntity>();
		dstheloai = theloaires.findAll();
		model.addAttribute("dstheloai", dstheloai);
		model.addAttribute("countcart", cart.size());
		Optional<sachEntity> sachEn = sachResponsitory.findById(idsach);
		SachInfo sachInfo = new SachInfo();
		if (sachEn.isPresent()) {
			Optional<tacgiaEntity> tg = tgresponsitory.findById(sachEn.get().getTacgia());
			if (tg.isPresent()) {
				Optional<theloaiEntity> tl = theloaires.findById(sachEn.get().getTheloai());

				model.addAttribute("listsachtacgia",
						sachResponsitory.getsachTheoTacGia(pageable, sachEn.get().getTacgia()));
				if (tl.isPresent()) {
					Optional<taikhoanEntity> tk2 = tkresponsitory.findById(sachEn.get().getNguoidang());
					model.addAttribute("listsachtheloai",
							sachResponsitory.getsachTheoTheloai(pageable, sachEn.get().getTheloai()));
					if (tk2.isPresent()) {

						sachInfo.setId(sachEn.get().getId());
						sachInfo.setTensach(sachEn.get().getTensach());
						sachInfo.setTacgia(tg.get().getTentacgia());
						sachInfo.setNxb(sachEn.get().getNxb());
						sachInfo.setTheloai(tl.get().getTentheloai());
						sachInfo.setGia(sachEn.get().getGia());
						sachInfo.setNoidung(sachEn.get().getNoidung());
						sachInfo.setSoluong(sachEn.get().getSoluong());
						sachInfo.setNguoidang(tk2.get().getHovaten());
						sachInfo.setThoigiandang(sachEn.get().getThoigiandang());
						sachInfo.setAnh(sachEn.get().getAnh());
					}
				}
			}
		}
		model.addAttribute("sachinfo", sachInfo);
		model.addAttribute("searchkey", "");
		model.addAttribute("pagecate", "chitietsach");
		model.addAttribute("anotheloai", "det");
		return "client/index";
	}
	@Autowired
	PhanHoiResponsitory phanhoires;
	@PostMapping("/phanhoi/send")
	public String sendMessage(@ModelAttribute("mess") phanhoiEntity mess, Principal principal, Model model) throws ParseException {
		if (principal != null) {
			TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
			taikhoanEntity tk = currenttk.getTaikhoan();
			model.addAttribute("ano", "notnull");
			model.addAttribute("taikhoan", tk);
		mess.setTenkhachhang(tk.getHovaten());
			mess.setIdkhachhang(tk.getId());
			mess.setTime(Util.getCurrentTime());
phanhoires.save(mess);
return "client/thongbaothanhcong";
		} else {
			model.addAttribute("ano", "none");
return "redirect:/dangnhap";
		}
	
	}

	@GetMapping("/mybook/book/{pageid}")
	public String bookPage(@PathVariable int pageid, @RequestParam(name = "search", defaultValue = "") String key,
			@RequestParam(name = "theloai", defaultValue = "0") int idtheloai,
			@RequestParam(name = "sort", defaultValue = "thoigiandang") String sorte,
			@RequestParam(name = "thutu", defaultValue = "giam") String thutu, Model model, Principal principal) {
		if (principal != null) {
			TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
			taikhoanEntity tk = currenttk.getTaikhoan();
			model.addAttribute("ano", "notnull");
			model.addAttribute("taikhoan", tk);

		} else {
			model.addAttribute("ano", "none");

		}
		List<theloaiEntity> dstheloai = new ArrayList<theloaiEntity>();
		dstheloai = theloaires.findAll();
		model.addAttribute("dstheloai", dstheloai);
		model.addAttribute("countcart", cart.size());
		long pageSize = 12;
		int pageSizeInt = (int) pageSize;

		if (idtheloai == 0) {
			long totalPage;
			if (sachResponsitory.countSearchByName(key) % pageSize != 0) {
				totalPage = sachResponsitory.countSearchByName(key) / pageSize + 1;
			} else {
				totalPage = sachResponsitory.countSearchByName(key) / pageSize;
			}
			List<Integer> pageList = new ArrayList<Integer>();
			int i;
			for (i = 0; i < totalPage; i++) {
				pageList.add(i + 1);
			}
			if (thutu.equals("tang")) {
				Sort sort = Sort.by(sorte).ascending();

				Pageable pageable3 = PageRequest.of(pageid, pageSizeInt, sort);

				model.addAttribute("listsach", sachResponsitory.searchByName(pageable3, key));

			}
			if (thutu.equals("giam")) {
				Sort sort = Sort.by(sorte).descending();

				Pageable pageable3 = PageRequest.of(pageid, pageSizeInt, sort);

				model.addAttribute("listsach", sachResponsitory.searchByName(pageable3, key));
			}
			model.addAttribute("maxPage", pageList.size());
			model.addAttribute("pageList", pageList);
			model.addAttribute("anotheloai", "all");
		} else {
			long totalPage;
			if (sachResponsitory.countSachByTheLoai(idtheloai, key) % pageSize != 0) {
				totalPage = sachResponsitory.countSachByTheLoai(idtheloai, key) / pageSize + 1;
			} else {
				totalPage = sachResponsitory.countSachByTheLoai(idtheloai, key) / pageSize;
			}

			List<Integer> pageList = new ArrayList<Integer>();
			int i;
			for (i = 0; i < totalPage; i++) {
				pageList.add(i + 1);
			}
			if (thutu.equals("tang")) {
				Sort sort = Sort.by(sorte).ascending();

				Pageable pageable3 = PageRequest.of(pageid, pageSizeInt, sort);

				model.addAttribute("listsach", sachResponsitory.getSachTheoTheLoai(pageable3, idtheloai, key));

			}
			if (thutu.equals("giam")) {
				Sort sort = Sort.by(sorte).descending();

				Pageable pageable3 = PageRequest.of(pageid, pageSizeInt, sort);

				model.addAttribute("listsach", sachResponsitory.getSachTheoTheLoai(pageable3, idtheloai, key));
			}
			if (sachResponsitory.countSachByTheLoai(idtheloai, key) == 0) {
				model.addAttribute("listnull", "null");
			}
			Optional<theloaiEntity> theloais = theloaires.findById(idtheloai);
			if (theloais.isPresent()) {
				model.addAttribute("theloaicurrent", theloais.get());
			}
			model.addAttribute("maxPage", pageList.size());
			model.addAttribute("pageList", pageList);
			model.addAttribute("anotheloai", "ele");

		}
		model.addAttribute("idtheloai", idtheloai);
		model.addAttribute("pagecate", "book");
		model.addAttribute("sort", sorte);
		model.addAttribute("thutu", thutu);
		model.addAttribute("searchkey", key);
		model.addAttribute("currentPage", pageid);
		return "client/index";
	}
	

}
