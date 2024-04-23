package com.main.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component("jmListener")
public class JobMonitoringListener implements JobExecutionListener 
{
	
	private long start,end;
	
      @Override
    public void beforeJob(JobExecution jobExecution) {
    	 start = System.currentTimeMillis();
    }
      
      @Override
    public void afterJob(JobExecution jobExecution) {
    	 end = System.currentTimeMillis();
    	 System.out.println("Job Execution Status : "+jobExecution.getExitStatus());
    	 System.out.println("Job has taken "+(end-start)+"ms to complete the task");
    }
}
