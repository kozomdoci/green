package com.lgy.spring_mvc_board_std.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgy.spring_mvc_board_std.dto.BDto;
import com.lgy.spring_mvc_board_std.service.BService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BController {
//	service imple 단으로 넘아갔기 때문에 SqlSession 필요 없음 
//	@Autowired
//	private SqlSession sqlSession;

	@Autowired
	private BService service;
	
	@RequestMapping("/list")
	public String list(Model model) {
		log.info("@# list in BControoler");

//		IBDao dao = sqlSession.getMapper(IBDao.class);
//		model.addAttribute("list", dao.list());
		ArrayList<BDto> list = service.list();
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping("/write")
//	public String write(HttpServletRequest request, Model model) {
	public String write(@RequestParam HashMap<String, String> param) {
		log.info("@# write in BControoler");
		
//		IBDao dao = sqlSession.getMapper(IBDao.class);
//		dao.write(request.getParameter("bname")
//				, request.getParameter("btitle")
//				, request.getParameter("bcontent"));
		service.write(param);
		
		return "redirect:list";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("@# write_view in BControoler");
		
		return "write_view";
	}
	
	@RequestMapping("/content_view")
//	public String content_view(HttpServletRequest request, Model model) {
	public String content_view(@RequestParam HashMap<String, String> param, Model model) {
		log.info("@# content_view in BControoler");
		
//		IBDao dao = sqlSession.getMapper(IBDao.class);
//		model.addAttribute("content_view", dao.contentView(request.getParameter("bid")));
		BDto dto = service.contentView(param);
		model.addAttribute("content_view", dto);
		
		return "content_view";
	}
	
	@RequestMapping("/modify")
//	public String modify(HttpServletRequest request, Model model) {
	public String modify(@RequestParam HashMap<String, String> param) {
		log.info("@# modify in BControoler");
		
//		IBDao dao = sqlSession.getMapper(IBDao.class);
//		dao.modify(request.getParameter("bid")
//				, request.getParameter("bname")
//				, request.getParameter("btitle")
//				, request.getParameter("bcontent"));
		service.modify(param);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
//	public String delete(HttpServletRequest request, Model model) {
	public String delete(@RequestParam HashMap<String, String> param) {
		log.info("@# delete in BControoler");
		
//		IBDao dao = sqlSession.getMapper(IBDao.class);
//		dao.delete(request.getParameter("bid"));
		service.delete(param);
		
		return "redirect:list";
	}
}




















