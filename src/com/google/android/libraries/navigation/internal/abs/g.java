package com.google.android.libraries.navigation.internal.abs;

import android.opengl.GLES20;
import android.support.v4.media.session.PlaybackStateCompat;
import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;
import com.google.android.libraries.navigation.internal.abf.aj;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.FloatBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    public static final String a = "g";
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final e f;
    public boolean g;
    public a h;
    public a i;
    public a j;
    public final float[] k;
    public final char[] l;
    private final String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final b f148n;
    private final FloatBuffer o;
    private final FloatBuffer p;
    private final CharBuffer q;

    public g(String str, int i, int i2) {
        e eVar = e.a;
        b bVar = b.a;
        com.google.android.libraries.navigation.internal.abf.s.k(str, "debugName");
        this.m = str;
        Integer numValueOf = Integer.valueOf(i);
        com.google.android.libraries.navigation.internal.abf.s.g(i, 1, 65536, String.format("widthQuads[%s] must be <= %s", numValueOf, 65536));
        this.b = i;
        Integer numValueOf2 = Integer.valueOf(i2);
        com.google.android.libraries.navigation.internal.abf.s.g(i2, 1, 65536, String.format("heightQuads[%s] must be <= %s", numValueOf2, 65536));
        this.c = i2;
        int i3 = i + 1;
        this.d = i3;
        int i4 = i2 + 1;
        this.e = i4;
        String str2 = String.format("[%s x %s] quads size exceeds %s vertex limit", numValueOf, numValueOf2, 65536);
        int i5 = 0;
        com.google.android.libraries.navigation.internal.abf.s.a(((long) i3) * ((long) i4) < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, str2);
        com.google.android.libraries.navigation.internal.abf.s.k(eVar, "glUtils2");
        this.f = eVar;
        this.f148n = bVar;
        int i6 = i3 * i4;
        this.o = eVar.f(i6 * 12);
        this.p = eVar.f(i6 * 8);
        int i7 = i * i2 * 6;
        this.q = ByteBuffer.allocateDirect(i7 + i7).order(ByteOrder.nativeOrder()).asCharBuffer();
        float[] fArr = new float[i6 * 3];
        this.k = fArr;
        char[] cArr = new char[i7];
        this.l = cArr;
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(cArr, (char) 0);
        this.g = false;
        this.h = null;
        this.i = null;
        this.j = null;
        int i8 = 0;
        while (i8 < i2) {
            for (int i9 = i5; i9 < i; i9++) {
                int i10 = this.d;
                int i11 = (i8 * i10) + i9;
                int i12 = i11 + 1;
                int i13 = i10 + i11;
                int i14 = i13 + 1;
                int i15 = ((i8 * i) + i9) * 6;
                char c = (char) i11;
                this.q.put(i15, c);
                int i16 = i15 + 1;
                char c2 = (char) i12;
                this.q.put(i16, c2);
                int i17 = i15 + 2;
                char c3 = (char) i13;
                this.q.put(i17, c3);
                int i18 = i15 + 3;
                this.q.put(i18, c2);
                int i19 = i15 + 4;
                this.q.put(i19, c3);
                int i20 = i15 + 5;
                char c4 = (char) i14;
                this.q.put(i20, c4);
                char[] cArr2 = this.l;
                cArr2[i15] = c;
                cArr2[i16] = c2;
                cArr2[i17] = c3;
                cArr2[i18] = c2;
                cArr2[i19] = c3;
                cArr2[i20] = c4;
            }
            i8++;
            i5 = 0;
        }
    }

    public static int a(String str, e eVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(str, "tag");
        com.google.android.libraries.navigation.internal.abf.s.k(eVar, "glUtils2");
        return eVar.b(str, "uniform   mat4  uMVPMatrix; attribute vec3  vPosition; attribute vec2  a_texCoord; varying   vec2  v_texCoord; void main() {   gl_Position = uMVPMatrix * vec4(vPosition,1);   v_texCoord = a_texCoord; }", "precision mediump float; uniform sampler2D u_Texture; uniform float     alpha; varying vec2      v_texCoord; void main() {   gl_FragColor = texture2D(u_Texture, v_texCoord);   gl_FragColor.a *= alpha; }");
    }

    public final void b() {
        if (this.g) {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
            return;
        }
        try {
            this.h = this.f.c("vPosition", this.o, 3);
            this.i = this.f.c("a_texCoord", this.p, 2);
            e eVar = this.f;
            CharBuffer charBuffer = this.q;
            com.google.android.libraries.navigation.internal.abf.s.k(charBuffer, "charBuffer");
            int iA = eVar.a();
            GLES20.glBindBuffer(34962, iA);
            b bVar = eVar.d;
            int iCapacity = charBuffer.capacity();
            bVar.c(iCapacity + iCapacity, charBuffer);
            GLES20.glBindBuffer(34962, 0);
            this.j = new a("indexBuffer", iA, FujifilmMakernoteDirectory.TAG_DEVELOPMENT_DYNAMIC_RANGE, 6);
            this.g = true;
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException(String.format("%s.glUploadBuffers() failed to acquire a glHandle", this.m), e);
        }
    }

    public final void c(int i) {
        com.google.android.libraries.navigation.internal.abf.s.a(i != 0, "shaderProgramHandle");
        if (!this.g) {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
            return;
        }
        this.f.g(i, this.h);
        this.f.g(i, this.i);
        GLES20.glBindBuffer(34963, this.j.b);
    }

    public final void d() {
        if (!this.g) {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
        } else {
            this.f148n.f(this.b * this.c * 6, this.j.c);
        }
    }

    public final void e(int i, int i2, float f, float f2, float f3, float f4, float f5) {
        String str = a;
        com.google.android.libraries.navigation.internal.abf.p.f(str, 2);
        Integer numValueOf = Integer.valueOf(i);
        int i3 = this.d;
        com.google.android.libraries.navigation.internal.abf.s.g(i, 0, i3 - 1, String.format("i[%s] must be within [0,%s)", numValueOf, Integer.valueOf(i3)));
        Integer numValueOf2 = Integer.valueOf(i2);
        int i4 = this.e;
        com.google.android.libraries.navigation.internal.abf.s.g(i2, 0, i4 - 1, String.format("j[%s] must be within [0,%s)", numValueOf2, Integer.valueOf(i4)));
        if (this.g) {
            com.google.android.libraries.navigation.internal.abf.p.f(str, 6);
            return;
        }
        int i5 = (i2 * this.d) + i;
        int i6 = i5 * 3;
        this.o.put(i6, f);
        int i7 = i6 + 1;
        this.o.put(i7, f2);
        int i8 = i6 + 2;
        this.o.put(i8, f3);
        float[] fArr = this.k;
        fArr[i6] = f;
        fArr[i7] = f2;
        fArr[i8] = f3;
        int i9 = i5 + i5;
        this.p.put(i9, f4);
        this.p.put(i9 + 1, f5);
    }

    public final String toString() {
        aj ajVarF = aj.f(this);
        ajVarF.g("debugName", this.m);
        aj ajVarE = ajVarF.c("widthQuads", this.b).c("heightQuads", this.c).e("isGLUploaded", this.g);
        ajVarE.g("vertexChannelInfo", this.h);
        ajVarE.g("texCoordChannelInfo", this.i);
        ajVarE.g("indexChannelInfo", this.j);
        return ajVarE.toString();
    }
}
