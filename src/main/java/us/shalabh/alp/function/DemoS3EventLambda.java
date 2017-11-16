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