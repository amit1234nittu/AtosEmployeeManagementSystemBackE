package net.guides.springboot2.crud.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	
	
    private String first_name;
    private String last_name;
    private String email_address;
 
    public Employee() {
  
    }

	// TODO Auto-generated constructor stub
	

	public long getId() {
		return id;
	}

	public Employee(long id, String first_name, String last_name, String email_address) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_address = email_address;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
 
    

}
