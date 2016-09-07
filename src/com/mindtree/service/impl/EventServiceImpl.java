/**
 * 
 */
package com.mindtree.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.mindtree.dao.EventDao;
import com.mindtree.dao.impl.EventHibernateDao;
import com.mindtree.model.Employee;
import com.mindtree.model.Event;
import com.mindtree.service.EventService;

/**
 * @author Nephilim
 *
 */
public class EventServiceImpl implements EventService {
	
	EventDao eventDao = new EventHibernateDao();
	Session session = null;
	Transaction tx =null;
	
	@Override
	public void openSession() {
		// TODO Auto-generated method stub
		session = this.getSession();
		tx = session.beginTransaction(); 
	}
	
	public Session getSession(){
		Configuration configuration = new Configuration();
		configuration.configure("resources/hibernate.cfg.xml");
		ServiceRegistryBuilder srBuilder = new ServiceRegistryBuilder();
		srBuilder.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = srBuilder.buildServiceRegistry();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		return factory.openSession();
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		eventDao.addEmployee(session , employee);
	}

	@Override
	public void addEvent(Event event) {
		// TODO Auto-generated method stub
		eventDao.addEvent(session, event);
	}

	@Override
	public void closeSession() {
		// TODO Auto-generated method stub
		tx.commit();
		session.close();
		
	}

	@Override
	public void registerEmpForEvent(Employee emp1, Event event1) {
		// TODO Auto-generated method stub
				
		//Commented for Unidirectional mapping
		//event1.addEmployee(emp1);
		emp1.addEvent(event1);
		this.addEmployee(emp1);
		this.addEvent(event1);
	}

	@Override
	public Employee getEmpByMID(String mid) {
		// TODO Auto-generated method stub
		
		return eventDao.getEmployeeByMID(session,mid);
		
	}

	@Override
	public Event getEventByTitle(String title) {
		// TODO Auto-generated method stub
		return eventDao.getEventByTitle(session,title);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return eventDao.getAllEmployees(session);
	}

	
	

}
