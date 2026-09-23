package com.google.android.libraries.navigation.internal.px;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class es implements Comparable {
    public DateTime a = new DateTime(0);
    public final com.google.android.libraries.navigation.internal.oe.x b;
    private final com.google.android.libraries.navigation.internal.oe.j c;

    public es(com.google.android.libraries.navigation.internal.oe.j jVar, com.google.android.libraries.navigation.internal.oe.x xVar) {
        this.c = jVar;
        this.b = xVar;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.a.compareTo((ReadableInstant) ((es) obj).a);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof es)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return this.c.equals(((es) obj).c);
    }

    public final int hashCode() {
        return this.c.hashCode();
    }
}
