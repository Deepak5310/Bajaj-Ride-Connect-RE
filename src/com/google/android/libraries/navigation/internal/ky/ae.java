package com.google.android.libraries.navigation.internal.ky;

import com.google.android.libraries.navigation.internal.lh.be;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ae implements ab {
    protected final int a;

    public ae(int i) {
        be.c(i > 0, "bad alias: %s", Integer.valueOf(i));
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ky.ab
    public long a(long j) {
        long j2 = this.a;
        return j2 * (j / j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ae) && this.a == ((ae) obj).a;
    }
}
