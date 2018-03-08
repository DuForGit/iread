package com.iread.font.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iread.beans.domain.UserInfomations;
import com.iread.font.beans.po.UserPo;
import com.iread.font.beans.vo.RegisterVo;
import com.iread.font.dao.RegisterUserMapper;
import com.iread.font.dao.UserMapper;
import com.iread.font.service.RegisterService;

/**
 *项目名称: iread
 *类名称: RegisterServiceImpl
 *类描述: RegisterService接口的实现
 *创建人: Administrator
 *创建时间: 2017年12月20日下午1:11:08
 * @version 1.0.0
 * @author 方秋都
 *
 */
@Service
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RegisterUserMapper registerMapper;

	/* (non-Javadoc)
	 * @see com.iread.font.service.RegisterService#register(com.iread.beans.domain.User)
	 */
	@Override
	public Integer register(RegisterVo u) {
		UserPo p = new UserPo(u.getName(), u.getEmail(), null, u.getPassword());
		registerMapper.regisetUser(p);
		System.out.println(p.getId());
		return p.getId();
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.RegisterService#register(com.iread.beans.domain.UserInfomations)
	 */
	@Override
	public Integer register(UserInfomations uinfo) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.RegisterService#isExistEmail(java.lang.String)
	 */
	@Override
	public boolean isExistEmail(String email) {
		if(userMapper.isExistEmail(email) == null){
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.iread.font.service.RegisterService#isExistName(java.lang.String)
	 */
	@Override
	public boolean isExistName(String name) {
		if(userMapper.isExistName(name) == null){
			return false;
		}
		return true;
	}

}
