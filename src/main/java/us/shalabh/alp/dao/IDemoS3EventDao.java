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

/**
 * <p>
 * Demonstrates a Data Access Object Interface that can be provided as a dependency to the
 * Service class <code>DemoS3EventService</code>
 * </p>
 *
 * @author Shalabh Jaiswal
 */
public interface IDemoS3EventDao
{
	/**
	 * get the data
	 * 
	 * @return
	 */
	public String getData();
}
