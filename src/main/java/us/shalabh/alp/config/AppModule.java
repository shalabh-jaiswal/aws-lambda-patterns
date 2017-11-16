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
package us.shalabh.alp.config;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import dagger.Module;
import dagger.Provides;
import us.shalabh.alp.dao.DemoHttpRequestDao;
import us.shalabh.alp.dao.DemoS3EventDao;
import us.shalabh.alp.dao.IDemoHttpRequestDao;
import us.shalabh.alp.dao.IDemoS3EventDao;
import us.shalabh.alp.service.DemoHttpRequestService;
import us.shalabh.alp.service.DemoS3EventService;
import us.shalabh.alp.service.IDemoHttpRequestService;
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
	
	/**
	 * Provides an implementation of an <code>IDemoHttpRequestDao</code> 
	 * 
	 * @param demoHttpRequestDao
	 * @return
	 */
	@Provides
	public IDemoHttpRequestDao provideDemoHttpRequestDao(DemoHttpRequestDao demoHttpRequestDao)
	{
		return demoHttpRequestDao;
	}
	
	/**
	 * Provides an implementation of an <code>IDemoHttpRequestService</code>
	 * 
	 * @param demoHttpRequestService
	 * @return
	 */
	@Provides
	public IDemoHttpRequestService provideDemoHttpRequestService(DemoHttpRequestService demoHttpRequestService)
	{
		return demoHttpRequestService;
	}
}
