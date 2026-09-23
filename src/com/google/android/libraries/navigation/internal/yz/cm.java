package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cm extends i {
    final /* synthetic */ cq a;
    private final Iterator b;

    public cm(cq cqVar) {
        this.a = cqVar;
        this.b = cqVar.countMap.entrySet().iterator();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.i
    protected final /* bridge */ /* synthetic */ Object a() {
        while (this.b.hasNext()) {
            Map.Entry entry = (Map.Entry) this.b.next();
            int i = ((AtomicInteger) entry.getValue()).get();
            if (i != 0) {
                return new ky(entry.getKey(), i);
            }
        }
        b();
        return null;
    }
}
