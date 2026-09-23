package com.google.android.libraries.navigation.internal.agh;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class k extends j implements es {
    private static final long serialVersionUID = -1773560792952436569L;

    protected k() {
    }

    public /* bridge */ /* synthetic */ Comparator comparator() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, com.google.android.libraries.navigation.internal.agh.ea
    /* JADX INFO: renamed from: d */
    public /* bridge */ /* synthetic */ he keySet() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, com.google.android.libraries.navigation.internal.agh.ea
    /* JADX INFO: renamed from: e */
    public com.google.android.libraries.navigation.internal.agi.gf values() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return m();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, com.google.android.libraries.navigation.internal.agh.ea
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.agi.hd f() {
        return m();
    }

    @Override // java.util.SortedMap
    public final /* bridge */ /* synthetic */ Object firstKey() {
        return n();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.es
    public final /* synthetic */ es h(Long l) {
        return B();
    }

    @Override // java.util.SortedMap
    public final /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
        return h((Long) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.es
    public final /* synthetic */ es i(Long l, Long l2) {
        return C();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.es
    public final /* synthetic */ es j(Long l) {
        return D();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public hi keySet() {
        throw null;
    }

    /* JADX INFO: renamed from: l */
    public /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.agi.hd t() {
        throw null;
    }

    @Override // java.util.SortedMap
    public final /* bridge */ /* synthetic */ Object lastKey() {
        return o();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.es
    public final /* synthetic */ com.google.android.libraries.navigation.internal.agi.hi m() {
        return t();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.es
    public final /* synthetic */ Long n() {
        return Long.valueOf(p());
    }

    @Override // com.google.android.libraries.navigation.internal.agh.es
    public final /* synthetic */ Long o() {
        return Long.valueOf(q());
    }

    @Override // java.util.SortedMap
    public final /* bridge */ /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return i((Long) obj, (Long) obj2);
    }

    @Override // java.util.SortedMap
    public final /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
        return j((Long) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.j, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }
}
