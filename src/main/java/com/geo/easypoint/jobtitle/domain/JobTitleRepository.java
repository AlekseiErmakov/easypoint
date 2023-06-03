package com.geo.easypoint.jobtitle.domain;

import com.geo.easypoint.employee.entity.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleRepository extends JpaRepository<JobTitle, Long> {
}
