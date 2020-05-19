package com.ilp3.system.service;


import org.springframework.stereotype.Service;
import com.ilp3.system.entity.RoleDO;
import java.util.List;
import java.util.Set;

@Service
public interface RoleService {
	RoleDO get(Long id);
	List<RoleDO> list();
	int save(RoleDO role);
	int update(RoleDO role);
	int remove(Long id);
	List<RoleDO> list(Long userId);
    Set<String> listRoles(Long userId);
}
