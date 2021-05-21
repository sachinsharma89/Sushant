package com.jtc.india;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class Jtc29B {
public static void main(String[] args) {
Transaction tx=null;
try{
SessionFactory sf=CHibernateUtil.getSessionFactory();
Session session=sf.openSession();
tx=session.beginTransaction();
System.out.println("\n1. All the Customers");
String SQL1="select * from Customers cts";
SQLQuery sq=session.createSQLQuery(SQL1);
/*sq=sq.addScalar("cid",Hibernate.Integer);
sq=sq.addScalar("cname",Hibernate.STRING);
sq=sq.addScalar("email",Hibernate.STRING);
sq=sq.addScalar("city",Hibernate.STRING);
sq=sq.addScalar("status",Hibernate.STRING); 
*/
List<Object[]> clist=sq.list();
for(Object obj[]:clist){
for(Object o:obj){
System.out.println(o+"\t");
}
System.out.println();
}
System.out.println("\n2. Emails of all the contacts");
String SQL4="select cts.email from customers cts";
SQLQuery sq1=session.createSQLQuery(SQL4);
//List<String> ems=sq1.addScalar("email",Hibernate.STRING).list();
//for(String str:ems){
//System.out.println(str);
//}
tx.commit();
session.close();
}catch(Exception e){
e.printStackTrace();
if(tx!=null){
tx.rollback();
}
}
}
}
