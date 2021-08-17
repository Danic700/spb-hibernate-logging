package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticsServiceImpl implements DiagnosticsService{
	
	@Autowired
	private HikariDataSourcePoolMetadata dataSourcePoolMetadata;
	
	@Override
	public String getDatasourceInfo() {
	

	    String returnInfo =  "DATASOURCE ACTIVE = " + dataSourcePoolMetadata.getActive() +  " DATASOURCE IDLE = " + dataSourcePoolMetadata.getIdle() +  " DATASOURCE MAX = " + dataSourcePoolMetadata.getMax();
		return returnInfo;
	}

}
