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

import javax.inject.Singleton;

import com.amazonaws.services.s3.AmazonS3;

import dagger.Component;
import us.shalabh.alp.service.DemoS3EventService;

/**
 * Dagger 2 App Component
 *
 * @author Shalabh Jaiswal
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent
{

	/**
	 * get an S3 Object
	 * 
	 * @return
	 */
	AmazonS3 getAmazonS3();
	
	/**
	 * gets DemoS3EventService object
	 * 
	 * @return
	 */
	DemoS3EventService getDemoS3EventService();
}
