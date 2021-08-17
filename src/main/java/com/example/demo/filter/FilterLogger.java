package com.example.demo.filter;
import org.slf4j.MDC;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class FilterLogger implements Filter {
	
	   private static final String CORRELATION_ID_HEADER_NAME = "X-Correlation-Id";
	   private static final String CORRELATION_ID_LOG_VAR_NAME = "correlationId";


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(servletRequest);

 
		
		final String eventId = generateEventId();
        MDC.put(CORRELATION_ID_LOG_VAR_NAME, eventId);
        log.debug(servletRequest.getMethod() + " " + servletRequest.getRequestURI() + " " + eventId);



        HttpServletResponse servletResponse = (HttpServletResponse) response;
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(servletResponse);
        
		chain.doFilter(requestWrapper, responseWrapper);
		
        

		
		byte[] responseArray = responseWrapper.getContentAsByteArray();
        String responseStr = new String(responseArray,responseWrapper.getCharacterEncoding());
        log.debug(responseStr + " " + eventId);

        responseWrapper.addHeader("eventId", eventId);
        responseWrapper.copyBodyToResponse();

				
	}
	



    private String generateEventId() {
        return UUID.randomUUID().toString();
    }
}
	
	

