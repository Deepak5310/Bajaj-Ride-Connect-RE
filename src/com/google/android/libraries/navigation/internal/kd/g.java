package com.google.android.libraries.navigation.internal.kd;

import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.zr.al;
import com.google.android.libraries.navigation.internal.zr.am;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    private int a = 0;
    private float b = 0.0f;
    private float c = 0.0f;

    public final am a() {
        al alVar = (al) am.a.q();
        int i = this.a;
        if (!alVar.b.H()) {
            alVar.v();
        }
        am amVar = (am) alVar.b;
        amVar.b |= 1;
        amVar.c = i;
        float f = this.b;
        if (!alVar.b.H()) {
            alVar.v();
        }
        am amVar2 = (am) alVar.b;
        amVar2.b |= 2;
        amVar2.d = f;
        float f2 = this.c;
        if (!alVar.b.H()) {
            alVar.v();
        }
        am amVar3 = (am) alVar.b;
        amVar3.b |= 4;
        amVar3.e = f2;
        return (am) alVar.t();
    }

    public final void b(float f) {
        this.a++;
        this.b += f;
        this.c += f * f;
    }

    public final String toString() {
        int i = this.a;
        float fSqrt = 0.0f;
        float f = i == 0 ? 0.0f : this.b / i;
        if (i != 0) {
            float f2 = i * this.c;
            float f3 = this.b;
            fSqrt = (float) (Math.sqrt(f2 - (f3 * f3)) / ((double) i));
        }
        return new ak("FLOAT_STATISTICS_TRACKER").c("N", this.a).b("SUM", this.b).b("SUM_SQUARES", this.c).b("AVG", f).b("DEV", fSqrt).toString();
    }
}
