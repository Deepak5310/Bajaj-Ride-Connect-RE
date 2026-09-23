package com.google.android.libraries.navigation.internal.fw;

import com.google.android.libraries.navigation.internal.yx.al;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u {
    public long a;
    public long b;
    public long c;
    public long d;
    public long e;

    private final Object[] b() {
        return new Object[]{Long.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Long.valueOf(this.d), Long.valueOf(this.e)};
    }

    final void a(u uVar) {
        this.a += uVar.a;
        this.b += uVar.b;
        this.c += uVar.c;
        this.d += uVar.d;
        this.e += uVar.e;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof u) && Arrays.deepEquals(b(), ((u) obj).b());
    }

    public final int hashCode() {
        return Arrays.hashCode(b());
    }

    public final String toString() {
        return al.b(this).d("receivedBytes", this.a).d("sentBytes", this.b).d("sentCompressedBytes", this.c).d("sentGmmMessages", this.d).d("sentCompressedGmmMessages", this.e).toString();
    }
}
