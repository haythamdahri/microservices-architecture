package com.springcloud.microservices.filters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ZuulLoggingFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// Set if this filter must be executed or not
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// Complete logic
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		log.info("request -> {} request uri -> {}", request, request.getRequestURI());

		return null;
	}

	@Override
	public String filterType() {
		// "pre" OR "post" OR "error"
		return "pre";
	}

	@Override
	public int filterOrder() {
		// Set priority of this filter in case we have multiple filters
		return 1;
	}

}
