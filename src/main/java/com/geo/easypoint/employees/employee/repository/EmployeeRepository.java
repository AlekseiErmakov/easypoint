package com.geo.easypoint.employees.employee.repository;

import com.geo.easypoint.employees.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByJobTitle_Id(Long jobTitleId);

    boolean existsByCompetency_Id(Long competencyId);
}
