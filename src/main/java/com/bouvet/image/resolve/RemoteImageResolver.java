package com.bouvet.image.resolve;

import java.util.Collection;

import com.bouvet.api.Image;
import com.bouvet.exception.AppException;

@FunctionalInterface
public interface RemoteImageResolver {

	public Collection<Image> resolve(String url) throws AppException;
	
	
}
