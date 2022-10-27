package org.zerock.controller.lecture.p07mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.lecture.JavaBean18;
import org.zerock.domain.lecture.JavaBean19;
import org.zerock.mapper.lecture.Mapper10;


@Controller
@RequestMapping("ex36")
public class Controller36 {
	
	@Autowired
	private Mapper10 mapper;
	
	@RequestMapping("sub01")
	public void method1() {
		int a = mapper.removeCustomer();
		System.out.println(a + "개 삭제됨");
	}
	
	@RequestMapping("sub02")
	public void method2() {
		int cnt = mapper.removeEmployee(); // 1번 직원 삭제
		System.out.println(cnt + "개 직원 레코드 삭제됨");
	}
	
	@RequestMapping("sub03")
	public void method3(int id) {
		int cnt = mapper.removeCustomerById(id);
		System.out.println(cnt + "개 고객 레코드 삭제됨");
	}
	
	@RequestMapping("sub04")
	public void method4(@RequestParam(name = "id", defaultValue = "0") int id) {
		int cnt = mapper.removeEmployeeBtId(id);
		System.out.println(cnt + "개 직원 레코드 삭제됨");
	}
	
	@RequestMapping("sub05")
	public void method5() {
		int cnt = mapper.addCustomer();
		System.out.println(cnt + "개 고객 정보 입력됨");
	}
	
	@RequestMapping("sub06")
	public void method6() {
		int cnt = mapper.addSupplier();
		System.out.println(cnt + "개 공급자 정보 입력됨");
	}
	
	@GetMapping("sub07")
	public void custormerForm() {
		
	}
	
	@PostMapping("sub07")
	public void method7(JavaBean18 c) {
		int cnt = mapper.insertCustomer(c);
		System.out.println(cnt + "개 고객 정보 입력됨");
	}
	
	@GetMapping("sub08")
	public void supplierForm() {
		
	}
	
	@PostMapping("sub08")
	public void method8(JavaBean19 supplier) {
		int cnt = mapper.insertSupplier(supplier);
		System.out.println(cnt + "개 공급자 정보 입력됨");
	}
}
