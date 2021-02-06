package com.hibernate.HibernateDemo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class HibernateQueryLanguagePart1 
{
    public static void main( String[] args )
    {
     
        Configuration config = new Configuration().configure("hibernate.xml").addAnnotatedClass(Laptop.class);
       config.configure("hibernate.xml").addAnnotatedClass(Student.class);

        org.hibernate.service.ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        

        Query q = session.createQuery("from Student");
        List<Student> sList =  q.list();
        for(Student s: sList)
        	System.out.println(s.toString());
        q = session.createQuery("from Student where rollno < 5 ");
         sList =  q.list();
        for(Student s: sList)
        	System.out.println(s.toString());
        
         q = session.createQuery("from Student where rollno  = 11 ");
        Student s =  (Student) q.uniqueResult();
        System.out.println(s.toString());
        
        //s = (Student) session.get(Student.class,112);
        
        t.commit();
        session.close();
                
    }
}
