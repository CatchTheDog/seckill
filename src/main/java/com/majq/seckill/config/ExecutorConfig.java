package com.majq.seckill.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池初始化
 */
@Configuration
@EnableAsync
public class ExecutorConfig {
	public static final String ASYNCSERVICEEXCUTOR = "asyncServiceExcutor";
	private static final Logger logger = LoggerFactory.getLogger(ExecutorConfig.class);

	@Bean(name = ASYNCSERVICEEXCUTOR)
	public Executor asyncServiceExcutor() {
		logger.info("start asyncServiceExcutor!");
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(5);
		executor.setQueueCapacity(999999);
		executor.setThreadNamePrefix("async-service-");
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.initialize();
		return executor;
	}

}
