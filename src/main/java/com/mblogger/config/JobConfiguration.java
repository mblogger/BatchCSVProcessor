package com.mblogger.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.mblogger.mapper.FileHeaderMapper;
import com.mblogger.processor.CSVFileProcessor;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilders;

	@Autowired
	private StepBuilderFactory stepBuilders;
	
	@Autowired
	ItemReader<FileHeaderMapper> reader;
	
	@Autowired
	ItemProcessor<FileHeaderMapper, String> itemProcessor;
	
	@Autowired
	ItemWriter<String> writer;
	
	// tag : Read Write and Processor

	@Bean
	public ItemReader<FileHeaderMapper> cvsFileReader() {
		FlatFileItemReader<FileHeaderMapper> reader = new FlatFileItemReader<FileHeaderMapper>();
		reader.setResource(new ClassPathResource("input/product.csv"));
		reader.setLineMapper(new DefaultLineMapper<FileHeaderMapper>() {
			{
				setFieldSetMapper(new BeanWrapperFieldSetMapper<FileHeaderMapper>() {
					{
						setTargetType(FileHeaderMapper.class);
					}
				});
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setDelimiter(DELIMITER_COMMA);
					}
				});
			}
		});

		return reader;
	}

	@Bean
	public ItemProcessor<FileHeaderMapper, String> csvFileProcessor() {
		return new CSVFileProcessor();
	}

	@Bean
	public ItemWriter<String> jsonFileWriter() {
		FlatFileItemWriter<String> writer = new FlatFileItemWriter<String>();
		writer.setShouldDeleteIfExists(true);
		writer.setResource(new ClassPathResource("output/product.json"));
		writer.setLineAggregator(new DelimitedLineAggregator<String>() {
			{
				setFieldExtractor(new BeanWrapperFieldExtractor<String>() {
					{
						setNames(new String[] { "id", "attribute_set_id", "price", "status", "visibility", "sku", "name", "type_id", "created_at", "updated_at" });
					}
				});

			}
		});

		return writer;
	}

	// end : Read Write and Processor

	// tag : Job Step

	@Bean
	public Job importJob(@Qualifier("step1") Step s1) {
		return jobBuilders.get("importJob").flow(s1).end().build();
	}

	@Bean
	public Step step1(ItemReader<FileHeaderMapper> reader, ItemProcessor<FileHeaderMapper, String> itemProcessor, ItemWriter<String> writer) {
		return stepBuilders.get("step1").<FileHeaderMapper, String> chunk(10).reader(reader).processor(itemProcessor).writer(writer)
				.build();
	}

	// end : Job Step
}
