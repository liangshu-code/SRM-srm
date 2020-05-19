package com.ilp3.common.service;

import com.ilp3.common.domain.PageDO;
import com.ilp3.common.domain.SysLogDO;
import com.ilp3.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogService {
	public PageDO<SysLogDO> queryList(Query query);
	
	int remove(Long id);
	int batchRemove(List<Long> ids);
}
