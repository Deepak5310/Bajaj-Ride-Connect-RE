package com.google.android.libraries.geo.mapcore.renderer;

import android.opengl.GLES20;
import androidx.tracing.Trace;
import com.facebook.hermes.intl.Constants;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bt {
    private static bs a;

    /* JADX WARN: Code duplicated, block: B:11:0x0018 A[Catch: all -> 0x01e8, PHI: r9
      0x0018: PHI (r9v3 com.google.android.libraries.geo.mapcore.renderer.bs) = 
      (r9v0 com.google.android.libraries.geo.mapcore.renderer.bs)
      (r9v1 com.google.android.libraries.geo.mapcore.renderer.bs)
      (r9v0 com.google.android.libraries.geo.mapcore.renderer.bs)
      (r9v0 com.google.android.libraries.geo.mapcore.renderer.bs)
      (r9v0 com.google.android.libraries.geo.mapcore.renderer.bs)
     binds: [B:68:0x01b4, B:66:0x019c, B:63:0x0192, B:16:0x0025, B:10:0x0016] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0007, B:11:0x0018, B:70:0x01b8, B:72:0x01bc, B:82:0x01e3, B:81:0x01e0, B:83:0x01e4, B:7:0x000d, B:13:0x001d, B:17:0x0026, B:19:0x0031, B:21:0x003f, B:23:0x006c, B:25:0x0094, B:34:0x00ce, B:37:0x00d8, B:40:0x00f7, B:42:0x0125, B:43:0x0133, B:45:0x0139, B:47:0x0147, B:48:0x014a, B:50:0x0152, B:52:0x015a, B:56:0x0163, B:61:0x017a, B:64:0x0194, B:67:0x019e, B:29:0x00c0, B:77:0x01da), top: B:90:0x0003, inners: #0, #2 }] */
    public static synchronized bs a() {
        EGLSurface eGLSurfaceEglCreatePbufferSurface;
        EGLDisplay eGLDisplayEglGetDisplay;
        if (a == null) {
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("GlConstantsProvider.createGlConstants");
            try {
                EGL10 egl10 = (EGL10) EGLContext.getEGL();
                bs bsVar = null;
                if (egl10 != null) {
                    EGLContext eGLContextEglGetCurrentContext = egl10.eglGetCurrentContext();
                    if (eGLContextEglGetCurrentContext != null) {
                        if (eGLContextEglGetCurrentContext.equals(EGL10.EGL_NO_CONTEXT)) {
                            eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                            if (!eGLDisplayEglGetDisplay.equals(EGL10.EGL_NO_DISPLAY)) {
                                egl10.eglInitialize(eGLDisplayEglGetDisplay, new int[2]);
                                int[][] iArr = {new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12326, 8, 12325, 8, 12352, 4, 12344}, new int[]{12326, 8, 12325, 8, 12338, 0, 12344}};
                                int[][] iArr2 = {new int[]{12440, 2, 12344}, new int[]{12440, 1, 12344}};
                                EGLContext eGLContext = eGLContextEglGetCurrentContext;
                                EGLSurface eGLSurface = null;
                                int i = 0;
                                while (true) {
                                    if (i >= 2) {
                                        eGLContextEglGetCurrentContext = eGLContext;
                                        eGLSurfaceEglCreatePbufferSurface = eGLSurface;
                                        break;
                                    }
                                    int[] iArr3 = new int[1];
                                    int i2 = i;
                                    c(egl10, eGLDisplayEglGetDisplay, iArr[i], null, 0, iArr3);
                                    int i3 = iArr3[0];
                                    EGLConfig[] eGLConfigArr = new EGLConfig[i3];
                                    c(egl10, eGLDisplayEglGetDisplay, iArr[i2], eGLConfigArr, i3, iArr3);
                                    if (iArr3[0] > 0) {
                                        eGLContextEglGetCurrentContext = egl10.eglCreateContext(eGLDisplayEglGetDisplay, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, iArr2[i2]);
                                        b(egl10);
                                        eGLSurfaceEglCreatePbufferSurface = egl10.eglCreatePbufferSurface(eGLDisplayEglGetDisplay, eGLConfigArr[0], new int[]{12375, 2, 12374, 2, 12344});
                                        b(egl10);
                                        boolean zEglMakeCurrent = egl10.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglGetCurrentContext);
                                        b(egl10);
                                        if (zEglMakeCurrent) {
                                            break;
                                        }
                                        eGLContext = eGLContextEglGetCurrentContext;
                                        eGLSurface = eGLSurfaceEglCreatePbufferSurface;
                                    }
                                    i = i2 + 1;
                                }
                            } else {
                                eGLSurfaceEglCreatePbufferSurface = null;
                            }
                        } else {
                            eGLSurfaceEglCreatePbufferSurface = null;
                            eGLDisplayEglGetDisplay = null;
                        }
                        if (eGLContextEglGetCurrentContext == null || eGLContextEglGetCurrentContext.equals(EGL10.EGL_NO_CONTEXT)) {
                            com.google.android.libraries.navigation.internal.zb.j.a aVar = com.google.android.libraries.navigation.internal.zb.j.b;
                            new RuntimeException("Failed to create off-screen context");
                            ((com.google.android.libraries.navigation.internal.zb.h) aVar.F(1346)).p("GlConstantsProvider");
                            if (dVarB != null) {
                                Trace.endSection();
                            }
                        } else {
                            String strGlGetString = GLES20.glGetString(7936);
                            String strGlGetString2 = GLES20.glGetString(7938);
                            String strGlGetString3 = GLES20.glGetString(7937);
                            int[] iArr4 = new int[1];
                            GLES20.glGetIntegerv(3379, iArr4, 0);
                            int i4 = iArr4[0];
                            if (i4 == 0) {
                                i4 = 2048;
                            }
                            int i5 = i4;
                            GLES20.glGetIntegerv(35660, iArr4, 0);
                            int i6 = iArr4[0];
                            GLES20.glGetIntegerv(36347, iArr4, 0);
                            int i7 = iArr4[0];
                            int[] iArr5 = new int[2];
                            GLES20.glGetIntegerv(33902, iArr5, 0);
                            int i8 = iArr5[1];
                            GLES20.glGetIntegerv(34921, iArr5, 0);
                            int i9 = iArr5[0];
                            String strGlGetString4 = GLES20.glGetString(7939);
                            br brVar = br.NONE;
                            if (strGlGetString4 != null) {
                                for (String str : com.google.android.libraries.navigation.internal.yx.bj.b(' ').g(strGlGetString4)) {
                                    if (com.google.android.libraries.navigation.internal.yx.c.c(str, "GL_OES_TEXTURE_NPOT")) {
                                        brVar = br.FULL;
                                        break;
                                    }
                                    if (com.google.android.libraries.navigation.internal.yx.c.c(str, "GL_IMG_TEXTURE_NPOT") || com.google.android.libraries.navigation.internal.yx.c.c(str, "GL_NV_TEXTURE_NPOT_2D_MIPMAP")) {
                                        brVar = br.CLAMP;
                                    }
                                }
                            }
                            br brVar2 = brVar;
                            if (eGLSurfaceEglCreatePbufferSurface != null && eGLDisplayEglGetDisplay != null) {
                                egl10.eglMakeCurrent(eGLDisplayEglGetDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                                egl10.eglDestroySurface(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface);
                                egl10.eglDestroyContext(eGLDisplayEglGetDisplay, eGLContextEglGetCurrentContext);
                            }
                            if (strGlGetString == null && strGlGetString2 == null && strGlGetString3 == null && strGlGetString4 == null) {
                                com.google.android.libraries.navigation.internal.zb.j.a aVar2 = com.google.android.libraries.navigation.internal.zb.j.b;
                                new RuntimeException("Failed to get GlConstants");
                                ((com.google.android.libraries.navigation.internal.zb.h) aVar2.F(1348)).p("GlConstantsProvider");
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                            } else {
                                bsVar = new bs(strGlGetString, strGlGetString2, strGlGetString3, i5, i6, i7, i8, i9, brVar2);
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                            }
                        }
                    } else if (dVarB != null) {
                        Trace.endSection();
                    }
                } else if (dVarB != null) {
                    Trace.endSection();
                }
                a = bsVar;
                if (bsVar == null) {
                    a = new bs(Constants.COLLATION_INVALID, Constants.COLLATION_INVALID, Constants.COLLATION_INVALID, 2048, 0, 128, 1, 8, br.NONE);
                }
            } catch (Throwable th) {
                if (dVarB == null) {
                    throw th;
                }
                try {
                    Trace.endSection();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        }
        return a;
    }

    private static void b(EGL10 egl10) {
        egl10.eglGetError();
    }

    private static void c(EGL10 egl10, EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
    }
}
