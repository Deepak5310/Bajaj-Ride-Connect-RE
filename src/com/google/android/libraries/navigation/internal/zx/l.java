package com.google.android.libraries.navigation.internal.zx;

import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.dk;
import com.google.android.libraries.navigation.internal.yz.ho;
import com.google.android.libraries.navigation.internal.yz.kd;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l extends dk implements Serializable, ho {
    final ho a;
    transient Collection b;
    transient Map c;

    public l(ho hoVar) {
        this.a = hoVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dn, com.google.android.libraries.navigation.internal.yz.kd
    public final boolean B(kd kdVar) {
        boolean zT = false;
        for (Map.Entry entry : kdVar.u()) {
            zT |= t(entry.getKey(), entry.getValue());
        }
        return zT;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dk
    protected final ho a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dn, com.google.android.libraries.navigation.internal.yz.Cdo
    protected final /* synthetic */ Object aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dk, com.google.android.libraries.navigation.internal.yz.dn
    /* JADX INFO: renamed from: b */
    protected final /* synthetic */ kd aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dk, com.google.android.libraries.navigation.internal.yz.dn, com.google.android.libraries.navigation.internal.yz.kd
    public final /* bridge */ /* synthetic */ Collection c(Object obj) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dk, com.google.android.libraries.navigation.internal.yz.ho
    /* JADX INFO: renamed from: g */
    public final List c(Object obj) {
        return new i(this.a.c(obj));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dn, com.google.android.libraries.navigation.internal.yz.kd
    public final boolean t(Object obj, Object obj2) {
        ar.t(obj, "null key in entry (%s, %s)", obj, obj2);
        ar.t(obj2, "null value in entry (%s, %s)", obj, obj2);
        return this.a.t(obj, obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dn, com.google.android.libraries.navigation.internal.yz.kd
    public final Collection u() {
        Collection collection = this.b;
        if (collection != null) {
            return collection;
        }
        h hVar = new h(this.a.u());
        this.b = hVar;
        return hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dn, com.google.android.libraries.navigation.internal.yz.kd
    public final Map w() {
        Map map = this.c;
        if (map != null) {
            return map;
        }
        k kVar = new k(this, this.a.w());
        this.c = kVar;
        return kVar;
    }
}
