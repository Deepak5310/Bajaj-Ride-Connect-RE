package com.google.android.libraries.navigation.internal.zx;

import com.google.android.libraries.navigation.internal.yx.aa;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.dq;
import com.google.android.libraries.navigation.internal.yz.hb;
import com.google.android.libraries.navigation.internal.yz.lj;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends dq {
    private final Set a;

    public c(Set set) {
        this.a = set;
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
        return hb.d(this.a.iterator(), new aa() { // from class: com.google.android.libraries.navigation.internal.zx.a
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                Map.Entry entry = (Map.Entry) obj;
                ar.q(entry);
                return new b(entry);
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
