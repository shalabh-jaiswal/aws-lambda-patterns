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
