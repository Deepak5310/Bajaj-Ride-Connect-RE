package com.google.android.libraries.navigation.internal.afr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements f {
    public static final f a = g.b(Collections.emptySet());
    private final List b;
    private final List c;

    public p(List list, List list2) {
        this.b = list;
        this.c = list2;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Set a() {
        List list = this.c;
        int size = this.b.size();
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = this.c.size();
        for (int i = 0; i < size2; i++) {
            Collection collection = (Collection) ((k) this.c.get(i)).a();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet hashSet = new HashSet(c.a(size));
        int size3 = this.b.size();
        for (int i2 = 0; i2 < size3; i2++) {
            Object objA = ((k) this.b.get(i2)).a();
            j.b(objA);
            hashSet.add(objA);
        }
        int size4 = arrayList.size();
        for (int i3 = 0; i3 < size4; i3++) {
            for (Object obj : (Collection) arrayList.get(i3)) {
                j.b(obj);
                hashSet.add(obj);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
