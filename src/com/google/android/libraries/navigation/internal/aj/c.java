package com.google.android.libraries.navigation.internal.aj;

import android.animation.TimeInterpolator;
import com.google.android.libraries.navigation.internal.ms.bq;
import com.google.android.libraries.navigation.internal.ms.cx;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.mx.ac;
import com.google.android.libraries.navigation.internal.mx.w;
import com.google.android.libraries.navigation.internal.nc.ap;
import com.google.android.libraries.navigation.internal.yx.am;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static final c a;
    public static final bq b;
    private static final cx q;
    public final ap c;
    public final ap d;
    public final ap e;
    public final ap f;
    public final float g;
    public final float h;
    public final float i;
    public final float j;
    public final float k;
    public final float l;
    public final TimeInterpolator m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f341n;
    public final int o;
    public final boolean p;

    static {
        c cVar = new c(new b());
        a = cVar;
        b = new bq();
        q = new d(cVar);
    }

    public c() {
        this(new b());
    }

    public c(b bVar) {
        this.c = bVar.a;
        this.d = bVar.b;
        this.e = bVar.c;
        this.f = bVar.d;
        this.g = 1.0f;
        this.h = 1.0f;
        this.i = 1.0f;
        this.j = 1.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = bVar.i;
        this.f341n = bVar.j;
        this.o = bVar.k;
        this.p = false;
    }

    public static w a(dd ddVar) {
        return new ac(com.google.android.libraries.navigation.internal.ad.b.ANIMATION, ddVar, q);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.c.equals(cVar.c) || !this.d.equals(cVar.d) || !this.e.equals(cVar.e) || !this.f.equals(cVar.f)) {
            return false;
        }
        float f = cVar.g;
        float f2 = cVar.h;
        float f3 = cVar.i;
        float f4 = cVar.j;
        float f5 = cVar.k;
        float f6 = cVar.l;
        if (!am.a(this.m, cVar.m) || this.f341n != cVar.f341n || this.o != cVar.o) {
            return false;
        }
        boolean z = cVar.p;
        return true;
    }

    public final int hashCode() {
        ap apVar = this.c;
        ap apVar2 = this.d;
        ap apVar3 = this.e;
        ap apVar4 = this.f;
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        return Arrays.hashCode(new Object[]{apVar, apVar2, apVar3, apVar4, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf2, fValueOf2, this.m, Integer.valueOf(this.f341n), Integer.valueOf(this.o), false});
    }
}
