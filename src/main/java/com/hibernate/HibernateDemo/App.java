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
public class App 
{
    public static void main( String[] args )
    {
        Student s =  new Student();
        s.setRollno(1);
        s.setName("manish");
        
        Configuration config = new Configuration().configure("hibernate.xml").addAnnotatedClass(Student.class);
        org.hibernate.service.ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        session.save(s);
        t.commit();
        session.close();
        
        
    }
}
