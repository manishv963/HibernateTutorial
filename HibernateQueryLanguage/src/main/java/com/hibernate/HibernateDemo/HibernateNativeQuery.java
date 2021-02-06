package com.hibernate.HibernateDemo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateNativeQuery {
    public static void main( String[] args )
    {
     
        Configuration config = new Configuration().configure("hibernate.xml").addAnnotatedClass(Laptop.class);
       config.configure("hibernate.xml").addAnnotatedClass(Student.class);

        org.hibernate.service.ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();

        //s = (Student) session.get(Student.class,112);

        SQLQuery sql = session.createSQLQuery("select rollno,name from Student where rollno > 10 ");
        sql.addEntity(Student.class);
        List<Student> studList = sql.list();
        for(Student s : studList)
        	System.out.println(s.getName());
        
        
        t.commit();
        session.close();
                
    }

}
