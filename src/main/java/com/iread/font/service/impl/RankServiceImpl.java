package com.iread.font.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iread.beans.domain.RankNav;
import com.iread.font.dao.RankMapper;
import com.iread.font.service.RankService;
import com.iread.utils.PageUtil;

/**
 *项目名称: iread
 *类名称: RankServiceImpl
 *类描述: rank页面的具体实现
 *创建人: Administrator
 *创建时间: 2018年2月2日上午11:45:42
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Service
public class RankServiceImpl implements RankService {
	
	@Autowired
	private RankMapper r;

	/* (non-Javadoc)
	 * @see com.iread.font.service.RankService#getRankNav()
	 */
	@Override
	public List<RankNav> getRankNav() {
		return r.getRankNav();
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.RankService#getRankBooks(int, int)
	 */
	@Override
	public Map<String, Object> getRankBooks(int order, int page) {
		PageUtil.startPage(page);
		return PageUtil.pageInfos(r.getRankBooks(order));
	}

}
