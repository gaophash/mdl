package com.jiasu.mdl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Description : ThreadConfig. <br />
 * Create Time : 2023年1月9日 <br />
 * Copyright : Copyright (c) 2010 - 2019 All rights reserved. <br />
 * 
 * @author gaopeng
 * @version 1.0
 */
@Configuration
public class ThreadConfig {
	
	@Bean("baseExeExecutor")
	public ThreadPoolTaskExecutor baseExeExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setThreadNamePrefix("base-exe-");
		threadPoolTaskExecutor.setMaxPoolSize(50);
		threadPoolTaskExecutor.setCorePoolSize(50);
		threadPoolTaskExecutor.setKeepAliveSeconds(60); 
		threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		threadPoolTaskExecutor.initialize();
		return threadPoolTaskExecutor;
	}
	
	@Bean("smsTaskExecutor")
	public ThreadPoolTaskExecutor smsTaskExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setThreadNamePrefix("sms-");
		threadPoolTaskExecutor.setMaxPoolSize(10);
		threadPoolTaskExecutor.setCorePoolSize(10);
		threadPoolTaskExecutor.setKeepAliveSeconds(60); 
		threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		threadPoolTaskExecutor.initialize();
		return threadPoolTaskExecutor;
	}
	
	
}
