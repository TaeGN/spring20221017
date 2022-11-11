package org.zerock.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.member.MemberDto;
import org.zerock.service.member.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("signup")
	public void signup() {
		
	}
	
	@PostMapping("signup")
	public String signup(
			MemberDto member,
			RedirectAttributes rttr) {
		System.out.println(member);
		
		int cnt = service.insert(member);
		
		// 가입 ok
		rttr.addFlashAttribute("message", "회원가입 되었습니다.");
		return "redirect:/board/list";
		
		
	}
	
	@GetMapping("list")
	public void list(Model model) {
		model.addAttribute("memberList", service.list());
	}
}












