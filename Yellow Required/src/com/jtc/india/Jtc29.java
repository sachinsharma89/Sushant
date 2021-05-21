package com.jtc.india;

import java.util.List;
public class Jtc29{
public static void main(String[] args) {
CustomerDAO cdao = DAOFactory.getCustomerDAO();
System.out.println("All Customers");
List<Customer> list = cdao.getAllCustomers();
for (Customer c : list) {
System.out.println(c);
}
System.out.println("\nCustomer by Status");
list = cdao.getCustomerByStatus("Active");
for (Customer c : list) {
System.out.println(c);
}
System.out.println("\nCustomers by email");
Customer c = (Customer) cdao.getCustomersByEmail("som@jtcindia.com");
System.out.println(c);
}
}

