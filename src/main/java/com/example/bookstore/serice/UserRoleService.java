package com.example.bookstore.serice;

import com.example.bookstore.model.entity.enums.UserRoleEnum;
import javassist.tools.rmi.ObjectNotFoundException;

public interface UserRoleService {

    void assignUserRole(String username, UserRoleEnum roleEnum) throws ObjectNotFoundException;
}
