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
package us.shalabh.alp.utils.http;

import java.util.HashMap;
import java.util.Map;

import us.shalabh.alp.model.HttpResponse;

/**
 * Http Utilities
 *
 * @author Shalabh Jaiswal
 */
public class HttpUtils
{
	// HTTP Status Codes
	private static final int HTTP_ACCESS_DENIED = 401;
	private static final int HTTP_INTERNAL_SERVER_ERROR = 500;

	/**
	 * Sets CORS headers
	 * 
	 * @param headers
	 * @return
	 */
	public static void setCORSHeaders(HttpResponse response)
	{
		Map<String, String> headers = response.getHeaders();

		if (headers == null)
		{
			headers = new HashMap<String, String>();
		}

		// TODO narrow the access, and pick up the url from a properties file.
		headers.put("Access-Control-Allow-Origin", "*");
		response.setHeaders(headers);
	}

	/**
	 * sets an error response with 401 code
	 * 
	 * @param response
	 */
	public static void setAccessDeniedResponse(HttpResponse response)
	{
		response.setStatusCode(HTTP_ACCESS_DENIED);
		setCORSHeaders(response);

		response.setBody("Access Denied");
	}

	/**
	 * sets an error response with 500 code
	 * 
	 * @param response
	 */
	public static void setInternalServerErrorResponse(HttpResponse response)
	{
		response.setStatusCode(HTTP_INTERNAL_SERVER_ERROR);
		setCORSHeaders(response);

		response.setBody("Internal Server Error");
	}
}
