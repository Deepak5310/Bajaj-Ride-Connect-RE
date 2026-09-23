package com.google.android.libraries.navigation.internal.vz;

import com.google.android.libraries.navigation.internal.adu.m;
import com.google.android.libraries.navigation.internal.ee.u;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.nn;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    private fd a;

    public final synchronized fd a() {
        if (this.a == null) {
            ez ezVar = new ez();
            nn nnVarE = u.a.keySet().listIterator();
            while (nnVarE.hasNext()) {
                Integer num = (Integer) nnVarE.next();
                com.google.android.libraries.navigation.internal.en.a aVar = num.intValue() == m.NAVIGATION_STATUS.eU ? new com.google.android.libraries.navigation.internal.en.a() : null;
                if (aVar != null) {
                    ezVar.f(num, aVar);
                }
            }
            this.a = ezVar.d();
        }
        return this.a;
    }
}
