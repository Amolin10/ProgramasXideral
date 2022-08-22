package com.client.rest.service;

import java.util.List;
import com.client.rest.model.Deportista;

public interface CustomerService {

	public List<Deportista> getCustomers();

	public void saveCustomer(Deportista theCustomer);

	public Deportista getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
