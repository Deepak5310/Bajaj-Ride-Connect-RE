package com.google.android.libraries.geo.mapcore.renderer;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class dr implements ag {
    private final EGL10 a = (EGL10) EGLContext.getEGL();

    @Override // com.google.android.libraries.geo.mapcore.renderer.ag
    public final int a() {
        return this.a.eglGetError();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ag
    public final dt b(du duVar, ds dsVar, dt dtVar, int[] iArr) {
        return dt.a(this.a.eglCreateContext(dw.d(duVar), dw.b(dsVar), dw.c(dtVar), iArr));
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ag
    public final dt c() {
        return dt.a(this.a.eglGetCurrentContext());
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ag
    public final dt d() {
        return dw.b;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ag
    public final du e() {
        return dw.a;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ag
    public final dv f(du duVar, ds dsVar, Object obj, int[] iArr) {
        EGLSurface eGLSurfaceEglCreateWindowSurface = this.a.eglCreateWindowSurface(dw.d(duVar), dw.b(dsVar), obj, iArr);
        return eGLSurfaceEglCreateWindowSurface == EGL10.EGL_NO_SURFACE ? dw.c : new dv(eGLSurfaceEglCreateWindowSurface);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ag
    public final dv g() {
        return dw.c;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ag
    public final boolean h(du duVar, dt dtVar) {
        return this.a.eglDestroyContext(dw.d(duVar), dw.c(dtVar));
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ag
    public final boolean i(du duVar, int[] iArr) {
        return this.a.eglInitialize(dw.d(duVar), iArr);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ag
    public final boolean j(du duVar, dv dvVar, dv dvVar2, dt dtVar) {
        return this.a.eglMakeCurrent(dw.d(duVar), dw.e(dvVar), dw.e(dvVar2), dw.c(dtVar));
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ag
    public final boolean k(du duVar, dv dvVar) {
        return this.a.eglSwapBuffers(dw.d(duVar), dw.e(dvVar));
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ag
    public final void l(du duVar, int[] iArr, ds[] dsVarArr, int[] iArr2) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        this.a.eglChooseConfig(dw.d(duVar), iArr, eGLConfigArr, 1, iArr2);
        dsVarArr[0] = new ds(eGLConfigArr[0]);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ag
    public final void m(du duVar, dv dvVar) {
        this.a.eglDestroySurface(dw.d(duVar), dw.e(dvVar));
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ag
    public final du n() {
        EGLDisplay eGLDisplayEglGetDisplay = this.a.eglGetDisplay(null);
        return eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY ? dw.a : new du(eGLDisplayEglGetDisplay);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.ag
    public final void o(du duVar) {
        this.a.eglTerminate(dw.d(duVar));
    }
}
