package com.majq.seckill.controller;

import com.majq.seckill.domain.User;
import com.majq.seckill.service.imp.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserServiceImpl userService;
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/getUserList")
	List<User> getUserList() {
		logger.info("这是info日志！");
		logger.debug("这是debug日志");
		logger.error("这是debug日志");
		logger.warn("这是warn日志");
		logger.trace("这是trance日志");
		return userService.getUserList();
	}
}
