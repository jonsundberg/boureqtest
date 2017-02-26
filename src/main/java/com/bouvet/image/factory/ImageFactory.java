package com.bouvet.image.factory;

import java.util.concurrent.ExecutionException;

import com.bouvet.api.Image;
import com.bouvet.constant.Delimiter;
import com.bouvet.exception.AppException;
import com.bouvet.util.UrlUtil;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class ImageFactory {

	private static final ImageFactory imageFactory = null;

	private static final LoadingCache<Image, Image> imageCache = CacheBuilder.newBuilder().maximumSize(200).build(new CacheLoader<Image, Image>() {
		public Image load(Image image) throws Exception {
			return validateImage(image);
		}

		private Image validateImage(Image image) {
			image.setValid(UrlUtil.isImage(image.getUrl()));
			return image;
		}
	});

	private ImageFactory() {
	}

	public static ImageFactory getInstance() {
		if (null == imageFactory) {
			return new ImageFactory();
		}
		return imageFactory;
	}

	public Image get(String url, String comment) throws AppException {
		try {
			return imageCache.get(new Image(url, comment));
		} catch (ExecutionException e) {
			throw new AppException(e);
		}
	}
	
	public Image get(String url) throws AppException {
		return get(url,null);
	}

	public Image parseLine(String s, Delimiter delimiter) throws AppException {
		if(s.contains(delimiter.getDelimiter())){
			String[] split = delimiter.split(s,2);
			return get(split[0],split[1]);
		}
		return get(s);
	}

}
