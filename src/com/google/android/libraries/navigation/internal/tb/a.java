package com.google.android.libraries.navigation.internal.tb;

import com.google.android.libraries.navigation.internal.tj.u;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.as;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements as {
    final /* synthetic */ b a;

    public a(b bVar) {
        this.a = bVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.as
    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        boolean zIsEmpty;
        u uVar = (u) obj;
        synchronized (this.a.b) {
            Set set = (Set) this.a.a.get(uVar.j());
            ar.q(set);
            zIsEmpty = set.isEmpty();
        }
        return zIsEmpty;
    }
}
