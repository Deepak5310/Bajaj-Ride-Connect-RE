package com.google.android.libraries.navigation.internal.afx;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag {
    public static final ag a;
    public final ConcurrentNavigableMap b;
    public final ConcurrentMap c;
    public final ConcurrentMap d;

    static {
        Logger.getLogger(ag.class.getName());
        a = new ag();
    }

    public ag() {
        new ConcurrentSkipListMap();
        this.b = new ConcurrentSkipListMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    public static void a(Map map, ai aiVar) {
    }

    public static void b(Map map, ai aiVar) {
    }
}
