package com.google.android.libraries.navigation.internal.oe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class an {
    private final ad a;
    private final int b;
    private final int c;

    public an(ad adVar, int i, int i2) {
        this.a = adVar;
        this.b = i;
        this.c = i2;
    }

    public an(an anVar, int i, int i2) {
        this.a = anVar.a;
        this.b = i + anVar.b;
        this.c = i2 + anVar.b;
    }

    public final int a() {
        return this.c - this.b;
    }

    public final x b(int i) {
        return this.a.l(this.b + i);
    }

    public final ad c() {
        return ad.o(this.a, this.b, this.c);
    }

    public final ai d() {
        x xVarL = this.a.l(this.b);
        int i = xVarL.a;
        int i2 = xVarL.b;
        int i3 = i;
        int i4 = i2;
        for (int i5 = this.b + 1; i5 < this.c; i5++) {
            this.a.u(i5, xVarL);
            int i6 = xVarL.a;
            if (i6 < i) {
                i = i6;
            }
            if (i6 > i3) {
                i3 = i6;
            }
            int i7 = xVarL.b;
            if (i7 < i4) {
                i4 = i7;
            }
            if (i7 > i2) {
                i2 = i7;
            }
        }
        xVarL.J(i, i4);
        return new ai(xVarL, new x(i3, i2));
    }

    public final void e(int i, x xVar) {
        this.a.u(this.b + i, xVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof an) {
            an anVar = (an) obj;
            if (anVar.b == this.b && anVar.c == this.c && anVar.a.equals(this.a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.b + 31) * 31) + this.c) * 31) + this.a.hashCode();
    }

    public final String toString() {
        return "[(" + this.b + "," + this.c + "," + String.valueOf(this.a) + "]";
    }
}
