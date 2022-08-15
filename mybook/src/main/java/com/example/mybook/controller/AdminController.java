package com.example.mybook.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
public class AdminController {
	
	@Autowired
	TaikhoanResponsitory tkresponsitory;

	@RequestMapping(value = { "/admin" })
	public String Index(Model model, Principal principal) {

		return "redirect:/admin/danhsachdonhang";
	}

	@Autowired
	PhanHoiResponsitory phanhoires;
	@Autowired
	DonHangResponsitory donhangres;

	@GetMapping("/admin/{cate}")
	public String CategoryAdmin(@PathVariable String cate, HttpServletRequest request, RedirectAttributes redirect,
			Model model, Principal principal) {
		TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
		taikhoanEntity tk = currenttk.getTaikhoan();
		if(!tk.getPhanquyen().equals("ADMIN")) {
			return "404";
		}
		Sort sortmess = Sort.by("time").descending();
		Pageable pageablemess = PageRequest.of(0, 3, sortmess);
		model.addAttribute("newmess", phanhoires.getMessages(pageablemess));

		model.addAttribute("TaiKhoanHienTai", tk);

		switch (cate) {
		case "danhsachnguoidung":
			List<taikhoanEntity> list1 = tkresponsitory.findAll();
			List<taikhoanEntity> lists = new ArrayList<taikhoanEntity>();
			for (taikhoanEntity tks : list1) {
				if (tks.getId() != tk.getId()) {
					lists.add(tks);
				}
			}
			model.addAttribute("category", "danhsachnguoidung");
			model.addAttribute("listacc", lists);
			break;

		case "danhsachdonhang":
			List<donhangEntity> listdonhang = donhangres.findAll();
			List<DonHangInfo> list = new ArrayList<DonHangInfo>();
			for (donhangEntity donhang : listdonhang) {
				Optional<taikhoanEntity> tke = tkresponsitory.findById(donhang.getIdkhachhang());
				if (tke.isPresent()) {
					DonHangInfo donhanginf = new DonHangInfo();
					donhanginf.setId(donhang.getId());
					donhanginf.setTenkhachhang(tke.get().getHovaten());
					donhanginf.setThanhtien(donhang.getThanhtien());
					donhanginf.setTimedathang(donhang.getTimedathang());
					donhanginf.setTimenhanhang(donhang.getTimenhanhang());
					donhanginf.setTrangthai(donhang.getTrangthai());
					list.add(donhanginf);
				}

			}
			model.addAttribute("listdonhang", list);
			model.addAttribute("category", "danhsachdonhang");

			break;
		case "danhsachsanpham":
			Sort sort = Sort.by("id").ascending();
			long pageSize = 10;
			int pageSizeint = (int) pageSize;
			Pageable pageable = PageRequest.of(0, pageSizeint, sort);

			long totalpages = sachResponsitory.count() / pageSize;
			List<Integer> pageList = new ArrayList<Integer>();

			int i;
			for (i = 0; i < totalpages + 1; i++) {
				pageList.add(i + 1);
			}
			model.addAttribute("ano", "null");
			model.addAttribute("CurrentPage", 0);
			model.addAttribute("pageList", pageList);
			model.addAttribute("countSach", sachResponsitory.count());
			model.addAttribute("listsach", sachResponsitory.getListSach(pageable));
			model.addAttribute("category", "danhsachsanpham");
			break;
		case "themsachmoi":
			sachEntity newsach = new sachEntity();
			List<theloaiEntity> listtl = theloaiRes.findAll();
			List<tacgiaEntity> listtg = tgResponsitory.findAll();
			model.addAttribute("newsach", newsach);
			model.addAttribute("dstheloai", listtl);
			model.addAttribute("dstacgia", listtg);
			model.addAttribute("ano", "add");
			model.addAttribute("category", "themsachmoi");
			break;
		case "theloaisach":
			List<theloaiEntity> listtheloai = new ArrayList<theloaiEntity>();
			listtheloai = theloaiRes.findAll();
			model.addAttribute("listtheloai", listtheloai);
			model.addAttribute("category", "theloaisach");
			break;
		case "themtheloaimoi":
			theloaiEntity newtheloai = new theloaiEntity();
			model.addAttribute("newtheloai", newtheloai);
			model.addAttribute("ano", "add");
			model.addAttribute("category", "themtheloaimoi");
			break;

		case "tacgia":
			List<tacgiaEntity> listtacgia = tgResponsitory.findAll();
			
			model.addAttribute("listtacgia", listtacgia);
			model.addAttribute("category", "tacgia");

			break;
		case "themtacgiamoi":
			tacgiaEntity newtacgia = new tacgiaEntity();
			model.addAttribute("newtacgia", newtacgia);
			model.addAttribute("ano", "add");
			model.addAttribute("category", "themtacgiamoi");
			break;

		case "phanhoicuakhachhang":
			Sort so=Sort.by("time").descending();
			Pageable pages=PageRequest.of(0,20 , so);
			model.addAttribute("listphanhoi", phanhoires.getMessages(pages));
			
			model.addAttribute("category", "phanhoicuakhachhang");

			break;
		case "myprofile":
			Optional<taikhoanEntity> taikhoan = tkresponsitory.findById(tk.getId());
			if (taikhoan.isPresent()) {
				model.addAttribute("taikhoanselected", taikhoan.get());

			}
			model.addAttribute("ano", "mine");
			model.addAttribute("category", "myprofile");

			break;
		default:
			break;
		}

		return "adminview/index";
	}
@RequestMapping("/admin/tinnhan/{id}")
public String ChitietTinNhan(@PathVariable int id, Principal principal, Model model) {
	TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
	taikhoanEntity tk = currenttk.getTaikhoan();
	model.addAttribute("TaiKhoanHienTai", tk);
	Sort sortmess = Sort.by("time").descending();
	Pageable pageablemess = PageRequest.of(0, 3, sortmess);
	model.addAttribute("newmess", phanhoires.getMessages(pageablemess));
	
	Optional<phanhoiEntity> item=phanhoires.findById(id);
	if(item.isPresent()) {
		model.addAttribute("itemres", item.get());
	}
	model.addAttribute("category", "tinnhan");
	return "adminview/index";
	
}


