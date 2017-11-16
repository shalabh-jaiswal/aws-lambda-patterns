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

import javax.inject.Inject;

import com.amazonaws.services.lambda.runtime.Context;

import us.shalabh.alp.model.HttpRequest;
import us.shalabh.alp.model.HttpResponse;
import us.shalabh.alp.service.IDemoHttpRequestService;

/**
 * Demo Lambda to handle Http Requests via API Gateway. 
 *
 * @author Shalabh Jaiswal
 */
public class DemoHttpRequestLambda extends HttpBaseHandler
{
	// service class
	@Inject
	IDemoHttpRequestService demoHttpRequestService; 
	
	/* (non-Javadoc)
	 * @see us.shalabh.alp.function.HttpBaseHandler#init()
	 */
	@Override
	protected void init()
	{
		demoHttpRequestService = appComponent.getDemoHttpRequestService();
	}
	
	/* (non-Javadoc)
	 * @see us.shalabh.alp.function.HttpBaseHandler#process(us.shalabh.alp.model.HttpRequest, us.shalabh.alp.model.HttpResponse, com.amazonaws.services.lambda.runtime.Context)
	 */
	@Override
	protected HttpResponse process(HttpRequest request, HttpResponse response, Context context)
	{
		// json created by hand. 
		String body = "{\"data\":\"" +demoHttpRequestService.getData() +"\"}";		
		response.setBody(body);
		
		return response;
	}

}
