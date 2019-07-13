package edu.cuit.robin.campushelper.dao;

import edu.cuit.robin.campushelper.model.Role;

import java.util.List;

/**
 * @ Author      : robin.
 * @ Date        : Created in 21:07 2019/4/12
 * @ Description : TODO
 */

public interface RoleDao {
    List<Role> queryAllRole();
    Role queryRoleByName(String rName);
    int insertRole(Role role);
    int updateRole(Role role);
    int deleteRole(List idArr);
}
