package com.service;

import org.springframework.stereotype.Service;

@Service
public class HystrixTestService implements FeignProviderService, FeignConsumerService{

	@Override
	public String consumerTest(String name) {
		return "method consumerTest has an error";
	}

	@Override
	public String ribbonTest(String name) {
		return "method ribbonTest has an error";
	}

	@Override
	public String productTest(String name) {
		return "methond productTest has an error";
	}

	@Override
	public String hystrixTest(String name) {
		return "methond hystrixTest has an error";
	}
	
}
