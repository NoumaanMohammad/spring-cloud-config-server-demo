package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.listener.annotation.FailedTask;
import org.springframework.cloud.task.repository.TaskExecution;

@SpringBootApplication
@EnableTask
public class SpringCloudTaskApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTaskApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		if(strings != null) {
			System.out.println("HI am a task");
		}
		
	}

	@BeforeTask
	public void onTaskStartup(TaskExecution taskExecution) {
		System.out.println("task started");
		
	}

	@AfterTask
	public void onTaskEnd(TaskExecution taskExecution) {
		 System.out.println("task ended");
		
	}

	@FailedTask
	public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {
		System.out.println("task failed");
		
	}

}
