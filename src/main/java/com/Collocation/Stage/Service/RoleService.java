package com.Collocation.Stage.Service;

import com.Collocation.Stage.Repository.IRoleRepository;
import com.Collocation.Stage.Service.interfaces.RoleInterface;
import com.Collocation.Stage.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements RoleInterface {

    private final IRoleRepository roleRepository;

    @Autowired
    public RoleService(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Integer id) {
        return roleRepository.findById(id);
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Integer id, Role updatedRole) {
        Role role = roleRepository.findById(id).orElse(null);
        if (role != null) {
            role.setNomRole(updatedRole.getNomRole());
            return roleRepository.save(role);
        }
        return null;
    }

    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }
}
