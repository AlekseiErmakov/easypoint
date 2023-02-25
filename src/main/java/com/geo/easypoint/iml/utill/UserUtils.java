package com.geo.easypoint.iml.utill;

import com.geo.easypoint.iml.employee.entity.Employee;
import com.geo.easypoint.iml.users.entity.EasyPointUser;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserUtils {

    public static EasyPointUser getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (EasyPointUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static Employee getCurrentEmployee() {
        return getCurrentUser().getEmployee();
    }
}
