package com.geo.easypoint.employee.service;

import com.geo.easypoint.administrative.unit.domain.AdministrativeUnit;
import com.geo.easypoint.administrative.unit.domain.AdministrativeUnitRepository;
import com.geo.easypoint.common.exception.EasyPointLogicException;
import com.geo.easypoint.common.exception.EasyPointNotFoundException;
import com.geo.easypoint.common.mapper.EasyPointMapper;
import com.geo.easypoint.common.mapper.PartialUpdater;
import com.geo.easypoint.competency.domain.Competency;
import com.geo.easypoint.competency.domain.CompetencyRepository;
import com.geo.easypoint.employee.dto.request.CreateEmployeeRequest;
import com.geo.easypoint.employee.dto.request.EmployeeUpdateRequest;
import com.geo.easypoint.employee.dto.response.EmployeeDto;
import com.geo.easypoint.employee.dto.response.EmployeeTableDto;
import com.geo.easypoint.employee.entity.Address;
import com.geo.easypoint.employee.entity.Employee;
import com.geo.easypoint.employee.entity.JobTitle;
import com.geo.easypoint.employee.entity.PassportInfo;
import com.geo.easypoint.employee.repository.EmployeeRepository;
import com.geo.easypoint.jobtitle.domain.JobTitleRepository;
import java.util.HashSet;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AdministrativeUnitRepository administrativeUnitRepository;
    private final CompetencyRepository competencyRepository;
    private final JobTitleRepository jobTitleRepository;

    @Transactional(readOnly = true)
    public List<EmployeeTableDto> findAll() {
        return EasyPointMapper.toEmployeeDto(employeeRepository.findAll());
    }

    @Transactional(readOnly = true)
    public EmployeeDto findById(Long id) {
        return EasyPointMapper.toEmployeeInfoDto(EasyPointNotFoundException.orElseThrow(id, Employee.class, employeeRepository::findById));
    }

    @Transactional
    public EmployeeTableDto create(CreateEmployeeRequest createEmployeeRequest) {
        List<AdministrativeUnit> administrativeUnits = administrativeUnitRepository.findAllById(createEmployeeRequest.adminStructures());
        Employee employee = employeeRepository.saveAndFlush(EasyPointMapper.toEmployee(createEmployeeRequest, administrativeUnits));
        return EasyPointMapper.toEmployeeDto(employee);
    }


    @Transactional
    public void updateEmployee(EmployeeUpdateRequest request, Long id) {
        Employee employee = EasyPointNotFoundException.orElseThrow(id, Employee.class, employeeRepository::findById);
        PartialUpdater.updater()
                .update(request.address(), addressUpdateRequest -> {
                    Address address = employee.getAddress();
                    PartialUpdater.updater()
                            .update(addressUpdateRequest.country(), address::setCountry)
                            .update(addressUpdateRequest.city(), address::setCity)
                            .update(addressUpdateRequest.flat(), address::setFlat)
                            .update(addressUpdateRequest.street(), address::setStreet)
                            .update(addressUpdateRequest.flat(), address::setFlat);
                })
                .update(request.passportInfo(), passportInfoUpdateRequest -> {
                    PassportInfo passportInfo = employee.getPassportInfo();
                    PartialUpdater.updater()
                            .update(passportInfoUpdateRequest.number(), passportInfo::setNumber)
                            .update(passportInfoUpdateRequest.sex(), passportInfo::setSex)
                            .update(passportInfoUpdateRequest.authority(), passportInfo::setAuthority)
                            .update(passportInfoUpdateRequest.birthDate(), passportInfo::setBirthDate)
                            .update(passportInfoUpdateRequest.issueDate(), passportInfo::setIssueDate)
                            .update(passportInfoUpdateRequest.expiredDate(), passportInfo::setExpiredDate);
                })
                .update(request.firstName(), employee::setFirstname)
                .update(request.surname(), employee::setSurname)
                .update(request.patronomic(), employee::setLastname)
                .update(request.hiredDate(), employee::setHiredDated)
                .update(request.administrativeUnits(), administrativeUnitIds -> {
                    List<AdministrativeUnit> administrativeUnits = administrativeUnitRepository.findAllById(administrativeUnitIds);
                    if (administrativeUnits.size() != administrativeUnitIds.size()) {
                        throw new EasyPointLogicException("Can't find all administrative units");
                    }
                    employee.setAdministrativeUnits(new HashSet<>(administrativeUnits));
                })
                .update(request.competencyId(), competencyId -> {
                    Competency competency = EasyPointNotFoundException.orElseThrow(competencyId, Competency.class, competencyRepository::findById);
                    employee.setCompetency(competency);
                })
                .update(request.jobTitleId(), jobTitleId -> {
                    JobTitle jobTitle = EasyPointNotFoundException.orElseThrow(jobTitleId, JobTitle.class, jobTitleRepository::findById);
                    employee.setJobTitle(jobTitle);
                });
    }

}
