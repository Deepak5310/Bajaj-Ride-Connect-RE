package com.google.android.libraries.navigation.internal.abw;

import android.opengl.GLSurfaceView;
import android.view.Choreographer;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abf.s;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g extends h implements Choreographer.FrameCallback {
    private final Choreographer c;

    public g(Choreographer choreographer) {
        s.k(choreographer, "choreographer");
        this.c = choreographer;
    }

    @Override // com.google.android.libraries.navigation.internal.abw.h
    protected final void a() {
        this.c.postFrameCallback(this);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        GLSurfaceView gLSurfaceView = this.b;
        if (gLSurfaceView == null) {
            p.f(h.a, 3);
        } else {
            p.f(h.a, 2);
            gLSurfaceView.requestRender();
        }
    }
}
