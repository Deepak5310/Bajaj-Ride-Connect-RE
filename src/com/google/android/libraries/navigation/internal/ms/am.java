package com.google.android.libraries.navigation.internal.ms;

import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am implements cx {
    private final cx[] a;

    public am(List list) {
        this.a = (cx[]) list.toArray(new cx[list.size()]);
    }

    @Override // com.google.android.libraries.navigation.internal.ms.cx
    public final boolean a(cw cwVar, Object obj, ck ckVar) {
        for (cx cxVar : this.a) {
            if (cxVar.a(cwVar, obj, ckVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.cx
    public final boolean b(cw cwVar, ck ckVar) {
        for (cx cxVar : this.a) {
            if (cxVar.b(cwVar, ckVar)) {
                return true;
            }
        }
        return false;
    }
}
