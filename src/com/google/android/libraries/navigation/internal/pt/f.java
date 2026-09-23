package com.google.android.libraries.navigation.internal.pt;

import com.google.android.libraries.navigation.internal.acw.h;
import com.google.android.libraries.navigation.internal.acw.j;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements Serializable {
    public final List a;

    public f(List list) {
        this.a = list;
    }

    public static f a(j jVar) {
        int i = ev.d;
        eq eqVar = new eq();
        if (jVar != null) {
            int size = jVar.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                d dVarB = d.b((h) jVar.b.get(i2));
                if (dVarB != null) {
                    eqVar.h(dVarB);
                }
            }
        }
        return new f(eqVar.g());
    }
}
