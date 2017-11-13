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
package us.shalabh.alp.config;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import dagger.Module;
import dagger.Provides;
import us.shalabh.alp.dao.DemoS3EventDao;
import us.shalabh.alp.dao.IDemoS3EventDao;
import us.shalabh.alp.service.DemoS3EventService;
import us.shalabh.alp.service.IDemoS3EventService;

/**
 * Dagger 2 App Module
 *
 * @author Shalabh Jaiswal
 */
@Module
public class AppModule
{
	/**
	 * returns an S3 Object
	 * 
	 * @return
	 */
	@Provides
	AmazonS3 provideAmazonS3()
	{
		return AmazonS3ClientBuilder.standard().build();
	}	
	
	/**
	 * Provides concrete implementation of an <code>IDemoS3EventService</code>
	 * 
	 * @param demoS3EventService
	 * @return
	 */
	@Provides
	public IDemoS3EventService provideDemoS3EventService(DemoS3EventService demoS3EventService)
	{
		return demoS3EventService;
	}
	
	/**
	 * Provides concrete implementation of an <code>IDemoS3EventDao</code>
	 * 
	 * @param demoS3EventService
	 * @return
	 */
	@Provides
	public IDemoS3EventDao provideDemoS3EventDao(DemoS3EventDao demoS3EventDao)
	{
		return demoS3EventDao;
	}
}
