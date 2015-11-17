package com.wannafitshare.customer.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wannafitshare.vo.Customer;

import common.util.PagingBean;


/**
 * Customer테이블과 연동하는 DAO 클래스
 * Transaction은 Business Service(CustomerService)에서 처리해야 하므로 
 * 모든 메소드들은 Connection을 받아서 처리한다.
 * 
 * @Repository : Model의 DAO 클래스 빈 등록
 */
///////////////////////////////////////////////////////////////////////////


@Repository
public class CustomerDaoImpl implements CustomerDao {

	
	private SqlSessionTemplate session; //no-arg생성자로 객체생성후 instance변수 

	@Autowired
	public CustomerDaoImpl(SqlSessionTemplate session) {
		this.session = session;
	}
	public CustomerDaoImpl() {
	}

	@Override
	public int insertCustomer(Customer customer) {
		return session.insert("customerMapper.insertCustomer", customer);
	}
		
	@Override
	public int deleteCustomerById(String csId){
		return session.delete("customerMapper.deleteCustomerById", csId);
	}
	
	@Override
	public int updateCustomer(Customer customer){
		return session.update("customerMapper.updateCustomer", customer);
	}
	
	@Override
	public Customer selectCustomerById(String customerId){
		return session.selectOne("customerMapper.selectCustomerById", customerId);
	}
	
	@Override
	public List<Customer> selectCustomers(){
		return session.selectList("customerMapper.selectCustomers");
	}
	
	@Override
	public List<Customer> selectCustomersPaging(int pageNo){
		HashMap map = new HashMap();
		map.put("contentsPerPage", PagingBean.CONTENTS_PER_PAGE);
		map.put("pageNo", pageNo);
		List<Customer> list = session.selectList("customerMapper.selectCustomersPaging", map);
		return list;
	}
	
	@Override
	public List<Customer> selectCustomersByName(String customerName){
		return session.selectList("customerMapper.selectCustomersByName", customerName);
	}	
	
	@Override
	public int selectCountCustomers(){
		return session.selectOne("customerMapper.selectCountCustomers");
	}
}
