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
package us.shalabh.alp.service;

import javax.inject.Inject;
import javax.inject.Singleton;

import us.shalabh.alp.dao.IDemoS3EventDao;

/**
 * <p>
 * Service class for our Demo S3 Event Lambda function. This class is for
 * demonstrating dependency injection using Dagger2 and therefore does not have
 * any meat in it. In a real world application, this is where all the business
 * logic would go.
 * </p>
 *
 * <p>
 * This Service class has a dependency on the DAO class
 * <code>DemoS3EventDao</code>
 * <p>
 * 
 * @author Shalabh Jaiswal
 */
@Singleton
public class DemoS3EventService implements IDemoS3EventService
{
	// Dao
	private IDemoS3EventDao demoS3EventDao;

	/**
	 * constructor injection
	 */
	@Inject
	public DemoS3EventService(IDemoS3EventDao demoS3EventDao)
	{
		this.demoS3EventDao = demoS3EventDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see us.shalabh.alp.service.IDemoS3EventService#getData()
	 */
	@Override
	public String getData()
	{
		// gets data from the DAO
		return demoS3EventDao.getData();
	}

}
