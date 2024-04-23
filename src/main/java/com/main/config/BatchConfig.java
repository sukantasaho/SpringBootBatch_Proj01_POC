package com.main.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.main.listener.JobMonitoringListener;
import com.main.processor.BookItemProcessor;
import com.main.reader.BookItemReader;
import com.main.writer.BookItemWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig 
{
    @Autowired
	private JobBuilderFactory jobBuilderFactory;
    @Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	
	@Autowired
	private JobMonitoringListener listener;
	@Autowired
	private BookItemWriter bookItemWriter;
	@Autowired
	private BookItemReader bookItemReader;
	@Autowired
	private BookItemProcessor bookItemProcessor;
	
	@Bean(name = "step1")
	public Step createStep1()
	{
		return stepBuilderFactory.get("step1")
				.<String,String>chunk(2)
				.reader(bookItemReader)
				.processor(bookItemProcessor)
				.writer(bookItemWriter)
				.build();
	}
	@Bean(name = "job1")
	public Job createJob1()
	{
		return jobBuilderFactory.get("job1")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.start(createStep1())
				.build();
	}
}
