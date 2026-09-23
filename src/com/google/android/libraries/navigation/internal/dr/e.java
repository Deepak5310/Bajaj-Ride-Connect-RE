package com.google.android.libraries.navigation.internal.dr;

import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.fd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public final l a;
    public com.google.android.libraries.navigation.internal.dt.a b;
    public boolean c;
    public int d;

    public e(l lVar, boolean z, int i, com.google.android.libraries.navigation.internal.dt.a aVar) {
        this.a = lVar;
        this.c = z;
        this.b = aVar;
        this.d = i;
    }

    final int a() {
        com.google.android.libraries.navigation.internal.dt.a aVar = this.b;
        boolean z = this.c;
        int i = this.d;
        fd fdVar = z ? aVar.f : aVar.e;
        if (true != fdVar.containsKey(Integer.valueOf(i))) {
            i = -1;
        }
        Integer num = (Integer) fdVar.get(Integer.valueOf(i));
        ar.q(num);
        return num.intValue();
    }
}
