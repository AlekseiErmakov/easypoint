package com.geo.easypoint.impl.utill;

import com.geo.easypoint.impl.employee.entity.Employee;
import com.geo.easypoint.impl.users.entity.EasyPointUser;
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
