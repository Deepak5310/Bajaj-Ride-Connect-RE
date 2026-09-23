package com.google.android.libraries.navigation.internal.tb;

import com.google.android.libraries.navigation.internal.tj.t;
import com.google.android.libraries.navigation.internal.yx.as;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final HashMap a = new HashMap();
    public final Object b = new Object();
    public final List c = new CopyOnWriteArrayList();
    public final as d = new a(this);

    public b(Set set) {
        for (t tVar : t.values()) {
            HashSet hashSet = new HashSet();
            if (set.contains(tVar)) {
                hashSet.add("Globally Blocked Prompts");
            }
            this.a.put(tVar, hashSet);
        }
    }
}
