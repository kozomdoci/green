package com.lgy.spring_mvc_board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lgy.spring_mvc_board.command.BCommand;
import com.lgy.spring_mvc_board.command.BContentCommand;
import com.lgy.spring_mvc_board.command.BDeleteCommand;
import com.lgy.spring_mvc_board.command.BListCommand;
import com.lgy.spring_mvc_board.command.BModifyCommand;
import com.lgy.spring_mvc_board.command.BWriteCommand;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BController {
	// 인터페이스로 객체를 미리 생성하면 조회,저장,수정,삭제 등의 작업을 할 때마다 매번 객체 생성할 필요 없음
	BCommand command;
	
	// 게시판 목록 조회
	@RequestMapping("/list")
	public String list(Model model) {
		log.info("@# list method in BControoler");
		
		// Service(command)단 호출
//		BListCommand command = new BListCommand();
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	//게시글 저장
	//request : 뷰에서 값을 받아옴
	//model : 뷰로 값을 넘김
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# write method in BControoler");
		
		//request 객체에 String bname, String btitle, String bcontent 값들이 있음
		model.addAttribute("request", request);
		//command 단 호출
		command = new BWriteCommand();
		//model 에 request 를 담고 있음
		command.execute(model);
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("@# write_view in BControoler");
		
		return "write_view";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		log.info("@# content_view in BControoler");
		
		//request 객체에 bid 값이 담겨있음
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		log.info("@# modify in BControoler");
		
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		log.info("@# delete in BControoler");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
}




















