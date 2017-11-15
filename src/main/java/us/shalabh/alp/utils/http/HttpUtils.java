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
