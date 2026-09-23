package com.mappls.sdk.maps.renderer.textureview;

import android.content.Context;
import android.view.TextureView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.renderer.MapRenderer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes4.dex */
public class TextureViewMapRenderer extends MapRenderer {
    private TextureViewRenderThread renderThread;
    private boolean translucentSurface;

    public TextureViewMapRenderer(Context context, TextureView textureView, String str, boolean z) {
        super(context, str);
        this.translucentSurface = z;
        TextureViewRenderThread textureViewRenderThread = new TextureViewRenderThread(textureView, this);
        this.renderThread = textureViewRenderThread;
        textureViewRenderThread.start();
    }

    @Override // com.mappls.sdk.maps.renderer.MapRenderer
    protected void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        super.onSurfaceCreated(gl10, eGLConfig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mappls.sdk.maps.renderer.MapRenderer, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        super.onSurfaceChanged(gl10, i, i2);
    }

    @Override // com.mappls.sdk.maps.renderer.MapRenderer
    protected void onSurfaceDestroyed() {
        super.onSurfaceDestroyed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mappls.sdk.maps.renderer.MapRenderer, android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        super.onDrawFrame(gl10);
    }

    @Override // com.mappls.sdk.maps.renderer.MapRenderer
    public void setOnSurfaceBitmapChangeListener(MapplsMap.OnSurfaceBitmapChangeListener onSurfaceBitmapChangeListener) {
        super.setOnSurfaceBitmapChangeListener(onSurfaceBitmapChangeListener);
        this.renderThread.setOnSurfaceBitmapChangeListener(onSurfaceBitmapChangeListener);
    }

    @Override // com.mappls.sdk.maps.renderer.MapRendererScheduler
    public void requestRender() {
        this.renderThread.requestRender();
    }

    @Override // com.mappls.sdk.maps.renderer.MapRendererScheduler
    public void queueEvent(Runnable runnable) {
        this.renderThread.queueEvent(runnable);
    }

    @Override // com.mappls.sdk.maps.renderer.MapRenderer
    public void onStop() {
        this.renderThread.onPause();
    }

    @Override // com.mappls.sdk.maps.renderer.MapRenderer
    public void onStart() {
        this.renderThread.onResume();
    }

    @Override // com.mappls.sdk.maps.renderer.MapRenderer
    public void onDestroy() {
        this.renderThread.onDestroy();
    }

    public boolean isTranslucentSurface() {
        return this.translucentSurface;
    }
}
