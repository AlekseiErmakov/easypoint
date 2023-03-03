package com.geo.easypoint.impl.employee.repository;

import com.geo.easypoint.impl.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
