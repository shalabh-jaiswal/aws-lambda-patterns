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
package us.shalabh.alp.client;

import java.io.IOException;

import com.amazonaws.services.lambda.runtime.events.S3Event;

import us.shalabh.alp.function.DemoS3EventLambda;

/**
 * Just invokes the Demo Lambda Handlers
 *
 * @author Shalabh Jaiswal
 */
public class SimpleAWSLambdaSimulator
{
	/**
	 * psvm 
	 * 
	 * @param args
	 */
	public static void main(String args[])
	{
		try
		{
			invokeDemoS3EventLambda();
		}
		catch (Throwable t)
		{
			// something went wrong
			t.printStackTrace();
		}
	}
	
	/**
	 * Simulate the lambda being invoked. 
	 * 
	 * @throws IOException
	 */
	private static void invokeDemoS3EventLambda() throws IOException
	{			
		// invoke the lambda
		DemoS3EventLambda lambda = new DemoS3EventLambda();
		lambda.handleRequest(new S3Event(null), new ClientTestContext());
	}
}
