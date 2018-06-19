package com.majq.seckill.inerceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 日志拦截器
 */
public class MyLogInterceptor implements HandlerInterceptor {
	public static final String URL_PATTERN = "/**";
	private final String START_TIME = "start_time";
	private Logger logger = LoggerFactory.getLogger(MyLogInterceptor.class);

	/**
	 * 请求处理前
	 *
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		logger.info("request handle start!");
		logger.info("sessionId:{},url:{},param:{},requestIp:{},requestMethod:{},requestType:{}", request.getRequestedSessionId(), request.getRequestURL(), request.getParameterMap().toString(), request.getMethod(), request.getContentType());
		request.setAttribute(START_TIME, System.currentTimeMillis());
		return true;
	}

	/**
	 * 请求处理时
	 *
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

	}

	/**
	 * 请求处理后
	 *
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		Long startTime = Long.valueOf(request.getAttribute(START_TIME).toString());
		logger.info("sessionId:{},url:{},param:{},requestIp:{},requestMethod:{},requestType:{},responseBody:{},userTimes:{}", request.getRequestedSessionId(), request.getRequestURL(), request.getParameterMap().toString(), request.getMethod(), request.getContentType(), response.toString(), System.currentTimeMillis() - startTime);
		logger.info("request handle end!");
	}
}
