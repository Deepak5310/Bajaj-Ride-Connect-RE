package com.google.android.libraries.navigation.internal.cy;

import com.google.android.libraries.navigation.internal.db.i;
import com.google.android.libraries.navigation.internal.db.j;
import com.google.android.libraries.navigation.internal.de.x;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.google.android.libraries.navigation.internal.kp.c implements com.google.android.libraries.navigation.internal.ic.a {
    private final j a;
    private final boolean b = false;

    public a(j jVar) {
        this.a = jVar;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.e, com.google.android.libraries.navigation.internal.ic.a
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c
    public final com.google.android.libraries.navigation.internal.kp.f c() {
        com.google.android.libraries.navigation.internal.kp.f fVarG = new com.google.android.libraries.navigation.internal.kp.f("car-head").g("timeMs", this.a.c);
        int iB = i.b(this.a.i);
        if (iB == 0) {
            iB = i.a;
        }
        if (iB == 0) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.kp.f fVarH = fVarG.f("provider", iB - 1).c("head", this.a.d).c("sd", this.a.e).c("rot", this.a.f).h("use", this.a.g);
        x xVarJ = j();
        if (xVarJ != null) {
            fVarH.m("pose", String.format(Locale.US, "%f,%f,%f,%f", Float.valueOf(xVarJ.a), Float.valueOf(xVarJ.b), Float.valueOf(xVarJ.c), Float.valueOf(xVarJ.d)));
        }
        return fVarH;
    }

    public final float f() {
        return this.a.d;
    }

    public final float g() {
        return this.a.e;
    }

    public final float h() {
        return this.a.f;
    }

    public final long i() {
        return this.a.c;
    }

    public final x j() {
        j jVar = this.a;
        if ((jVar.b & 32) == 0) {
            return null;
        }
        com.google.android.libraries.navigation.internal.afj.d dVar = jVar.h;
        if (dVar == null) {
            dVar = com.google.android.libraries.navigation.internal.afj.d.a;
        }
        return new x((float) dVar.b, (float) dVar.c, (float) dVar.d, (float) dVar.e);
    }

    @Override // com.google.android.libraries.navigation.internal.kp.e
    public final boolean k() {
        return false;
    }

    public final boolean l() {
        return this.a.g;
    }

    public final int m() {
        int iB = i.b(this.a.i);
        return iB == 0 ? i.a : iB;
    }

    public final String toString() {
        ak akVarD = al.b(this).d("timeMs", i());
        int iM = m();
        String strA = i.a(iM);
        if (iM == 0) {
            throw null;
        }
        akVarD.g("provider", strA);
        ak akVarE = akVarD.b("heading", f()).b("rateOfTurn", h()).b("headingStdDev", g()).e("shouldUseHeading", l());
        akVarE.g("pose", j());
        return akVarE.toString();
    }
}
