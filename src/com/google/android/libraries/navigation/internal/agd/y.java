package com.google.android.libraries.navigation.internal.agd;

import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class y {
    @Deprecated
    public static int a(z zVar, Byte b, Byte b2) {
        return zVar.a(b.byteValue(), b2.byteValue());
    }

    public static Comparator d(z zVar, Comparator comparator) {
        if (comparator instanceof z) {
            return zVar.d((z) comparator);
        }
        throw new NoSuchMethodError();
    }
}
