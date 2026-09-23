package com.google.android.libraries.navigation.internal.oe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak {
    public double a;
    public int b;
    public int c;
    public int d;
    public int e;
    private final x f;

    public ak() {
        this(null);
    }

    public ak(byte[] bArr) {
        this.b = Integer.MAX_VALUE;
        this.c = Integer.MIN_VALUE;
        this.d = Integer.MIN_VALUE;
        this.e = Integer.MAX_VALUE;
        this.a = Math.toRadians(0.0d);
        this.f = new x();
    }

    public final void a(r rVar) {
        x xVarZ;
        if (rVar == null || (xVarZ = x.z(rVar)) == null) {
            return;
        }
        this.f.W(xVarZ);
        this.f.U(this.a);
        int i = this.c;
        x xVar = this.f;
        int i2 = xVar.a;
        this.c = Math.max(i, i2);
        this.b = Math.min(this.b, i2);
        int i3 = this.e;
        int i4 = xVar.b;
        this.e = Math.min(i3, i4);
        this.d = Math.max(this.d, i4);
    }
}
