package com.google.android.libraries.navigation.internal.afx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aq extends ax {
    private final as a;

    public aq(as asVar) {
        com.google.android.libraries.navigation.internal.yx.ar.r(asVar, "result");
        this.a = asVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof aq) {
            return this.a.equals(((aq) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "FixedResultPicker(" + String.valueOf(this.a) + ")";
    }
}
