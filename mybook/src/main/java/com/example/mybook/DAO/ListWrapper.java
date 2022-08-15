package com.example.mybook.DAO;

import java.util.ArrayList;
import java.util.List;

import com.example.mybook.model.ChitietdonhangInfo;

public class ListWrapper {
public List<ChitietdonhangInfo> donhanglist;

public List<ChitietdonhangInfo> getDonhanglist() {
	return donhanglist;
}

public void setDonhanglist(List<ChitietdonhangInfo> cart) {
	this.donhanglist = cart;
}

}
