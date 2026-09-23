package com.google.android.libraries.geo.mapcore.renderer;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class dw implements ai {
    public static final du a = new du(EGL10.EGL_NO_DISPLAY);
    public static final dt b = new dt(EGL10.EGL_NO_CONTEXT);
    public static final dv c = new dv(EGL10.EGL_NO_SURFACE);
    private static final ah d = new dr();

    public static EGLConfig b(ds dsVar) {
        com.google.android.libraries.navigation.internal.yx.ar.a(true);
        return dsVar.a;
    }

    public static EGLContext c(dt dtVar) {
        com.google.android.libraries.navigation.internal.yx.ar.a(true);
        return dtVar.a;
    }

    public static EGLDisplay d(du duVar) {
        com.google.android.libraries.navigation.internal.yx.ar.a(true);
        return duVar.a;
    }

    public static EGLSurface e(dv dvVar) {
        com.google.android.libraries.navigation.internal.yx.ar.a(true);
        return dvVar.a;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ai
    public final ah a() {
        return d;
    }
}
