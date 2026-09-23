package com.google.android.libraries.navigation.internal.abs;

import android.opengl.GLES20;
import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    private static final String a = "f";
    private final a b;
    private final a c;
    private final a d;
    private final int e;
    private final int f;
    private final e g;
    private final b h;

    public f(float[] fArr, short[] sArr, float[] fArr2, int i) {
        e eVar = e.a;
        b bVar = b.a;
        com.google.android.libraries.navigation.internal.abf.s.a(i != 0, "glShaderProgramHandle");
        this.e = i;
        this.f = 12;
        com.google.android.libraries.navigation.internal.abf.s.k(eVar, "glUtils2");
        this.g = eVar;
        this.h = bVar;
        this.b = eVar.c("vPosition", b(fArr), 3);
        ShortBuffer shortBufferAsShortBuffer = ByteBuffer.allocateDirect(24).order(ByteOrder.nativeOrder()).asShortBuffer();
        shortBufferAsShortBuffer.put(sArr);
        shortBufferAsShortBuffer.position(0);
        com.google.android.libraries.navigation.internal.abf.s.k(shortBufferAsShortBuffer, "shortBuffer");
        int iA = eVar.a();
        GLES20.glBindBuffer(34962, iA);
        b bVar2 = eVar.d;
        int iCapacity = shortBufferAsShortBuffer.capacity();
        bVar2.c(iCapacity + iCapacity, shortBufferAsShortBuffer);
        GLES20.glBindBuffer(34962, 0);
        this.c = new a("indexBuffer", iA, FujifilmMakernoteDirectory.TAG_DEVELOPMENT_DYNAMIC_RANGE, 1);
        this.d = eVar.c("vColor", b(fArr2), 4);
    }

    private final FloatBuffer b(float[] fArr) {
        FloatBuffer floatBufferF = this.g.f(fArr.length * 4);
        floatBufferF.put(fArr);
        floatBufferF.position(0);
        return floatBufferF;
    }

    public final void a(float[] fArr, String str) {
        com.google.android.libraries.navigation.internal.abf.s.a(true, "mvp.length != 4*4 : 16");
        com.google.android.libraries.navigation.internal.abf.s.k(str, "debugStr");
        com.google.android.libraries.navigation.internal.abf.p.f(a, 2);
        GLES20.glUseProgram(this.e);
        this.g.g(this.e, this.b);
        this.g.g(this.e, this.d);
        GLES20.glBindBuffer(34963, this.c.b);
        this.h.j(GLES20.glGetUniformLocation(this.e, "uMVPMatrix"), fArr);
        this.h.f(12, this.c.c);
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindBuffer(34963, 0);
    }
}
