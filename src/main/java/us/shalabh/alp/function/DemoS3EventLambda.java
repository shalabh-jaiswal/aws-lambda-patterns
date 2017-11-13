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
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;

import us.shalabh.alp.service.IDemoS3EventService;

/**
 * AWS Lambda Function to handle an S3 Event
 *
 * @author Shalabh Jaiswal
 */
public class DemoS3EventLambda extends BaseHandler<S3Event, String>
{
	// S3 Object
	@Inject
	AmazonS3 s3;

	// Service class
	@Inject
	IDemoS3EventService demoS3EventService;
	
	/* (non-Javadoc)
	 * @see us.shalabh.alp.function.BaseHandler#init()
	 */
	@Override
	public void init()
	{		
		s3 = appComponent.getAmazonS3();
		demoS3EventService = appComponent.getDemoS3EventService();
	}

	/* (non-Javadoc)
	 * @see us.shalabh.alp.function.BaseHandler#process(java.lang.Object, com.amazonaws.services.lambda.runtime.Context)
	 */
	@Override
	public String process(S3Event input, Context context)
	{
		String data = demoS3EventService.getData();		
		System.out.println(data);
		
		return data;
	}
}