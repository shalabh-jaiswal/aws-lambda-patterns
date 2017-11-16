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

import us.shalabh.alp.dao.IDemoHttpRequestDao;

/**
 * Service Class Implementation
 *
 * @author Shalabh Jaiswal
 */
@Singleton
public class DemoHttpRequestService implements IDemoHttpRequestService
{
	private IDemoHttpRequestDao demoHttpRequestDao;
	
	/**
	 * contructor injection
	 */
	@Inject
	public DemoHttpRequestService(IDemoHttpRequestDao demoHttpRequestDao)
	{
		this.demoHttpRequestDao = demoHttpRequestDao;
	}
	
	/* (non-Javadoc)
	 * @see us.shalabh.alp.service.IDemoHttpRequestService#getData()
	 */
	@Override
	public String getData()
	{
		return demoHttpRequestDao.getData();
	}

}
