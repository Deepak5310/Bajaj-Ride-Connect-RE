package com.google.android.libraries.navigation.internal.afx;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q {
    private static q a;
    private final List b = Collections.emptyList();

    public static synchronized q a() {
        if (a == null) {
            a = new q();
        }
        return a;
    }

    public final synchronized List b() {
        return this.b;
    }

    public final synchronized void c() {
    }
}
