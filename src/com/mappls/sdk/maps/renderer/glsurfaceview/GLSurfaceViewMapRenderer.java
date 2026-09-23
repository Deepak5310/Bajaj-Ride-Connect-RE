package com.mappls.sdk.maps.renderer.glsurfaceview;

import android.content.Context;
import android.opengl.GLSurfaceView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.renderer.MapRenderer;
import com.mappls.sdk.maps.renderer.egl.EGLConfigChooser;
import com.mappls.sdk.maps.renderer.egl.EGLContextFactory;
import com.mappls.sdk.maps.renderer.egl.EGLWindowSurfaceFactory;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes4.dex */
public class GLSurfaceViewMapRenderer extends MapRenderer implements GLSurfaceView.Renderer {
    private final MapplsGLSurfaceView glSurfaceView;

    public GLSurfaceViewMapRenderer(Context context, MapplsGLSurfaceView mapplsGLSurfaceView, String str) {
        super(context, str);
        this.glSurfaceView = mapplsGLSurfaceView;
        mapplsGLSurfaceView.setEGLContextFactory(new EGLContextFactory());
        mapplsGLSurfaceView.setEGLWindowSurfaceFactory(new EGLWindowSurfaceFactory());
        mapplsGLSurfaceView.setEGLConfigChooser(new EGLConfigChooser());
        mapplsGLSurfaceView.setRenderer(this);
        mapplsGLSurfaceView.setRenderMode(0);
        mapplsGLSurfaceView.setPreserveEGLContextOnPause(true);
        mapplsGLSurfaceView.setDetachedListener(new MapplsGLSurfaceView.OnGLSurfaceViewDetachedListener() { // from class: com.mappls.sdk.maps.renderer.glsurfaceview.GLSurfaceViewMapRenderer.1
            @Override // com.mappls.sdk.maps.renderer.glsurfaceview.MapplsGLSurfaceView.OnGLSurfaceViewDetachedListener
            public void onGLSurfaceViewDetached() {
                GLSurfaceViewMapRenderer.this.nativeReset();
            }
        });
    }

    @Override // com.mappls.sdk.maps.renderer.MapRenderer
    public void onStop() {
        this.glSurfaceView.onPause();
    }

    @Override // com.mappls.sdk.maps.renderer.MapRenderer
    public void onPause() {
        super.onPause();
    }

    @Override // com.mappls.sdk.maps.renderer.MapRenderer
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.mappls.sdk.maps.renderer.MapRenderer
    public void onStart() {
        this.glSurfaceView.onResume();
    }

    @Override // com.mappls.sdk.maps.renderer.MapRenderer
    public void onResume() {
        super.onResume();
    }

    @Override // com.mappls.sdk.maps.renderer.MapRenderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        super.onSurfaceCreated(gl10, eGLConfig);
    }

    @Override // com.mappls.sdk.maps.renderer.MapRenderer
    protected void onSurfaceDestroyed() {
        super.onSurfaceDestroyed();
    }

    @Override // com.mappls.sdk.maps.renderer.MapRenderer, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        super.onSurfaceChanged(gl10, i, i2);
    }

    @Override // com.mappls.sdk.maps.renderer.MapRenderer
    public void setOnSurfaceBitmapChangeListener(MapplsMap.OnSurfaceBitmapChangeListener onSurfaceBitmapChangeListener) {
        super.setOnSurfaceBitmapChangeListener(onSurfaceBitmapChangeListener);
        this.glSurfaceView.setOnSurfaceBitmapChangeListener(onSurfaceBitmapChangeListener);
    }

    @Override // com.mappls.sdk.maps.renderer.MapRenderer, android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        super.onDrawFrame(gl10);
    }

    @Override // com.mappls.sdk.maps.renderer.MapRendererScheduler
    public void requestRender() {
        this.glSurfaceView.requestRender();
    }

    @Override // com.mappls.sdk.maps.renderer.MapRendererScheduler
    public void queueEvent(Runnable runnable) {
        this.glSurfaceView.queueEvent(runnable);
    }
}
