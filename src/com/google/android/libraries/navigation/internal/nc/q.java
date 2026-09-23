package com.google.android.libraries.navigation.internal.nc;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q extends ad {
    private final CharSequence a;

    public q(CharSequence charSequence) {
        this.a = charSequence;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ad
    public final CharSequence a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ad) {
            return this.a.equals(((ad) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "ConstantCharSequenceViewPropertyValue{charSequence=" + this.a.toString() + "}";
    }
}