	@GetMapping("/admin/danhsachdonhang/giaohang")
	public String GiaoHang(@RequestParam("id") int id, @RequestParam("trangthai") int trangthai) throws ParseException {
		Optional<donhangEntity> donen = donhangres.findById(id);
		if (donen.isPresent()) {
			donhangEntity don = donen.get();
			don.setTimenhanhang(Util.getCurrentTime());
			don.setTrangthai(trangthai);
			donhangres.save(don);
		}

		return "redirect:/admin/danhsachdonhang";
	}

	@Autowired
	ChiTietDonHangResponsitory chitietres;

	@GetMapping("/admin/danhsachdonhang/chitietdonhang")
	public String Chitietdonhang(@RequestParam("id") int id, Model model, Principal principal) {
		TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
		taikhoanEntity tk = currenttk.getTaikhoan();
		model.addAttribute("TaiKhoanHienTai", tk);
		List<ChitietdonhangInfo> listchitietdonhang = new ArrayList<ChitietdonhangInfo>();
		List<chitietdonhangEntity> chitietEn = chitietres.getChiTietDonHang(id);
		Optional<donhangEntity> donhang = donhangres.findById(id);
		if (donhang.isPresent()) {
			Optional<taikhoanEntity> tke = tkresponsitory.findById(donhang.get().getIdkhachhang());
			if (tke.isPresent()) {
				DonHangInfo donhanginf = new DonHangInfo();
				donhanginf.setId(donhang.get().getId());
				donhanginf.setTenkhachhang(tke.get().getHovaten());
				donhanginf.setThanhtien(donhang.get().getThanhtien());
				donhanginf.setTimedathang(donhang.get().getTimedathang());
				donhanginf.setTimenhanhang(donhang.get().getTimenhanhang());
				donhanginf.setTrangthai(donhang.get().getTrangthai());
				model.addAttribute("donhanginfo", donhanginf);
			}
		}
		Sort sortmess = Sort.by("time").descending();
		Pageable pageablemess = PageRequest.of(0, 3, sortmess);
		model.addAttribute("newmess", phanhoires.getMessages(pageablemess));
		for (chitietdonhangEntity chitiet : chitietEn) {
			Optional<sachEntity> sach = sachResponsitory.findById(chitiet.getSanpham());
			if (sach.isPresent()) {
				ChitietdonhangInfo donhanginfo = new ChitietdonhangInfo();
				donhanginfo.setId(sach.get().getId());
				donhanginfo.setAnh(sach.get().getAnh());
				donhanginfo.setGia(sach.get().getGia());
				donhanginfo.setSoluong(chitiet.getSoluong());
				donhanginfo.setSanpham(sach.get().getTensach());
				listchitietdonhang.add(donhanginfo);
			}
		}
		model.addAttribute("chitiendonhanginfo", listchitietdonhang);
		model.addAttribute("category", "chitietdonhang");
		return "adminview/index";
	}

