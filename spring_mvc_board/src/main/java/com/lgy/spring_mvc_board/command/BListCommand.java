package com.lgy.spring_mvc_board.command;

import java.util.ArrayList;
import org.springframework.ui.Model;
import com.lgy.spring_mvc_board.dao.BDao;
import com.lgy.spring_mvc_board.dto.BDto;

//게시판 목록 조회
public class BListCommand implements BCommand{

	@Override
	public void execute(Model model) {
		//DAO단 호출
		BDao dao = new BDao();
		//게시글들을 dtos 객체로 받음
		ArrayList<BDto> dtos = dao.list();
		//컨트롤러단으로 데이터를 전달하기 위해 model 객체를 사용 (dtos 객체를 list 라는 이름으로 컨트롤러단으로 전송)
		model.addAttribute("list", dtos);
	}
}










