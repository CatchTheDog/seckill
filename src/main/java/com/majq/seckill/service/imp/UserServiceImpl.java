package com.majq.seckill.service.imp;

import com.majq.seckill.dao.local.UserDao;
import com.majq.seckill.domain.User;
import com.majq.seckill.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Resource
	private UserDao userDao;

	@Override
	public List<User> getUserList() {
		logger.info("getUserList!");
		return userDao.queryList();
	}
}
