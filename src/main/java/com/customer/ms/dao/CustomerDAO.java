package com.customer.ms.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.customer.ms.model.Customer;

@Repository
public class CustomerDAO {
	
	private static final Map<String, Customer> cusMap= new HashMap<String, Customer>();
	
	static {
		initCus();
	}
	
	private static void initCus() {
		Customer Cus1= new Customer("C01", "Smith", "NY");
		Customer Cus2= new Customer("C02", "John", "CT");
		Customer Cus3= new Customer("C03", "Ethan", "CA");
		
		cusMap.put(Cus1.getCusId(), Cus1);
		cusMap.put(Cus2.getCusId(), Cus2);
		cusMap.put(Cus3.getCusId(), Cus3);
	}
	
	public Customer getCustomer(String cusID) {
		return cusMap.get(cusID);
	}
	
	public List<Customer> getAllCustomers(){
		Collection<Customer> c= cusMap.values();
		List<Customer> list= new ArrayList<Customer>();
		list.addAll(c);
		return list;
	}
	
	public Customer addCustomer(Customer cus) {
		cusMap.put(cus.getCusId(), cus);
		return cus;
	}
	
	public Customer updateCustomer(Customer cus) {
		if(cusMap.containsKey(cus.getCusId())) {
			cusMap.remove(cus.getCusId());
			cusMap.put(cus.getCusId(), cus);
			return cus;
		}
		return null;
	}
	
	public void removeCustomer(String cusId) {
			cusMap.remove(cusId);
	}
}
