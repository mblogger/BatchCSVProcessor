package com.mblogger.config;

import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableAutoConfiguration
public class JobContext {

	@Autowired
	JobRepository jobRepository;
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	JobRegistry jobRegistry;
	
	@Autowired
	PlatformTransactionManager transactionManager;
	
	@Bean
	public MapJobRepositoryFactoryBean jobRepository() {
		MapJobRepositoryFactoryBean jobRepo = new MapJobRepositoryFactoryBean();
		jobRepo.setTransactionManager((ResourcelessTransactionManager) transactionManager());
		
		return jobRepo;
	}
	
	@Bean
	public ResourcelessTransactionManager transactionManager() {
		return new ResourcelessTransactionManager();
	}
	
	@Bean
	public SimpleJobLauncher jobLauncher() {
		SimpleJobLauncher sjl = new SimpleJobLauncher();
		sjl.setJobRepository((JobRepository) jobRepository());
		
		return sjl;
	}
}
