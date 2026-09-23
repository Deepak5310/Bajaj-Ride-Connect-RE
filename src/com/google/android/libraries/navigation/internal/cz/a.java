package com.google.android.libraries.navigation.internal.cz;

import com.google.android.apps.gmm.location.navigation.bt;
import com.google.android.libraries.navigation.internal.zr.dx;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements bt {
    final /* synthetic */ Set a;

    public a(Set set) {
        this.a = set;
    }

    @Override // com.google.android.apps.gmm.location.navigation.bt
    public final void a(dx dxVar) {
        Iterator it2 = this.a.iterator();
        while (it2.hasNext()) {
            ((bt) it2.next()).a(dxVar);
        }
    }
}
