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
