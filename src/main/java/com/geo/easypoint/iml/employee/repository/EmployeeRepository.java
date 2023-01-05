package com.geo.easypoint.iml.employee.repository;

import com.geo.easypoint.iml.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
