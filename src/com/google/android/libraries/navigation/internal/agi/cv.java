package com.google.android.libraries.navigation.internal.agi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class cv {
    @Deprecated
    public static Long a(cw cwVar, Object obj) {
        long jQ = cwVar.q(obj);
        if (jQ != cwVar.a() || cwVar.containsKey(obj)) {
            return Long.valueOf(jQ);
        }
        return null;
    }

    @Deprecated
    public static Long b(cw cwVar, Object obj, Long l) {
        boolean zContainsKey = cwVar.containsKey(obj);
        long jB = cwVar.b(obj, l.longValue());
        if (zContainsKey) {
            return Long.valueOf(jB);
        }
        return null;
    }

    @Deprecated
    public static Long c(cw cwVar, Object obj) {
        if (cwVar.containsKey(obj)) {
            return Long.valueOf(cwVar.c(obj));
        }
        return null;
    }
}
