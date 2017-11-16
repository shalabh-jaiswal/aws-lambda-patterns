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

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import us.shalabh.alp.config.AppComponent;
import us.shalabh.alp.config.DaggerAppComponent;
import us.shalabh.alp.exception.AccessDeniedException;
import us.shalabh.alp.model.HttpRequest;
import us.shalabh.alp.model.HttpResponse;
import us.shalabh.alp.utils.http.HttpUtils;

/**
 * <p>
 * Base HTTP Handler. Creates a canned response and Handles Errors out of the
 * box.
 * </p>
 *
 * @author Shalabh Jaiswal
 */
public abstract class HttpBaseHandler implements RequestHandler<HttpRequest, HttpResponse>
{
	// dagger app component
	static final AppComponent appComponent = DaggerAppComponent.builder().build();
	
	/**
	 * initialization code. used for setting up dependencies.
	 */
	protected void init()
	{
		// do nothing by default
	}

	/**
	 * process the HTTP Request
	 * 
	 * @param request
	 * @param response
	 * @param context
	 * @return
	 */
	protected abstract HttpResponse process(HttpRequest request, HttpResponse response, Context context);

	/**
	 * destroy method to release/close resources if any.
	 */
	protected void destroy()
	{
		// do nothing by default
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.
	 * lang.Object, com.amazonaws.services.lambda.runtime.Context)
	 */
	@Override
	public final HttpResponse handleRequest(HttpRequest request, Context context)
	{
		HttpResponse response = new HttpResponse();

		try
		{
			// 1. initialize
			init();

			// 2. create a canned Response object with CORS enabled and process
			HttpUtils.setCORSHeaders(response);
			response = process(request, response, context);

			// 3. release/close resources
			destroy();
		}
		catch (AccessDeniedException ade)
		{
			// Access Denied - 401
			HttpUtils.setAccessDeniedResponse(response);

			// can be logged using log4j too
			ade.printStackTrace();
		}
		catch (Throwable t)
		{
			// internal server error - 500
			HttpUtils.setInternalServerErrorResponse(response);

			// can be logged using log4j as well
			t.printStackTrace();
		}

		return response;
	}
}
