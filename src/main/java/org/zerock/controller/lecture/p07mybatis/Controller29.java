package org.zerock.controller.lecture.p07mybatis;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.mapper.lecture.Mapper02;

@Controller
@RequestMapping("ex29")
public class Controller29 {
	
	@Autowired
	private Mapper02 mapper;
	
	@RequestMapping("sub01")
	public void method1() {
		List<String> names = mapper.getCustomerNames();
		System.out.println(names.size());
		System.out.println(names.get(0));
		System.out.println(names.get(1));
	}
	
	@RequestMapping("sub02")
	public void method2() {
		List<Integer> ids = mapper.getCustomerIds();
		System.out.println(ids.size());
		for(int id : ids) {
			System.out.println(id);
		}
	}
	
	@RequestMapping("sub03")
	public void method3() {
		List<Double> priceList = mapper.getProductPrices();
		System.out.println(priceList.size());
		for(double price : priceList) {
			System.out.println(price);
		}
		
	}
	
	@RequestMapping("sub04")
	public void method4() {
		List<LocalDate> birthDates = mapper.getBirthDate();
		List<String> firstNameList = mapper.getEmployeesFirstName();
		List<String> lastNameList = mapper.getEmployeesLastName();
		
		System.out.println(birthDates.size());
		for(int i = 0; i < birthDates.size(); i++) {
			System.out.println(firstNameList.get(i) + " " + lastNameList.get(i) + " : " + birthDates.get(i));
		}
	}
}
