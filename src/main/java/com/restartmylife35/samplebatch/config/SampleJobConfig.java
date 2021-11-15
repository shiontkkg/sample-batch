package com.restartmylife35.samplebatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@EnableBatchProcessing
public class SampleJobConfig {

  @Autowired
  private JobBuilderFactory jobBuilderFactory;
  
  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step step1(Tasklet tasklet1) {
    return stepBuilderFactory.get("step1").tasklet(tasklet1).build();
  }

  @Bean
  public Step step2(Tasklet tasklet2) {
    return stepBuilderFactory.get("step2").tasklet(tasklet2).build();
  }

  @Bean
  public Job sampleJob(Step step1, Step step2) {
    return jobBuilderFactory.get("sampleJob").start(step1).next(step2).build();
  }

}
