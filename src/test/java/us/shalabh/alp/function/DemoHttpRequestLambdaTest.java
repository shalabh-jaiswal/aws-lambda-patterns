/** 
 * Copyright 2017. All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of shalabh.us. The intellectual and technical 
 * concepts contained herein are proprietary to shalabh.us 
 * and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from shalabh.us
 */
package us.shalabh.alp.function;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import org.junit.Assert;
import us.shalabh.alp.model.HttpRequest;
import us.shalabh.alp.model.HttpResponse;
import us.shalabh.alp.service.IDemoHttpRequestService;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 *
 * @author Shalabh Jaiswal
 */
@RunWith(MockitoJUnitRunner.class)
public class DemoHttpRequestLambdaTest
{
	// mock service
	@Mock
	private IDemoHttpRequestService mockDemoHttpRequestService;
	
	// inject mock into SUT
	@InjectMocks
	private DemoHttpRequestLambda demoHttpRequestLambda; 
	
	/**
	 * Test Injection
	 */
	@Test
	public void TestInjection()
	{
		Mockito.when(mockDemoHttpRequestService.getData()).thenReturn("Mock Data");
		
		HttpResponse response = new HttpResponse();		
		response = demoHttpRequestLambda.process(new HttpRequest(), response, new TestContext());
		
		Assert.assertEquals("{\"data\":\"Mock Data\"}", response.getBody());
	}
}
