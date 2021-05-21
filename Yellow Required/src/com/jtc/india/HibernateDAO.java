package com.jtc.india;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class HibernateDAO implements CustomerDAO {
@Override
public Customer getCustomersByEmail(String email) {
Transaction tx=null;
Customer cust=null;
try{
SessionFactory sf=CHibernateUtil.getSessionFactory();
Session session=sf.openSession();
tx=session.beginTransaction();
String SQL2="select {cts.*} from customers cts where cts.email=?";
SQLQuery sq2=session.createSQLQuery(SQL2);
sq2.setString(0, email);
List<Customer> list=sq2.addEntity("cts",Customer.class).list();
if(list.size()>0)
cust=list.get(0);
tx.commit();
session.close();
}catch(Exception e){
e.printStackTrace();
}
return cust;
}
@Override
public List<Customer> getAllCustomers() {
Transaction tx=null;
List<Customer> list=null;
try{
SessionFactory sf=CHibernateUtil.getSessionFactory();
Session session=sf.openSession();
tx=session.beginTransaction();
String SQL1="select {cts.*} from customers cts";
SQLQuery sq1=session.createSQLQuery(SQL1);
list=sq1.addEntity("cts",Customer.class).list();
tx.commit();
session.close();
}catch(Exception e){
e.printStackTrace();
}
return list;
}
@Override
public List<Customer> getCustomerByStatus(String status) {
Transaction tx=null;
List<Customer> list=null;
try{
SessionFactory sf=CHibernateUtil.getSessionFactory();
Session session=sf.openSession();
tx=session.beginTransaction();
String SQL3="select {cts.*} from customers cts where cts.status= :sts";
SQLQuery sq3=session.createSQLQuery(SQL3);
sq3.setString("sts", "Active");
list=sq3.addEntity("cts",Customer.class).list();
tx.commit();
session.close();
}catch(Exception e){
e.printStackTrace();
}
return list;
}
}
