package com.lgy.spring_mvc_board.command;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import com.lgy.spring_mvc_board.dao.BDao;

//게시글 저장
public class BWriteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		//DAO 에 있는 String bname, String btitle, String bcontent 값들이 필요
		//model 객체에서 꺼내서 전송
		Map<String, Object> map = model.asMap();
		
//		request : 컨트롤러단에서 보내주는 이름
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BDao dao = new BDao();
//		DAO 단 호출
		dao.write(bname, btitle, bcontent);
	}
}






