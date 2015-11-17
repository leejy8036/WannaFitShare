package com.wannafitshare.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wannafitshare.customer.exception.DuplicatedIdException;
import com.wannafitshare.customer.service.CustomerService;
import com.wannafitshare.vo.Customer;

import common.validator.CustomerValidator;


/**
  * @RequestMapping - 요청 URL 등록
  * 				- 요청 url 등록  value="url" 
  * 			    - 요청 방식 등록 : method=GET/POST : RequestMethod 선언된 상수이용
  * 				- 생략 : get/post 모두 처리.	
  * hello.do로 url 경로로 post방식의 요청을 처리하는 handler(controller)메소드 ......
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	//고객 ID로 고객 조회 처리 Handler
	@RequestMapping("/findById")
	public String findById(@RequestParam String csId, ModelMap model){
		Customer customer = service.findCustomerById(csId);
		model.addAttribute("customer", customer);
		return "customer/customer_info.tiles";
	}
	
	@RequestMapping("/findByName")
	public	String findByName(@RequestParam String csName,ModelMap model){
		List<Customer> list =service.findCustomerByName(csName);
		model.addAttribute("namelist",list);
		return "customer/search_success.tiles";
	}
	//고객 List 조회처리 Handler
	@RequestMapping("list")
	public String list(@RequestParam(defaultValue="1") String pageNo, ModelMap model){
		int page = 1;
		try {
			page = Integer.parseInt(pageNo); //null일 경우 예외처리를 통해 page를 1로 처리한다..
		} catch (NumberFormatException e) {}
		Map attributes = service.getAllCustomersPaging(page);
		model.addAllAttributes(attributes);
		return "customer/list.tiles";
	}
	//고객 등록 처리 Handler
	@RequestMapping("add")
	public String add(@ModelAttribute Customer customer, Errors errors, ModelMap model) throws DuplicatedIdException, SQLException{
		
		new CustomerValidator().validate(customer, errors);
		if(errors.hasErrors()){
			return "customer/register_form.tiles";
		}
		service.addCustomer(customer);
		model.addAttribute("csId", customer.getCsId());
		return "redirect:/customer/registerSuccess.do"; 
	}
	//등록 후 성공페이지로 이동 처리.
	@RequestMapping("registerSuccess")
	public String registerSuccess(@RequestParam String csId, ModelMap model){
		
		model.addAttribute("customer", service.findCustomerById(csId));
		return "customer/register_success.tiles";
	}
	//수정폼 조회 처리 Handler
	@RequestMapping("modifyForm")
	public String modifyForm(@RequestParam(defaultValue="") String csId, ModelMap model)
	throws Exception{
//		요청파라미터 검증..wjidqwi
		if(csId.trim().length()==0){
			throw new Exception("수정할 고객의 아이디가 없습니다.");
		}

		model.addAttribute("customer",service.findCustomerById(csId));

		return "customer/modify_form.tiles";
	}
	//수정 처리 Handler
	@RequestMapping("modify")
	public String modify(@ModelAttribute Customer customer, Errors errors, @RequestParam(defaultValue="1") String pageNo, ModelMap model)
	throws Exception{
		//Validator를 이용해 요청파라미터 체크
		new CustomerValidator().validate(customer, errors);
	
		if (errors.hasErrors()) {
			return "customer/modify_form.tiles";
		}
		service.updateCustomer(customer);
		model.addAttribute("csId", customer.getCsId());
		model.addAttribute("pageNo", pageNo);
		return "redirect:/customer/findById.do";
	}
	//고객 삭제 처리 HandlerattributeValue
	@RequestMapping("remove.do")
	public String remove(@RequestParam(defaultValue="") String csId, @RequestParam(defaultValue="1") String pageNo, ModelMap model)
	throws Exception{
		//요청파라미터 검증
		if(csId.trim().length()==0){
			throw new Exception("삭제할 고객의 아이디가 없습니다.");
		}
		//비지니스 로직 - 삭제처리(removeCustomer())
		service.removeCustomer(csId);
		model.addAttribute("pageNo",pageNo);
		//응답
		return "redirect:/customer/list.do"; 
	}
	
	@RequestMapping("idDuplicatedCheck")
	@ResponseBody
	public String idDuplicatedCheck(@RequestParam String csId){
		Customer cust = service.findCustomerById(csId);
		return String.valueOf(cust!=null); //중복인 경우 "true" 리턴
	}
	

}
