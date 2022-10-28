package org.zerock.mapper.lecture;

import org.zerock.domain.lecture.JavaBean18;
import org.zerock.domain.lecture.JavaBean19;

public interface Mapper10 {
	int removeCustomer();
	
	int removeEmployee();
	
	int removeCustomerById(int id);
	
	int removeEmployeeBtId(int id);
	
	int addCustomer();
	
	int addSupplier();
	
	int insertCustomer(JavaBean18 bean1);
	
	int insertSupplier(JavaBean19 bean2);
	
	int insertCustomerAndGetKey(JavaBean18 bean);
	
	int insertSupplierAndGetKey(JavaBean19 bean);
}
