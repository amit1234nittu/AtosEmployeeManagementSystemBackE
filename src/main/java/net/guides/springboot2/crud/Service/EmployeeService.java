package net.guides.springboot2.crud.Service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import net.guides.springboot2.crud.Exception.ResourceNotFoundException;
import net.guides.springboot2.crud.Model.Employee;
import net.guides.springboot2.crud.Repository.EmployeeRepository;

@Repository
public class EmployeeService {
	
	@Autowired
    private EmployeeRepository employeeRepository;
	
	public List<Employee> retrieveEmployeeDetails(){
		
		List<Employee> emp = employeeRepository.findAll();
		
		return emp;
	}
	
	public Employee getEmployeeById(Long employeeId) throws ResourceNotFoundException{
		
		 Employee employee = employeeRepository.findById(employeeId)
		         .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return employee;
		
	}
	
	

	public Employee createEmployee(@Valid Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Long employeeId,Employee employeeDetails) throws ResourceNotFoundException{
		 
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		 employee.setEmail_address(employeeDetails.getEmail_address());
	     employee.setLast_name(employeeDetails.getLast_name());
	     employee.setFirst_name(employeeDetails.getFirst_name());
	     final Employee updatedEmployee = employeeRepository.save(employee);
		
		return updatedEmployee;
		
	}
	
	public void deleteEmployee(Long employeeId) throws ResourceNotFoundException{
		Employee employee = employeeRepository.findById(employeeId)
			       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

			        employeeRepository.delete(employee);
		
		
	}
	
	
}
