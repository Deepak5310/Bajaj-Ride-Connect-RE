package com.google.android.libraries.navigation.internal.zx;

import com.google.android.libraries.navigation.internal.yx.aa;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.df;
import com.google.android.libraries.navigation.internal.yz.hb;
import com.google.android.libraries.navigation.internal.yz.lj;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h extends df {
    final Collection a;

    public h(Collection collection) {
        this.a = collection;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df
    /* JADX INFO: renamed from: a */
    protected final Collection aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, com.google.android.libraries.navigation.internal.yz.Cdo
    protected final /* synthetic */ Object aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return hb.d(this.a.iterator(), new aa() { // from class: com.google.android.libraries.navigation.internal.zx.f
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                Map.Entry entry = (Map.Entry) obj;
                ar.q(entry);
                return new g(entry);
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return f();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        return lj.a(this, objArr);
    }
}
