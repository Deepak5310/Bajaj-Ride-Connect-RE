package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cg extends bz implements Serializable, ce {
    private static final long serialVersionUID = -7046029254386353129L;
    protected final ce c;
    protected transient com.google.android.libraries.navigation.internal.agi.hd d;
    protected transient he e;
    protected transient gf f;

    public cg(ce ceVar) {
        super(ceVar);
        this.c = ceVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ boolean containsKey(Object obj) {
        return bw.d(this, obj);
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean containsValue(Object obj) {
        return cd.m(this.c, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.bz, java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.c.equals(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    /* JADX INFO: renamed from: f */
    public final gf values() {
        throw null;
    }

    @Override // java.util.Map
    public final void forEach(BiConsumer biConsumer) {
        cd.l(this.c, biConsumer);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    /* JADX INFO: renamed from: g */
    public final he keySet() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.bz, com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agc.d
    @Deprecated
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return super.d(obj);
    }

    @Override // java.util.Map
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        cd.q();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    @Deprecated
    public final com.google.android.libraries.navigation.internal.agi.hd h() {
        return entrySet();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.bz, java.util.Map
    public final int hashCode() {
        return this.c.hashCode();
    }

    @Override // java.util.Map
    @Deprecated
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final Long compute(Long l, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // java.util.Map
    @Deprecated
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final Long computeIfAbsent(Long l, Function function) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public final Long computeIfPresent(Long l, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        if (this.e == null) {
            he heVarKeySet = this.c.keySet();
            hf hfVar = hh.a;
            this.e = new hg(heVarKeySet);
        }
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    @Deprecated
    public final Long l(Object obj, Long l) {
        throw null;
    }

    @Override // java.util.Map
    @Deprecated
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public final Long merge(Long l, Long l2, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final Long putIfAbsent(Long l, Long l2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return super.n((Long) obj, (Long) obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Long replace(Long l, Long l2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final boolean r(long j) {
        throw null;
    }

    @Override // java.util.Map
    @Deprecated
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        return super.p(obj);
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final boolean replace(Long l, Long l2, Long l3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public final com.google.android.libraries.navigation.internal.agi.hd entrySet() {
        if (this.d == null) {
            cq cqVarU = ((cv) this.c).u();
            com.google.android.libraries.navigation.internal.agi.he heVar = com.google.android.libraries.navigation.internal.agi.hh.a;
            this.d = new com.google.android.libraries.navigation.internal.agi.hg(cqVarU);
        }
        return this.d;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Collection values() {
        if (this.f == null) {
            this.f = new gh(this.c.values());
        }
        return this.f;
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }
}
