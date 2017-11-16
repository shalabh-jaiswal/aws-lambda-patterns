/** 
 * Copyright 2017 shalabh.us
 * 
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
package us.shalabh.alp.client;

import java.io.IOException;

import com.amazonaws.services.lambda.runtime.events.S3Event;

import us.shalabh.alp.function.DemoHttpRequestLambda;
import us.shalabh.alp.function.DemoS3EventLambda;
import us.shalabh.alp.model.HttpRequest;
import us.shalabh.alp.model.HttpResponse;

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
			switch (args[0])
			{
				case "S3_EVENT":
					invokeDemoS3EventLambda();
					break;
				case "HTTP_REQUEST":
					invokeDemoHttpRequestLambda();
					break;
				default:
					break;
			}

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

	/**
	 * Simulate the HTTP Request lambda being invoked.
	 * 
	 * @throws IOException
	 */
	private static void invokeDemoHttpRequestLambda() throws IOException
	{
		// invoke the lambda
		DemoHttpRequestLambda lambda = new DemoHttpRequestLambda();
		HttpResponse response = lambda.handleRequest(new HttpRequest(), new ClientTestContext());

		System.out.println(response.getBody());
	}

}
