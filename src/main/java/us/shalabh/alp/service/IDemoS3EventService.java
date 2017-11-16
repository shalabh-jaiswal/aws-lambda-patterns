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
package us.shalabh.alp.service;

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
public interface IDemoS3EventService
{
	/**
	 * get data from the underlying data-source and
	 * apply business logic.
	 * 
	 * @return
	 */
	public String getData();
}
