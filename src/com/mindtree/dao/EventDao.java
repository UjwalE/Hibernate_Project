/**
 * 
 */
package com.mindtree.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mindtree.model.Employee;
import com.mindtree.model.Event;

/**
 * @author Nephilim
 *
 */
public interface EventDao {

	void addEmployee(Session session, Employee employee);

	void addEvent(Session session, Event event);

	Employee getEmployeeByMID(Session session, String mid);

	Event getEventByTitle(Session session, String title);

	List<Employee> getAllEmployees(Session session);

}
