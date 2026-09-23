package com.google.android.libraries.navigation.internal.lh;

import android.accounts.Account;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p {
    public final Account a;
    public final Set b;
    public final Set c;
    public final String d;
    public final String e;
    public final com.google.android.libraries.navigation.internal.mc.f f;
    public Integer g;
    private final Map h;

    public p(Account account, Set set, Map map, String str, String str2, com.google.android.libraries.navigation.internal.mc.f fVar) {
        this.a = account;
        Set setEmptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.b = setEmptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.h = map;
        this.d = str;
        this.e = str2;
        this.f = fVar == null ? com.google.android.libraries.navigation.internal.mc.f.b : fVar;
        HashSet hashSet = new HashSet(setEmptySet);
        Iterator it2 = map.values().iterator();
        while (it2.hasNext()) {
            Set set2 = ((o) it2.next()).a;
            hashSet.addAll(null);
        }
        this.c = Collections.unmodifiableSet(hashSet);
    }
}
