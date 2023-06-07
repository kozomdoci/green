package com.lgy.spring_mvc_board.command;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import com.lgy.spring_mvc_board.dao.BDao;
import com.lgy.spring_mvc_board.dto.BDto;

public class BContentCommand implements BCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bid = request.getParameter("bid");
		
		//DAO 호출
		BDao dao = new BDao();
		//contentView 메소드에 글번호(bid)를 넘겨서 select 쿼리 수행 => 게시글 하나의 내용을 BDto 객체로 리턴 받음
		BDto dto = dao.contentView(bid);
		//dto 객체를 model 객체에 추가 (뷰에서 꺼내 사용할 수 있음) (dtos 객체를 content_view 라는 이름으로 컨트롤러단으로 전송) 
		model.addAttribute("content_view", dto);
	}
	
}





