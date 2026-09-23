package com.google.android.libraries.navigation.internal.aac;

import com.google.android.libraries.navigation.internal.yz.ek;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class x extends n {
    private List b;

    public x(ek ekVar, boolean z) {
        super(ekVar, z, true);
        List listEmptyList = ekVar.isEmpty() ? Collections.emptyList() : hx.e(ekVar.size());
        for (int i = 0; i < ekVar.size(); i++) {
            listEmptyList.add(null);
        }
        this.b = listEmptyList;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.n
    public final void g(int i, Object obj) {
        List list = this.b;
        if (list != null) {
            list.set(i, new w(obj));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.aac.n
    public final void i() {
        List list = this.b;
        if (list != null) {
            d(t(list));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.aac.n
    public final void s(m mVar) {
        super.s(mVar);
        this.b = null;
    }

    public abstract Object t(List list);
}
