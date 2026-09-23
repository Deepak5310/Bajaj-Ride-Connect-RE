package com.google.android.libraries.navigation.internal.afn;

import android.graphics.Matrix;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g {
    String a;
    String b;
    boolean c;
    float d;
    float e;
    float f;
    float g;
    float h;
    float i;
    float j;
    ArrayList k = new ArrayList();
    ArrayList l = new ArrayList();
    Matrix m = null;

    public final g a(g gVar) {
        g gVar2 = new g();
        gVar2.a = gVar.a;
        gVar2.b = this.a;
        gVar2.c = gVar.c;
        gVar2.d = gVar.d;
        gVar2.f = gVar.f;
        gVar2.e = gVar.e;
        gVar2.g = gVar.g;
        gVar2.h = gVar.h;
        gVar2.i = gVar.i;
        gVar2.j = gVar.j;
        gVar2.k = this.k;
        gVar2.l = this.l;
        gVar2.m = this.m;
        Matrix matrix = gVar.m;
        if (matrix != null) {
            Matrix matrix2 = this.m;
            if (matrix2 == null) {
                gVar2.m = matrix;
            } else {
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.preConcat(gVar.m);
                gVar2.m = matrix3;
            }
        }
        return gVar2;
    }
}