	@GetMapping("/admin/danhsachsanpham/{pageid}")
	public String SearchSachPage(@PathVariable int pageid, Model model, Principal principal) {
		TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
		taikhoanEntity tk = currenttk.getTaikhoan();
		model.addAttribute("TaiKhoanHienTai", tk);
		Sort sort = Sort.by("id").ascending();
		long pageSize = 10;
		int pageSizeint = (int) pageSize;
		Pageable pageable = PageRequest.of(pageid, pageSizeint, sort);

		long totalpages = sachResponsitory.count() / pageSize;
		List<Integer> pageList = new ArrayList<Integer>();

		int i;
		for (i = 0; i < totalpages + 1; i++) {
			pageList.add(i + 1);
		}
		Sort sortmess = Sort.by("time").descending();
		Pageable pageablemess = PageRequest.of(0, 3, sortmess);
		model.addAttribute("newmess", phanhoires.getMessages(pageablemess));
		model.addAttribute("CurrentPage", pageid);
		model.addAttribute("pageList", pageList);
		model.addAttribute("countSach", sachResponsitory.count());
		model.addAttribute("listsach", sachResponsitory.getListSach(pageable));
		model.addAttribute("category", "danhsachsanpham");
		model.addAttribute("ano", "null");
		return "adminview/index";
	}

	@GetMapping("/admin/danhsachsanpham/search")
	public String SearchSach(@RequestParam("search") String key, Model model, Principal principal) {
		TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
		taikhoanEntity tk = currenttk.getTaikhoan();
		model.addAttribute("TaiKhoanHienTai", tk);
		Sort sortmess = Sort.by("time").descending();
		Pageable pageablemess = PageRequest.of(0, 3, sortmess);
		model.addAttribute("newmess", phanhoires.getMessages(pageablemess));
		Sort sort = Sort.by("id").ascending();
		long pageSize = 10;
		int pageSizeint = (int) pageSize;
		Pageable pageable = PageRequest.of(0, pageSizeint, sort);

		long totalpages = sachResponsitory.countSearchByName(key) / pageSize;
		List<Integer> pageList = new ArrayList<Integer>();

		int i;
		for (i = 0; i < totalpages + 1; i++) {
			pageList.add(i + 1);
		}
		model.addAttribute("ano", "search");
		model.addAttribute("searchkey", key);
		model.addAttribute("CurrentPage", 0);
		model.addAttribute("pageList", pageList);
		model.addAttribute("countSach", sachResponsitory.countSearchByName(key));
		model.addAttribute("listsach", sachResponsitory.searchByName(pageable, key));
		model.addAttribute("category", "danhsachsanpham");
		return "adminview/index";
	}

	@GetMapping("/admin/danhsachsanpham/search/{pageid}")
	public String PageSanPham(@PathVariable int pageid, @RequestParam("search") String key, Model model,
			Principal principal) {
		TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
		taikhoanEntity tk = currenttk.getTaikhoan();
		model.addAttribute("TaiKhoanHienTai", tk);
		Sort sortmess = Sort.by("time").descending();
		Pageable pageablemess = PageRequest.of(0, 3, sortmess);
		model.addAttribute("newmess", phanhoires.getMessages(pageablemess));
		Sort sort = Sort.by("id").ascending();
		long pageSize = 10;
		int pageSizeint = (int) pageSize;
		Pageable pageable = PageRequest.of(pageid, pageSizeint, sort);

		long totalpages = sachResponsitory.countSearchByName(key) / pageSize;
		List<Integer> pageList = new ArrayList<Integer>();

		int i;
		for (i = 0; i < totalpages + 1; i++) {
			pageList.add(i + 1);
		}
		model.addAttribute("CurrentPage", pageid);
		model.addAttribute("pageList", pageList);
		model.addAttribute("searchkey", key);
		model.addAttribute("countSach", sachResponsitory.countSearchByName(key));
		model.addAttribute("listsach", sachResponsitory.searchByName(pageable, key));
		model.addAttribute("ano", "search");
		model.addAttribute("category", "danhsachsanpham");
		return "adminview/index";
	}

