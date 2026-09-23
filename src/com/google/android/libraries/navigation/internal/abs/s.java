package com.google.android.libraries.navigation.internal.abs;

import android.opengl.Matrix;
import com.google.firebase.messaging.Constants;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class s {
    public final int a;
    public final float[] b;
    public final float[] c;

    public s(com.google.android.libraries.navigation.internal.abt.j jVar, String str, int i, float[] fArr) {
        com.google.android.libraries.navigation.internal.abf.s.k(jVar, Constants.ScionAnalytics.PARAM_LABEL);
        com.google.android.libraries.navigation.internal.abf.s.k(str, "fullText");
        this.a = i;
        com.google.android.libraries.navigation.internal.abf.s.a(i != 0, "glTextureHandle");
        com.google.android.libraries.navigation.internal.abf.s.k(fArr, "model2worldMatrix");
        this.b = fArr;
        int length = fArr.length;
        com.google.android.libraries.navigation.internal.abf.s.a(length == 16, String.format("model2worldMatrix.length:%s", Integer.valueOf(length)));
        float[] fArr2 = new float[16];
        this.c = fArr2;
        Matrix.setIdentityM(fArr2, 0);
    }
}
