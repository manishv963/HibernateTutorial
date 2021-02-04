package com.hibernate.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class HibernateSecondLevelCache 
{
    public static void main( String[] args )
    {
        Student s = new Student();
        Student s1 = new Student();

        Configuration config = new Configuration().configure("hibernate.xml").addAnnotatedClass(Laptop.class);
       config.configure("hibernate.xml").addAnnotatedClass(Student.class);

        //config.addAnnotatedClass(Student.class);
        org.hibernate.service.ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        
        s = (Student) session.get(Student.class,112);
        
        System.out.println(s.toString());

        t.commit();
        session.close();
              
        Session session1 = sf.openSession();
        Transaction t1 = session1.beginTransaction();
        
       s1 = (Student) session1.get(Student.class,112);

        System.out.println(s1.toString());

        t1.commit();
        session1.close();
    }
}
