package com.juaracoding.serviceapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.juaracoding.serviceapi.entity.Role;

public interface RoleUserRepository extends CrudRepository<Role, Long> {

	@Query (value = "select users.id, roles.name from roles INNER JOIN user_roles\r\n"
			+ "ON roles.id = user_roles.role_id \r\n"
			+ "JOIN users ON users.id = user_roles.user_id", nativeQuery = true )
    List<Role> RoleUsers();
	
//	@Query (value = "update roles.name from roles INNER JOIN user_roles\r\n"
//			+ "ON roles.id = user_roles.role_id \r\n"
//			+ "JOIN users ON users.id = user_roles.user_id where users.id = :idUser", nativeQuery = true )
    List<Role> UpdateRoleUsers(@Param("idUser")String idUser);
	
}
