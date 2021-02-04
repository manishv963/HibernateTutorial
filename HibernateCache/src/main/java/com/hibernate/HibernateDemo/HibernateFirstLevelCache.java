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
public class HibernateFirstLevelCache 
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
        s1 = (Student) session.get(Student.class,112);

        System.out.println(s.toString());
        System.out.println(s1.toString());

        t.commit();
        session.close();
                
    }
}
