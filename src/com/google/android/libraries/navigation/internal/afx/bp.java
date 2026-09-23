package com.google.android.libraries.navigation.internal.afx;

import java.util.HashSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bp {
    private static bp a;

    public bp() {
        new HashSet();
    }

    public static synchronized bp a() {
        if (a == null) {
            a = new bp();
        }
        return a;
    }
}
