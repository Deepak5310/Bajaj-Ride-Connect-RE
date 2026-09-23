package com.google.android.libraries.navigation.internal.yz;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class v extends o implements SortedMap {
    SortedSet d;
    final /* synthetic */ ae e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(ae aeVar, SortedMap sortedMap) {
        super(aeVar, sortedMap);
        this.e = aeVar;
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return h().comparator();
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return h().firstKey();
    }

    public SortedMap h() {
        return (SortedMap) this.a;
    }

    public SortedMap headMap(Object obj) {
        return new v(this.e, h().headMap(obj));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kb
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public SortedSet g() {
        return new w(this.e, h());
    }

    @Override // com.google.android.libraries.navigation.internal.yz.o, com.google.android.libraries.navigation.internal.yz.kb, java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public SortedSet keySet() {
        SortedSet sortedSet = this.d;
        if (sortedSet != null) {
            return sortedSet;
        }
        SortedSet sortedSetG = g();
        this.d = sortedSetG;
        return sortedSetG;
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return h().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new v(this.e, h().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new v(this.e, h().tailMap(obj));
    }
}
