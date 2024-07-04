package com.kedu.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kedu.dao.MemberDAO;
import com.kedu.dto.MemberDTO;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/login")
	public String login(MemberDTO dto) throws Exception {
		int result = memberDAO.login(dto);
		if(result == 1) session.setAttribute("loginID", dto.getId());
		
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("/logout")
	public String logout() throws Exception {
		session.invalidate();
		
		return "ok";
	}
	
	@RequestMapping("/join")
	public String join() throws Exception {
		
		return "member/join";
	}
	
	@ResponseBody
	@RequestMapping(value="/idcheck", produces="text/html;charset=utf8")
	public String idcheck(String id) throws Exception {
		boolean result = memberDAO.idcheck(id);
		
		return String.valueOf(result);
	}
	
	@RequestMapping("/joinProc")
	public String joinProc(MemberDTO dto) throws Exception {
		memberDAO.joinProc(dto);
		
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String delete(String id) throws Exception {
		String resultStr = "fail";
		int result = memberDAO.memberDelete(id);
		if(result > 0) {
			session.invalidate();
			resultStr = "ok";
		}
		
		return resultStr;
	}
	
	@RequestMapping("/mypage")
	public String mypage(Model model) throws Exception {
		MemberDTO dto = memberDAO.memberInfo((String)session.getAttribute("loginID"));
		model.addAttribute("dto", dto);
		
		return "member/mypage";
	}
	
	@RequestMapping("/update")
	public String update(String name) throws Exception {
		memberDAO.update((String)session.getAttribute("loginID"), name);
		
		return "redirect:/member/mypage";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		
		return "error";
	}
	
}
