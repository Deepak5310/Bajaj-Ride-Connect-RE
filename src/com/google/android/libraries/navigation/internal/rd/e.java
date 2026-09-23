package com.google.android.libraries.navigation.internal.rd;

import com.google.android.libraries.navigation.internal.adg.er;
import com.google.android.libraries.navigation.internal.adg.es;
import com.google.android.libraries.navigation.internal.adg.ex;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class e implements g {
    public static e c(int i) {
        er erVar = (er) es.a.q();
        if (!erVar.b.H()) {
            erVar.v();
        }
        es esVar = (es) erVar.b;
        esVar.b |= 1;
        esVar.c = i;
        return new b((es) erVar.t());
    }

    public static e d(ex exVar) {
        er erVar = (er) es.a.q();
        if (!erVar.b.H()) {
            erVar.v();
        }
        int i = exVar.CG;
        es esVar = (es) erVar.b;
        esVar.b |= 1;
        esVar.c = i;
        return new b((es) erVar.t());
    }

    public abstract es a();

    @Override // com.google.android.libraries.navigation.internal.rd.g
    public final int b() {
        return 1;
    }
}
