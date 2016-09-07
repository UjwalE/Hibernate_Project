/**
 * 
 */
package com.mindtree.service;

import java.util.List;

import org.hibernate.Session;

import com.mindtree.model.Employee;
import com.mindtree.model.Event;

/**
 * @author Nephilim
 *
 */
public interface EventService {
	
	public Session getSession();

	public void addEmployee(Employee employee);

	public void addEvent(Event event);

	public void openSession();

	public void closeSession();

	public void registerEmpForEvent(Employee emp1, Event event1);

	public Employee getEmpByMID(String mid);

	public Event getEventByTitle(String title);

	public List<Employee> getAllEmployees();
}
