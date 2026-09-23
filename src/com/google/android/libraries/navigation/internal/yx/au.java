package com.google.android.libraries.navigation.internal.yx;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class au implements Serializable, as {
    private static final long serialVersionUID = 0;
    final as a;

    public au(as asVar) {
        this.a = asVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.as
    public final boolean a(Object obj) {
        return !this.a.a(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yx.as
    public final boolean equals(Object obj) {
        if (obj instanceof au) {
            return this.a.equals(((au) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return ~this.a.hashCode();
    }

    public final String toString() {
        return "Predicates.not(" + String.valueOf(this.a) + ")";
    }
}
