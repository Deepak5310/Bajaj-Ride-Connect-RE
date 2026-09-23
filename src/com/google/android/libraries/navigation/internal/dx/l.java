package com.google.android.libraries.navigation.internal.dx;

import com.google.android.libraries.navigation.internal.ace.nx;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l extends n {
    public final nx a;

    public l(nx severity) {
        Intrinsics.checkNotNullParameter(severity, "severity");
        this.a = severity;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l) && this.a == ((l) obj).a;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "LegacySeverity(severity=" + this.a + ")";
    }
}
