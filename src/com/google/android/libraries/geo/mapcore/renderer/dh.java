package com.google.android.libraries.geo.mapcore.renderer;

import android.opengl.GLES20;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class dh {
    bx a;
    bv b;
    dk f;
    int g;
    int h;
    int j;
    int k;
    int l;
    int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f80n;
    int o;
    int p;
    int q;
    int r;
    int s;
    ArrayList c = new ArrayList();
    ArrayList d = new ArrayList();
    final float[] i = new float[16];
    private final int[] t = new int[8];
    f e = new f();

    public dh(bx bxVar) {
        this.g = 0;
        this.h = 0;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.f80n = -1;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = -1;
        this.a = bxVar;
        this.b = bxVar.b();
        dk dkVar = new dk();
        this.f = dkVar;
        di diVar = dkVar.d;
        String[] strArr = {diVar.a, diVar.b, diVar.c};
        int iGlCreateShader = GLES20.glCreateShader(35633);
        GLES20.glShaderSource(iGlCreateShader, this.f.a);
        GLES20.glCompileShader(iGlCreateShader);
        int iGlCreateShader2 = GLES20.glCreateShader(35632);
        GLES20.glShaderSource(iGlCreateShader2, this.f.b);
        GLES20.glCompileShader(iGlCreateShader2);
        int iGlCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(iGlCreateProgram, iGlCreateShader);
        GLES20.glAttachShader(iGlCreateProgram, iGlCreateShader2);
        for (int i = 0; i < 3; i++) {
            GLES20.glBindAttribLocation(iGlCreateProgram, i, strArr[i]);
        }
        GLES20.glLinkProgram(iGlCreateProgram);
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, this.t, 0);
        int iGlGetError = GLES20.glGetError();
        if (this.t[0] != 1 || iGlGetError != 0) {
            GLES20.glGetProgramInfoLog(iGlCreateProgram);
            a(this.f.a);
            a(this.f.b);
        }
        this.g = iGlCreateProgram;
        d dVar = this.e.d;
        String[] strArr2 = {dVar.a, dVar.b, dVar.c, dVar.d};
        int iGlCreateShader3 = GLES20.glCreateShader(35633);
        GLES20.glShaderSource(iGlCreateShader3, this.e.a);
        GLES20.glCompileShader(iGlCreateShader3);
        int iGlCreateShader4 = GLES20.glCreateShader(35632);
        GLES20.glShaderSource(iGlCreateShader4, this.e.b);
        GLES20.glCompileShader(iGlCreateShader4);
        int iGlCreateProgram2 = GLES20.glCreateProgram();
        GLES20.glAttachShader(iGlCreateProgram2, iGlCreateShader3);
        GLES20.glAttachShader(iGlCreateProgram2, iGlCreateShader4);
        for (int i2 = 0; i2 < 4; i2++) {
            GLES20.glBindAttribLocation(iGlCreateProgram2, i2, strArr2[i2]);
        }
        GLES20.glLinkProgram(iGlCreateProgram2);
        GLES20.glGetProgramiv(iGlCreateProgram2, 35714, this.t, 0);
        int iGlGetError2 = GLES20.glGetError();
        if (this.t[0] != 1 || iGlGetError2 != 0) {
            a(this.e.a);
            a(this.e.b);
        }
        this.h = iGlCreateProgram2;
        dj djVar = this.f.c;
        this.j = GLES20.glGetUniformLocation(this.g, djVar.a);
        this.k = GLES20.glGetUniformLocation(this.g, djVar.b);
        this.l = GLES20.glGetUniformLocation(this.g, djVar.d);
        this.m = GLES20.glGetUniformLocation(this.g, djVar.c);
        e eVar = this.e.c;
        this.f80n = GLES20.glGetUniformLocation(this.h, eVar.a);
        this.o = GLES20.glGetUniformLocation(this.h, eVar.b);
        this.p = GLES20.glGetUniformLocation(this.h, eVar.f);
        this.q = GLES20.glGetUniformLocation(this.h, eVar.c);
        this.r = GLES20.glGetUniformLocation(this.h, eVar.d);
        this.s = GLES20.glGetUniformLocation(this.h, eVar.e);
    }

    private static String a(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        Scanner scanner = new Scanner(str);
        int i = 1;
        while (scanner.hasNextLine()) {
            sb.append(String.format(Locale.getDefault(), "%03d", Integer.valueOf(i)));
            sb.append(": ");
            sb.append(scanner.nextLine());
            sb.append("\n");
            i++;
        }
        return sb.toString();
    }
}
