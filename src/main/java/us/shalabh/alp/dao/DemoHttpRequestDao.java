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
 * Gets data from a data source for eg. DynamoDB
 *
 * @author Shalabh Jaiswal
 */
@Singleton
public class DemoHttpRequestDao implements IDemoHttpRequestDao
{
	/**
	 * default constructor
	 */
	@Inject
	public DemoHttpRequestDao()
	{
		// do nothing. 
	}
	
	/* (non-Javadoc)
	 * @see us.shalabh.alp.dao.IDemoHttpRequestDao#getData()
	 */
	@Override
	public String getData()
	{
		return "Data for the HTTP Request";
	}

}
