/**
 * 
 */
package com.mindtree.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mindtree.dao.EventDao;
import com.mindtree.model.Employee;
import com.mindtree.model.Event;

/**
 * @author Nephilim
 *
 */
public class EventHibernateDao implements EventDao {

	
	@Override
	public void addEmployee(Session session, Employee employee) {
		// TODO Auto-generated method stub
		session.save(employee);
		
	}


	@Override
	public void addEvent(Session session, Event event) {
		// TODO Auto-generated method stub
		session.save(event);
	}


	@Override
	public Employee getEmployeeByMID(Session session, String mid) {
		// TODO Auto-generated method stub
		
		Query query = session.createQuery("from Employee e where e.mid=:mid");
		query.setParameter("mid", mid);
		
		List<Employee> emp = (List<Employee>)query.list(); 
		
		if(emp!=null && emp.size()>0){return emp.get(0);}
		else return null;
		
	}


	@Override
	public Event getEventByTitle(Session session, String title) {
		// TODO Auto-generated method stub
		Query query = session.createQuery("from Event e where e.title=:title");
		query.setParameter("title", title);
		
		List<Event>  event= (List<Event>)query.list(); 
		
		if(event!=null && event.size()>0)return event.get(0);
		else return null;
	}


	@Override
	public List<Employee> getAllEmployees(Session session) {
		// TODO Auto-generated method stub
		Query query = session.createQuery("from Employee e");

		List<Employee> emp = (List<Employee>) query.list();

		if (emp != null)
			return emp;
		else
			return null;
	}

}
