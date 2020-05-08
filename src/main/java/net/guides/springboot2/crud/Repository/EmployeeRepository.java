package net.guides.springboot2.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.crud.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
