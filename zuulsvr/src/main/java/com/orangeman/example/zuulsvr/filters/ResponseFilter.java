package com.orangeman.example.zuulsvr.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ResponseFilter extends ZuulFilter {
	private static final int FILTER_ORDER = 1;
	private static final boolean SHOULD_FILTER = true;
	private static final Logger logger = LoggerFactory.getLogger(ResponseFilter.class);

	@Autowired
	FilterUtils filterUtils;

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return SHOULD_FILTER;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		RequestContext ctx = RequestContext.getCurrentContext();
		
		logger.debug("Adding the correlation id to the outbound headers. {}", filterUtils.getCorrelationId());
		
		ctx.getResponse().addHeader(
				FilterUtils.CORRELATION_ID,
				filterUtils.getCorrelationId());
		
		logger.info("Completing outgoing request for {}.", ctx.getRequest().getRequestURI());
		
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return FilterUtils.POST_FILTER_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return FILTER_ORDER;
	}

}
