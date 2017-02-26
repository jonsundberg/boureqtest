package com.bouvet.image.resolve;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.bouvet.api.Image;
import com.bouvet.constant.Delimiter;
import com.bouvet.exception.AppException;
import com.bouvet.image.factory.ImageFactory;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public enum BouvetImageResolver implements RemoteImageResolver{
	
	INSTANCE;

	@Override
	public Collection<Image> resolve(String url) throws AppException {
		List<Image> images = new ArrayList<>();
		try {
			List<String> lines = Resources.readLines(new URL(url), Charsets.UTF_8);
			for (String line : lines) {
				if(isValidLine(line)){
					Image image = ImageFactory.getInstance().parseLine(line,Delimiter.SPACE);
					if(image.isValid() && !images.contains(image)){
						images.add(image);
					}
				}
				
			}
		} catch (Exception e) {
			throw new AppException(e.getMessage(), e);
		} 
		return images;
	}

	private boolean isValidLine(String s) {
		return null != s && !s.startsWith("#") && !s.isEmpty();
	}

}
