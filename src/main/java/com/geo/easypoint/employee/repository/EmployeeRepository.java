package com.geo.easypoint.employee.repository;

import com.geo.easypoint.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByJobTitle_Id(Long jobTitleId);

    boolean existsByCompetency_Id(Long competencyId);
}
