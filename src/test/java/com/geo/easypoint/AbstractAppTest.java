package com.geo.easypoint;

import com.geo.easypoint.employees.competency.web.CompetencyController;
import com.geo.easypoint.employees.employee.controller.EmployeeController;
import com.geo.easypoint.employees.jobtitle.web.JobTittleController;
import com.geo.easypoint.employees.competency.domain.CompetencyRepository;
import com.geo.easypoint.employees.employee.repository.EmployeeRepository;
import com.geo.easypoint.employees.jobtitle.domain.JobTitleRepository;
import com.geo.easypoint.tool.plummet.domain.PlummetRepository;
import com.geo.easypoint.tool.plummet.web.PlummetController;
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
    @Autowired
    protected JobTittleController jobTittleController;
    @Autowired
    protected JobTitleRepository jobTitleRepository;
    @Autowired
    protected PlummetRepository plummetRepository;
    @Autowired
    protected PlummetController plummetController;
}
