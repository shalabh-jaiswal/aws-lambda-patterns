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
package us.shalabh.alp.dao;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * <p>
 * Demonstrates a Data Access Object that can be provided as a dependency to the
 * Service class <code>DemoS3EventService</code>
 * </p>
 *
 * @author Shalabh Jaiswal
 */
@Singleton
public class DemoS3EventDao implements IDemoS3EventDao
{

	/**
	 * default constructor.
	 * the @Inject here tells Dagger that this class represents a dependency
	 */
	@Inject
	public DemoS3EventDao()
	{	
	}
	
	/* (non-Javadoc)
	 * @see us.shalabh.alp.dao.IDemoS3EventDao#getData()
	 */
	@Override
	public String getData()
	{
		// let's assume this data came from a real data store like DynamoDB or Firebase etc.
		return "Real Data";
	}
	
}
