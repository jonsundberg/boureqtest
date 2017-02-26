package com.bouvet.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.HttpMethod;

import com.bouvet.exception.AppException;

public abstract class UrlUtil {

	private UrlUtil() {

	}
	
	public static String guessContentTypeFromName(String filename){
		return HttpURLConnection.guessContentTypeFromName(filename);
	}
	
	
	public static boolean isStatusOk(String url) {
		return isStatusOk(url,HttpMethod.HEAD);
	}

	public static boolean isStatusOk(String url, String httpMethod) {
		try {
			return getResponseCode(url,httpMethod) == HttpURLConnection.HTTP_OK;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isImage(String url) {
		try {
			return getContentType(url).startsWith("image/");
		} catch (Exception e) {
			return false;
		}
	}

	public static String getContentType(String url) {
		try {
			return createHeadConnection(url).getContentType();
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public static int getResponseCode(String url, String httpMethod) throws AppException {
		try {
			return createHeadConnection(url).getResponseCode();
		} catch (IOException e) {
			throw new AppException(e);
		}
	}
	
	private static HttpURLConnection createHeadConnection(String url) throws AppException{
		return createConnection(url, HttpMethod.HEAD);
	}
	
	private static HttpURLConnection createConnection(String url, String httpMethod) throws AppException{
		try {
			HttpURLConnection huc = (HttpURLConnection) new URL(url).openConnection();
			huc.setRequestMethod(httpMethod);
			return huc;
		} catch (IOException e) {
			throw new AppException(e);
		}
	}

}
