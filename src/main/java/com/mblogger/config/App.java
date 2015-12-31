package com.mblogger.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App
{
	public static void main(String[] args){
		ApplicationContext context = new AnnotationConfigApplicationContext(JobContext.class, JobConfiguration.class);
		
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("importJob");

		try {
			JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
			System.out.println("Exit Status : " + jobExecution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		AbstractApplicationContext aac = (AbstractApplicationContext) context;
		aac.close();
		
		System.out.println("Done");
    }
}
