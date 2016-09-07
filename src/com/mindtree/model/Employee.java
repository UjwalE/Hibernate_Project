/**
 * 
 */
package com.mindtree.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Nephilim
 *
 */
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
	
	//Synthetic identifier is created used as MID has business meaning
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	int id;
	
	@Column(name = "MID")
	String mid;
	
	@Column(name = "NAME")
	String name;
	
	@Column(name = "JOIN_DATE")
	Date dateOfJoinig;
	
	@Column(name = "EMAIL_ID")
	String emailId;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="EMPLOYEE_EVENT", 
				joinColumns={@JoinColumn(name="EMPLOYEE_ID")}, 
				inverseJoinColumns={@JoinColumn(name="EVENT_ID")})
	Set<Event> events = new HashSet<Event>();

	/**
	 * @param mid
	 * @param name
	 * @param dateOfJoinig
	 * @param emailId
	 * 
	 * Constructor for creating new Employee object so as to add an entry for a new employee 
	 */
	public Employee(String mid, String name, Date dateOfJoinig, String emailId) {
		this.mid = mid;
		this.name = name;
		this.dateOfJoinig = dateOfJoinig;
		this.emailId = emailId;
	}

	/*Setter & Getters pairs for the member variable of Employee*/
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the mid
	 */
	public String getMid() {
		return mid;
	}

	/**
	 * @param mid the mid to set
	 */
	public void setMid(String mid) {
		this.mid = mid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dateOfJoinig
	 */
	public Date getDateOfJoinig() {
		return dateOfJoinig;
	}

	/**
	 * @param dateOfJoinig the dateOfJoinig to set
	 */
	public void setDateOfJoinig(Date dateOfJoinig) {
		this.dateOfJoinig = dateOfJoinig;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	/**
	 * @return the events
	 */
	public Set<Event> getEvents() {
		return events;
	}

	/**
	 * @param events the events to set
	 */
	public void setEvents(Set<Event> events) {
		this.events = events;
	}



	/*hashCode() and equals() for comparison of Event Objects*/ 
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfJoinig == null) ? 0 : dateOfJoinig.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + id;
		result = prime * result + ((mid == null) ? 0 : mid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (dateOfJoinig == null) {
			if (other.dateOfJoinig != null) {
				return false;
			}
		} else if (!dateOfJoinig.equals(other.dateOfJoinig)) {
			return false;
		}
		if (emailId == null) {
			if (other.emailId != null) {
				return false;
			}
		} else if (!emailId.equals(other.emailId)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (mid == null) {
			if (other.mid != null) {
				return false;
			}
		} else if (!mid.equals(other.mid)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
	
	public void addEvent(Event event){
		this.events.add(event);
	}

	public Object getEventsAsString() {
		// TODO Auto-generated method stub
		String e ="";
		Iterator<Event> itr = this.events.iterator();
		while(itr.hasNext()){
			Event event = (Event)itr.next();
			e+= event.getTitle()+";";
		}
		return e;
	}
		
}
