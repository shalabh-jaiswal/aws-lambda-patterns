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

/**
 * <p>
 * Base Lambda Handler. All Lambda functions should extend from this or a
 * subclass of this Base Handler. That way the functions may benefit from
 * Dependency Injection and Error handling.
 * </p>
 * 
 * <p>
 * Implements a template pattern with the following steps:
 * <ul>
 * <li>init - To initialize the dependencies
 * <li>process - To Process the request. This is what a handleRequest() would
 * normally do
 * <li>destroy - To destroy/close resources if needed.
 * </ul>
 * </p>
 *
 * @author Shalabh Jaiswal
 */
public abstract class BaseHandler<I, O> implements RequestHandler<I, O>
{
	// dagger app component
	static final AppComponent appComponent = DaggerAppComponent.builder().build();
	
	/**
	 * Initialization code. primarily used to initialize dependencies
	 */
	protected void init()
	{
		// do nothing
	}

	/**
	 * process the request as would normally be done in the
	 * <code>handleRequest</code> method.
	 * 
	 * @param input
	 * @param context
	 * @return
	 */
	protected abstract O process(I input, Context context);

	/**
	 * release resources if any. 
	 */
	protected void destroy()
	{
		// do nothing
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.
	 * lang.Object, com.amazonaws.services.lambda.runtime.Context)
	 */
	@Override
	public final O handleRequest(I input, Context context)
	{
		// 1. initialize
		init();
		
		// 2. process
		O output = process(input, context);
		
		// 3. destroy
		destroy();
		
		return output;
	}

}
