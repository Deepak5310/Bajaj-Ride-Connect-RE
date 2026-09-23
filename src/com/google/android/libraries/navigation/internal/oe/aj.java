package com.google.android.libraries.navigation.internal.oe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class aj implements e {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.oe.aj");

    @Override // com.google.android.libraries.navigation.internal.oe.e
    public ai a() {
        int i = j(0).a;
        int iMin = j(0).b;
        int iMax = i;
        int iMax2 = iMin;
        int iMin2 = iMax;
        for (int i2 = 1; i2 < 4; i2++) {
            iMin2 = Math.min(iMin2, j(i2).a);
            iMax = Math.max(iMax, j(i2).a);
            iMin = Math.min(iMin, j(i2).b);
            iMax2 = Math.max(iMax2, j(i2).b);
        }
        return new ai(new x(iMin2, iMin), new x(iMax, iMax2));
    }

    @Override // com.google.android.libraries.navigation.internal.oe.e
    public boolean b(aj ajVar) {
        if (ajVar == null || ajVar.j(0) == null) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 815)).p("Tried to intersect null region, or region with null vertex.");
            return false;
        }
        if (!r(ajVar)) {
            return false;
        }
        if (k(ajVar.j(0)) || ajVar.k(j(0))) {
            return true;
        }
        return s(ajVar);
    }

    public abstract int c();

    public x g() {
        throw null;
    }

    public abstract x j(int i);

    public abstract boolean k(x xVar);

    public boolean l(aj ajVar) {
        if (r(ajVar)) {
            for (int i = 0; i < 4; i++) {
                if (!k(ajVar.j(i))) {
                    return false;
                }
            }
            if (!s(ajVar)) {
                return true;
            }
        }
        return false;
    }

    final boolean r(aj ajVar) {
        int iMin = j(0).a;
        int iMin2 = j(0).b;
        int iMax = iMin2;
        int iMax2 = iMin;
        for (int i = 1; i < 4; i++) {
            iMin = Math.min(iMin, j(i).a);
            iMax2 = Math.max(iMax2, j(i).a);
            iMin2 = Math.min(iMin2, j(i).b);
            iMax = Math.max(iMax, j(i).b);
        }
        int iMax3 = ajVar.j(0).a;
        int i2 = 1;
        int iMin3 = ajVar.j(0).b;
        int iMax4 = iMin3;
        int iMin4 = iMax3;
        while (true) {
            ajVar.c();
            if (i2 >= 4) {
                break;
            }
            iMin4 = Math.min(iMin4, ajVar.j(i2).a);
            iMax3 = Math.max(iMax3, ajVar.j(i2).a);
            iMin3 = Math.min(iMin3, ajVar.j(i2).b);
            iMax4 = Math.max(iMax4, ajVar.j(i2).b);
            i2++;
        }
        return iMin <= iMax3 && iMin2 <= iMax4 && iMax2 >= iMin4 && iMax >= iMin3;
    }

    protected final boolean s(aj ajVar) {
        ajVar.c();
        x xVarG = g();
        x xVarG2 = ajVar.g();
        int i = 0;
        while (i < 4) {
            x xVarJ = j(i);
            x xVar = xVarG2;
            int i2 = 0;
            while (i2 < 4) {
                x xVarJ2 = ajVar.j(i2);
                if (y.g(xVarG, xVarJ, xVar, xVarJ2)) {
                    return true;
                }
                i2++;
                xVar = xVarJ2;
            }
            i++;
            xVarG = xVarJ;
        }
        return false;
    }
}
