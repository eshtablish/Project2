package Inheritance.Inheritance;


import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf=new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(FresherEmployee.class).addAnnotatedClass(ExperienceEmployee.class);
	
		SessionFactory sf=conf.buildSessionFactory();	
		Session ses=sf.openSession();
		
		Transaction tc=ses.beginTransaction();
		
		FresherEmployee f1= new FresherEmployee();
		f1.setEmpId(1);
		f1.setEmpName("Preethi");
		f1.setContractPeriod(4);
		f1.setIncrement(5);
		
		FresherEmployee f2= new FresherEmployee();
		f2.setEmpId(2);
		f2.setEmpName("Swathi");
		f2.setContractPeriod(5);
		f2.setIncrement(4);
		
		FresherEmployee f3= new FresherEmployee();
		f3.setEmpId(3);
		f3.setEmpName("Sneha");
		f3.setContractPeriod(7);
		f3.setIncrement(6);
		
		ExperienceEmployee e1=new ExperienceEmployee();
		e1.setEmpId(4);
		e1.setEmpName("Ramya");
		e1.setExperience(7);
		e1.setHike(15);
		
		ExperienceEmployee e2=new ExperienceEmployee();
		e2.setEmpId(5);
		e2.setEmpName("Santhosh");
		e2.setExperience(3);
		e2.setHike(5);
		
		ExperienceEmployee e3=new ExperienceEmployee();
		e3.setEmpId(6);
		e3.setEmpName("Akshay");
		e3.setExperience(7);
		e3.setHike(15);
		
		ses.save(e3);
		ses.save(e2);
		ses.save(e1);
		ses.save(f3);
		ses.save(f2);
		ses.save(f1);
		
		tc.commit();
	
		
	}

}

