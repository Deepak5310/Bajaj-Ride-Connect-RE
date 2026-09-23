package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class kr extends dn implements Serializable {
    private static final long serialVersionUID = 0;
    final kd a;
    transient Collection b;
    transient Set c;
    transient Map d;

    public kr(kd kdVar) {
        this.a = kdVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dn, com.google.android.libraries.navigation.internal.yz.kd
    public final boolean B(kd kdVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dn, com.google.android.libraries.navigation.internal.yz.kd
    public final boolean C(Object obj, Object obj2) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.libraries.navigation.internal.yz.dn, com.google.android.libraries.navigation.internal.yz.Cdo
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public kd aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dn, com.google.android.libraries.navigation.internal.yz.kd
    public final void q() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dn, com.google.android.libraries.navigation.internal.yz.kd
    public final boolean t(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dn, com.google.android.libraries.navigation.internal.yz.kd
    public final Collection u() {
        Collection collection = this.b;
        if (collection != null) {
            return collection;
        }
        Collection collectionU = this.a.u();
        Collection jzVar = collectionU instanceof Set ? new jz(Collections.unmodifiableSet((Set) collectionU)) : new jy(Collections.unmodifiableCollection(collectionU));
        this.b = jzVar;
        return jzVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dn, com.google.android.libraries.navigation.internal.yz.kd
    public final Map w() {
        Map map = this.d;
        if (map != null) {
            return map;
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(new jx(this.a.w(), new js(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.yz.kq
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                return ks.a((Collection) obj);
            }
        })));
        this.d = mapUnmodifiableMap;
        return mapUnmodifiableMap;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dn, com.google.android.libraries.navigation.internal.yz.kd
    public final Set x() {
        Set set = this.c;
        if (set != null) {
            return set;
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(this.a.x());
        this.c = setUnmodifiableSet;
        return setUnmodifiableSet;
    }
}
