package com.google.android.libraries.navigation.internal.abs;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.opengl.GLUtils;
import androidx.work.Data;
import app.notifee.core.event.LogEvent;
import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;
import com.google.android.libraries.navigation.internal.abf.ad;
import com.google.android.libraries.navigation.internal.abf.ah;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public static final e a = new e(b.a);
    public static final ThreadLocal b;
    public static final ThreadLocal c;
    private static final ThreadLocal e;
    private static final ThreadLocal f;
    private static final ThreadLocal g;
    private static final ThreadLocal h;
    public final b d;

    static {
        ExecutorService executorService = ah.a;
        e = new ad();
        f = new ad();
        g = new ad();
        h = new ad();
        b = new ad();
        c = new ad();
    }

    public e(b bVar) {
        this.d = bVar;
    }

    static String e(int i) {
        if (i == 0) {
            return null;
        }
        Integer numValueOf = Integer.valueOf(i);
        return String.format("*** GlError *** #%s|0x%x: %s", numValueOf, numValueOf, GLU.gluErrorString(i));
    }

    static final int k(String str, int i, String str2) {
        com.google.android.libraries.navigation.internal.abf.s.k(str, "tag");
        com.google.android.libraries.navigation.internal.abf.p.f(str, 4);
        int iGlCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(iGlCreateShader, str2);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = (int[]) g.get();
        iArr[0] = 0;
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] == 1) {
            com.google.android.libraries.navigation.internal.abf.p.f(str, 4);
            return iGlCreateShader;
        }
        IllegalStateException illegalStateException = new IllegalStateException(String.format("glCompileShader() FAILED[%s]: %s", Integer.valueOf(iArr[0]), GLES20.glGetShaderInfoLog(iGlCreateShader)));
        com.google.android.libraries.navigation.internal.abf.p.f(str, 6);
        throw illegalStateException;
    }

    public final int a() {
        int[] iArr = (int[]) e.get();
        iArr[0] = 0;
        GLES20.glGenBuffers(1, iArr, 0);
        return iArr[0];
    }

    public final int b(String str, String str2, String str3) {
        com.google.android.libraries.navigation.internal.abf.s.k(str, "tag");
        com.google.android.libraries.navigation.internal.abf.p.f(str, 4);
        int iK = k(str, 35633, str2);
        int iK2 = k(str, 35632, str3);
        int iGlCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(iGlCreateProgram, iK);
        GLES20.glAttachShader(iGlCreateProgram, iK2);
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = (int[]) h.get();
        iArr[0] = 0;
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            com.google.android.libraries.navigation.internal.abf.p.f(str, 4);
            return iGlCreateProgram;
        }
        IllegalStateException illegalStateException = new IllegalStateException(String.format("glLinkProgram() FAILED[%s]: %s", Integer.valueOf(iArr[0]), GLES20.glGetProgramInfoLog(iGlCreateProgram)));
        com.google.android.libraries.navigation.internal.abf.p.f(str, 6);
        throw illegalStateException;
    }

    public final a c(String str, FloatBuffer floatBuffer, int i) {
        com.google.android.libraries.navigation.internal.abf.s.k(floatBuffer, "floatBuffer");
        int iA = a();
        GLES20.glBindBuffer(34962, iA);
        this.d.c(floatBuffer.capacity() * 4, floatBuffer);
        GLES20.glBindBuffer(34962, 0);
        return new a(str, iA, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, i);
    }

    public final String d() {
        return e(GLES20.glGetError());
    }

    public final FloatBuffer f(int i) {
        return ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public final void g(int i, a aVar) {
        com.google.android.libraries.navigation.internal.abf.s.a(i != 0, "shaderProgram");
        com.google.android.libraries.navigation.internal.abf.s.k(aVar, LogEvent.LEVEL_INFO);
        GLES20.glBindBuffer(34962, aVar.b);
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(i, aVar.a);
        GLES20.glEnableVertexAttribArray(iGlGetAttribLocation);
        GLES20.glVertexAttribPointer(iGlGetAttribLocation, aVar.d, aVar.c, false, 0, 0);
    }

    public final void h(a aVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(aVar, "glChannelInfo");
        int[] iArr = (int[]) f.get();
        iArr[0] = aVar.b;
        GLES20.glDeleteBuffers(1, iArr, 0);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0043  */
    public final void i(int i, Bitmap bitmap) {
        com.google.android.libraries.navigation.internal.abf.s.k(bitmap, "bitmap");
        int i2 = 1;
        com.google.android.libraries.navigation.internal.abf.s.a(i != 0, "glTextureHandle");
        this.d.b(i);
        this.d.h(10241, 9728.0f);
        this.d.h(Data.MAX_DATA_BYTES, 9729.0f);
        this.d.h(10242, 33071.0f);
        this.d.h(10243, 33071.0f);
        ThreadLocal threadLocal = com.google.android.libraries.navigation.internal.abf.k.a;
        Bitmap.Config config = bitmap.getConfig();
        if (config != null) {
            int i3 = com.google.android.libraries.navigation.internal.abf.i.a[config.ordinal()];
            if (i3 != 1) {
                i2 = 2;
                if (i3 != 2 && i3 != 3) {
                    i2 = 4;
                }
            }
        } else {
            i2 = 4;
        }
        int[] iArr = (int[]) com.google.android.libraries.navigation.internal.abf.k.a.get();
        iArr[0] = 0;
        GLES20.glGetIntegerv(3317, iArr, 0);
        int i4 = iArr[0];
        if (i2 != i4) {
            com.google.android.libraries.navigation.internal.abf.j.a(i2);
        }
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        if (i2 != i4) {
            com.google.android.libraries.navigation.internal.abf.j.a(i4);
        }
    }

    public final void j(String str) {
        com.google.android.libraries.navigation.internal.abf.s.k(str, "TAG");
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            while (iGlGetError != 0) {
                if (com.google.android.libraries.navigation.internal.abf.p.f(str, 6)) {
                    e(iGlGetError);
                }
                iGlGetError = GLES20.glGetError();
            }
        }
    }
}
