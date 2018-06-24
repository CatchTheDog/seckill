package com.majq.seckill.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.majq.seckill.domain.User;
import com.majq.seckill.service.imp.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserServiceImpl userService;
	@Autowired
	private ObjectMapper objectMapper;
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/getUserList")
	public List<User> getUserList() {
		logger.info("这是info日志！");
		logger.debug("这是debug日志");
		logger.error("这是debug日志");
		logger.warn("这是warn日志");
		logger.trace("这是trance日志");
		List<User> list = userService.getUserList();
		return list;
	}


	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String logIn(Model model) {
		logger.info("log in success!");
		model.addAttribute("value", "majq");
		return "index";
	}
}
