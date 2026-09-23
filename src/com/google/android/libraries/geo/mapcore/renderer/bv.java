package com.google.android.libraries.geo.mapcore.renderer;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import androidx.tracing.Trace;
import androidx.work.Data;
import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class bv {
    private float A;
    private final long B;
    private ByteBuffer C;
    private final SparseArray D;
    private int E;
    private int F;
    private int G;
    public float e;
    public bw f;
    public bw g;
    public final boolean[] h;
    public boolean i;
    public boolean j;
    public final int[] k;
    public bw l;
    public ff m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final bw[] f77n;
    public int o;
    public final HashMap p;
    private final Resources s;
    private float z;
    private static final com.google.android.libraries.navigation.internal.zb.j r = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.geo.mapcore.renderer.bv");
    public static int a = 0;
    public static final int[] q = bu.a();
    public int b = -1;
    public int c = -1;
    public int d = -1;
    private int t = -1;
    private int u = -1;
    private boolean v = false;
    private int w = -1;
    private int x = -1;
    private int y = -1;

    public bv(Resources resources, long j) {
        bw bwVar = bw.a;
        this.f = bwVar;
        this.g = bwVar;
        this.i = false;
        this.k = new int[]{0, 0, 0, 0};
        this.C = ByteBuffer.allocateDirect(4096).order(ByteOrder.nativeOrder());
        this.F = 1;
        this.D = new SparseArray();
        this.G = 1;
        this.o = 0;
        this.E = -1;
        this.p = new HashMap();
        com.google.android.libraries.navigation.internal.yx.ar.q(resources);
        this.s = resources;
        this.h = new boolean[bt.a().f];
        this.f77n = new bw[8];
        for (int i = 0; i < 8; i++) {
            this.f77n[i] = bw.a;
        }
        this.B = j;
        ac(4096, false);
    }

    public static final void O() {
        GLES20.glCullFace(1029);
    }

    public static final void S(int i, int i2, int[] iArr) {
        GLES20.glUniform4iv(i, i2, iArr, 0);
    }

    public static final void T(int i, float[] fArr) {
        GLES20.glUniformMatrix3fv(i, 1, false, fArr, 0);
    }

    public static final void V(float[] fArr) {
        GLES20.glVertexAttrib4fv(2, fArr, 0);
    }

    public static final void X(int i, int i2, Bitmap bitmap) {
        GLUtils.texSubImage2D(3553, 0, i, i2, bitmap);
    }

    private static String Z(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        Scanner scanner = new Scanner(str);
        int i = 1;
        while (scanner.hasNextLine()) {
            sb.append(String.format(Locale.US, "%03d", Integer.valueOf(i)));
            sb.append(": ");
            sb.append(scanner.nextLine());
            sb.append("\n");
            i++;
        }
        return sb.toString();
    }

    private final ByteBuffer aa(int i) {
        if (i > this.B) {
            ac(i, true);
            return ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        }
        int iCapacity = this.C.capacity();
        if (iCapacity < i) {
            while (i > iCapacity) {
                iCapacity += iCapacity;
            }
            ac(iCapacity, false);
            this.C = ByteBuffer.allocateDirect(iCapacity).order(ByteOrder.nativeOrder());
        }
        return this.C;
    }

    private static void ab(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        String strConcat = str.concat("\n");
        while (iGlGetError != 0) {
            strConcat = strConcat + "Error code: " + iGlGetError + "\n";
            iGlGetError = GLES20.glGetError();
        }
        new RuntimeException(strConcat);
        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1354)).p("GlContext error");
    }

    private static void ac(int i, boolean z) {
        if (!z) {
            String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
            Trace.setCounter("GLTransferBuffer-size", i);
        } else {
            String[] strArr2 = com.google.android.libraries.navigation.internal.nw.e.a;
            Trace.setCounter("GLTransferBufferOnceOff-size", i);
            Trace.setCounter("GLTransferBufferOnceOff-size", 0);
        }
    }

    private final ByteBuffer ad(float[] fArr, int i) {
        ByteBuffer byteBufferAa = aa(i * 4);
        byteBufferAa.asFloatBuffer().put(fArr, 0, i);
        byteBufferAa.rewind();
        return byteBufferAa;
    }

    public final boolean A() {
        return this.b != -1;
    }

    public final void B(int i, bw bwVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(bwVar);
        if (i == 0) {
            throw null;
        }
        int i2 = i - 1;
        if (this.f77n[i2] != bwVar) {
            if (this.G != i) {
                GLES20.glActiveTexture(33983 + i);
                this.G = i;
            }
            GLES20.glBindTexture(3553, bwVar.d);
            this.f77n[i2] = bwVar;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0019  */
    /* JADX WARN: Code duplicated, block: B:13:0x001d  */
    /* JADX WARN: Code duplicated, block: B:16:0x0021  */
    /* JADX WARN: Code duplicated, block: B:17:0x0025  */
    /* JADX WARN: Code duplicated, block: B:18:0x0027  */
    /* JADX WARN: Code duplicated, block: B:21:0x0041  */
    /* JADX WARN: Code duplicated, block: B:23:? A[RETURN, SYNTHETIC] */
    public final void C(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = i - 1;
        if (i8 != 0) {
            i3 = 9729;
            if (i8 != 1) {
                i3 = 9987;
                i4 = 9729;
            }
            i5 = i2 - 1;
            i6 = 33071;
            if (i5 != 0) {
                i7 = 10497;
                if (i5 != 1) {
                    i6 = 10497;
                } else if (i5 == 2) {
                    i7 = 33071;
                    i6 = 10497;
                }
            } else {
                i7 = 33071;
            }
            GLES20.glTexParameteri(3553, 10241, i3);
            GLES20.glTexParameteri(3553, Data.MAX_DATA_BYTES, i4);
            GLES20.glTexParameteri(3553, 10242, i6);
            GLES20.glTexParameteri(3553, 10243, i7);
            if (i == 3) {
                GLES20.glGenerateMipmap(3553);
            }
        }
        i3 = 9728;
        i4 = i3;
        i5 = i2 - 1;
        i6 = 33071;
        if (i5 != 0) {
            i7 = 10497;
            if (i5 != 1) {
                i6 = 10497;
            } else if (i5 == 2) {
                i7 = 33071;
                i6 = 10497;
            }
        } else {
            i7 = 33071;
        }
        GLES20.glTexParameteri(3553, 10241, i3);
        GLES20.glTexParameteri(3553, Data.MAX_DATA_BYTES, i4);
        GLES20.glTexParameteri(3553, 10242, i6);
        GLES20.glTexParameteri(3553, 10243, i7);
        if (i == 3) {
            GLES20.glGenerateMipmap(3553);
        }
    }

    public final void D(bw bwVar, int i, int i2, int i3, int i4) {
        bw bwVar2 = this.f77n[0];
        B(1, bwVar);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, FujifilmMakernoteDirectory.TAG_FILM_MODE, null);
        C(i3, i4);
        B(1, bwVar2);
        bwVar.e = i * i2 * 4;
    }

    public final void E(bw bwVar, int i, int i2, int i3, int i4, int i5, ByteBuffer byteBuffer) {
        com.google.android.libraries.navigation.internal.yx.ar.q(bwVar);
        bw bwVar2 = this.f77n[0];
        B(1, bwVar);
        GLES20.glTexImage2D(3553, 0, i, i2, i3, 0, i, FujifilmMakernoteDirectory.TAG_FILM_MODE, byteBuffer);
        C(i4, i5);
        B(1, bwVar2);
        bwVar.e = i2 * i3 * 4;
    }

    public final ByteBuffer F(byte[] bArr, int i) {
        ByteBuffer byteBufferAa = aa(i);
        byteBufferAa.put(bArr, 0, i);
        byteBufferAa.rewind();
        return byteBufferAa;
    }

    public final ByteBuffer G(int[] iArr, int i) {
        ByteBuffer byteBufferAa = aa(i * 4);
        byteBufferAa.asIntBuffer().put(iArr, 0, i);
        byteBufferAa.rewind();
        return byteBufferAa;
    }

    public final ByteBuffer H(short[] sArr, int i) {
        ByteBuffer byteBufferAa = aa(i + i);
        byteBufferAa.asShortBuffer().put(sArr, 0, i);
        byteBufferAa.rewind();
        return byteBufferAa;
    }

    public final bw I(String str, int i) {
        bw bwVar = new bw(i);
        bwVar.a(null, this.l);
        this.l = bwVar;
        return bwVar;
    }

    public final void J(float[] fArr, int i, int i2) {
        if (!A()) {
            ((com.google.android.libraries.navigation.internal.zb.h) r.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1355)).p("Started frame before we created our EGL context");
        }
        ab("Unknown GL error(s) in frameStart:");
        this.j = false;
        com.google.android.libraries.navigation.internal.yx.ar.k(!this.i);
        this.i = true;
        GLES20.glDisable(3089);
        GLES20.glColorMask(true, true, true, true);
        GLES20.glDepthMask(true);
        GLES20.glStencilMask(-1);
        GLES20.glClearColor(fArr[0], fArr[1], fArr[2], fArr[3]);
        GLES20.glClearDepthf(1.0f);
        GLES20.glClearStencil(0);
        GLES20.glClear(17664);
        GLES20.glViewport(0, 0, i, i2);
        p();
    }

    public final void K(float[] fArr, int i) {
        s(34962, i * 4, ad(fArr, i), 35044);
    }

    public final void L(int i, int[] iArr, int i2) {
        s(34962, i2 * 4, G(iArr, i2), 35044);
    }

    public final void M(short[] sArr, int i, int i2) {
        s(34963, i + i, H(sArr, i), i2);
    }

    public final void N(int i, int i2, float[] fArr, int i3) {
        GLES20.glBufferSubData(i, i2, i3 * 4, ad(fArr, i3));
    }

    public final void P(int i, int i2) {
        GLES20.glDrawArrays(i, 0, i2);
    }

    public final void Q(int i, int i2, int i3) {
        GLES20.glDrawElements(i, i2, FujifilmMakernoteDirectory.TAG_DEVELOPMENT_DYNAMIC_RANGE, i3);
    }

    public final void R(int i, int i2, int[] iArr) {
        GLES20.glUniform2iv(i, i2, iArr, 0);
    }

    public final void U(int i, float[] fArr) {
        GLES20.glUniformMatrix4fv(i, 1, false, fArr, 0);
    }

    public final void W(int i, int i2, int i3, int i4, byte[] bArr) {
        GLES20.glTexSubImage2D(3553, 0, i, i2, i3, i4, 6408, FujifilmMakernoteDirectory.TAG_FILM_MODE, F(bArr, bArr.length));
    }

    public final void Y(bw bwVar, int i, int i2, int i3, int i4, int[] iArr) {
        E(bwVar, 6408, i, i2, 1, 2, G(iArr, iArr.length));
    }

    public final int a(String str, String str2, String[] strArr) {
        int iC = c(35633, str);
        int iC2 = c(35632, str2);
        int iGlCreateProgram = GLES20.glCreateProgram();
        int iGlGetError = GLES20.glGetError();
        if (iGlCreateProgram == 0 || iGlGetError != 0) {
            throw new fa("glCreateProgram failed", "<no info log>", Z(str), Z(str2));
        }
        GLES20.glAttachShader(iGlCreateProgram, iC);
        int iGlGetError2 = GLES20.glGetError();
        if (iGlGetError2 != 0) {
            throw new fa("glAttachShader(vertShader) failed", com.google.android.libraries.navigation.internal.b.b.l(iGlGetError2, iC, "Shader id: ", "\nGL error code: "), Z(str), Z(str2));
        }
        GLES20.glAttachShader(iGlCreateProgram, iC2);
        if (GLES20.glGetError() != 0) {
            throw new fa("glAttachShader(fragShader) failed", com.google.android.libraries.navigation.internal.b.b.b(iC2, "Shader id "), Z(str), Z(str2));
        }
        for (int i = 0; i < strArr.length; i++) {
            String str3 = strArr[i];
            if (!str3.equals("unused")) {
                GLES20.glBindAttribLocation(iGlCreateProgram, i, str3);
                int iGlGetError3 = GLES20.glGetError();
                if (iGlGetError3 != 0) {
                    throw new fa("glBindAttribLocation failed", "Attrib name: " + str3 + "\nAttrib index: " + i + "\nGL error code: " + iGlGetError3, Z(str), Z(str2));
                }
            }
        }
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = this.k;
        iArr[0] = 0;
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        int[] iArr2 = this.k;
        int iGlGetError4 = GLES20.glGetError();
        if (iArr2[0] == 1 && iGlGetError4 == 0) {
            return iGlCreateProgram;
        }
        throw new fa("glLinkProgram failed", GLES20.glGetProgramInfoLog(iGlCreateProgram), Z(str), Z(str2));
    }

    public final int b(int i, String str) {
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(i, str);
        if (GLES20.glGetError() != 0) {
            throw new fa("Error while getting uniform location for ".concat(str));
        }
        if (iGlGetUniformLocation != -1) {
            return iGlGetUniformLocation;
        }
        throw new fa("Unable to get uniform location for ".concat(str));
    }

    final int c(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        int iGlGetError = GLES20.glGetError();
        if (iGlCreateShader == 0 || iGlGetError != 0) {
            throw new fa(com.google.android.libraries.navigation.internal.b.b.l(iGlGetError, iGlCreateShader, "glCreateShader failed with return value ", " and GL error code "), "<no info log>", i, "<unused source>");
        }
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = this.k;
        iArr[0] = 0;
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        int[] iArr2 = this.k;
        int iGlGetError2 = GLES20.glGetError();
        if (iArr2[0] == 0 || iGlGetError2 != 0) {
            throw new fa("glCompileShader failed", GLES20.glGetShaderInfoLog(iGlCreateShader), i, Z(str));
        }
        return iGlCreateShader;
    }

    public final bw d(String str) {
        int[] iArr = this.k;
        iArr[0] = 0;
        GLES20.glGenBuffers(1, iArr, 0);
        return I(String.valueOf(str).concat("_indices"), this.k[0]);
    }

    public final bw e(String str) {
        int[] iArr = this.k;
        iArr[0] = 0;
        GLES20.glGenTextures(1, iArr, 0);
        return I(String.valueOf(str).concat("_texture"), this.k[0]);
    }

    public final bw f(String str) {
        int[] iArr = this.k;
        iArr[0] = 0;
        GLES20.glGenBuffers(1, iArr, 0);
        return I(String.valueOf(str).concat("_vertices"), this.k[0]);
    }

    public final ee g(Class cls) {
        ee eeVar;
        ee eeVar2 = (ee) this.p.get(cls);
        if (eeVar2 != null) {
            return eeVar2;
        }
        try {
            eeVar = (ee) cls.newInstance();
            try {
                this.p.put(cls, eeVar);
            } catch (IllegalAccessException | InstantiationException unused) {
                eeVar2 = eeVar;
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1352)).s("Failed to instantiate ShaderProgram class %s", cls);
                eeVar = eeVar2;
            }
        } catch (IllegalAccessException | InstantiationException unused2) {
        }
        com.google.android.libraries.navigation.internal.yx.ar.q(eeVar);
        return eeVar;
    }

    public final ek h(int i) {
        ek ekVar = (ek) this.D.get(i);
        if (ekVar != null) {
            return ekVar;
        }
        ek ekVar2 = new ek(com.google.android.libraries.navigation.internal.b.b.b(i, "resource"), 3, 1);
        Resources resources = this.s;
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = displayMetrics.densityDpi;
        options.inTargetDensity = displayMetrics.densityDpi;
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(resources, i, options);
        if (bitmapDecodeResource != null) {
            int width = bitmapDecodeResource.getWidth();
            int height = bitmapDecodeResource.getHeight();
            boolean zJ = com.google.android.libraries.navigation.internal.nq.a.j(bitmapDecodeResource.getWidth());
            int height2 = bitmapDecodeResource.getHeight();
            if (!zJ || !com.google.android.libraries.navigation.internal.nq.a.j(height2)) {
                Bitmap.Config config = Bitmap.Config.ARGB_8888;
                int width2 = bitmapDecodeResource.getWidth();
                int height3 = bitmapDecodeResource.getHeight();
                int iF = com.google.android.libraries.navigation.internal.nq.a.f(width2, 1);
                int iF2 = com.google.android.libraries.navigation.internal.nq.a.f(height3, 1);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iF, iF2, config);
                bitmapCreateBitmap.setDensity(bitmapDecodeResource.getDensity());
                bitmapCreateBitmap.eraseColor(0);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                Paint paint = new Paint();
                canvas.drawBitmap(bitmapDecodeResource, 0.0f, 0.0f, paint);
                if (iF > width2) {
                    canvas.drawBitmap(bitmapDecodeResource, new Rect(width2 - 1, 0, width2, height3), new Rect(width2, 0, width2 + 1, height3), paint);
                }
                if (iF2 > height3) {
                    canvas.drawBitmap(bitmapDecodeResource, new Rect(0, height3 - 1, width2, height3), new Rect(0, height3, width2, height3 + 1), paint);
                }
                if (iF > width2 && iF2 > height3) {
                    canvas.drawBitmap(bitmapDecodeResource, new Rect(width2 - 1, height3 - 1, width2, height3), new Rect(width2, height3, width2 + 1, height3 + 1), paint);
                }
                bitmapDecodeResource.recycle();
                bitmapDecodeResource = bitmapCreateBitmap;
            }
            ekVar2.a(bitmapDecodeResource, width, height);
        }
        this.D.put(i, ekVar2);
        return ekVar2;
    }

    public final void i(bw bwVar) {
        int i = bwVar.d;
        if (i != this.g.d) {
            GLES20.glBindBuffer(34963, i);
        }
        this.g = bwVar;
    }

    public final void j(int i) {
        if (this.E == i) {
            return;
        }
        GLES20.glUseProgram(i);
        this.E = i;
    }

    public final void k(bw bwVar) {
        int i = bwVar.d;
        if (i != this.f.d) {
            GLES20.glBindBuffer(34962, i);
        }
        this.f = bwVar;
    }

    public final void l(bw bwVar) {
        if (bwVar == this.f) {
            z();
        }
        if (bwVar == this.g) {
            y();
        }
        int[] iArr = this.k;
        iArr[0] = bwVar.d;
        GLES20.glDeleteBuffers(1, iArr, 0);
        x(bwVar);
    }

    public final void m(bw bwVar) {
        if (bwVar.b()) {
            for (int i = 0; i < 8; i++) {
                bw[] bwVarArr = this.f77n;
                if (bwVarArr[i] == bwVar) {
                    bwVarArr[i] = bw.a;
                }
            }
            int[] iArr = this.k;
            iArr[0] = bwVar.d;
            GLES20.glDeleteTextures(1, iArr, 0);
            x(bwVar);
        }
    }

    public final void n(int i) {
        if (this.h[i]) {
            GLES20.glDisableVertexAttribArray(i);
            this.h[i] = false;
        }
    }

    public final void o(int i) {
        if (this.h[i]) {
            return;
        }
        GLES20.glEnableVertexAttribArray(i);
        this.h[i] = true;
    }

    public final void p() {
        this.c = -1;
        this.d = -1;
        this.t = -1;
        this.u = -1;
        this.v = false;
        this.w = Integer.MIN_VALUE;
        this.x = Integer.MIN_VALUE;
        this.y = Integer.MIN_VALUE;
        this.z = Float.NaN;
        this.A = Float.NaN;
        this.e = Float.NaN;
        for (int i = 0; i < 8; i++) {
            GLES20.glActiveTexture(33984 + i);
            GLES20.glBindTexture(3553, 0);
            this.f77n[i] = bw.a;
        }
        GLES20.glActiveTexture(33984);
        this.G = 1;
        this.E = -1;
        GLES20.glBindBuffer(34962, bw.a.d);
        GLES20.glBindBuffer(34963, bw.a.d);
        bw bwVar = bw.a;
        this.f = bwVar;
        this.g = bwVar;
        for (int i2 = 0; i2 < this.h.length; i2++) {
            GLES20.glDisableVertexAttribArray(i2);
            this.h[i2] = false;
        }
    }

    public final void q() {
        com.google.android.libraries.navigation.internal.yx.ar.k(this.i);
        this.i = false;
        ab("Unknown GL error(s) in frameEnd:");
    }

    public final void r(int i, int i2) {
        com.google.android.libraries.navigation.internal.yx.ar.k(this.i);
        if (this.c == i && this.d == i2) {
            return;
        }
        if (i == 1 && i2 == 0) {
            GLES20.glDisable(3042);
        } else {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(i, i2);
        }
        this.c = i;
        this.d = i2;
    }

    public final void s(int i, int i2, Buffer buffer, int i3) {
        GLES20.glBufferData(i, i2, buffer, i3);
        if (i == 34962) {
            this.f.e = i2;
        } else {
            this.g.e = i2;
        }
    }

    public final void t(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.k(this.i);
        if (this.t == i) {
            return;
        }
        if (i == 519) {
            GLES20.glDisable(2929);
        } else {
            GLES20.glEnable(2929);
            GLES20.glDepthFunc(i);
        }
        this.t = i;
    }

    public final void u(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.k(this.i);
        if (this.u == i) {
            return;
        }
        GLES20.glDepthMask(1 == i);
        this.u = i;
    }

    public final void v(float f, float f2) {
        com.google.android.libraries.navigation.internal.yx.ar.k(this.i);
        if (this.z == f && this.A == f2) {
            return;
        }
        if (f == 0.0f && f2 == 0.0f) {
            GLES20.glDisable(32823);
        } else {
            GLES20.glEnable(32823);
            GLES20.glPolygonOffset(f, f2);
        }
        this.z = f;
        this.A = f2;
    }

    public final void w(boolean z, int i, int i2, int i3) {
        com.google.android.libraries.navigation.internal.yx.ar.k(this.i);
        if (this.v == z && this.w == i && this.x == i2 && this.y == i3) {
            return;
        }
        if (z) {
            GLES20.glEnable(2960);
            GLES20.glStencilFunc(i, i2, i3);
            if (i == 519) {
                GLES20.glStencilOp(7681, 7681, 7681);
            } else {
                GLES20.glStencilOp(7680, 7680, 7680);
            }
            GLES20.glStencilMask(i3);
        } else {
            GLES20.glDisable(2960);
        }
        this.v = z;
        this.w = i;
        this.x = i2;
        this.y = i3;
    }

    public final void x(bw bwVar) {
        com.google.android.libraries.navigation.internal.yx.ar.k(bwVar.b());
        if (this.l == bwVar) {
            this.l = bwVar.c;
        }
        bw bwVar2 = bwVar.b;
        if (bwVar2 != null) {
            bwVar2.c = bwVar.c;
        }
        bw bwVar3 = bwVar.c;
        if (bwVar3 != null) {
            bwVar3.b = bwVar2;
        }
        bwVar.b = null;
        bwVar.c = null;
        bwVar.g = false;
    }

    public final void y() {
        i(bw.a);
    }

    public final void z() {
        k(bw.a);
    }
}
