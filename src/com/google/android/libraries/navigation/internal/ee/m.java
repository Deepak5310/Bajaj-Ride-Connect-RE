package com.google.android.libraries.navigation.internal.ee;

import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class m {
    static {
        b().c();
    }

    public static l b() {
        a aVar = new a();
        aVar.b(new p[0]);
        return aVar;
    }

    public abstract ev a();

    /* JADX WARN: Multi-variable type inference failed */
    public final String c(int i) {
        ev evVarA = a();
        if (evVarA == null || evVarA.isEmpty()) {
            return null;
        }
        int i2 = i != 1 ? 3 : 4;
        int size = evVarA.size();
        int i3 = 0;
        while (i3 < size) {
            p pVar = (p) evVarA.get(i3);
            i3++;
            if (pVar.a() == i2) {
                return pVar.e();
            }
        }
        return ((p) evVarA.get(0)).e();
    }
}
