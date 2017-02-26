package com.bouvet.service;

import java.util.Collection;

import com.bouvet.AppProperties;
import com.bouvet.api.Image;
import com.bouvet.exception.AppException;
import com.bouvet.image.resolve.BouvetImageResolver;

public class ImageService {

	public static Collection<Image> fetchFromBouvet() throws AppException {
		String bouvetUrl = AppProperties.getInstance().getBouvetUrl();
		return BouvetImageResolver.INSTANCE.resolve(bouvetUrl);
	}


}
