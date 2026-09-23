package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f extends dq {
    final Set a;
    final /* synthetic */ g b;

    public f(g gVar) {
        this.b = gVar;
        this.a = gVar.b.keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dq, com.google.android.libraries.navigation.internal.yz.df
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ Collection aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, com.google.android.libraries.navigation.internal.yz.Cdo
    protected final /* synthetic */ Object aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dq
    /* JADX INFO: renamed from: b */
    protected final Set aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new jo(this.b.entrySet().iterator());
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return f();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.Cdo
    public final String toString() {
        StringBuilder sbA = bt.a(size());
        sbA.append('[');
        boolean z = true;
        for (Object obj : this) {
            if (!z) {
                sbA.append(", ");
            }
            z = false;
            if (obj == this) {
                sbA.append("(this Collection)");
            } else {
                sbA.append(obj);
            }
        }
        sbA.append(']');
        return sbA.toString();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        return lj.a(this, objArr);
    }
}
