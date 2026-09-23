package com.google.android.libraries.navigation.internal.oe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ai extends aj {
    public final x a;
    public final x b;
    private volatile x c;
    private volatile x d;

    public ai(x xVar, x xVar2) {
        this.a = xVar;
        this.b = xVar2;
    }

    public static ai h(x xVar, int i) {
        return new ai(new x(xVar.a - i, xVar.b - i), new x(xVar.a + i, xVar.b + i));
    }

    public static ai i(x[] xVarArr) {
        ai aiVar = new ai(new x(), new x());
        aiVar.p(xVarArr);
        return aiVar;
    }

    public static ai m(ad adVar) {
        if (adVar.e() <= 0) {
            return null;
        }
        x xVarL = adVar.l(0);
        int i = xVarL.a;
        int i2 = xVarL.b;
        int i3 = i;
        int i4 = i2;
        for (int i5 = 1; i5 < adVar.e(); i5++) {
            adVar.u(i5, xVarL);
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

    @Override // com.google.android.libraries.navigation.internal.oe.aj, com.google.android.libraries.navigation.internal.oe.e
    public final ai a() {
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aj, com.google.android.libraries.navigation.internal.oe.e
    public final boolean b(aj ajVar) {
        if (!(ajVar instanceof ai)) {
            return super.b(ajVar);
        }
        ai aiVar = (ai) ajVar;
        x xVar = this.a;
        int i = xVar.a;
        x xVar2 = aiVar.b;
        if (i > xVar2.a || xVar.b > xVar2.b) {
            return false;
        }
        x xVar3 = this.b;
        int i2 = xVar3.a;
        x xVar4 = aiVar.a;
        return i2 >= xVar4.a && xVar3.b >= xVar4.b;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aj
    public final int c() {
        return 4;
    }

    public final int d() {
        return this.b.b - this.a.b;
    }

    public final int e() {
        return this.b.a - this.a.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ai) {
            ai aiVar = (ai) obj;
            if (aiVar.b.equals(this.b) && aiVar.a.equals(this.a)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aj
    public final x g() {
        return this.a;
    }

    public final int hashCode() {
        return ((this.b.hashCode() + 31) * 31) + this.a.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aj
    public final x j(int i) {
        if (i == 0) {
            if (this.c == null) {
                this.c = new x(this.b.a, this.a.b);
            }
            return this.c;
        }
        if (i == 1) {
            return this.b;
        }
        if (i != 2) {
            if (i == 3) {
                return this.a;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        if (this.d == null) {
            this.d = new x(this.a.a, this.b.b);
        }
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aj
    public final boolean k(x xVar) {
        int i;
        x xVar2 = this.a;
        int i2 = xVar.a;
        if (i2 < xVar2.a) {
            return false;
        }
        x xVar3 = this.b;
        return i2 <= xVar3.a && (i = xVar.b) >= xVar2.b && i <= xVar3.b;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.aj
    public final boolean l(aj ajVar) {
        ai aiVarA = ajVar.a();
        x xVar = aiVarA.a;
        x xVar2 = this.a;
        if (xVar2.a > xVar.a || xVar2.b > xVar.b) {
            return false;
        }
        x xVar3 = this.b;
        x xVar4 = aiVarA.b;
        return xVar3.a >= xVar4.a && xVar3.b >= xVar4.b;
    }

    public final void n(x xVar, x xVar2) {
        o(xVar.a, xVar.b, xVar2.a, xVar2.b);
    }

    public final void o(int i, int i2, int i3, int i4) {
        x xVar = this.a;
        xVar.a = i;
        xVar.b = i2;
        x xVar2 = this.b;
        xVar2.a = i3;
        xVar2.b = i4;
        if (this.c != null) {
            this.c.a = i3;
            this.c.b = i2;
        }
        if (this.d != null) {
            this.d.a = i;
            this.d.b = i4;
        }
    }

    public final void p(x[] xVarArr) {
        x xVar = xVarArr[0];
        int i = xVar.a;
        int i2 = xVar.b;
        int i3 = i;
        int i4 = i2;
        int i5 = i3;
        for (int i6 = 1; i6 < xVarArr.length; i6++) {
            x xVar2 = xVarArr[i6];
            int i7 = xVar2.a;
            if (i7 < i5) {
                i5 = i7;
            }
            if (i7 > i3) {
                i3 = i7;
            }
            int i8 = xVar2.b;
            if (i8 < i2) {
                i2 = i8;
            }
            if (i8 > i4) {
                i4 = i8;
            }
        }
        o(i5, i2, i3, i4);
    }

    public final void q(x xVar) {
        x xVar2 = this.b;
        x xVar3 = this.a;
        xVar.J((xVar3.a + xVar2.a) / 2, (xVar3.b + xVar2.b) / 2);
    }

    public final String toString() {
        x xVar = this.b;
        return "[" + this.a.toString() + ", " + xVar.toString() + "]";
    }

    public final ai f(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.b(i, "distance cannot be negative: "));
        }
        x xVar = this.a;
        x xVar2 = new x(xVar.a - i, xVar.b - i);
        x xVar3 = this.b;
        return new ai(xVar2, new x(xVar3.a + i, xVar3.b + i));
    }
}
