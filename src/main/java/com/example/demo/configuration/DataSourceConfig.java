package com.example.demo.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {
	
	
	 @Autowired
	 DataSource dataSource;

	 @Bean
	 public HikariDataSourcePoolMetadata dataSourcePoolMetadata() {
		 
	        HikariDataSourcePoolMetadata dataSourcePoolMetadata = new HikariDataSourcePoolMetadata((HikariDataSource) dataSource);
	        return dataSourcePoolMetadata;
	 }

}