	@RequestMapping("/admin/profile/{id}")
	public String goToProfileUser(@PathVariable int id, Model model, Principal principal) {
		TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
		taikhoanEntity tk = currenttk.getTaikhoan();
		model.addAttribute("TaiKhoanHienTai", tk);
		Sort sortmess = Sort.by("time").descending();
		Pageable pageablemess = PageRequest.of(0, 3, sortmess);
		model.addAttribute("newmess", phanhoires.getMessages(pageablemess));
		Optional<taikhoanEntity> tk2 = tkresponsitory.findById(id);
		if (tk2.isPresent()) {
			model.addAttribute("taikhoanselected", tk2.get());
			model.addAttribute("listdonhang", donhangres.LichSu(id));
		}
		model.addAttribute("ano", "other");
		model.addAttribute("category", "profile");
		return "adminview/index";
	}

	@RequestMapping("/admin/myprofile")
	public String goToProfile(Model model, Principal principal) {
		TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
		taikhoanEntity tk = currenttk.getTaikhoan();
		model.addAttribute("TaiKhoanHienTai", tk);
		Sort sortmess = Sort.by("time").descending();
		Pageable pageablemess = PageRequest.of(0, 3, sortmess);
		model.addAttribute("newmess", phanhoires.getMessages(pageablemess));
		model.addAttribute("taikhoanselected", tk);

		model.addAttribute("ano", "other");
		model.addAttribute("category", "myprofile");
		return "adminview/index";
	}

	@Autowired
	SachResponsitory sachResponsitory;

