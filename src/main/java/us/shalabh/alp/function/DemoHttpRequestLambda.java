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
