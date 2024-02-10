package com.oz.ozHouse.client.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {
	/*
	modelMapper 를 사용하기 위한 config 입니다
	*/
	
	@Bean
	public ModelMapper getMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
			.setFieldMatchingEnabled(true)
			.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
			.setMatchingStrategy(MatchingStrategies.LOOSE);
		
		return modelMapper;
	}
}
