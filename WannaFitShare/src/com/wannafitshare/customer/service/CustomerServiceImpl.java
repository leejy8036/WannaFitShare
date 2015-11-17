package com.wannafitshare.customer.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wannafitshare.customer.dao.CustomerDao;
import com.wannafitshare.customer.exception.CustomerNotFoundException;
import com.wannafitshare.customer.exception.DuplicatedIdException;
import com.wannafitshare.vo.Customer;

import common.util.PagingBean;

/**
 * 사전에 spring.xml 에서 component-scan 등록하여서 사용 
 * @Service : Model의 Business Service 클래스 bean 등록 
 * @Resource : 등록된 Bean의 이름과 매칭해서 주입
                              선언 위치 : instance 변수, 주입 받기 위한 메소드(매개변수가 하나 여야 함) 
                              속성 : name - 주입할 bean의 이름
 *             <CustomerDao 앞에 선언하여 bean 자동등록>	
 *             
 * Spring을 적용하지 않은 customerService와 다른점
 * 1. 싱글톤패턴으로 하지 않았다 - spring에서 기본값으로 만들면 싱글톤패턴이 된다.
 * 2. SqlSession을 받지 않는다 - TX작업 여기서 안함(SqlSession 객체를 만들 이유가 없음) -> Spring Container한테 맡길거임(spring한테 맡기겠다)             
 *
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	
	private CustomerDao dao;
	
	
	public CustomerServiceImpl() {
	}
	@Autowired
	public CustomerServiceImpl(CustomerDao dao){
		this.dao = dao;
	}
	
	
	/**
	 * 고객을 등록하는 메소드.
	 *  - 고객 id (id)는 중복될 수 없다.  
	 *  	- 등록하려는 고객의 id와 같은 id의 고객이 이미 등록된 경우 등록 처리 하지 않는다. 
	 * @param customer 등록할 고객 정보를 가진 Customer객체를 받을 매개변수.
	 * @throws DuplicatedIdException
	 * @throws SQLException 
	 */
	@Override
	public void addCustomer(Customer customer) throws DuplicatedIdException,SQLException{
			//등록할 고객의 id로 고객조회
			Customer cust = dao.selectCustomerById(customer.getCsId());
			if(cust != null){
				//이미 있는 고객ID이므로 예외발생 시킨다.
				throw new DuplicatedIdException(customer.getCsId()+"는 이미 등록된 ID입니다.");
			}
			//DB에 insert 
			dao.insertCustomer(customer);		
	}
	
	
	/**
	 * 매개변수로 받은 ID의 고객을 찾아 삭제 처리
	 *  - 매개변수로 받은 ID의 고객이 없으면 처리를 진행하지 않는다. 
	 * @param id
	 * @throws CustomerNotFoundException 삭제할 고객이 DB에 없으면 발생
	 * @throws SQLException 
	 */
	@Override
	public void removeCustomer(String csId) throws CustomerNotFoundException{
		Customer cust = dao.selectCustomerById(csId);
		if(cust==null){
			throw new CustomerNotFoundException(csId+"는 없는 ID이므로 삭제할 수 없습니다.");
		}
		dao.deleteCustomerById(csId);
	}

	/**
	 * 전체 고객들을 조회하는 메소드.
	 * @return 전체 List <Customer>
	 * @throws SQLException
	 */
	@Override
	public List<Customer> getAllCustomers(){
		return dao.selectCustomers();
	}
	
	/**
	 * id로 고객을 찾는 메소드
	 * @param id 조회할 고객의 ID
	 * @return customerList에서 조회한 고객객체에서 찾는 고객이 없으면 null을 리턴한다.
	 * @throws SQLException 
	 */
	@Override
	public Customer findCustomerById(String csId){
			return dao.selectCustomerById(csId);
	}
	
	/**
	 * 이름으로 고객을 조회하는 메소드
	 * @param name 조회할 고객의 이름
	 * @return customerList에서 조회된 고객들을 담아 리턴할 ArrayList
	 */
	@Override
	public List<Customer>  findCustomerByName(String customerName){
			return dao.selectCustomersByName(customerName);
	}
	
	/**
	 * 매개변수로 받은 고객과 같은 ID를 가진 고객정보를 찾아 수정 처리.
	 *  - 수정하려는 고객의 ID가 없는 경우 처리를 진행하지 않는다.
	 * @param newCust 변경할 고객 정보
	 * @throws SQLException 
	 * @throws CustomerNotFoundException 수정할 고객이 DB에 없으면 발생
	 */
	@Override
	public void updateCustomer(Customer newCust) throws CustomerNotFoundException{
			Customer cust = dao.selectCustomerById(newCust.getCsId());
			if(cust==null){
				throw new CustomerNotFoundException(newCust.getCsId()+"는 없는 ID이므로 수정할 수 없습니다.");
			}
			dao.updateCustomer(newCust);
	}
	
	/**
	 * 페이징 처리
	 */
	@Override
	public Map getAllCustomersPaging(int pageNo){
		HashMap map = new HashMap();
		map.put("list", dao.selectCustomersPaging(pageNo));
		PagingBean pagingBean = new PagingBean(dao.selectCountCustomers(), pageNo);
		map.put("pagingBean", pagingBean);
		return map;
	}
	
}//class
