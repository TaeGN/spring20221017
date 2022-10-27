package org.zerock.controller.lecture.p07mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.lecture.JavaBean13;
import org.zerock.domain.lecture.JavaBean15;
import org.zerock.mapper.lecture.Mapper07;
import org.zerock.mapper.lecture.Mapper08;

@Controller
@RequestMapping("ex34")
public class Controller34 {
	
	@Autowired
	private Mapper07 mapper;
	
	@Autowired
	private Mapper08 mapper2;
	
	@RequestMapping("sub01")
	public void method1() {
		JavaBean13 category = mapper.getCategory();
		System.out.println(category.getId());
		System.out.println(category.getName());
		category.getProduct().forEach(p -> {
			System.out.println(p.getId() + " : " + p.getName() + " : " + p.getPrice());	
		});
	}
	
	@RequestMapping("sub02")
	public void method2() {
		JavaBean15 product = mapper.getProduct();
		System.out.println(product.getId());
		System.out.println(product.getName());
		product.getProduct().forEach(p -> System.out.println(p.getId() + " : "
										+ p.getName() + " : "
										+ p.getPrice()));
	}
	
	@RequestMapping("sub03")
	public void method3() {
		System.out.println("entity");
		mapper2.getProductName().forEach(System.out::println);
		
		System.out.println("CDATA");
		mapper2.getProductName().forEach(System.out::println);
	}
	
	@RequestMapping("sub04")
	public void method4() {
		mapper2.getEmployeeFirstName().forEach(System.out::println);
	}
}





