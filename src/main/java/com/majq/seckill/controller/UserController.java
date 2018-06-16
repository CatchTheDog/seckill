package com.majq.seckill.controller;

import com.majq.seckill.domain.User;
import com.majq.seckill.service.imp.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserServiceImpl userService;

	@RequestMapping("/getUserList")
	List<User> getUserList() {
		return userService.getUserList();
	}
}
