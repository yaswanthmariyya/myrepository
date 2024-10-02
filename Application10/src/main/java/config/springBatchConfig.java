package config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;


import Beans.covidcases;
import Repository.covidcaseRepository;

@Configuration
public class springBatchConfig {
	@Autowired
	private covidcaseRepository covidcaserepository;
	@Autowired
	private JobRepository jobRepository;
	 @Autowired
	   private PlatformTransactionManager transactionManager;
	@Bean
	public FlatFileItemReader<covidcases> itemReader(){
	FlatFileItemReader<covidcases> reader = new FlatFileItemReader<>();
	reader.setResource(new FileSystemResource("D:/spring examp/covid_cases.csv"));
	reader.setLinesToSkip(1);
	reader.setLineMapper(lineMapper());
	return reader;
	}
private LineMapper<covidcases> lineMapper(){
	DefaultLineMapper<covidcases> lineMapper = new DefaultLineMapper<>();
	DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
	tokenizer.setDelimiter(",");
	tokenizer.setStrict(false);
	tokenizer.setNames("Country","Confirmed","Deaths","Recovered","Active");
	BeanWrapperFieldSetMapper<covidcases> beanWrapperFieldSetMapper =new BeanWrapperFieldSetMapper<>();
	beanWrapperFieldSetMapper.setTargetType(covidcases.class);
	lineMapper.setLineTokenizer(tokenizer);
	lineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
	return lineMapper;
}
@Bean
public CovidCasesDataProcessor itemProcessor() {
	CovidCasesDataProcessor processor = new CovidCasesDataProcessor();
	return processor;
}
@Bean
public RepositoryItemWriter<covidcases> itemWriter(){
	RepositoryItemWriter<covidcases> writer= new RepositoryItemWriter<>();
	writer.setRepository(covidcaserepository);
	writer.setMethodName("save");
	return writer;
}
@Bean
public Step covidCasesStep(JobRepository jobRepository,PlatformTransactionManager transactionManager) {
	return new StepBuilder("covidCasesStep", jobRepository)
			.<covidcases, covidcases>chunk(10, transactionManager)
			.reader(itemReader())
			.processor(itemProcessor())
			.writer(itemWriter())
			.build();
}
@Bean
public Job runJob(JobRepository jobRepository) {
	return new JobBuilder("csv-job",jobRepository)
			.flow(covidCasesStep(jobRepository,transactionManager))
			.end()
			.build();
	
}
}
