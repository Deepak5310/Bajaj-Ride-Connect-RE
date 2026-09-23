package com.google.android.libraries.geo.mapcore.renderer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import com.google.android.libraries.navigation.internal.po.fx;
import com.google.android.libraries.navigation.internal.po.gj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, bg {
    private final String a;
    private bi b;
    private bh c;
    private boolean d;
    private boolean e;
    private final gj f;
    private fx g;

    public GLTextureView(Context context, gj gjVar, String str) {
        super(context);
        this.f = gjVar;
        this.a = str;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bg
    public final View a() {
        return this;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bg
    public final void b() {
        bi biVar = this.b;
        if (biVar != null) {
            biVar.a();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bg
    public final void c() {
        this.e = true;
        bi biVar = this.b;
        if (biVar != null) {
            biVar.b();
            this.b = null;
        }
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        fx fxVar = this.g;
        return fxVar == null ? super.canScrollHorizontally(i) : fxVar.a();
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i) {
        fx fxVar = this.g;
        return fxVar == null ? super.canScrollVertically(i) : fxVar.a();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bg
    public final void d() {
        bi biVar = this.b;
        if (biVar != null) {
            biVar.c();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bg
    public final void e() {
        bi biVar = this.b;
        if (biVar != null) {
            biVar.d();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bg
    public final void f() {
        bi biVar = this.b;
        if (biVar != null) {
            biVar.e();
        }
    }

    protected final void finalize() throws Throwable {
        try {
            bi biVar = this.b;
            if (biVar != null) {
                biVar.b();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bg
    public final void g() {
        bi biVar = this.b;
        if (biVar != null) {
            biVar.f();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bg
    public final boolean h() {
        bi biVar = this.b;
        if (biVar != null) {
            return biVar.k();
        }
        return false;
    }

    @Override // android.view.TextureView, android.view.View
    protected final void onAttachedToWindow() {
        bi biVar;
        super.onAttachedToWindow();
        if (this.e) {
            return;
        }
        bh bhVar = this.c;
        if (this.d && bhVar != null && ((biVar = this.b) == null || biVar.j())) {
            bo boVar = new bo(bhVar, this.a);
            this.b = boVar;
            boVar.c();
        }
        this.d = false;
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        this.d = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        bi biVar = this.b;
        if (biVar != null) {
            biVar.g(surfaceTexture);
            this.b.i(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        bi biVar = this.b;
        if (biVar == null) {
            return true;
        }
        biVar.h();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        bi biVar = this.b;
        if (biVar != null) {
            biVar.i(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bg
    public final void setGestureController$ar$class_merging(fx fxVar) {
        this.g = fxVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bg
    public final void setGlThreadPriority$ar$ds() {
        bi biVar = this.b;
        if (biVar != null) {
            biVar.l();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bg
    public final void setTransparent(boolean z) {
        if (z) {
            setAlpha(0.0f);
            setOpaque(false);
        } else {
            setAlpha(1.0f);
            setOpaque(true);
        }
    }

    @Override // android.view.View
    public final void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
            gj gjVar = this.f;
            if (gjVar != null) {
                gjVar.a(i);
            }
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bg
    public final void setRenderer(bh bhVar) {
        if (this.b != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
        this.c = bhVar;
        this.b = new bo(bhVar, this.a);
        setSurfaceTextureListener(this);
    }
}
