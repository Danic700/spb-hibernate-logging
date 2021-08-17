package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DiagnosticsService;

@RestController
@RequestMapping("diagnostics")
public class DiagnosticsController {
	
	
	@Autowired
	private DiagnosticsService diagnosticsService;
	
	@GetMapping("/dataSource")
	public String dataSourceInfo() {
		
		return diagnosticsService.getDatasourceInfo();
	}

}
