package com.google.android.libraries.navigation.internal.ms;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bl {
    static final void a(bx bxVar, cx cxVar, int i) {
        int i2 = 0;
        while (true) {
            bw[] bwVarArr = bxVar.b;
            if (i2 >= bwVarArr.length) {
                return;
            }
            bwVarArr[i2].d(i == 4 ? cxVar : null);
            i2++;
        }
    }

    static final void b(bx bxVar, cx cxVar, cs csVar, int i) {
        int i2 = 0;
        while (true) {
            bw[] bwVarArr = bxVar.b;
            if (i2 >= bwVarArr.length) {
                return;
            }
            bw bwVar = bwVarArr[i2];
            if (i != 3 || bwVar.c()) {
                try {
                    bwVar.b(cxVar, csVar, i == 1);
                } catch (Exception e) {
                    for (Throwable cause = e; cause != null; cause = cause.getCause()) {
                    }
                    com.google.android.libraries.navigation.internal.mv.b bVarA = com.google.android.libraries.navigation.internal.mv.b.a(e, bwVar, csVar);
                    bVarA.setStackTrace(e.getStackTrace());
                    throw bVarA;
                }
            }
            i2++;
        }
    }
}
