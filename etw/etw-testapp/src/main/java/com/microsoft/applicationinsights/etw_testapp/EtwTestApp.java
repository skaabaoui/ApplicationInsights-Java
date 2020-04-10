/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.microsoft.applicationinsights.etw_testapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.task.TaskSchedulerBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class EtwTestApp extends SpringBootServletInitializer {

    public EtwTestApp() {
        super();
        setRegisterErrorPageFilter(false);
    }

    public static void main(String[] args) {
        SpringApplication.run(EtwTestApp.class, args);
    }

    @Bean
    public TaskScheduler taskScheduler() {
        return new TaskSchedulerBuilder(1, "ewt-testapp-worker", null).build();
    }
}
