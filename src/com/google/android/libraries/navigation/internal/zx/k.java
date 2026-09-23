package com.google.android.libraries.navigation.internal.zx;

import com.google.android.libraries.navigation.internal.yz.df;
import com.google.android.libraries.navigation.internal.yz.dl;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k extends dl {
    Set a;
    Collection b;
    final /* synthetic */ Map c;
    final /* synthetic */ l d;

    public k(l lVar, Map map) {
        this.c = map;
        this.d = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, com.google.android.libraries.navigation.internal.yz.Cdo
    protected final /* synthetic */ Object aF() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, java.util.Map
    public final boolean containsValue(Object obj) {
        return ((df) values()).d(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, java.util.Map
    public final Set entrySet() {
        Set set = this.a;
        if (set != null) {
            return set;
        }
        c cVar = new c(this.c.entrySet());
        this.a = cVar;
        return cVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl
    protected final Map f() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        List listC = this.d.c(obj);
        if (listC.isEmpty()) {
            return null;
        }
        return listC;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dl, java.util.Map
    public final Collection values() {
        Collection collection = this.b;
        if (collection != null) {
            return collection;
        }
        e eVar = new e(this.c.values(), entrySet());
        this.b = eVar;
        return eVar;
    }
}
