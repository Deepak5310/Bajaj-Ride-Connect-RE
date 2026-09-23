package com.mappls.sdk.maps.renderer;

import android.content.Context;
import com.mappls.sdk.maps.LibraryLoader;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.log.Logger;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapRenderer implements MapRendererScheduler {
    private static final String TAG = "Mbgl-MapRenderer";
    private MapplsMap.OnFpsChangedListener onFpsChangedListener;
    private long timeElapsed;
    private long nativePtr = 0;
    private double expectedRenderTime = 0.0d;

    private native void nativeInitialize(MapRenderer mapRenderer, float f, String str);

    private native void nativeOnSurfaceChanged(int i, int i2);

    private native void nativeOnSurfaceCreated();

    private native void nativeOnSurfaceDestroyed();

    private native void nativeRender();

    protected native void finalize() throws Throwable;

    protected native void nativeReset();

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void setOnSurfaceBitmapChangeListener(MapplsMap.OnSurfaceBitmapChangeListener onSurfaceBitmapChangeListener) {
    }

    static {
        LibraryLoader.load();
    }

    public MapRenderer(Context context, String str) {
        nativeInitialize(this, context.getResources().getDisplayMetrics().density, str);
    }

    public void setOnFpsChangedListener(MapplsMap.OnFpsChangedListener onFpsChangedListener) {
        this.onFpsChangedListener = onFpsChangedListener;
    }

    protected void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        nativeOnSurfaceCreated();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        gl10.glViewport(0, 0, i, i2);
        nativeOnSurfaceChanged(i, i2);
    }

    protected void onSurfaceDestroyed() {
        nativeOnSurfaceDestroyed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDrawFrame(GL10 gl10) {
        long jNanoTime = System.nanoTime();
        try {
            nativeRender();
        } catch (Error e) {
            Logger.e(TAG, e.getMessage());
        }
        double dNanoTime = System.nanoTime() - jNanoTime;
        double d = this.expectedRenderTime;
        if (dNanoTime < d) {
            try {
                Thread.sleep((long) ((d - dNanoTime) / 1000000.0d));
            } catch (InterruptedException e2) {
                Logger.e(TAG, e2.getMessage());
            }
        }
        if (this.onFpsChangedListener != null) {
            updateFps();
        }
    }

    void queueEvent(MapRendererRunnable mapRendererRunnable) {
        queueEvent((Runnable) mapRendererRunnable);
    }

    private void updateFps() {
        long jNanoTime = System.nanoTime();
        this.onFpsChangedListener.onFpsChanged(1.0E9d / (jNanoTime - this.timeElapsed));
        this.timeElapsed = jNanoTime;
    }

    public void setMaximumFps(int i) {
        if (i <= 0) {
            return;
        }
        this.expectedRenderTime = 1.0E9d / ((double) i);
    }
}