	@RequestMapping("/admin/chitietsach/{id}")
	public String gotoChiTietSach(@PathVariable int id, Model model, Principal principal) {
		TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
		taikhoanEntity tk = currenttk.getTaikhoan();
		Sort sortmess = Sort.by("time").descending();
		Pageable pageablemess = PageRequest.of(0, 3, sortmess);
		model.addAttribute("newmess", phanhoires.getMessages(pageablemess));
		model.addAttribute("TaiKhoanHienTai", tk);
		model.addAttribute("category", "chitietsach");
		Optional<sachEntity> sachEn = sachResponsitory.findById(id);
		SachInfo sachInfo = new SachInfo();
		if (sachEn.isPresent()) {
			Optional<tacgiaEntity> tg = tgResponsitory.findById(sachEn.get().getTacgia());
			if (tg.isPresent()) {
				Optional<theloaiEntity> tl = theloaiRes.findById(sachEn.get().getTheloai());
				if (tl.isPresent()) {
					Optional<taikhoanEntity> tk2 = tkresponsitory.findById(sachEn.get().getNguoidang());
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
		return "adminview/index";
	}

	@PostMapping(value = "/admin/themsachmoi/add")
	public String addnewSach(@ModelAttribute("newsach") sachEntity sach, Model model,
			@RequestParam("image") MultipartFile img, Principal principal) throws IOException, ParseException {
		TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
		taikhoanEntity tk = currenttk.getTaikhoan();
		model.addAttribute("TaiKhoanHienTai", tk);
		String filename = StringUtils.cleanPath(img.getOriginalFilename());
		sach.setNguoidang(tk.getId());
		sach.setAnh(filename);
		sach.setThoigiandang(Util.getCurrentTime());
		sachEntity s = sachResponsitory.save(sach);
		Util.uploadImg(img, "sach", s.getId());

		return "redirect:/admin/danhsachsanpham";

	}

	@RequestMapping(value = "/admin/capnhatsach/{id}")
	public String updateSach(@PathVariable int id, Principal principal, Model model) {
		TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
		taikhoanEntity tk = currenttk.getTaikhoan();
		model.addAttribute("TaiKhoanHienTai", tk);
		Sort sortmess = Sort.by("time").descending();
		Pageable pageablemess = PageRequest.of(0, 3, sortmess);
		model.addAttribute("newmess", phanhoires.getMessages(pageablemess));
		List<theloaiEntity> listtl = theloaiRes.findAll();
		List<tacgiaEntity> listtg = tgResponsitory.findAll();
		Optional<sachEntity> sach = sachResponsitory.findById(id);
		if (sach.isPresent()) {
			model.addAttribute("newsach", sach.get());
			model.addAttribute("category", "capnhatsach");
			model.addAttribute("dstheloai", listtl);
			model.addAttribute("dstacgia", listtg);
		}

		model.addAttribute("ano", "update");
		return "adminview/index";
	}

	@RequestMapping(value = "/admin/xoasach/{id}")
	public String deleteSach(@PathVariable int id, Principal principal, Model model) {

		sachResponsitory.deleteById(id);
		Util.deleteImg("sach", id);
		return "redirect:/admin/danhsachsanpham";
	}

	@RequestMapping(value = "/admin/xoatheloai/{id}")
	public String deleteTheLoai(@PathVariable int id, Principal principal, Model model) {
		theloaiRes.deleteById(id);
		Util.deleteImg("theloai", id);
		return "redirect:/admin/theloaisach";
	}

	@RequestMapping(value = "/admin/xoatacgia/{id}")
	public String deleteTacgia(@PathVariable int id, Principal principal, Model model) {
		tgResponsitory.deleteById(id);
		Util.deleteImg("tacgia", id);
		return "redirect:/admin/tacgia";
	}

	@Autowired
	private TheloaiResponsitory theloaiRes;

	@PostMapping(value = { "/admin/themtheloaimoi/add" })
	public String addnewTheloai(@ModelAttribute("newtheloai") theloaiEntity theloai, Model model,
			@RequestParam("image") MultipartFile anh, Principal principal) throws IOException {

		String filename = StringUtils.cleanPath(anh.getOriginalFilename());
		theloai.setAnh(filename);
		theloaiEntity tl = theloaiRes.save(theloai);
		Util.uploadImg(anh, "theloai", tl.getId());
		return "redirect:/admin/theloaisach";
	}

	@RequestMapping("/admin/capnhattheloai/{id}")
	public String updateTheLoai(@PathVariable int id, Principal principal, Model model) {
		TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
		taikhoanEntity tk = currenttk.getTaikhoan();
		model.addAttribute("TaiKhoanHienTai", tk);
		Optional<theloaiEntity> theloaisl = theloaiRes.findById(id);
		if (theloaisl.isPresent()) {
			model.addAttribute("newtheloai", theloaisl.get());
			model.addAttribute("category", "capnhattheloai");
			model.addAttribute("ano", "update");
		}

		return "redirect:/admin/theloaisach";
	}

	@PostMapping(value = { "/admin/themtheloaimoi/update" })
	public String saveUpdateTheLoai(@ModelAttribute("newtheloai") theloaiEntity theloai,
			@RequestParam("image") MultipartFile img, Principal principal, Model model) throws IOException {

		String filename = StringUtils.cleanPath(img.getOriginalFilename());
		theloai.setAnh(filename);
		theloaiEntity tl = theloaiRes.save(theloai);
		Util.uploadImg(img, "theloai", tl.getId());
		return "redirect:/admin/theloaisach";
	}

	@Autowired
	private TacgiaResponsitory tgResponsitory;

	@RequestMapping("/admin/capnhattacgia/{id}")
	private String updateTacgia(@PathVariable int id, Principal principal, Model model) {
		TaiKhoanHienTai currenttk = (TaiKhoanHienTai) ((Authentication) principal).getPrincipal();
		taikhoanEntity tk = currenttk.getTaikhoan();
		model.addAttribute("TaiKhoanHienTai", tk);
		Sort sortmess = Sort.by("time").descending();
		Pageable pageablemess = PageRequest.of(0, 3, sortmess);
		model.addAttribute("newmess", phanhoires.getMessages(pageablemess));
		Optional<tacgiaEntity> tacgiasl = tgResponsitory.findById(id);
		if (tacgiasl.isPresent()) {
			model.addAttribute("newtacgia", tacgiasl.get());
			model.addAttribute("category", "capnhattacgia");
		}
		model.addAttribute("ano", "update");
		return "adminview/index";
	}

	@PostMapping(value = { "/admin/themtacgiamoi/update" })
	public String saveUpdateTacGia(@ModelAttribute("newtacgia") tacgiaEntity tacgia,
			@RequestParam("image") MultipartFile img, Principal principal, Model model) throws IOException {

		String filename = StringUtils.cleanPath(img.getOriginalFilename());
		tacgia.setAnh(filename);
		tacgiaEntity tg = tgResponsitory.save(tacgia);
		Util.uploadImg(img, "tacgia", tg.getId());
		return "redirect:/admin/tacgia";
	}

	@PostMapping(value = { "/admin/themtacgiamoi/add" })
	public String addnewTacGia(@ModelAttribute("newtacgia") tacgiaEntity tacgia, Model model, Principal principal,
			@RequestParam("image") MultipartFile img) throws IOException {

		String filename = StringUtils.cleanPath(img.getOriginalFilename());
		tacgia.setAnh(filename);
		tacgiaEntity tg = tgResponsitory.save(tacgia);
		Util.uploadImg(img, "tacgia", tg.getId());
		return "redirect:/admin/tacgia";

	}

}
