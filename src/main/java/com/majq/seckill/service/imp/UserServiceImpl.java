package com.majq.seckill.service.imp;

import com.majq.seckill.dao.local.UserDao;
import com.majq.seckill.domain.User;
import com.majq.seckill.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public List<User> getUserList() {
		return userDao.queryList();
	}
}
