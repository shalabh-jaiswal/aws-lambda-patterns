/** 
 * Copyright 2017 shalabh.us
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
