package com.google.android.libraries.navigation.internal.zg;

import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l {
    public static final Comparator a = new e();
    public static final l b = new l(new j(Collections.emptyList()));
    public final j c;

    public l(j jVar) {
        this.c = jVar;
    }

    public final boolean a() {
        return this.c.isEmpty();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof l) && ((l) obj).c.equals(this.c);
    }

    public final int hashCode() {
        return ~this.c.hashCode();
    }

    public final String toString() {
        return this.c.toString();
    }
}
