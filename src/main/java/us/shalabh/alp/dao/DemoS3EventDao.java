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
