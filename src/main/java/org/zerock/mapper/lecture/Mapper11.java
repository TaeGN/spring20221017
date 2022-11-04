package org.zerock.mapper.lecture;

import org.zerock.domain.lecture.JavaBean18;
import org.zerock.domain.lecture.JavaBean19;

public interface Mapper11 {
	int updateCustomer(JavaBean18 customer);

	JavaBean18 getCustomerById(int id);
	
	int updateSupplier(JavaBean19 supplier);
	
	JavaBean19 getSupplierById(int id);

	int updateBank(int account, int money);

	int insertCustomer(JavaBean18 customer);
	
	int insertSupplier(JavaBean19 supplier);

	int deleteSupplier(int id);

	int deleteCustomer(int id);	
}
