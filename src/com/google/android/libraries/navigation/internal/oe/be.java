package com.google.android.libraries.navigation.internal.oe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class be {
    protected boolean f;

    public abstract int a();

    public abstract x c(int i);

    public bd d() {
        throw null;
    }

    public abstract void e(int i, x[] xVarArr);

    public abstract boolean g(x xVar);

    public boolean k(aj ajVar) {
        if (!d().k(ajVar)) {
            return false;
        }
        if (g(ajVar.j(0)) || ajVar.k(c(0))) {
            return true;
        }
        int iA = a();
        x xVar = ((ai) ajVar).a;
        x[] xVarArr = new x[2];
        for (int i = 0; i < iA; i++) {
            e(i, xVarArr);
            int i2 = 0;
            x xVar2 = xVar;
            while (i2 < 4) {
                x xVarJ = ajVar.j(i2);
                if (y.g(xVarArr[0], xVarArr[1], xVar2, xVarJ)) {
                    return true;
                }
                i2++;
                xVar2 = xVarJ;
            }
        }
        return false;
    }
}
