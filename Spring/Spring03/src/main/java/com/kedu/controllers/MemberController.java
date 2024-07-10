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
import com.kedu.services.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

   @Autowired
   private HttpSession session;
   
   @Autowired
   private MemberService memberService;
   
   @RequestMapping("/join")
   public String join() throws Exception{
      return "member/join";
   }
   
   @ResponseBody
   @RequestMapping(value="/idcheck", produces="text/html;charset=utf8")
   public String idcheck(String id) throws Exception{
      boolean result = memberService.idExitst(id);
      return String.valueOf(result);
   }
   
   @RequestMapping("/joinProc")
   public String insert(MemberDTO dto) throws Exception{
	  memberService.memberInsert(dto);
      return "redirect:/";
   }
   
   @RequestMapping("/login")
   public String login(MemberDTO dto) throws Exception{
      boolean result = memberService.login(dto);
      if(result) {
    	  session.setAttribute("loginID", dto.getId());
      }
      return "redirect:/";
   }
   
   @RequestMapping("/logout")
   public String logout() throws Exception{
      session.invalidate();
      return "redirect:/";
   }
   
   @RequestMapping("/delete")
   public String delete() throws Exception{
      String id=(String)session.getAttribute("loginID");
      memberService.memberDelete(id);
      session.invalidate();
      return "redirect:/";
   }
  
   @RequestMapping("/update")
   public String update(String name) throws Exception{
      String id =(String)session.getAttribute("loginID");
      memberService.memberUpdate(id,name);
      return "redirect: /member/mypage";
   }
   
   @RequestMapping("/mypage")
   public String mypage(Model model) throws Exception{
      String id = (String)session.getAttribute("loginID");
      MemberDTO dto = memberService.mypage(id);
      model.addAttribute("dto",dto);
      return "member/mypage";
   }
   
   
   //try-catch축약
   @ExceptionHandler(Exception.class)
   public String exceptionHandler(Exception e) {
      e.printStackTrace();
      return "error";   
   }
}
