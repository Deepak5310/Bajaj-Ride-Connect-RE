package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class fs<K, V> extends ay<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient fd<K, ? extends ek<V>> map;
    final transient int size;

    public fs(fd fdVar, int i) {
        this.map = fdVar;
        this.size = i;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an, com.google.android.libraries.navigation.internal.yz.kd
    @Deprecated
    public final boolean B(kd kdVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an, com.google.android.libraries.navigation.internal.yz.kd
    @Deprecated
    public final boolean C(Object obj, Object obj2) {
        throw null;
    }

    public abstract ek a(Object obj);

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public /* bridge */ /* synthetic */ Collection c(Object obj) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    @Deprecated
    public /* bridge */ /* synthetic */ Collection d(Object obj) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an, com.google.android.libraries.navigation.internal.yz.kd
    /* JADX INFO: renamed from: e */
    public ek u() {
        return (ek) super.u();
    }

    public final ek f() {
        return (ek) super.v();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public final int i() {
        return this.size;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an
    public final /* synthetic */ Collection j() {
        return new fp(this);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an
    public final /* synthetic */ Collection k() {
        return new fr(this);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an
    public final /* bridge */ /* synthetic */ Iterator l() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an, com.google.android.libraries.navigation.internal.yz.kd
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public final fd w() {
        return this.map;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an
    public final Map o() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an
    public final Set p() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    @Deprecated
    public final void q() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an, com.google.android.libraries.navigation.internal.yz.kd
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public final fy x() {
        return this.map.keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kd
    public final boolean s(Object obj) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an, com.google.android.libraries.navigation.internal.yz.kd
    @Deprecated
    public final boolean t(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an
    public final boolean z(Object obj) {
        return obj != null && super.z(obj);
    }
}
