package com.jtc.india;

import java.util.List;
public interface CustomerDAO {
public Customer getCustomersByEmail(String email);
public List<Customer> getAllCustomers();
public List<Customer> getCustomerByStatus(String status);
}