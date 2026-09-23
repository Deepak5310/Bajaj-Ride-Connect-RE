package com.google.android.libraries.geo.mapcore.renderer.jni;

import android.opengl.GLES20;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class RendererJni {
    public static void a(int i, int i2, float[] fArr) {
        GLES20.glUniform4fv(i, i2, fArr, 0);
    }
}
