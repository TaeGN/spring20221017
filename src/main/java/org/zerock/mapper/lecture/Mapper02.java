package org.zerock.mapper.lecture;

import java.time.LocalDate;
import java.util.List;

public interface Mapper02 {
	
	public List<String> getCustomerNames();
	
	List<Integer> getCustomerIds();
	
	List<Double> getProductPrices();
	
	List<LocalDate> getBirthDate();
	
	List<String> getEmployeesFirstName();
	
	List<String> getEmployeesLastName();
}
