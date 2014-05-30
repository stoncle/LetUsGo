package com.superman.letusgo.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

public class AppCache {
	
	// tag for log
	private static String TAG = AppCache.class.getSimpleName();
	
	public static Bitmap getCachedImage (Context ctx, String url) {
		String cacheKey = AppUtil.md5(url);
		/*
		 * 如果本地缓存照片存在，则直接从本地获取，否则从网络上获取
		 */
		Bitmap cachedImage = SDUtil.getImage(cacheKey);
		if (cachedImage != null) {
			Log.w(TAG, "get cached image");
			return cachedImage;
		} else {
			Bitmap newImage = IOUtil.getBitmapRemote(ctx, url);
			SDUtil.saveImage(newImage, cacheKey);
			return newImage;
		}
	}
	
	public static Bitmap getImage (String url) {
		String cacheKey = AppUtil.md5(url);
		return SDUtil.getImage(cacheKey);
	}
}