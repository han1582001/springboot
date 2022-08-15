package com.example.mybook.Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.mybook.Responsitory.SachResponsitory;
import com.example.mybook.Responsitory.TaikhoanResponsitory;
import com.example.mybook.entities.chitietdonhangEntity;
import com.example.mybook.entities.sachEntity;
import com.example.mybook.entities.taikhoanEntity;
import com.example.mybook.model.ChitietdonhangInfo;
import com.google.gson.Gson;

public class Util {

	public static void uploadImg(MultipartFile muFile, String tenthumuc, int id) throws IOException {
		String fileName = StringUtils.cleanPath(muFile.getOriginalFilename());
		String uploadDir = "src/main/resources/static/images/" + tenthumuc + "/" + id;
		saveImg(uploadDir, fileName, muFile);
	}

	public static void saveImg(String uploadDir, String filename, MultipartFile multipartFile) throws IOException {
		Path uploadPath = Paths.get(uploadDir);
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filepath = uploadPath.resolve(filename);
			Files.copy(inputStream, filepath, StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException e) {
			// TODO: handle exception
			throw new IOException("Tải ảnh lên bị lỗi");
		}

	}

	public static boolean chechitem(List<ChitietdonhangInfo> list, int idsach) {
		boolean x=false;
		for(ChitietdonhangInfo item:list) {
			if(item.getId()==idsach) {
				x=true;
			}
		}
		return x;
	}
	
	public static int getIndexItem(List<ChitietdonhangInfo>list, int idsach) {
		for(ChitietdonhangInfo item:list) {
			if(item.getId()==idsach) {
				return list.indexOf(item);
			}
		}
		return 0;
	}
	public static void WriteFileJson(String itemcart) throws IOException {
		String path = "cart.json";
		String folder = "src/main/resources/static/json/";
		File file=new File(folder);
		file.mkdirs();
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter(path));
			writer.write(itemcart);
			writer.flush();
			writer.close();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public static void Cart(List<ChitietdonhangInfo> cart) throws IOException {
		Gson gson =new Gson();
		for(ChitietdonhangInfo cartitem:cart) {
		String json=gson.toJson(cartitem);
		WriteFileJson(json);
		}
	}

	public static void deleteImg(String tenthumuc, int id) {
		String removeDir = "src/main/resources/static/images/" + tenthumuc + "/" + id;
		try {
			Files.deleteIfExists(Paths.get(removeDir));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public static java.util.Date getCurrentTime() throws ParseException {
		LocalDateTime current = LocalDateTime.now();
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatted = current.format(formater);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date = format.parse(formatted);
		return date;
	}
}
