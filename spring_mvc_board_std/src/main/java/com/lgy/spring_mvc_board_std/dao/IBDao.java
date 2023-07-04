package com.lgy.spring_mvc_board_std.dao;

import java.util.ArrayList;
import java.util.HashMap;
import com.lgy.spring_mvc_board_std.dto.BDto;

public interface IBDao {
//	public ArrayList<BDto> list();
//	public void write(String bname, String btitle, String bcontent);
//	public BDto contentView(String strID);
//	private void upHit(String bid); 생략
//	public void modify(String bid, String bname, String btitle, String bcontent);
//	public void delete(String strID);

	public ArrayList<BDto> list();
	public void write(HashMap<String, String> param);
	public BDto contentView(HashMap<String, String> param);
	public void modify(HashMap<String, String> param);
	public void delete(HashMap<String, String> param);
}






