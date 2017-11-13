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
	public void init()
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
	public abstract O process(I input, Context context);

	/**
	 * release resources if any. 
	 */
	public void destroy()
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
