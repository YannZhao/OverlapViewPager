package com.overlapviewpager.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class Utils {

	public static int getDeviceWidth(Context context) {
		return getDeviceSize(context)[0];
	}

	public static int getDeviceHeight(Context context) {
		return getDeviceSize(context)[1];
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	public static int[] getDeviceSize(Context context) {
		int[] size = new int[2];

		int measuredWidth = 0;
		int measuredHeight = 0;
		Point point = new Point();
		WindowManager wm = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE));

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			wm.getDefaultDisplay().getSize(point);
			measuredWidth = point.x;
			measuredHeight = point.y;
		} else {
			DisplayMetrics dm = context.getResources().getDisplayMetrics();
			measuredWidth = dm.widthPixels;
			measuredHeight = dm.heightPixels;
		}

		size[0] = measuredWidth;
		size[1] = measuredHeight;
		return size;
	}

}
