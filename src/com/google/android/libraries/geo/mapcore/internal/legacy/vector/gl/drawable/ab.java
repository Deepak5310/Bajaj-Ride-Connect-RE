package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import com.google.android.libraries.geo.mapcore.internal.model.br;
import com.google.android.libraries.geo.mapcore.internal.model.cp;
import com.google.android.libraries.geo.mapcore.internal.model.cq;
import com.google.android.libraries.navigation.internal.yz.ck;
import java.util.Comparator;
import java.util.IdentityHashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class ab implements Comparator {
    private final IdentityHashMap a;

    public ab(com.google.android.libraries.navigation.internal.qh.c cVar, cq cqVar) {
        this.a = new IdentityHashMap(cqVar.f.size());
        cp cpVarK = cqVar.k();
        while (cpVarK.hasNext()) {
            br next = cpVarK.next();
            this.a.put(next, Integer.valueOf(cVar.e(next).H));
        }
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        br brVar = (br) obj;
        br brVar2 = (br) obj2;
        Integer num = (Integer) this.a.get(brVar);
        Integer num2 = (Integer) this.a.get(brVar2);
        return ck.b.c(num == null ? 0 : num.intValue(), num2 != null ? num2.intValue() : 0).c(brVar.b(), brVar2.b()).c(brVar.c(), brVar2.c()).a();
    }
}
