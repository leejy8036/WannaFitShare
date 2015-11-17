package com.wannafitshare.main;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wannafitshare.customer.exception.DuplicatedIdException;
import com.wannafitshare.customer.service.CustomerService;

import com.wannafitshare.vo.Customer;

public class TestCustomer {
	public static void main(String[] args) throws DuplicatedIdException, SQLException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("common/config/spring/customer-spring.xml");
		
		//CustomerService 주입받기기
		CustomerService service = (CustomerService)context.getBean("CustomerService");
		System.out.println("-----------------------전체 조회------------------");
		List <Customer> list = service.getAllCustomers();
		for(Customer cust : list){
			System.out.println(cust);
		}
		
		String id="ljy8036";
		Customer customer = new Customer(id, "1111", "이재영", "leejy803@daum.net","010-6363-0844");
		//service.addCustomer(customer);
		
		System.out.printf("--------------------ID %s로 조회----------------%n", id);
		System.out.println(service.findCustomerById(id));
		
	}//main
}//class
