package org.zerock.controller.lecture.p01mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller01 {
	
	@RequestMapping("/ex01/sub01")
	public void method1() {
		System.out.println("메소드 1번");
	}
	
	@RequestMapping("/ex01/sub02")
	public void method2() {
		System.out.println("메소드 2번");
	}
	
	@RequestMapping("/ex01/sub03")
	public void method3() {
		System.out.println("method 333333333333333");
	}
}
