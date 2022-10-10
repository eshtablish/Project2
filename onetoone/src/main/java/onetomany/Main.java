package onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf=new Configuration().configure().addAnnotatedClass(student.class).addAnnotatedClass(laptop.class);
		
		SessionFactory sf=conf.buildSessionFactory();
		Session ses=sf.openSession();
		
		Transaction tc=ses.beginTransaction();
		
		student s1=new student();
		s1.setSid(1);
		s1.setSname("preethi");
		s1.setSdomain("java");
		
		laptop l1=new laptop();
		l1.setLaptopId(101);
		l1.setLaptopName("HP");
		
		laptop l2=new laptop();
		l2.setLaptopId(102);
		l2.setLaptopName("Lenova");
		
		laptop l3=new laptop();
		l3.setLaptopId(103);
		l3.setLaptopName("Dell");
		
		
		List<laptop> ll=new ArrayList<laptop>();
		ll.add(l1);
		ll.add(l2);
		ll.add(l3);
		
		
		s1.setSlaptop(ll);
		ses.save(s1);
		ses.save(l1);
		ses.save(l2);
		ses.save(l3);
		
		
		tc.commit();
	}
}

