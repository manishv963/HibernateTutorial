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
public class HibernateQueryLanguagePart2 
{
    public static void main( String[] args )
    {
     
        Configuration config = new Configuration().configure("hibernate.xml").addAnnotatedClass(Laptop.class);
       config.configure("hibernate.xml").addAnnotatedClass(Student.class);

        org.hibernate.service.ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();

        //s = (Student) session.get(Student.class,112);
     
     
        
        Query q = session.createQuery("select rollno from Student where rollno = 10 "); 
        Integer studentObject1 =   (Integer) q.uniqueResult();
        System.out.println(studentObject1);
         q= session.createQuery("select rollno,name from Student where rollno = 10 "); 
        Object[] studentObject =  (Object[]) q.uniqueResult();
        System.out.println(studentObject[0] + " "+studentObject[1] );
        //s = (Student) session.get(Student.class,112);
        int b = 3;
        q= session.createQuery("select rollno,name from Student where rollno < :b ");
        q.setParameter("b", b);
        List<Object[]> studentObjectList =  (List<Object[]>) q.list();
        
        for(Object[] o : studentObjectList)
        	System.out.println(o[0] + " "+o[1] );
        t.commit();
        session.close();
                
    }
}
