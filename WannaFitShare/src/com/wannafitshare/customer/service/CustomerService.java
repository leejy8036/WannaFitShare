package com.wannafitshare.customer.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.wannafitshare.customer.exception.CustomerNotFoundException;
import com.wannafitshare.customer.exception.DuplicatedIdException;
import com.wannafitshare.vo.Customer;

public interface CustomerService {
	
	/**
	 * 고객을 등록하는 메소드.
	 *  - 고객 id (id)는 중복될 수 없다.  
	 *  	- 등록하려는 고객의 id와 같은 id의 고객이 이미 등록된 경우 등록 처리 하지 않는다. 
	 * @param customer 등록할 고객 정보를 가진 Customer객체를 받을 매개변수.
	 * @throws DuplicatedIdException
	 * @throws SQLException 
	 */
	void addCustomer(Customer customer) throws DuplicatedIdException,SQLException;

	
	/**
	 * 매개변수로 받은 ID의 고객을 찾아 삭제 처리
	 *  - 매개변수로 받은 ID의 고객이 없으면 처리를 진행하지 않는다. 
	 * @param id
	 * @throws CustomerNotFoundException 삭제할 고객이 DB에 없으면 발생
	 * @throws SQLException 
	 */
	void removeCustomer(String customerId) throws CustomerNotFoundException;

	
	/**
	 * 전체 고객들을 조회하는 메소드.
	 * @return 전체 List <Customer>
	 * @throws SQLException
	 */
	List<Customer> getAllCustomers();

	
	/**
	 * id로 고객을 찾는 메소드
	 * @param id 조회할 고객의 ID
	 * @return customerList에서 조회한 고객객체에서 찾는 고객이 없으면 null을 리턴한다.  
	 */
	Customer findCustomerById(String customerId);

	/**
	 * 이름으로 고객을 조회하는 메소드
	 * @param name 조회할 고객의 이름
	 * @return customerList에서 조회된 고객들을 담아 리턴할 ArrayList
	 */
	List<Customer> findCustomerByName(String customerName);
	
	/**
	 * 매개변수로 받은 고객과 같은 ID를 가진 고객정보를 찾아 수정 처리.
	 *  - 수정하려는 고객의 ID가 없는 경우 처리를 진행하지 않는다.
	 * @param newCust 변경할 고객 정보
	 * @throws CustomerNotFoundException 수정할 고객이 DB에 없으면 발생
	 * @throws SQLException
	 */
	void updateCustomer(Customer newCust) throws CustomerNotFoundException,SQLException;
	
	/**
	 * 페이징 처리 
	 * @param pageNo
	 * @return
	 */
	Map getAllCustomersPaging(int pageNo);
}
