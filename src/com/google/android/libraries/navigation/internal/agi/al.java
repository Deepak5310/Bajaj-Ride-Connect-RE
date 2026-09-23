package com.google.android.libraries.navigation.internal.agi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class al {
    @Deprecated
    public static Float a(am amVar, Object obj) {
        float fO = amVar.o(obj);
        if (fO != 0.0f || amVar.containsKey(obj)) {
            return Float.valueOf(fO);
        }
        return null;
    }

    @Deprecated
    public static Float b(am amVar, Object obj, Float f) {
        boolean zContainsKey = amVar.containsKey(obj);
        float fA = amVar.a(obj, f.floatValue());
        if (zContainsKey) {
            return Float.valueOf(fA);
        }
        return null;
    }

    @Deprecated
    public static Float c(am amVar, Object obj) {
        if (amVar.containsKey(obj)) {
            return Float.valueOf(amVar.b(obj));
        }
        return null;
    }
}
