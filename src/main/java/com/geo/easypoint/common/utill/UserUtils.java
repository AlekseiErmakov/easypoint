package com.geo.easypoint.common.utill;

import com.geo.easypoint.employee.entity.Employee;
import com.geo.easypoint.authentication.domain.user.EasyPointUser;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserUtils {

    public static EasyPointUser getCurrentUser() {
        return (EasyPointUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static Employee getCurrentEmployee() {
        return getCurrentUser().getEmployee();
    }
}
