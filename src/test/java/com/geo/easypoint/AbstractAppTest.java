package com.geo.easypoint;

import com.geo.easypoint.employee.controller.CompetencyController;
import com.geo.easypoint.employee.controller.EmployeeController;
import com.geo.easypoint.employee.repository.CompetencyRepository;
import com.geo.easypoint.employee.repository.EmployeeRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AbstractAppTest {
    @Autowired
    protected EmployeeRepository employeeRepository;
    @Autowired
    protected EmployeeController employeeController;
    @Autowired
    protected CompetencyController competencyController;
    @Autowired
    protected CompetencyRepository competencyRepository;
}
