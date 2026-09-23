package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class kl extends jt {
    final /* synthetic */ km a;

    public kl(km kmVar) {
        this.a = kmVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.jt
    public final Map a() {
        return this.a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return kc.h(this.a.a.x(), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.yz.kk
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                return this.a.a.a.c(obj);
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.yz.jt, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) Objects.requireNonNull((Map.Entry) obj);
        km kmVar = this.a;
        kmVar.a.x().remove(entry.getKey());
        return true;
    }
}
