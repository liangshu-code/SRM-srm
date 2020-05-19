package com.ilp3.common.service.impl;

import com.ilp3.common.dao.LogMapper;
import com.ilp3.common.domain.PageDO;
import com.ilp3.common.domain.SysLogDO;
import com.ilp3.common.service.LogService;
import com.ilp3.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
	@Autowired
	LogMapper logMapper;

	@Override
	public PageDO<SysLogDO> queryList(Query query) {
		List<SysLogDO> logs = logMapper.list(query);
		int total = logMapper.count();
		PageDO<SysLogDO> page = new PageDO<SysLogDO>();
		page.setTotal(total);
		page.setRows(logs);
		return page;
	}

	@Override
	public int remove(Long id) {
		int count = logMapper.remove(id);
		return count;
	}

	@Override
	public int batchRemove(List<Long> ids) {
		int count = logMapper.batchRemove(ids);
		return count;
	}
}
