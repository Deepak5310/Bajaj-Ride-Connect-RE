package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gf;
import com.google.android.libraries.navigation.internal.agi.hd;
import com.google.android.libraries.navigation.internal.agi.hi;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class e extends d implements cb {
    private static final long serialVersionUID = -1773560792952436569L;

    protected e() {
    }

    public /* bridge */ /* synthetic */ Comparator comparator() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.d, com.google.android.libraries.navigation.internal.agg.bj
    /* JADX INFO: renamed from: e */
    public gf values() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.d, java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return m();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.d, com.google.android.libraries.navigation.internal.agg.bj
    public final /* bridge */ /* synthetic */ hd f() {
        return m();
    }

    @Override // java.util.SortedMap
    public final /* bridge */ /* synthetic */ Object firstKey() {
        return n();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.cb
    public final /* synthetic */ cb h(Integer num) {
        return A();
    }

    @Override // java.util.SortedMap
    public final /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
        return h((Integer) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.cb
    public final /* synthetic */ cb i(Integer num, Integer num2) {
        return B();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.cb
    public final /* synthetic */ cb j(Integer num) {
        return C();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.d, java.util.Map, java.util.SortedMap
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public fe keySet() {
        throw null;
    }

    /* JADX INFO: renamed from: l */
    public /* bridge */ /* synthetic */ hd u() {
        throw null;
    }

    @Override // java.util.SortedMap
    public final /* bridge */ /* synthetic */ Object lastKey() {
        return o();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.cb
    public final /* synthetic */ hi m() {
        return u();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.cb
    public final /* synthetic */ Integer n() {
        return Integer.valueOf(q());
    }

    @Override // com.google.android.libraries.navigation.internal.agg.cb
    public final /* synthetic */ Integer o() {
        return Integer.valueOf(r());
    }

    @Override // java.util.SortedMap
    public final /* bridge */ /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return i((Integer) obj, (Integer) obj2);
    }

    @Override // java.util.SortedMap
    public final /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
        return j((Integer) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.d, java.util.Map, java.util.SortedMap
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }
}
