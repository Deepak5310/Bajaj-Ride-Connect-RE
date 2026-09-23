package com.google.android.libraries.geo.navcore.ui.header.views;

import android.graphics.Typeface;
import com.google.android.libraries.navigation.internal.nc.ap;
import com.google.android.libraries.navigation.internal.nc.x;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class m {
    final ap a;
    final ap b;
    final ap c;
    final ap d;
    final x g;
    final Typeface k;
    final ap m;
    final float e = 1.5f;
    final boolean f = true;
    final float h = 0.6f;
    final float i = 0.6f;
    final float j = 0.75f;
    final int l = 5;

    public m(ap apVar, ap apVar2, ap apVar3, ap apVar4, x xVar, Typeface typeface, ap apVar5) {
        this.a = apVar;
        this.b = apVar2;
        this.c = apVar3;
        this.d = apVar4;
        this.g = xVar;
        this.k = typeface;
        this.m = apVar5;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (this.a == mVar.a && this.b == mVar.b && this.c == mVar.c && this.d == mVar.d) {
                float f = mVar.e;
                boolean z = mVar.f;
                if (this.g.equals(mVar.g)) {
                    float f2 = mVar.h;
                    float f3 = mVar.i;
                    float f4 = mVar.j;
                    if (this.k.equals(mVar.k)) {
                        int i = mVar.l;
                        if (this.m == mVar.m) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        ap apVar = this.a;
        ap apVar2 = this.b;
        ap apVar3 = this.c;
        ap apVar4 = this.d;
        Float fValueOf = Float.valueOf(1.5f);
        x xVar = this.g;
        Float fValueOf2 = Float.valueOf(0.6f);
        return Arrays.hashCode(new Object[]{apVar, apVar2, apVar3, apVar4, fValueOf, true, xVar, fValueOf2, fValueOf2, Float.valueOf(0.75f), this.k, 5, this.m});
    }
}
