package com.mappls.sdk.maps.location;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.location.Location;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Projection;
import com.mappls.sdk.maps.geometry.LatLng;

/* JADX INFO: loaded from: classes4.dex */
public final class Utils {
    private static final String TAG = "Mbgl-com.mappls.sdk.maps.location.Utils";

    public static float normalize(float f) {
        return ((f % 360.0f) + 360.0f) % 360.0f;
    }

    public static float shortestRotation(float f, float f2) {
        double d = f2 - f;
        if (d > 180.0d) {
            return f + 360.0f;
        }
        return d < -180.0d ? f - 360.0f : f;
    }

    private Utils() {
    }

    static Bitmap generateShadow(Drawable drawable, float f) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        try {
            drawable.draw(canvas);
            return Bitmap.createScaledBitmap(bitmapCreateBitmap, toEven(intrinsicWidth + f), toEven(intrinsicHeight + f), false);
        } catch (IllegalArgumentException e) {
            e.getMessage().equals("radius must be > 0");
            throw e;
        }
    }

    private static void ensureShadowGradientRadius(Drawable drawable) {
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setGradientRadius(1.0f);
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            for (int i = 0; i < layerDrawable.getNumberOfLayers(); i++) {
                Drawable drawable2 = layerDrawable.getDrawable(i);
                if (drawable2 instanceof GradientDrawable) {
                    ((GradientDrawable) drawable2).setGradientRadius(1.0f);
                }
            }
        }
    }

    static float calculateZoomLevelRadius(MapplsMap mapplsMap, Location location) {
        if (location == null) {
            return 0.0f;
        }
        return (float) (((double) location.getAccuracy()) * (1.0d / mapplsMap.getProjection().getMetersPerPixelAtLatitude(location.getLatitude())));
    }

    static boolean immediateAnimation(Projection projection, LatLng latLng, LatLng latLng2) {
        return latLng.distanceTo(latLng2) / projection.getMetersPerPixelAtLatitude((latLng.getLatitude() + latLng2.getLatitude()) / 2.0d) > 50000.0d;
    }

    private static int toEven(float f) {
        int i = (int) (f + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }
}
