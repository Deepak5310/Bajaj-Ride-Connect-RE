package com.google.android.libraries.navigation.internal.ky;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class af extends ae {
    private final long b;
    private final long c;

    public af(int i, int i2, int i3) {
        super(i);
        this.b = i2;
        this.c = i3;
    }

    @Override // com.google.android.libraries.navigation.internal.ky.ae, com.google.android.libraries.navigation.internal.ky.ab
    public final long a(long j) {
        return super.a(Math.max(Math.min(j, this.c), this.b));
    }

    @Override // com.google.android.libraries.navigation.internal.ky.ae
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof af) && this.a == ((af) obj).a;
    }
}
