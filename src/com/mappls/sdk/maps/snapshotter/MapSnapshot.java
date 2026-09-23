package com.mappls.sdk.maps.snapshotter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.mappls.sdk.maps.geometry.LatLng;

/* JADX INFO: loaded from: classes4.dex */
public class MapSnapshot {
    private String[] attributions;
    private Bitmap bitmap;
    private long nativePtr;
    private boolean showLogo;

    private native void initialize();

    protected native void finalize();

    public native LatLng latLngForPixel(PointF pointF);

    public native PointF pixelForLatLng(LatLng latLng);

    private MapSnapshot(long j, Bitmap bitmap, String[] strArr, boolean z) {
        this.nativePtr = j;
        this.bitmap = bitmap;
        this.attributions = strArr;
        this.showLogo = z;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    protected String[] getAttributions() {
        return this.attributions;
    }

    boolean isShowLogo() {
        return this.showLogo;
    }
}
