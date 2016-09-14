package com.doubly.utils;

import android.util.Log;

/**
 * Created by darkbobo on 12/17/15.
 */
public class L {
	public static void e(String text){
		Log.e("Doubly", text);
	}
	public static void e(String tag, String text){
		Log.e(tag, text);
	}
}
