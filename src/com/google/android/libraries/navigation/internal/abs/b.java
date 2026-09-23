package com.google.android.libraries.navigation.internal.abs;

import android.opengl.GLES20;
import java.nio.Buffer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    public final void a() {
        GLES20.glActiveTexture(33984);
    }

    public final void b(int i) {
        GLES20.glBindTexture(3553, i);
    }

    public final void c(int i, Buffer buffer) {
        GLES20.glBufferData(34962, i, buffer, 35044);
    }

    public final void d(int i, int[] iArr) {
        GLES20.glDeleteTextures(i, iArr, 0);
    }

    public final void e() {
        GLES20.glDepthMask(false);
    }

    public final void f(int i, int i2) {
        GLES20.glDrawElements(4, i, i2, 0);
    }

    public final void g(int i, int[] iArr) {
        GLES20.glGenTextures(i, iArr, 0);
    }

    public final void h(int i, float f) {
        GLES20.glTexParameterf(3553, i, f);
    }

    public final void i(int i) {
        GLES20.glUniform1i(i, 0);
    }

    public final void j(int i, float[] fArr) {
        GLES20.glUniformMatrix4fv(i, 1, false, fArr, 0);
    }
}
