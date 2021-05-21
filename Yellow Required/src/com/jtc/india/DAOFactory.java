package com.jtc.india;

public class DAOFactory {
static CustomerDAO customerDAO = null;
static {
customerDAO = new HibernateCustomerDAO();
}
public static CustomerDAO getCustomerDAO(){
return customerDAO;
}
}

