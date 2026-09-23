package com.google.android.libraries.geo.mapcore.renderer;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class dt {
    public final EGLContext a;

    public dt(EGLContext eGLContext) {
        this.a = eGLContext;
    }

    static dt a(EGLContext eGLContext) {
        return eGLContext == EGL10.EGL_NO_CONTEXT ? dw.b : new dt(eGLContext);
    }
}
