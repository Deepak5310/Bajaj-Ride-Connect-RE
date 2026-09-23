package com.google.android.libraries.navigation.internal.jr;

import com.google.android.libraries.navigation.internal.af.e;
import com.google.android.libraries.navigation.internal.ms.ah;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.ch;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.mw.b;
import com.google.android.libraries.navigation.internal.mx.f;
import com.google.android.libraries.navigation.internal.mx.g;
import com.google.android.libraries.navigation.internal.mx.m;
import com.google.android.libraries.navigation.internal.nc.aj;
import com.google.android.libraries.navigation.internal.nc.an;
import com.google.android.libraries.navigation.internal.nc.ap;
import com.google.android.libraries.navigation.internal.nc.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final ap a = com.google.android.libraries.navigation.internal.nc.a.g(0);
    public static final ap b;
    public static final x c;
    private static final ap d;
    private static final ap e;
    private static final x f;

    /* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.jr.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PG */
    public final class C0034a<T extends cs> extends bt<T> {
        private final ap a;
        private final ap b;

        public C0034a(ap apVar, ap apVar2) {
            super(apVar, apVar2);
            this.a = apVar;
            this.b = apVar2;
        }

        @Override // com.google.android.libraries.navigation.internal.ms.bt
        protected final g a() {
            ap apVar = a.a;
            f fVar = new f(com.google.android.libraries.navigation.internal.js.a.a, new m[0]);
            fVar.e(ah.ab(this.a), ah.V(this.b), ch.f(com.google.android.libraries.navigation.internal.mw.a.DIVIDER_THICKNESS, a.b, b.a), ch.f(com.google.android.libraries.navigation.internal.mw.a.DIVIDER_COLOR, a.c, b.a));
            return fVar;
        }
    }

    static {
        com.google.android.libraries.navigation.internal.nc.a aVarG = com.google.android.libraries.navigation.internal.nc.a.g(1);
        b = aVarG;
        com.google.android.libraries.navigation.internal.nc.a aVarG2 = com.google.android.libraries.navigation.internal.nc.a.g(8);
        d = aVarG2;
        com.google.android.libraries.navigation.internal.nc.a aVarG3 = com.google.android.libraries.navigation.internal.nc.a.g(20);
        e = aVarG3;
        x xVarC = com.google.android.libraries.navigation.internal.w.b.c();
        c = xVarC;
        com.google.android.libraries.navigation.internal.af.a aVarB = e.b(com.google.android.libraries.navigation.internal.w.a.e(), com.google.android.libraries.navigation.internal.w.a.b());
        f = aVarB;
        com.google.android.libraries.navigation.internal.nc.ah ahVarB = aj.b(xVarC, aVarG);
        com.google.android.libraries.navigation.internal.nc.a aVarG4 = com.google.android.libraries.navigation.internal.nc.a.g(0);
        com.google.android.libraries.navigation.internal.nc.a aVarG5 = com.google.android.libraries.navigation.internal.nc.a.g(0);
        new an(new Object[]{ahVarB, aVarG3, aVarG4, aVarG3, aVarG5}, ahVarB, aVarG3, aVarG4, aVarG3, aVarG5);
        aj.b(xVarC, aVarG);
        aj.b(aVarB, aVarG2);
    }
}
