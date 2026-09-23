package com.google.android.libraries.navigation.internal.om;

import com.google.android.libraries.navigation.internal.adi.bo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u {
    public final Map a = new ConcurrentHashMap();
    public final Map b = new ConcurrentHashMap();
    public Integer c;

    public final String a(bo boVar) {
        return (String) this.a.get(boVar);
    }

    public final void b(bo boVar, String str) {
        this.a.put(boVar, str);
    }

    public final boolean c() {
        return !this.b.isEmpty();
    }
}
