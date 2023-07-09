package com.Collocation.Stage.Service.interfaces;

import com.Collocation.Stage.entities.Role;

import java.util.List;
import java.util.Optional;

public interface RoleInterface {
    List<Role> getAllRoles();
    Optional<Role> getRoleById(Integer id);
    Role saveRole(Role role);
    Role updateRole(Integer id, Role updatedRole);
    void deleteRole(Integer id);
}
